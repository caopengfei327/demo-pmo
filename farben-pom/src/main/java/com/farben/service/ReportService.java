package com.farben.service;

import com.alibaba.fastjson.JSONObject;
import com.farben.config.DataColumn;
import com.farben.entity.ReportBean;
import com.farben.exception.CommonException;
import com.farben.mapper.MilestoneMapper;
import com.farben.mapper.ReportMapper;
import com.farben.utils.ImportHelper;
import com.farben.utils.ImportUtil;
import com.farben.utils.PageUtils;
import com.farben.utils.WideTableCountUtils;
import com.farben.utils.export.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@Slf4j
public class ReportService {
    //将dao层属性注入service层
    public final static String FILE_EXTENSION_XLS = "xls";
    public final static String FILE_EXTENSION_XLSX = "xlsx";
    public final static String FILE_EXTENSION_CVS = "cvs";

    @Autowired
    ReportMapper reportMapper;

    @Resource
    MilestoneMapper milestoneMapper;

    public void importFile (MultipartFile multipartFile) throws Exception {

        String fileNameTmp = multipartFile.getOriginalFilename();

        if (!fileNameTmp.matches("^.+\\.(?i)(csv)$") &&
                !fileNameTmp.matches("^.+\\.(?i)(xls)$") &&
                !fileNameTmp.matches("^.+\\.(?i)(xlsx)$")) {
            log.error("文件格式上传不正确,fileName={}",fileNameTmp);
            throw new CommonException("文件格式上传不正确");
        }

        String fileName = fileNameTmp.substring(fileNameTmp.lastIndexOf(".")+1);

        ImportUtil<ReportBean> importExcelUtil = new ImportUtil<>(ReportBean.class);

        ImportHelper<ReportBean> helper;

        switch (fileName) {
            case FILE_EXTENSION_XLS:
                helper = importExcelUtil.readExcel2003(multipartFile.getInputStream());
                break;
            case FILE_EXTENSION_XLSX:
                helper = importExcelUtil.readExcel(multipartFile.getInputStream());
                break;
            default:
                helper = importExcelUtil.readCSV(multipartFile.getInputStream());
                break;
        }

        List<ReportBean> addUserList = new ArrayList<>();

        List<ReportBean> updateUserList = new ArrayList<>();

        while (helper.hasNext()){
            //宽表实体类
            ReportBean nextTemp = helper.next();
            if (null == nextTemp) {
                break;
            }

            int report = 0;
            if (null != nextTemp.getId()) {
                report = reportMapper.reportCount(nextTemp.getId());
            }
            //项目宽表按照公式进行相关列值的计算
            ReportBean next = WideTableCountUtils.budTotalCost(nextTemp);

            //如果数据库中无值，则进行新增，反之则进行更新
            if (report > 0) {
                updateUserList.add(next);
            } else {
                if (null != next.getId()) {
                    addUserList.add(next);
                }
            }

            //每次更新500条数据
            if (addUserList.size() == 500) {
                reportMapper.addReportInfoList(addUserList);
                log.info("插入成功的数据条数为[{}]",addUserList.size());
                addUserList.clear();
            }
//
            if (updateUserList.size() == 500) {
                reportMapper.updateReportInfoList(updateUserList);
                log.info("更新成功的数据条数为[{}]",updateUserList.size());
                updateUserList.clear();
            }
        }

        if (addUserList.size() > 0) {
            reportMapper.addReportInfoList(addUserList);
            log.info("插入成功的数据条数为[{}]",addUserList.size());
        }

        if (updateUserList.size() > 0) {
            reportMapper.updateReportInfoList(updateUserList);
            log.info("更新成功的数据条数为[{}]",updateUserList.size());
        }
    }


    public JSONObject queryReportList (Map<String, Object> reqMap) {
        log.info("queryReportList req{}",reqMap);

        Integer pageSize = null;

        if (null != reqMap.get("pageSize") && null != reqMap.get("start")) {
            //一页的页码数
            pageSize = (int) reqMap.get("pageSize");

            //请求开始数
            int startTemp = (int) reqMap.get("start");

            //算出实际开始数
            int start = PageUtils.startPage(startTemp,pageSize);

            //替换"start":?开始数
            reqMap.put("start",start);
        }

        //获取职能部门信息，用|分割符进行分割
        String departmentMsg = (String) reqMap.get("department");
        if (StringUtils.isNotBlank(departmentMsg) && !departmentMsg.equals("ALL")) {
            String[] department = departmentMsg.split("\\|",0);
            //获取销售部门
            if (1 == department.length) {
                reqMap.put("salesDepartment",department[0]);
            }
            //获取销售部门，交付二级部门
            if (2 == department.length) {
                reqMap.put("salesDepartment",department[0]);
                reqMap.put("delSecDepartment",department[1]);
            }
            //获取销售部门，交付二级部门，交付三级部门
            if (3 == department.length) {
                reqMap.put("salesDepartment",department[0]);
                reqMap.put("delSecDepartment",department[1]);
                reqMap.put("delThirdDepartment",department[2]);
            }
        }

        //查询总数
        int totalPage = 0;
        int count = reportMapper.queryReportCount(reqMap);
        if (null != pageSize) {
            //算出总页数
            totalPage = PageUtils.currentTotalpages(count,pageSize);
        }

        //查询出当前数据
        List<ReportBean> reportBeans = reportMapper.queryReportList(reqMap);
        JSONObject rsp = new JSONObject();
        rsp.put("tableTitle", DataColumn.REPORT_DATA_COLUMN_LIST);
        rsp.put("data",reportBeans);
        rsp.put("total",count);
        rsp.put("totalPage",totalPage);
        return rsp;
    }


    public JSONObject queryReporMap () {
        List<Map<String,Object>> stringObjectMap = reportMapper.queryReportMap();
        return null;
    }


    public void export(HttpServletResponse response,Map<String, Object> reqMap) {
        //定义导出的的表头，以及每个表头字段对应的对象变量名
//        List<Object> head = Arrays.asList("序号", "项目编号", "项目名称","客户名称","客户行业","合同编号");

//        List<Object> head = Arrays.asList("序号", "项目编号", "项目名称","客户名称","客户行业","合同编号");

        List<Object> head = DataColumn.REPORT_LIST;
        //宽表数据
        List<Map<String, Object>> reportTemp = reportMapper.exportReport(reqMap);
        List<List<Object>> sheetDataList = new ArrayList<>();
        sheetDataList.add(head);

        for (int i = 0;i<reportTemp.size();i++) {
            Map<String, Object> stringObjectMap = reportTemp.get(i);
            List<Object> report = new ArrayList<>();
            for(String key:stringObjectMap.keySet()){
                report.add(stringObjectMap.get(key));
            }
            sheetDataList.add(report);
        }

        ExcelUtils.export(response,"项目宽表数据", sheetDataList);
    }


    public JSONObject queryReportMileList (Map<String, Object> reqMap) {

        Integer pageSize = null;
        Integer startTemp;
        if (null != reqMap.get("pageSize") && null != reqMap.get("start")) {
            //一页的页码数
            pageSize = (int) reqMap.get("pageSize");
            //请求开始数
            startTemp = (int) reqMap.get("start");
            //算出实际开始数
            int start = PageUtils.startPage(startTemp,pageSize);
            //替换"start":?开始数
            reqMap.put("start",start);
        }

        //获取职能部门信息，用|分割符进行分割
        String departmentMsg = (String) reqMap.get("department");
        if (StringUtils.isNotBlank(departmentMsg) && !departmentMsg.equals("ALL")) {
            String[] department = departmentMsg.split("\\|",0);
            //获取销售部门
            if (1 == department.length) {
                reqMap.put("salesDepartment",department[0]);
            }
            //获取销售部门，交付二级部门
            if (2 == department.length) {
                reqMap.put("salesDepartment",department[0]);
                reqMap.put("delSecDepartment",department[1]);
            }
            //获取销售部门，交付二级部门，交付三级部门
            if (3 == department.length) {
                reqMap.put("salesDepartment",department[0]);
                reqMap.put("delSecDepartment",department[1]);
                reqMap.put("delThirdDepartment",department[2]);
            }
        }

        //查询总数
        int count = reportMapper.queryReportCount(reqMap);
        //算出总页数
        int totalPage = 0;
        if (null != pageSize) {
            totalPage = PageUtils.currentTotalpages(count,pageSize);
        }
        //查询宽表数据
        List<Map<String, Object>> reportList = reportMapper.queryReportTempList(reqMap);

        List<Map<String, Object>> reportTemp = new ArrayList<>();

        for (int i = 0;i<reportList.size(); i++) {
            Map<String, Object> stringObjectMap = reportList.get(i);
            //查询里程碑数据
            Map<String,Object> milesMap = new HashMap<>();
            milesMap.put("projectNo",stringObjectMap.get("projectNo"));
            List<Map<String, Object>> milestoneList = milestoneMapper.queryMileList(milesMap);
            stringObjectMap.put("mileinfos",milestoneList);
            reportTemp.add(stringObjectMap);
        }

        JSONObject rsp = new JSONObject();
        rsp.put("data",reportTemp);
        rsp.put("total",count);
        rsp.put("totalPage",totalPage);
        return rsp;
    }


    public void insertReportInfo (ReportBean reportBean) {
        ReportBean newReport = WideTableCountUtils.budTotalCost(reportBean);
        reportMapper.insertReportInfo(newReport);
    }
}