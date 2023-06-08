package com.farben.utils;

import com.farben.entity.ReportBean;
import com.farben.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Slf4j
public class WideTableCountUtils {

    /**
     * 项目宽表公式计算
     * （1）、加法 add()函数、
     * （2）、减法subtract()函数、
     * （3）、乘法multiply()函数、
     * （4）、除法divide()函数、
     */
    public static ReportBean budTotalCost(ReportBean reportBean) {

        try {
            //预算-人力成本
            BigDecimal budLaborCosts = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getBudLaborCosts())) {
                budLaborCosts = new BigDecimal(reportBean.getBudLaborCosts());
            }

            //预算-项目费用
            BigDecimal budProCost = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getBudProCost())) {
                budLaborCosts = new BigDecimal(reportBean.getBudProCost());
            }

            //合同金额
            BigDecimal contAmount = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getContAmount())) {
                contAmount = new BigDecimal(reportBean.getContAmount());
            }

            //最新预算-人力成本
            BigDecimal latestLaborCosts = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getLatestLaborCosts())) {
                latestLaborCosts = new BigDecimal(reportBean.getLatestLaborCosts());
            }

            //最新预算-项目费用
            BigDecimal latestProCost = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getLatestProCost())) {
                latestProCost = new BigDecimal(reportBean.getLatestProCost());
            }

            //实际总成本
            BigDecimal actTotalCost = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getActTotalCost())) {
                actTotalCost = new BigDecimal(reportBean.getActTotalCost());
            }

            //实际人力成本
            BigDecimal actLaborCosts = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getActLaborCosts())) {
                actLaborCosts = new BigDecimal(reportBean.getActLaborCosts());
            }

            //实际投入工时（人天）
            BigDecimal actWorkHours = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getActWorkHours())) {
                actWorkHours = new BigDecimal(reportBean.getActWorkHours());
            }

            //最新预算-总工时（人天）
            BigDecimal latestWorkHours = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getLatestWorkHours())) {
                latestWorkHours = new BigDecimal(reportBean.getLatestWorkHours());
            }

            //实际项目费用
            BigDecimal actProCost = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getActProCost())) {
                actProCost = new BigDecimal(reportBean.getActProCost());
            }

            //验收收入
            BigDecimal acceptanceIncome = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getAcceptanceIncome())) {
                acceptanceIncome = new BigDecimal(reportBean.getAcceptanceIncome());
            }

            //已回款金额
            BigDecimal receivedAmount = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getReceivedAmount())) {
                receivedAmount = new BigDecimal(reportBean.getReceivedAmount());
            }

            //预计完工还需工时
            BigDecimal expComTime = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getExpComTime())) {
                expComTime = new BigDecimal(reportBean.getExpComTime());
            }

            //还需项目费用
            BigDecimal expComProCost = new BigDecimal(0);
            if (StringUtils.isNotBlank(reportBean.getExpComProCost())) {
                expComProCost = new BigDecimal(reportBean.getExpComProCost());
            }


            //####################################################################################################

            //预算-总成本=(预算-人力成本+预算-项目费用)
            BigDecimal budTotalCostTemp = budLaborCosts.add(budProCost);
            String budTotalCost = strDataFormat(budTotalCostTemp);
            reportBean.setBudTotalCost(budTotalCost);

            //最新预算-总成本=最新预算-人力成本+最新预算-项目费用
            BigDecimal latestTotalCostTemp = latestLaborCosts.add(latestProCost);
            String latestTotalCost = strDataFormat(latestTotalCostTemp);
            reportBean.setLatestTotalCost(latestTotalCost);

            if (!BigDecimal.ZERO.equals(contAmount)) {
                //预算-销毛=合同金额-合同金额*1.06*0.06*1.13-预算-总成本
//                BigDecimal bigDecimalTmp1 = contAmount.multiply(new BigDecimal("1.06").multiply(new BigDecimal("0.06").multiply(new BigDecimal("1.13"))));
                BigDecimal bigDecimalTmp1 = contAmount.multiply(new BigDecimal("0.071868"));
                BigDecimal budHairLossTemp = contAmount.subtract(bigDecimalTmp1).subtract(budTotalCostTemp);
                String budHairLoss = strDataFormat(budHairLossTemp);
                reportBean.setBudHairLoss(budHairLoss);

                //预算-销毛率=预算-销毛/合同金额
                BigDecimal budGroSaleRateTemp = budHairLossTemp.divide(contAmount,BigDecimal.ROUND_CEILING);
                String budGroSaleRate = strDataFormat(budGroSaleRateTemp);
                reportBean.setBudGroSaleRate(budGroSaleRate);

                //最新预算-销毛=合同金额-合同金额/1.06*0.06*1.13-最新预算-总成本
//                BigDecimal bigDecimal = contAmount.divide((new BigDecimal("1.06")).multiply(new BigDecimal("0.06").multiply(new BigDecimal("1.13"))),BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                BigDecimal bigDecimal = contAmount.divide((new BigDecimal("1.06")).multiply(new BigDecimal("0.0678")),BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                BigDecimal latestHairLossTemp = contAmount.subtract(bigDecimal).subtract(latestTotalCostTemp);
                String latestHairLoss = strDataFormat(latestHairLossTemp);
                reportBean.setLatestHairLoss(latestHairLoss);

                //最新预算-销毛率=最新预算-销毛/合同金额
                BigDecimal latestSaleRateTemp = latestHairLossTemp.divide(contAmount,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String latestSaleRate = strDataFormat(latestSaleRateTemp);
                reportBean.setLatestSaleRate(latestSaleRate);
            }

            //预算成本消耗进度=实际总成本/最新预算-总成本
            if (!BigDecimal.ZERO.equals(actTotalCost) && !BigDecimal.ZERO.equals(latestTotalCostTemp)) {
                BigDecimal budCostConsResTemp = actTotalCost.divide(latestTotalCostTemp,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String budCostConsRes = strDataFormat(budCostConsResTemp);
                reportBean.setBudCostConsRes(budCostConsRes);
            }

            //预算人力成本消耗进度=实际人力成本/最新预算-人力成本
            if (!BigDecimal.ZERO.equals(actLaborCosts) && !BigDecimal.ZERO.equals(latestLaborCosts)) {
                BigDecimal budManCostGressTemp = actLaborCosts.divide(latestLaborCosts,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String budManCostGress = strDataFormat(budManCostGressTemp);
                reportBean.setBudManCostGress(budManCostGress);
            }

            //预算工时消耗进度=实际投入工时（人天）/最新预算-总工时（人天）
            if (!BigDecimal.ZERO.equals(actWorkHours) && !BigDecimal.ZERO.equals(latestWorkHours)) {
                BigDecimal budWorkProgressTemp = actWorkHours.divide(latestWorkHours,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String budWorkProgress = strDataFormat(budWorkProgressTemp);
                reportBean.setBudWorkProgress(budWorkProgress);
            }

            //剩余预算总成本=最新预算-总成本-实际总成本
            BigDecimal remBudTotalCostTemp = latestTotalCostTemp.subtract(actTotalCost);
            String remBudTotalCost = strDataFormat(remBudTotalCostTemp);
            reportBean.setRemBudTotalCost(remBudTotalCost);

            //剩余预算人力成本=最新预算-人力成本-实际人力成本
            BigDecimal remBudLaborCostsTemp = latestLaborCosts.subtract(actLaborCosts);
            String remBudLaborCosts = strDataFormat(remBudLaborCostsTemp);
            reportBean.setRemBudLaborCosts(remBudLaborCosts);

            //剩余预算项目费用=最新预算-项目费用-实际项目费用
            BigDecimal remBudProCostTemp = latestProCost.subtract(actProCost);
            String remBudProCost = strDataFormat(remBudProCostTemp);
            reportBean.setRemBudProCost(remBudProCost);

            //剩余工时=最新预算-总工时（人天）-实际投入工时（人天）
            BigDecimal remBudWorkHoursTemp = latestWorkHours.subtract(actWorkHours);
            String remBudWorkHours = strDataFormat(remBudWorkHoursTemp);
            reportBean.setRemBudWorkHours(remBudWorkHours);

            //验收进度=验收收入/合同金额
            if (!BigDecimal.ZERO.equals(acceptanceIncome) && !BigDecimal.ZERO.equals(contAmount)) {
                BigDecimal acceptanceProgressTemp = acceptanceIncome.divide(contAmount,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String acceptanceProgress = strDataFormat(acceptanceProgressTemp);
                reportBean.setAcceptanceProgress(acceptanceProgress);
            }

            //回款进度=已回款金额/合同金额
            if (!BigDecimal.ZERO.equals(receivedAmount) && !BigDecimal.ZERO.equals(contAmount)) {
                BigDecimal recAmountProgressTemp = receivedAmount.divide(contAmount,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String recAmountProgress = strDataFormat(recAmountProgressTemp);
                reportBean.setRecAmountProgress(recAmountProgress);
            }


            //预计人力成本单价=实际人力成本/实际投入工时（人天）
            if (!BigDecimal.ZERO.equals(actLaborCosts) && !BigDecimal.ZERO.equals(actWorkHours)) {
                BigDecimal estLaborPriceTemp = actLaborCosts.divide(actWorkHours,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                String estLaborPrice = strDataFormat(estLaborPriceTemp);
                reportBean.setEstLaborPrice(estLaborPrice);

                //预计完工还需人力成本=预计完工还需工时*预计人力成本单价
                BigDecimal expComLabCostsTemp = expComTime.multiply(estLaborPriceTemp);
                String expComLabCosts = strDataFormat(expComLabCostsTemp);
                reportBean.setExpComLabCosts(expComLabCosts);

                //I2-I2/1.06*0.06*1.13-AW2-BR2-BS2
                //预计/实际完工销毛=合同金额-合同金额/1.06*0.06*1.13-实际总成本-预计完工还需人力成本-还需项目费用
                BigDecimal expHairLossTemp = contAmount.subtract(contAmount.divide((new BigDecimal("1.06").multiply(new BigDecimal("0.06").multiply(new BigDecimal("1.13")))),BigDecimal.ROUND_CEILING,RoundingMode.DOWN)).subtract(actTotalCost).subtract(expComLabCostsTemp).subtract(expComProCost);
                String expHairLoss = strDataFormat(expHairLossTemp);
                reportBean.setExpHairLoss(expHairLoss);

                if (!BigDecimal.ZERO.equals(contAmount)) {
                    //预计/实际完工销毛率=（预计/实际完工销毛）/合同金额
                    BigDecimal expGroRateTemp = expHairLossTemp.divide(contAmount,BigDecimal.ROUND_CEILING,RoundingMode.DOWN);
                    String expGroRate = strDataFormat(expGroRateTemp);
                    reportBean.setExpGroRate(expGroRate);
                }
            }

            return reportBean;
        } catch (Exception e) {
            log.error("计算公式数据异常",e);
            throw new CommonException("项目名称为:"+reportBean.getProjectName()+",的计算公式数据相关列格式不对");
        }

    }

    public static String strDataFormat (BigDecimal bigDecimal) {
        //保留几位小数
        DecimalFormat df1 = new DecimalFormat("0.00");
        return df1.format(bigDecimal);
    }

}
