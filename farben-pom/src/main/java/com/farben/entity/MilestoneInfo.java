package com.farben.entity;


import com.farben.utils.ImportAnnotation;

import java.io.Serializable;

@ImportAnnotation(length = 17)
public class MilestoneInfo implements Serializable {

    /**
     * 标签ID
     */
    @ImportAnnotation(method = "setId" , type = Integer.class , cellIndex = 0)
    private Integer id;


    /**
     * 项目编号
     */
    @ImportAnnotation(method = "setProjectNo" ,cellIndex = 1)
    private String projectNo;

    /**
     * 验收节点
     */
    @ImportAnnotation(method = "setAccepNode" ,cellIndex = 2)
    private String accepNode;

    /**
     * 验收付款条件
     */
    @ImportAnnotation(method = "setAccepPayTerms" , cellIndex = 3)
    private String accepPayTerms;

    /**
     * 付款比例
     */
    @ImportAnnotation(method = "setPaymentRatio" ,cellIndex = 4)
    private String paymentRatio;

    /**
     * 验收比例
     */
    @ImportAnnotation(method = "setAcceptRatio" ,cellIndex = 5)
    private String acceptRatio;

    /**
     * 应收回款额
     */
    @ImportAnnotation(method = "setAcceptRatio" ,cellIndex = 6)
    private String recAmount;

    /**
     * 实际回款额
     */
    @ImportAnnotation(method = "setActualRepayAmount" ,cellIndex = 7)
    private String actualRepayAmount;

    /**
     * 验收收入
     */
    @ImportAnnotation(method = "setAccepIncome" ,cellIndex = 8)
    private String accepIncome;

    /**
     * 是否验收
     */
    @ImportAnnotation(method = "setAccepOrNot" ,cellIndex = 9)
    private String accepOrNot;

    /**
     * 基线验收计划
     */
    @ImportAnnotation(method = "setBaseAccepPlan" ,cellIndex = 10)
    private String baseAccepPlan;

    /**
     * 实际验收时间
     */
    @ImportAnnotation(method = "setActAccepTime" ,cellIndex = 11)
    private String actAccepTime;

    /**
     * 最新预计验收计划
     */
    @ImportAnnotation(method = "setLatExpAccepplan" ,cellIndex = 12)
    private String latExpAccepplan;

    /**
     * 最新验收年份
     */
    @ImportAnnotation(method = "setLatAccepYear" ,cellIndex = 13)
    private String latAccepYear;

    /**
     * 最新验收计划月份
     */
    @ImportAnnotation(method = "setLatAccepMonth" ,cellIndex = 14)
    private String latAccepMonth;

    /**
     * 是否回款
     */
    @ImportAnnotation(method = "setWheReceivePayment" ,cellIndex = 15)
    private String wheReceivePayment;

    /**
     * 备注
     */
    @ImportAnnotation(method = "setRemarks" ,cellIndex = 16)
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

    public String getAccepNode() {
        return accepNode;
    }

    public void setAccepNode(String accepNode) {
        this.accepNode = accepNode;
    }

    public String getAccepPayTerms() {
        return accepPayTerms;
    }

    public void setAccepPayTerms(String accepPayTerms) {
        this.accepPayTerms = accepPayTerms;
    }

    public String getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(String paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public String getAcceptRatio() {
        return acceptRatio;
    }

    public void setAcceptRatio(String acceptRatio) {
        this.acceptRatio = acceptRatio;
    }

    public String getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(String recAmount) {
        this.recAmount = recAmount;
    }

    public String getActualRepayAmount() {
        return actualRepayAmount;
    }

    public void setActualRepayAmount(String actualRepayAmount) {
        this.actualRepayAmount = actualRepayAmount;
    }

    public String getAccepIncome() {
        return accepIncome;
    }

    public void setAccepIncome(String accepIncome) {
        this.accepIncome = accepIncome;
    }

    public String getAccepOrNot() {
        return accepOrNot;
    }

    public void setAccepOrNot(String accepOrNot) {
        this.accepOrNot = accepOrNot;
    }

    public String getBaseAccepPlan() {
        return baseAccepPlan;
    }

    public void setBaseAccepPlan(String baseAccepPlan) {
        this.baseAccepPlan = baseAccepPlan;
    }

    public String getActAccepTime() {
        return actAccepTime;
    }

    public void setActAccepTime(String actAccepTime) {
        this.actAccepTime = actAccepTime;
    }

    public String getLatExpAccepplan() {
        return latExpAccepplan;
    }

    public void setLatExpAccepplan(String latExpAccepplan) {
        this.latExpAccepplan = latExpAccepplan;
    }

    public String getLatAccepYear() {
        return latAccepYear;
    }

    public void setLatAccepYear(String latAccepYear) {
        this.latAccepYear = latAccepYear;
    }

    public String getLatAccepMonth() {
        return latAccepMonth;
    }

    public void setLatAccepMonth(String latAccepMonth) {
        this.latAccepMonth = latAccepMonth;
    }

    public String getWheReceivePayment() {
        return wheReceivePayment;
    }

    public void setWheReceivePayment(String wheReceivePayment) {
        this.wheReceivePayment = wheReceivePayment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "MilestoneInfo{" +
                "id=" + id +
                ", projectNo='" + projectNo + '\'' +
                ", accepNode='" + accepNode + '\'' +
                ", accepPayTerms='" + accepPayTerms + '\'' +
                ", paymentRatio='" + paymentRatio + '\'' +
                ", acceptRatio='" + acceptRatio + '\'' +
                ", recAmount='" + recAmount + '\'' +
                ", actualRepayAmount='" + actualRepayAmount + '\'' +
                ", accepIncome='" + accepIncome + '\'' +
                ", accepOrNot='" + accepOrNot + '\'' +
                ", baseAccepPlan='" + baseAccepPlan + '\'' +
                ", actAccepTime='" + actAccepTime + '\'' +
                ", latExpAccepplan='" + latExpAccepplan + '\'' +
                ", latAccepYear='" + latAccepYear + '\'' +
                ", latAccepMonth='" + latAccepMonth + '\'' +
                ", wheReceivePayment='" + wheReceivePayment + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
