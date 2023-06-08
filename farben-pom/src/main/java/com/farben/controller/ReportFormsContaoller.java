package com.farben.controller;


import com.farben.entity.JsonResult;
import com.farben.entity.MilestoneInfo;
import com.farben.entity.ReportBean;
import com.farben.exception.CommonException;
import com.farben.mapper.MilestoneMapper;
import com.farben.mapper.ReportMapper;
import com.farben.service.MilestoneService;
import com.farben.service.ReportService;
import com.farben.utils.aop.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportFormsContaoller extends BaseController {

    @Resource
    ReportMapper reportMapper;

    @Resource
    ReportService reportService;

    @Resource
    MilestoneService milestoneService;

    @Resource
    MilestoneMapper milestoneMapper;

    @WebLog(channel = "web", name = "项目宽表数据导入", action = "/inputReportFile", saveFlag = true)
    @PostMapping(value = "/inputReportFile")
    public JsonResult<?> inputFile(@RequestBody MultipartFile multipartFile){
        try {
            log.info("开始导入数据");
            reportService.importFile(multipartFile);
            return renderSuccess();
        } catch (Exception e) {
            log.error("数据导入异常",e);
            throw new CommonException(e.getMessage());
        }
    }

    @WebLog(channel = "web", name = "里程碑数据导入", action = "/inputMilReportFile", saveFlag = true)
    @PostMapping(value = "/inputMilReportFile")
    public JsonResult<?> inputMilReportFile(@RequestBody MultipartFile multipartFile){
        try {
            milestoneService.inputMilReportFile(multipartFile);
            return renderSuccess();
        } catch (Exception e) {
            log.error("数据导入异常",e);
            throw new CommonException(e.getMessage());
        }
    }

    @WebLog(channel = "web", name = "宽表数据查询", action = "/queryReportList", saveFlag = true)
    @PostMapping(value = "/queryReportList")
    public JsonResult<?> queryReport(@RequestBody Map<String, Object> reqMap){
        try {
            return renderSuccess(reportService.queryReportList(reqMap));
        } catch (Exception e) {
            log.error("宽表数据查询异常",e);
            throw new CommonException("宽表数据查询异常");
        }
    }

    @WebLog(channel = "web", name = "项目宽表数据新增", action = "/insertReportInfo", saveFlag = true)
    @PostMapping(value = "/insertReportInfo")
    public JsonResult<?> insertReportInfo(@RequestBody ReportBean reportBean){
        try {
            log.info("开始插入项目宽表数据[{}]",reportBean.toString());
//            reportMapper.insertReportInfo(reportBean);
            reportService.insertReportInfo(reportBean);
            return renderSuccess();
        } catch (Exception e) {
            log.error("项目宽表数据新增异常",e);
            throw new CommonException("项目宽表数据新增异常");
        }
    }

    @WebLog(channel = "web", name = "项目宽表数据修改", action = "/updateReportInfo", saveFlag = true)
    @PostMapping(value = "/updateReportInfo")
    public JsonResult<?> updateReportInfo(@RequestBody Map<String, Object> reqMap){

        int id = (int) reqMap.get("id");
        int report = reportMapper.reportCount(id);
        if (0 == report) {
            throw new CommonException("该数据不存在");
        }

        try {
            log.info("开始更新数据[{}]",reqMap);
            reportMapper.updateReportInfo(reqMap);
            return renderSuccess();
        } catch (Exception e) {
            log.error("项目宽表数据修改异常",e);
            throw new CommonException("项目宽表数据修改异常");
        }
    }

    @WebLog(channel = "web", name = "里程碑数据查询", action = "/queryMilestoneList", saveFlag = true)
    @PostMapping(value = "/queryMilestoneList")
    public JsonResult<?> queryMilestoneList(@RequestBody Map<String, Object> reqMap){
        try {
            return renderSuccess(milestoneService.queryMilestoneList(reqMap));
        } catch (Exception e) {
            log.error("里程碑数据查询",e);
            throw new CommonException("里程碑数据查询异常");
        }
    }

    @WebLog(channel = "web", name = "项目宽表，里程碑数据关联查询", action = "/queryReportAndMileList", saveFlag = true)
    @PostMapping(value = "/queryReportAndMileList")
    public JsonResult<?> queryReportAndMileList(@RequestBody Map<String, Object> reqMap){
        try {
            return renderSuccess(reportMapper.queryReportAndMileList(reqMap));
        } catch (Exception e) {
            log.error("项目宽表，里程碑数据关联查询异常",e);
            throw new CommonException("项目宽表，里程碑数据关联查询异常");
        }
    }


    @WebLog(channel = "web", name = "宽表数据导出", action = "/exportReport", saveFlag = true)
//    @PostMapping(value = "/exportReport")
    @RequestMapping(value = "/exportReport",method = RequestMethod.GET)
//    public void exportReport(HttpServletResponse response, @RequestBody Map<String, Object> reqMap){
        public void exportReport(HttpServletResponse response, @RequestParam Map<String,Object> reqMap){
        try {
            reportService.export(response,reqMap);
        } catch (Exception e) {
            log.error("宽表数据数据导出异常",e);
            throw new CommonException("宽表数据数据导出异常");
        }
    }

    @WebLog(channel = "web", name = "里程碑数据新增", action = "/insertMilestoneInfo", saveFlag = true)
    @PostMapping(value = "/insertMilestoneInfo")
    public JsonResult<?> insertMilestoneInfo(@RequestBody MilestoneInfo milestoneInfo){
        try {
            log.info("开始插入里程碑数据[{}]",milestoneInfo.toString());
            milestoneMapper.insertMilestoneInfo(milestoneInfo);
            return renderSuccess();
        } catch (Exception e) {
            log.error("里程碑数据插入异常",e);
            throw new CommonException("里程碑数据插入异常");
        }
    }

    @WebLog(channel = "web", name = "里程碑数据修改", action = "/updateMilestoneInfo", saveFlag = true)
    @PostMapping(value = "/updateMilestoneInfo")
    public JsonResult<?> updateMilestoneInfo(@RequestBody Map<String, Object> reqMap){

        int id = (int) reqMap.get("id");
        int report = milestoneMapper.milestoneCount(id);
        if (0 == report) {
            throw new CommonException("该里程碑数据数据不存在");
        }

        try {
            log.info("开始更新里程碑数据[{}]",reqMap);
            milestoneMapper.updateMilestoneInfo(reqMap);
            return renderSuccess();
        } catch (Exception e) {
            log.error("里程碑数据修改异常",e);
            throw new CommonException("里程碑数据修改异常");
        }
    }


    @WebLog(channel = "web", name = "项目宽表，里程碑数据关联查询", action = "/queryReportMileList", saveFlag = true)
    @PostMapping(value = "/queryReportMileList")
    public JsonResult<?> queryMileList(@RequestBody Map<String, Object> reqMap){
        try {
            return renderSuccess(reportService.queryReportMileList(reqMap));
        } catch (Exception e) {
            log.error("数据查询异常",e);
            throw new CommonException("项目宽表，里程碑数据关联查询异常");
        }
    }

    @RequestMapping(value = "/downloadExcel",method = RequestMethod.GET)
//    @PostMapping(value = "/downloadExcel")
    public void exportReportTemp(HttpServletResponse response,@RequestParam Map<String,Object> params){
//        Map<String,Object> reqMap = new HashMap<>();
        try {
//            reportService.export(response,reqMap);
            reportService.export(response,params);
        } catch (Exception e) {
            log.error("数据导出异常",e);
            throw new CommonException("数据导出异常");
        }
    }

    @WebLog(channel = "web", name = "里程碑数据导出", action = "/exportMilestoneInfo", saveFlag = true)
//    @PostMapping(value = "/exportMilestoneInfo")
    @RequestMapping(value = "/exportMilestoneInfo",method = RequestMethod.GET)
    public void exportMilestoneInfo(HttpServletResponse response, @RequestParam Map<String, Object> reqMap){
        try {
            milestoneService.export(response,reqMap);
        } catch (Exception e) {
            log.error("里程碑数据导出异常",e);
            throw new CommonException("里程碑数据导出异常");
        }
    }

    @WebLog(channel = "web", name = "根据id删除项目宽表数据", action = "/deleteReportInfo", saveFlag = true)
    @PostMapping(value = "/deleteReportInfo")
    public JsonResult<?> deleteReport(@RequestBody Map<String, Object> idMap){

        if (idMap.isEmpty() || StringUtils.isBlank((String) idMap.get("fileIds"))) {
            throw new CommonException("删除宽表数据ID为空");
        }
        try {
            log.info("删除宽表数据[{}]",idMap);
            reportMapper.deleteReport(idMap);
            return renderSuccess();
        } catch (Exception e) {
            log.error("删除宽表数据异常",e);
            throw new CommonException("删除宽表数据异常");
        }
    }

    @WebLog(channel = "web", name = "根据id删除里程碑数据", action = "/deleteMilestone", saveFlag = true)
    @PostMapping(value = "/deleteMilestone")
    public JsonResult<?> deleteMilestone(@RequestBody Map<String, Object> idMap){

        if (idMap.isEmpty() || StringUtils.isBlank((String) idMap.get("fileIds"))) {
            throw new CommonException("删除里程碑数据，ID为空");
        }
        try {
            log.info("删除里程碑数据[{}]",idMap);
            milestoneMapper.deleteMilestone(idMap);
            return renderSuccess();
        } catch (Exception e) {
            log.error("删除里程碑数据异常",e);
            throw new CommonException("删除里程碑数据异常");
        }
    }

}
