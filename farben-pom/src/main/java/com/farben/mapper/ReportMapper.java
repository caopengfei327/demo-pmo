package com.farben.mapper;

import com.farben.entity.ReportBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {

    void addReportInfoList(List<ReportBean> list);

    void updateReportInfoList(List<ReportBean> list);

    int reportCount(int id);
    int queryReportCount(Map<String, Object> paramMap);

    List<ReportBean> queryReportList(Map<String, Object> paramMap);

    List<Map<String,Object>> queryReportMap();

//    int insertReportInfo(Map<String, Object> map);

    int insertReportInfo(ReportBean reportBean);

    int updateReportInfo(Map<String, Object> map);

    List<Map<String,Object>> queryReportAndMileList(Map<String, Object> map);

    List<Map<String, Object>> exportReport(Map<String, Object> map);
    List<Map<String,Object>> queryReportTempList(Map<String, Object> map);

    int deleteReport(Map<String, Object> idMap);
}