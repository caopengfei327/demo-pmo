package com.farben.mapper;

import com.farben.entity.MilestoneInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MilestoneMapper {

    void addMilestoneInfo(List<MilestoneInfo> list);

    void updateMilestoneInfoList(List<MilestoneInfo> list);

    int milestoneCount(int id);
    int queryMilestoneCount(Map<String, Object> paramMap);

//    int insertMilestoneInfo(Map<String, Object> map);

    int insertMilestoneInfo(MilestoneInfo milestoneInfo);

    int updateMilestoneInfo(Map<String, Object> map);

    List<MilestoneInfo> queryMilestonetList(Map<String, Object> paramMap);

    List<Map<String, Object>> queryMileList(Map<String, Object> map);

    List<Map<String, Object>> exportMilestoneInfo(Map<String, Object> map);

    int deleteMilestone(Map<String, Object> idMap);

}
