package com.farben.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class DataColumn {

    public static final List<Map<String, String>> REPORT_DATA_COLUMN_LIST = new ArrayList<>();

    public static final List<Map<String, String>> MILES_DATA_COLUMN_LIST = new ArrayList<>();

    public static final List<Map<String, String>> MILES_AND_REPORT_LIST = new ArrayList<>();

    public static List<Object> REPORT_LIST = new ArrayList<>();

    public static List<Object> MILESTONE_LIST = new ArrayList<>();


    @PostConstruct
    public static void init() {

        //宽表初始化MAP
        Map<String, String> WIDE_MAP = new LinkedHashMap<>(73);

        WIDE_MAP.put("id","标签ID");
        WIDE_MAP.put("projectNo","项目编号");
        WIDE_MAP.put("projectName","项目名称");
        WIDE_MAP.put("custName","客户名称");
        WIDE_MAP.put("custIndustry","客户行业");
        WIDE_MAP.put("contractNo","合同编号");
        WIDE_MAP.put("contStatus","合同状态");
        WIDE_MAP.put("contSignTime","合同签订时间");
        WIDE_MAP.put("contAmount","合同金额");
        WIDE_MAP.put("invoiceType","发票类型");
        WIDE_MAP.put("taxRate","税率");
        WIDE_MAP.put("contPayTerms","合同付款条件");
        WIDE_MAP.put("projectNature","项目性质");
        WIDE_MAP.put("salesDepartment","销售部门");
        WIDE_MAP.put("delSecDepartment","交付二级部门");
        WIDE_MAP.put("delThirdDepartment","交付三级部门");
        WIDE_MAP.put("thirdDepartment","三级");
        WIDE_MAP.put("pic","负责人");
        WIDE_MAP.put("proDelLocation","项目交付地");
        WIDE_MAP.put("projectManager","项目经理");
        WIDE_MAP.put("resSales","责任销售");
        WIDE_MAP.put("resPreSales","责任售前");
        WIDE_MAP.put("proStartTime","项目启动时间");
        WIDE_MAP.put("estProEndTime","预计项目结束时间");
        WIDE_MAP.put("proAccStatus","项目验收状态");
        WIDE_MAP.put("proStatus","项目状态");
        WIDE_MAP.put("estTotalCost","概算-总成本");
        WIDE_MAP.put("estLaborCosts","概算-人力成本");
        WIDE_MAP.put("estProCost","概算-项目费用");
        WIDE_MAP.put("estTotalHours","概算-总工时（人天）");
        WIDE_MAP.put("estHairLos","概算-销毛");
        WIDE_MAP.put("estGroRate","概算-销毛率");
        WIDE_MAP.put("budLaborCosts","预算-人力成本");
        WIDE_MAP.put("budRemainCosts","工时系统剩余人力成本预算");
        WIDE_MAP.put("budProCost","预算-项目费用");
        WIDE_MAP.put("budTotalCost","预算-总成本");
        WIDE_MAP.put("budTotalWorkHours","预算-总工时（人天）");
        WIDE_MAP.put("budHairLoss","预算-销毛");
        WIDE_MAP.put("budGroSaleRate","预算-销毛率");
        WIDE_MAP.put("budChangeLabCosts","预算变更-人力成本");
        WIDE_MAP.put("budChangeProCost","预算变更-项目费用");
        WIDE_MAP.put("budChangeWorkHours","预算变更-工时（人天）");
        WIDE_MAP.put("latestLaborCosts","最新预算-人力成本");
        WIDE_MAP.put("latestProCost","最新预算-项目费用");
        WIDE_MAP.put("latestTotalCost","最新预算-总成本");
        WIDE_MAP.put("latestWorkHours","最新预算-总工时（人天）");
        WIDE_MAP.put("latestHairLoss","最新预算-销毛");
        WIDE_MAP.put("latestSaleRate","最新预算-销毛率");
        WIDE_MAP.put("actTotalCost","实际总成本");
        WIDE_MAP.put("actLaborCosts","实际人力成本");
        WIDE_MAP.put("actProCost","实际项目费用");
        WIDE_MAP.put("actWorkHours","实际投入工时（人天）");
        WIDE_MAP.put("budCostConsRes","预算成本消耗进度");
        WIDE_MAP.put("budManCostGress","预算人力成本消耗进度");
        WIDE_MAP.put("budWorkProgress","预算工时消耗进度");
        WIDE_MAP.put("labVsWorkHours","人力成本执行VS工时执行");
        WIDE_MAP.put("remBudTotalCost","剩余预算总成本");
        WIDE_MAP.put("remBudLaborCosts","剩余预算人力成本");
        WIDE_MAP.put("remBudProCost","剩余预算项目费用");
        WIDE_MAP.put("remBudWorkHours","剩余工时");
        WIDE_MAP.put("numTobAccepted","待验收里程碑数量");
        WIDE_MAP.put("numMilestones","已验收里程碑数量");
        WIDE_MAP.put("acceptanceDate","验收日期");
        WIDE_MAP.put("acceptanceIncome","验收收入");
        WIDE_MAP.put("acceptanceProgress","验收进度");
        WIDE_MAP.put("receivedAmount","已回款金额");
        WIDE_MAP.put("recAmountProgress","回款进度");
        WIDE_MAP.put("expComTime","预计完工还需工时");
        WIDE_MAP.put("estLaborPrice","预计人力成本单价");
        WIDE_MAP.put("expComLabCosts","预计完工还需人力成本");
        WIDE_MAP.put("expComProCost","还需项目费用");
        WIDE_MAP.put("expHairLoss","预计/实际完工销毛");
        WIDE_MAP.put("expGroRate","预计/实际完工销毛率");
        WIDE_MAP.put("remarks","备注");

        //###############################初始化宽表前端展示List###############################//
        for(String key:WIDE_MAP.keySet()){

            Map<String, String> mapData = new HashMap<>();
            mapData.put("title",WIDE_MAP.get(key));
            mapData.put("props",key);
            REPORT_DATA_COLUMN_LIST.add(mapData);
        }
        //###############################初始化宽表前端展示List###############################//


        //###############################初始化宽表excel表头（ALL）###############################//
        Collection<String> value = WIDE_MAP.values();
        REPORT_LIST = new ArrayList<>(value);
        //###############################初始化宽表excel表头（ALL）###############################//

        //里程碑初始化MAP
        Map<String, String> milestoneInfoMap = new LinkedHashMap<>(17);

        milestoneInfoMap.put("id","标签ID");
        milestoneInfoMap.put("projectNo","项目编号");
        milestoneInfoMap.put("accepNode","验收节点");
        milestoneInfoMap.put("accepPayTerms","验收付款条件");
        milestoneInfoMap.put("paymentRatio","付款比例");
        milestoneInfoMap.put("acceptRatio","验收比例");
        milestoneInfoMap.put("recAmount","应收回款额");
        milestoneInfoMap.put("actualRepayAmount","实际回款额");
        milestoneInfoMap.put("accepIncome","验收收入");
        milestoneInfoMap.put("accepOrNot","是否验收");
        milestoneInfoMap.put("baseAccepPlan","基线验收计划");
        milestoneInfoMap.put("actAccepTime","实际验收时间");
        milestoneInfoMap.put("latExpAccepplan","最新预计验收计划");
        milestoneInfoMap.put("latAccepYear","最新验收年份");
        milestoneInfoMap.put("latAccepMonth","最新验收计划月份");
        milestoneInfoMap.put("wheReceivePayment","是否回款");
        milestoneInfoMap.put("remarks","备注");


        //###############################初始化里程碑前端展示List###############################//
        for(String key:milestoneInfoMap.keySet()){

            Map<String, String> mapData = new HashMap<>();
            mapData.put("title",milestoneInfoMap.get(key));
            mapData.put("props",key);
            MILES_DATA_COLUMN_LIST.add(mapData);
        }
        //###############################初始化里程碑前端展示List###############################//


        //###############################初始化里程碑excel表头（ALL）###############################//
        Collection<String> mileValue = milestoneInfoMap.values();
        MILESTONE_LIST = new ArrayList<>(mileValue);
        //###############################初始化里程碑excel表头（ALL）###############################//


        //里程碑初始化MAP
        Map<String, String> milesAndReportMap = new LinkedHashMap<>(17);

        milesAndReportMap.put("id","标签ID");
        milesAndReportMap.put("projectNo","项目编号");
        milesAndReportMap.put("projectName","项目名称");
        milesAndReportMap.put("contractNo","合同编号");
        milesAndReportMap.put("custName","客户名称");
        milesAndReportMap.put("contSignTime","合同签订时间");
        milesAndReportMap.put("salesDepartment","销售部门");
        milesAndReportMap.put("delSecDepartment","交付部门");
        milesAndReportMap.put("delThirdDepartment","交付部门（三级）");
        milesAndReportMap.put("projectManager","项目经理");
        milesAndReportMap.put("resSales","销售经理");
        milesAndReportMap.put("contAmount","合同金额");
        milesAndReportMap.put("taxRate","税率");
        milesAndReportMap.put("accepNode","验收节点");
        milesAndReportMap.put("accepPayTerms","验收付款条件");
        milesAndReportMap.put("paymentRatio","付款比例");
        milesAndReportMap.put("acceptRatio","验收比例");
        milesAndReportMap.put("recAmount","应收回款额");
        milesAndReportMap.put("actualRepayAmount","实际回款额");
        milesAndReportMap.put("accepIncome","验收收入");
        milesAndReportMap.put("accepOrNot","是否验收");
        milesAndReportMap.put("baseAccepPlan","基线验收计划");
        milesAndReportMap.put("actAccepTime","实际验收时间");
        milesAndReportMap.put("latExpAccepplan","最新预计验收计划");
        milesAndReportMap.put("latAccepYear","最新验收年份");
        milesAndReportMap.put("latAccepMonth","最新验收计划月份");
        milesAndReportMap.put("wheReceivePayment","是否回款");
        milesAndReportMap.put("remarks","备注");

        //###############################初始化宽表关联里程碑前端展示List###############################//
        for(String key:milesAndReportMap.keySet()){

            Map<String, String> mapData = new HashMap<>();
            mapData.put("title",milesAndReportMap.get(key));
            mapData.put("props",key);
            MILES_AND_REPORT_LIST.add(mapData);
        }
        //###############################初始化宽表关联里程碑前端展示List###############################//

    }
}
