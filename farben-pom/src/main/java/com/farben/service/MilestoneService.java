package com.farben.service;

import com.alibaba.fastjson.JSONObject;
import com.farben.config.DataColumn;
import com.farben.entity.MilestoneInfo;
import com.farben.exception.CommonException;
import com.farben.mapper.MilestoneMapper;
import com.farben.utils.ImportHelper;
import com.farben.utils.ImportUtil;
import com.farben.utils.PageUtils;
import com.farben.utils.export.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MilestoneService {
    //将dao层属性注入service层
    public final static String FILE_EXTENSION_XLS = "xls";
    public final static String FILE_EXTENSION_XLSX = "xlsx";

    @Autowired
    MilestoneMapper milestoneMapper;


    public void inputMilReportFile (MultipartFile multipartFile) throws Exception {

        String fileNameTmp = multipartFile.getOriginalFilename();

        if (!fileNameTmp.matches("^.+\\.(?i)(csv)$") &&
                !fileNameTmp.matches("^.+\\.(?i)(xls)$") &&
                !fileNameTmp.matches("^.+\\.(?i)(xlsx)$")) {
            log.error("文件格式上传不正确,fileName={}",fileNameTmp);
            throw new CommonException("文件格式上传不正确");
        }

        String fileName = fileNameTmp.substring(fileNameTmp.lastIndexOf(".")+1);

        ImportUtil<MilestoneInfo> importExcelUtil = new ImportUtil<>(MilestoneInfo.class);

        ImportHelper<MilestoneInfo> helper;

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

        List<MilestoneInfo> addUserList = new ArrayList<>();

        List<MilestoneInfo> updateUserList = new ArrayList<>();

        while (helper.hasNext()){
            //宽表实体类
            MilestoneInfo next = helper.next();
//            if (null ==next) {
//                break;
//            }
//            if (null == next.getId()) {
//                break;
//            }
//            int report = milestoneMapper.milestoneCount(next.getId());
//            //如果数据库中无值，则进行新增，反之则进行更新
//            if (report > 0) {
//                updateUserList.add(next);
//            } else {
//                addUserList.add(next);
//            }

            if (null == next) {
                break;
            }

            int report = 0;
            if (null != next.getId()) {
                report = milestoneMapper.milestoneCount(next.getId());
            }

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
                milestoneMapper.addMilestoneInfo(addUserList);
                log.info("插入成功的数据条数为[{}]",addUserList.size());
                addUserList.clear();
            }
//
            if (updateUserList.size() == 500) {
                milestoneMapper.updateMilestoneInfoList(updateUserList);
                log.info("更新成功的数据条数为[{}]",updateUserList.size());
                updateUserList.clear();
            }
        }

        if (addUserList.size() > 0) {
            milestoneMapper.addMilestoneInfo(addUserList);
            log.info("插入成功的数据条数为[{}]",addUserList.size());
        }

        if (updateUserList.size() > 0) {
            milestoneMapper.updateMilestoneInfoList(updateUserList);
            log.info("更新成功的数据条数为[{}]",updateUserList.size());
        }
    }

    public JSONObject queryMilestoneList (Map<String, Object> reqMap) {

        //一页的页码数
        int pageSize = (int) reqMap.get("pageSize");

        //请求开始数
        int startTemp = (int) reqMap.get("start");
        //算出实际开始数
        int start = PageUtils.startPage(startTemp,pageSize);
        //替换"start":?开始数
        reqMap.put("start",start);
        //账户级别
        String accountLevel = (String) reqMap.get("accountLevel");

        //查询总数
        int count = milestoneMapper.queryMilestoneCount(reqMap);
        //算出总页数
        int totalPage = PageUtils.currentTotalpages(count,pageSize);
        //查询出当前数据
        List<MilestoneInfo> reportBeans = milestoneMapper.queryMilestonetList(reqMap);
        JSONObject rsp = new JSONObject();
        rsp.put("tableTitle", DataColumn.MILES_DATA_COLUMN_LIST);
        rsp.put("data",reportBeans);
        rsp.put("total",count);
        rsp.put("totalPage",totalPage);
        return rsp;
    }


    public void export(HttpServletResponse response, Map<String, Object> reqMap) {
        //定义导出的的表头，以及每个表头字段对应的对象变量名
//        List<Object> head = Arrays.asList("序号", "项目编号", "项目名称","客户名称","客户行业","合同编号");

//        List<Object> head = Arrays.asList("序号", "项目编号", "项目名称","客户名称","客户行业","合同编号");

        List<Object> head = DataColumn.MILESTONE_LIST;

        //宽表数据
        List<Map<String, Object>> reportTemp = milestoneMapper.exportMilestoneInfo(reqMap);
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

        ExcelUtils.export(response,"里程碑数据", sheetDataList);
    }

}