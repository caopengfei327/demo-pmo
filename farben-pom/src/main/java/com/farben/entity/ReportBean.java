package com.farben.entity;


import com.farben.utils.ImportAnnotation;

import java.io.Serializable;

@ImportAnnotation(length = 74)
public class ReportBean implements Serializable {

    /**
     * 标签ID
     */
    @ImportAnnotation(method = "setId" , type = Integer.class , cellIndex = 0)
    private Integer id;

    /**
     * 项目编号
     */
    @ImportAnnotation(method = "setProjectNo",cellIndex = 1)
    private String projectNo;

    /**
     * 项目名称
     */
    @ImportAnnotation(method = "setProjectName",cellIndex = 2)
    private String projectName;

    /**
     * 客户名称
     */
    @ImportAnnotation(method = "setCustName",cellIndex = 3)
    private String custName;

    /**
     * 客户行业
     */
    @ImportAnnotation(method = "setCustIndustry",cellIndex = 4)
    private String custIndustry;

    /**
     * 合同编号
     */
    @ImportAnnotation(method = "setContractNo",cellIndex = 5)
    private String contractNo;

    /**
     * 合同状态
     */
    @ImportAnnotation(method = "setContStatus",cellIndex = 6)
    private String contStatus;

    /**
     * 合同签订时间
     */
    @ImportAnnotation(method = "setContSignTime",cellIndex = 7)
    private String contSignTime;

    /**
     * 合同金额
     */
    @ImportAnnotation(method = "setContAmount", cellIndex = 8)
    private String contAmount;

    /**
     * 发票类型
     */
    @ImportAnnotation(method = "setInvoiceType", cellIndex = 9)
    private String invoiceType;

    /**
     * 税率
     */
    @ImportAnnotation(method = "setTaxRate", cellIndex = 10)
    private String taxRate;

    /**
     * 合同付款条件
     */
    @ImportAnnotation(method = "setContPayTerms", cellIndex = 11)
    private String contPayTerms;

    /**
     * 项目性质
     */
    @ImportAnnotation(method = "setProjectNature", cellIndex = 12)
    private String projectNature;

    /**
     * 销售部门
     */
//    @ImportAnnotation(method = "setSalesDepartment" , cellIndex = 13)
    @ImportAnnotation(method = "setSalesDepartment" , cellIndex = 13)
    private String salesDepartment;

    /**
     * 交付二级部门
     */
    @ImportAnnotation(method = "setDelSecDepartment" , cellIndex = 14)
    private String delSecDepartment;

    /**
     * 交付三级部门
     */
    @ImportAnnotation(method = "setDelThirdDepartment" , cellIndex = 15)
    private String delThirdDepartment;

    /**
     * 三级
     */
    @ImportAnnotation(method = "setThirdDepartment" , cellIndex = 16)
    private String thirdDepartment;

    /**
     * 负责人
     */
    @ImportAnnotation(method = "setPic" , cellIndex = 17)
    private String pic;

    /**
     * 项目交付地
     */
    @ImportAnnotation(method = "setProDelLocation" , cellIndex = 18)
    private String proDelLocation;

    /**
     * 项目经理
     */
    @ImportAnnotation(method = "setProjectManager" , cellIndex = 19)
    private String projectManager;

    /**
     * 责任销售
     */
    @ImportAnnotation(method = "setResSales" , cellIndex = 20)
    private String resSales;

    /**
     * 责任售前
     */
    @ImportAnnotation(method = "setResPreSales" , cellIndex = 21)
    private String resPreSales;

    /**
     * 项目启动时间
     */
    @ImportAnnotation(method = "setProStartTime" , cellIndex = 22)
    private String proStartTime;

    /**
     * 预计项目结束时间
     */
    @ImportAnnotation(method = "setEstProEndTime" , cellIndex = 23)
    private String estProEndTime;

    /**
     * 项目验收状态
     */
    @ImportAnnotation(method = "setProAccStatus" , cellIndex = 24)
    private String proAccStatus;

    /**
     * 项目状态
     */
    @ImportAnnotation(method = "setProStatus" , cellIndex = 25)
    private String proStatus;

    /**
     * 概算-总成本
     */
    @ImportAnnotation(method = "setEstTotalCost" ,cellIndex = 26)
    private String estTotalCost;

    /**
     * 概算-人力成本
     */
    @ImportAnnotation(method = "setEstLaborCosts" ,cellIndex = 27)
    private String estLaborCosts;

    /**
     * 概算-项目费用
     */
    @ImportAnnotation(method = "setEstProCost" ,cellIndex = 28)
    private String estProCost;

    /**
     * 概算-总工时（人天）
     */
    @ImportAnnotation(method = "setEstTotalHours" ,cellIndex = 29)
    private String estTotalHours;

    /**
     * 概算-销毛
     */
    @ImportAnnotation(method = "setEstHairLos" , cellIndex = 30)
    private String estHairLos;

    /**
     * 概算-销毛率
     */
    @ImportAnnotation(method = "setEstGroRate" ,cellIndex = 31)
    private String estGroRate;

    /**
     * 预算-人力成本
     */
    @ImportAnnotation(method = "setBudLaborCosts" , cellIndex = 32)
    private String budLaborCosts;

    /**
     * 工时系统剩余人力成本预算
     */
    @ImportAnnotation(method = "setBudRemainCosts" , cellIndex = 33)
    private String budRemainCosts;

    /**
     * 预算-项目费用
     */
    @ImportAnnotation(method = "setBudProCost", cellIndex = 34)
    private String budProCost;

    /**
     * 预算-总成本
     */
    @ImportAnnotation(method = "setBudTotalCost",cellIndex = 35)
    private String budTotalCost;

    /**
     * 预算-总工时（人天）
     */
    @ImportAnnotation(method = "setBudTotalWorkHours" ,cellIndex = 36)
    private String budTotalWorkHours;

    /**
     * 预算-销毛
     */
    @ImportAnnotation(method = "setBudHairLoss", cellIndex = 37)
    private String budHairLoss;

    /**
     * 预算-销毛率
     */
    @ImportAnnotation(method = "setBudGroSaleRate" , cellIndex = 38)
    private String budGroSaleRate;

    /**
     * 预算变更-人力成本
     */
    @ImportAnnotation(method = "setBudChangeLabCosts" , cellIndex = 39)
    private String budChangeLabCosts;

    /**
     * 预算变更-项目费用
     */
    @ImportAnnotation(method = "setBudChangeProCost" , cellIndex = 40)
    private String budChangeProCost;

    /**
     * 预算变更-工时（人天）
     */
    @ImportAnnotation(method = "setBudChangeWorkHours" ,cellIndex = 41)
    private String budChangeWorkHours;

    /**
     * 最新预算-人力成本
     */
    @ImportAnnotation(method = "setLatestLaborCosts" , cellIndex = 42)
    private String latestLaborCosts;

    /**
     * 最新预算-项目费用
     */
    @ImportAnnotation(method = "setLatestProCost" , cellIndex = 43)
    private String latestProCost;

    /**
     * 最新预算-总成本
     */
    @ImportAnnotation(method = "setLatestTotalCost" , cellIndex = 44)
    private String latestTotalCost;

    /**
     * 最新预算-总工时（人天）
     */
    @ImportAnnotation(method = "setLatestWorkHours" ,cellIndex = 45)
    private String latestWorkHours;

    /**
     * 最新预算-销毛
     */
    @ImportAnnotation(method = "setLatestHairLoss" ,cellIndex = 46)
    private String latestHairLoss;

    /**
     * 最新预算-销毛率
     */
    @ImportAnnotation(method = "setLatestSaleRate" ,cellIndex = 47)
    private String latestSaleRate;

    /**
     * 实际总成本
     */
    @ImportAnnotation(method = "setActTotalCost" ,cellIndex = 48)
    private String actTotalCost;

    /**
     * 实际人力成本
     */
    @ImportAnnotation(method = "setActLaborCosts" ,cellIndex = 49)
    private String actLaborCosts;

    /**
     * 实际项目费用
     */
    @ImportAnnotation(method = "setActProCost" ,cellIndex = 50)
    private String actProCost;

    /**
     * 实际投入工时（人天）
     */
    @ImportAnnotation(method = "setActWorkHours" ,cellIndex = 51)
    private String actWorkHours;

    /**
     * 预算成本消耗进度
     */
    @ImportAnnotation(method = "setBudCostConsRes" ,cellIndex = 52)
    private String budCostConsRes;

    /**
     * 预算人力成本消耗进度
     */
    @ImportAnnotation(method = "setBudManCostGress" , cellIndex = 53)
    private String budManCostGress;

    /**
     * 预算工时消耗进度
     */
    @ImportAnnotation(method = "setBudWorkProgress" ,cellIndex = 54)
    private String budWorkProgress;

    /**
     * 人力成本执行VS工时执行
     */
    @ImportAnnotation(method = "setLabVsWorkHours" ,cellIndex = 55)
    private String labVsWorkHours;

    /**
     * 剩余预算总成本
     */
    @ImportAnnotation(method = "setRemBudTotalCost" ,cellIndex = 56)
    private String remBudTotalCost;

    /**
     * 剩余预算人力成本
     */
    @ImportAnnotation(method = "setRemBudLaborCosts" , cellIndex = 57)
    private String remBudLaborCosts;

    /**
     * 剩余预算项目费用
     */
    @ImportAnnotation(method = "setRemBudProCost" ,cellIndex = 58)
    private String remBudProCost;

    /**
     * 剩余工时
     */
    @ImportAnnotation(method = "setRemBudWorkHours",cellIndex = 59)
    private String remBudWorkHours;

    /**
     * 待验收里程碑数量
     */
    @ImportAnnotation(method = "setNumTobAccepted",cellIndex = 60)
    private String numTobAccepted;

    /**
     * 已验收里程碑数量
     */
    @ImportAnnotation(method = "setNumMilestones" , cellIndex = 61)
    private String numMilestones;

    /**
     * 验收日期
     */
    @ImportAnnotation(method = "setAcceptanceDate" , cellIndex = 62)
    private String acceptanceDate;

    /**
     * 验收收入
     */
    @ImportAnnotation(method = "setAcceptanceIncome" ,cellIndex = 63)
    private String acceptanceIncome;

    /**
     * 验收进度
     */
    @ImportAnnotation(method = "setAcceptanceProgress" , cellIndex = 64)
    private String acceptanceProgress;

    /**
     * 已回款金额
     */
    @ImportAnnotation(method = "setReceivedAmount" ,cellIndex = 65)
    private String receivedAmount;

    /**
     * 回款进度
     */
    @ImportAnnotation(method = "setRecAmountProgress" ,cellIndex = 66)
    private String recAmountProgress;

    /**
     * 预计完工还需工时
     */
    @ImportAnnotation(method = "setExpComTime" ,cellIndex = 67)
    private String expComTime;

    /**
     * 预计人力成本单价
     */
    @ImportAnnotation(method = "setEstLaborPrice" ,cellIndex = 68)
    private String estLaborPrice;

    /**
     * 预计完工还需人力成本
     */
    @ImportAnnotation(method = "setExpComLabCosts" , cellIndex = 69)
    private String expComLabCosts;

    /**
     * 还需项目费用
     */
    @ImportAnnotation(method = "setExpComProCost" , cellIndex = 70)
    private String expComProCost;

    /**
     * 预计/实际完工销毛
     */
    @ImportAnnotation(method = "setExpHairLoss",cellIndex = 71)
    private String expHairLoss;

    /**
     * 预计/实际完工销毛率
     */
    @ImportAnnotation(method = "setExpGroRate",cellIndex = 72)
    private String expGroRate;

    /**
     * 备注
     */
    @ImportAnnotation(method = "setRemarks",cellIndex = 73)
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContStatus() {
        return contStatus;
    }

    public void setContStatus(String contStatus) {
        this.contStatus = contStatus;
    }

    public String getContSignTime() {
        return contSignTime;
    }

    public void setContSignTime(String contSignTime) {
        this.contSignTime = contSignTime;
    }

    public String getContAmount() {
        return contAmount;
    }

    public void setContAmount(String contAmount) {
        this.contAmount = contAmount;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getContPayTerms() {
        return contPayTerms;
    }

    public void setContPayTerms(String contPayTerms) {
        this.contPayTerms = contPayTerms;
    }

    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
    }

    public String getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(String salesDepartment) {
        this.salesDepartment = salesDepartment;
    }

    public String getDelSecDepartment() {
        return delSecDepartment;
    }

    public void setDelSecDepartment(String delSecDepartment) {
        this.delSecDepartment = delSecDepartment;
    }

    public String getDelThirdDepartment() {
        return delThirdDepartment;
    }

    public void setDelThirdDepartment(String delThirdDepartment) {
        this.delThirdDepartment = delThirdDepartment;
    }

    public String getThirdDepartment() {
        return thirdDepartment;
    }

    public void setThirdDepartment(String thirdDepartment) {
        this.thirdDepartment = thirdDepartment;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProDelLocation() {
        return proDelLocation;
    }

    public void setProDelLocation(String proDelLocation) {
        this.proDelLocation = proDelLocation;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getResSales() {
        return resSales;
    }

    public void setResSales(String resSales) {
        this.resSales = resSales;
    }

    public String getResPreSales() {
        return resPreSales;
    }

    public void setResPreSales(String resPreSales) {
        this.resPreSales = resPreSales;
    }

    public String getProStartTime() {
        return proStartTime;
    }

    public void setProStartTime(String proStartTime) {
        this.proStartTime = proStartTime;
    }

    public String getEstProEndTime() {
        return estProEndTime;
    }

    public void setEstProEndTime(String estProEndTime) {
        this.estProEndTime = estProEndTime;
    }

    public String getProAccStatus() {
        return proAccStatus;
    }

    public void setProAccStatus(String proAccStatus) {
        this.proAccStatus = proAccStatus;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getEstTotalCost() {
        return estTotalCost;
    }

    public void setEstTotalCost(String estTotalCost) {
        this.estTotalCost = estTotalCost;
    }

    public String getEstLaborCosts() {
        return estLaborCosts;
    }

    public void setEstLaborCosts(String estLaborCosts) {
        this.estLaborCosts = estLaborCosts;
    }

    public String getEstProCost() {
        return estProCost;
    }

    public void setEstProCost(String estProCost) {
        this.estProCost = estProCost;
    }

    public String getEstTotalHours() {
        return estTotalHours;
    }

    public void setEstTotalHours(String estTotalHours) {
        this.estTotalHours = estTotalHours;
    }

    public String getEstHairLos() {
        return estHairLos;
    }

    public void setEstHairLos(String estHairLos) {
        this.estHairLos = estHairLos;
    }

    public String getEstGroRate() {
        return estGroRate;
    }

    public void setEstGroRate(String estGroRate) {
        this.estGroRate = estGroRate;
    }

    public String getBudLaborCosts() {
        return budLaborCosts;
    }

    public void setBudLaborCosts(String budLaborCosts) {
        this.budLaborCosts = budLaborCosts;
    }

    public String getBudRemainCosts() {
        return budRemainCosts;
    }

    public void setBudRemainCosts(String budRemainCosts) {
        this.budRemainCosts = budRemainCosts;
    }

    public String getBudProCost() {
        return budProCost;
    }

    public void setBudProCost(String budProCost) {
        this.budProCost = budProCost;
    }

    public String getBudTotalCost() {
        return budTotalCost;
    }

    public void setBudTotalCost(String budTotalCost) {
        this.budTotalCost = budTotalCost;
    }

    public String getBudTotalWorkHours() {
        return budTotalWorkHours;
    }

    public void setBudTotalWorkHours(String budTotalWorkHours) {
        this.budTotalWorkHours = budTotalWorkHours;
    }

    public String getBudHairLoss() {
        return budHairLoss;
    }

    public void setBudHairLoss(String budHairLoss) {
        this.budHairLoss = budHairLoss;
    }

    public String getBudGroSaleRate() {
        return budGroSaleRate;
    }

    public void setBudGroSaleRate(String budGroSaleRate) {
        this.budGroSaleRate = budGroSaleRate;
    }

    public String getBudChangeLabCosts() {
        return budChangeLabCosts;
    }

    public void setBudChangeLabCosts(String budChangeLabCosts) {
        this.budChangeLabCosts = budChangeLabCosts;
    }

    public String getBudChangeProCost() {
        return budChangeProCost;
    }

    public void setBudChangeProCost(String budChangeProCost) {
        this.budChangeProCost = budChangeProCost;
    }

    public String getBudChangeWorkHours() {
        return budChangeWorkHours;
    }

    public void setBudChangeWorkHours(String budChangeWorkHours) {
        this.budChangeWorkHours = budChangeWorkHours;
    }

    public String getLatestLaborCosts() {
        return latestLaborCosts;
    }

    public void setLatestLaborCosts(String latestLaborCosts) {
        this.latestLaborCosts = latestLaborCosts;
    }

    public String getLatestProCost() {
        return latestProCost;
    }

    public void setLatestProCost(String latestProCost) {
        this.latestProCost = latestProCost;
    }

    public String getLatestTotalCost() {
        return latestTotalCost;
    }

    public void setLatestTotalCost(String latestTotalCost) {
        this.latestTotalCost = latestTotalCost;
    }

    public String getLatestWorkHours() {
        return latestWorkHours;
    }

    public void setLatestWorkHours(String latestWorkHours) {
        this.latestWorkHours = latestWorkHours;
    }

    public String getLatestHairLoss() {
        return latestHairLoss;
    }

    public void setLatestHairLoss(String latestHairLoss) {
        this.latestHairLoss = latestHairLoss;
    }

    public String getLatestSaleRate() {
        return latestSaleRate;
    }

    public void setLatestSaleRate(String latestSaleRate) {
        this.latestSaleRate = latestSaleRate;
    }

    public String getActTotalCost() {
        return actTotalCost;
    }

    public void setActTotalCost(String actTotalCost) {
        this.actTotalCost = actTotalCost;
    }

    public String getActLaborCosts() {
        return actLaborCosts;
    }

    public void setActLaborCosts(String actLaborCosts) {
        this.actLaborCosts = actLaborCosts;
    }

    public String getActProCost() {
        return actProCost;
    }

    public void setActProCost(String actProCost) {
        this.actProCost = actProCost;
    }

    public String getActWorkHours() {
        return actWorkHours;
    }

    public void setActWorkHours(String actWorkHours) {
        this.actWorkHours = actWorkHours;
    }

    public String getBudCostConsRes() {
        return budCostConsRes;
    }

    public void setBudCostConsRes(String budCostConsRes) {
        this.budCostConsRes = budCostConsRes;
    }

    public String getBudManCostGress() {
        return budManCostGress;
    }

    public void setBudManCostGress(String budManCostGress) {
        this.budManCostGress = budManCostGress;
    }

    public String getBudWorkProgress() {
        return budWorkProgress;
    }

    public void setBudWorkProgress(String budWorkProgress) {
        this.budWorkProgress = budWorkProgress;
    }

    public String getLabVsWorkHours() {
        return labVsWorkHours;
    }

    public void setLabVsWorkHours(String labVsWorkHours) {
        this.labVsWorkHours = labVsWorkHours;
    }

    public String getRemBudTotalCost() {
        return remBudTotalCost;
    }

    public void setRemBudTotalCost(String remBudTotalCost) {
        this.remBudTotalCost = remBudTotalCost;
    }

    public String getRemBudLaborCosts() {
        return remBudLaborCosts;
    }

    public void setRemBudLaborCosts(String remBudLaborCosts) {
        this.remBudLaborCosts = remBudLaborCosts;
    }

    public String getRemBudProCost() {
        return remBudProCost;
    }

    public void setRemBudProCost(String remBudProCost) {
        this.remBudProCost = remBudProCost;
    }

    public String getRemBudWorkHours() {
        return remBudWorkHours;
    }

    public void setRemBudWorkHours(String remBudWorkHours) {
        this.remBudWorkHours = remBudWorkHours;
    }

    public String getNumTobAccepted() {
        return numTobAccepted;
    }

    public void setNumTobAccepted(String numTobAccepted) {
        this.numTobAccepted = numTobAccepted;
    }

    public String getNumMilestones() {
        return numMilestones;
    }

    public void setNumMilestones(String numMilestones) {
        this.numMilestones = numMilestones;
    }

    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getAcceptanceIncome() {
        return acceptanceIncome;
    }

    public void setAcceptanceIncome(String acceptanceIncome) {
        this.acceptanceIncome = acceptanceIncome;
    }

    public String getAcceptanceProgress() {
        return acceptanceProgress;
    }

    public void setAcceptanceProgress(String acceptanceProgress) {
        this.acceptanceProgress = acceptanceProgress;
    }

    public String getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(String receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public String getRecAmountProgress() {
        return recAmountProgress;
    }

    public void setRecAmountProgress(String recAmountProgress) {
        this.recAmountProgress = recAmountProgress;
    }

    public String getExpComTime() {
        return expComTime;
    }

    public void setExpComTime(String expComTime) {
        this.expComTime = expComTime;
    }

    public String getEstLaborPrice() {
        return estLaborPrice;
    }

    public void setEstLaborPrice(String estLaborPrice) {
        this.estLaborPrice = estLaborPrice;
    }

    public String getExpComLabCosts() {
        return expComLabCosts;
    }

    public void setExpComLabCosts(String expComLabCosts) {
        this.expComLabCosts = expComLabCosts;
    }

    public String getExpComProCost() {
        return expComProCost;
    }

    public void setExpComProCost(String expComProCost) {
        this.expComProCost = expComProCost;
    }

    public String getExpHairLoss() {
        return expHairLoss;
    }

    public void setExpHairLoss(String expHairLoss) {
        this.expHairLoss = expHairLoss;
    }

    public String getExpGroRate() {
        return expGroRate;
    }

    public void setExpGroRate(String expGroRate) {
        this.expGroRate = expGroRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ReportBean{" +
                "id=" + id +
                ", projectNo='" + projectNo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", custName='" + custName + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", contStatus='" + contStatus + '\'' +
                ", contSignTime='" + contSignTime + '\'' +
                ", contAmount='" + contAmount + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", contPayTerms='" + contPayTerms + '\'' +
                ", projectNature='" + projectNature + '\'' +
                ", salesDepartment='" + salesDepartment + '\'' +
                ", delSecDepartment='" + delSecDepartment + '\'' +
                ", delThirdDepartment='" + delThirdDepartment + '\'' +
                ", thirdDepartment='" + thirdDepartment + '\'' +
                ", pic='" + pic + '\'' +
                ", proDelLocation='" + proDelLocation + '\'' +
                ", projectManager='" + projectManager + '\'' +
                ", resSales='" + resSales + '\'' +
                ", resPreSales='" + resPreSales + '\'' +
                ", proStartTime='" + proStartTime + '\'' +
                ", estProEndTime='" + estProEndTime + '\'' +
                ", proAccStatus='" + proAccStatus + '\'' +
                ", proStatus='" + proStatus + '\'' +
                ", estTotalCost='" + estTotalCost + '\'' +
                ", estLaborCosts='" + estLaborCosts + '\'' +
                ", estProCost='" + estProCost + '\'' +
                ", estTotalHours='" + estTotalHours + '\'' +
                ", estHairLos='" + estHairLos + '\'' +
                ", estGroRate='" + estGroRate + '\'' +
                ", budLaborCosts='" + budLaborCosts + '\'' +
                ", budRemainCosts='" + budRemainCosts + '\'' +
                ", budProCost='" + budProCost + '\'' +
                ", budTotalCost='" + budTotalCost + '\'' +
                ", budTotalWorkHours='" + budTotalWorkHours + '\'' +
                ", budHairLoss='" + budHairLoss + '\'' +
                ", budGroSaleRate='" + budGroSaleRate + '\'' +
                ", budChangeLabCosts='" + budChangeLabCosts + '\'' +
                ", budChangeProCost='" + budChangeProCost + '\'' +
                ", budChangeWorkHours='" + budChangeWorkHours + '\'' +
                ", latestLaborCosts='" + latestLaborCosts + '\'' +
                ", latestProCost='" + latestProCost + '\'' +
                ", latestTotalCost='" + latestTotalCost + '\'' +
                ", latestWorkHours='" + latestWorkHours + '\'' +
                ", latestHairLoss='" + latestHairLoss + '\'' +
                ", latestSaleRate='" + latestSaleRate + '\'' +
                ", actTotalCost='" + actTotalCost + '\'' +
                ", actLaborCosts='" + actLaborCosts + '\'' +
                ", actProCost='" + actProCost + '\'' +
                ", actWorkHours='" + actWorkHours + '\'' +
                ", budCostConsRes='" + budCostConsRes + '\'' +
                ", budManCostGress='" + budManCostGress + '\'' +
                ", budWorkProgress='" + budWorkProgress + '\'' +
                ", labVsWorkHours='" + labVsWorkHours + '\'' +
                ", remBudTotalCost='" + remBudTotalCost + '\'' +
                ", remBudLaborCosts='" + remBudLaborCosts + '\'' +
                ", remBudProCost='" + remBudProCost + '\'' +
                ", remBudWorkHours='" + remBudWorkHours + '\'' +
                ", numTobAccepted='" + numTobAccepted + '\'' +
                ", numMilestones='" + numMilestones + '\'' +
                ", acceptanceDate='" + acceptanceDate + '\'' +
                ", acceptanceIncome='" + acceptanceIncome + '\'' +
                ", acceptanceProgress='" + acceptanceProgress + '\'' +
                ", receivedAmount='" + receivedAmount + '\'' +
                ", recAmountProgress='" + recAmountProgress + '\'' +
                ", expComTime='" + expComTime + '\'' +
                ", estLaborPrice='" + estLaborPrice + '\'' +
                ", expComLabCosts='" + expComLabCosts + '\'' +
                ", expComProCost='" + expComProCost + '\'' +
                ", expHairLoss='" + expHairLoss + '\'' +
                ", expGroRate='" + expGroRate + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
