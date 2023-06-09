-- CREATE TABLE `WIDE_REPORT_TABLE`  (
--   `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
--   `PROJECT_NO` varchar(10) NULL COMMENT '项目编号',
--   `PROJECT_NAME` varchar(255) NULL COMMENT '项目名称',
--   `CUST_NAME` varchar(255) NULL COMMENT '客户名称',
--   `CUST_INDUSTRY` varchar(100) NULL COMMENT '客户行业',
--   `CONTRACT_NO` varchar(100) NULL COMMENT '合同编号',
--   `CONTRACT_STATUS` varchar(10) NULL COMMENT '合同状态',
--   `CONTRACT_SIGNING_TIME` varchar(10) NULL COMMENT '合同签订时间',
--   `CONTRACT_AMOUNT` numeric(19, 2) NULL COMMENT '合同金额',
--   `INVOICE_TYPE` varchar(10) NULL COMMENT '发票类型',
--   `TAX_RATE` numeric(5, 2) NULL COMMENT '税率',
--   `CONTRACT_PAYMENT_TERMS` varchar(255) NULL COMMENT '合同付款条件',
--   `PROJECT_NATURE` varchar(100) NULL COMMENT '项目性质',
--   `SALES_DEPARTMENT` varchar(100) NULL COMMENT '销售部门',
--   `DELIVERY_SECONDARY_DEPARTMENT` varchar(100) NULL COMMENT '交付二级部门',
--   `DELIVERY_THIRDLEVEL_DEPARTMENT` varchar(100) NULL COMMENT '交付三级部门',
--   `THIRDLEVEL_DEPARTMENT` varchar(100) NULL COMMENT '三级',
--   `PIC` varchar(100) NULL COMMENT '负责人',
--   `PROJECT_DELIVERY_LOCATION` varchar(255) NULL COMMENT '项目交付地',
--   `PROJECT_MANAGER` varchar(100) NULL COMMENT '项目经理',
--   `RESPONSIBLE_SALES` varchar(100) NULL COMMENT '责任销售',
--   `RESPONSIBLE_PRE_SALES` varchar(100) NULL COMMENT '责任售前',
--   `PROJECT_START_TIME` varchar(6) NULL COMMENT '项目启动时间',
--   `ESTIMATED_PROJECT_ENDTIME` varchar(6) NULL COMMENT '预计项目结束时间',
--   `PROJECT_ACCEPTANCE_STATUS` varchar(6) NULL COMMENT '项目验收状态',
--   `PROJECT_STATUS` varchar(6) NULL COMMENT '项目状态',
--   `ESTIMATE_TOTALCOST` numeric(19, 2) NULL COMMENT '概算-总成本',
--   `ESTIMATE_LABORCOSTS` numeric(19, 2) NULL COMMENT '概算-人力成本',
--   `ESTIMATE_PROJECTCOST` numeric(19, 2) NULL COMMENT '概算-项目费用',
--   `ESTIMATE_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '概算-总工时（人天）',
--   `ESTIMATE_HAIRLOSS` varchar(100) NULL COMMENT '概算-销毛',
--   `ESTIMATE_GROSSSALESRATE` varchar(100) NULL COMMENT '概算-销毛率',
--   `BUDGET_LABORCOSTS` numeric(19, 2) NULL COMMENT '预算-人力成本',
--   `BUDGET_REMAINING_COSTS` numeric(19, 2) NULL COMMENT '工时系统剩余人力成本预算',
--   `BUDGET_PROJECTCOST` numeric(19, 2) NULL COMMENT '预算-项目费用',
--   `BUDGET_TOTALCOST` numeric(19, 2) NULL COMMENT '预算-总成本',
--   `BUDGET_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '预算-总工时（人天）',
--   `BUDGET_HAIRLOSS` varchar(100) NULL COMMENT '预算-销毛',
--   `BUDGET_GROSSSALESRATE` varchar(100) NULL COMMENT '预算-销毛率',
--   `BUDGET_CHANGE_LABORCOSTS` numeric(19, 2) NULL COMMENT '预算变更-人力成本',
--   `BUDGET_CHANGE_PROJECTCOST` numeric(19, 2) NULL COMMENT '预算变更-项目费用',
--   `BUDGET_CHANGE_TOTALWORKINGHOURS` numeric(19, 2) NULL COMMENT '预算变更-工时（人天）',
--   `LATEST_BUDGET_LABORCOSTS` numeric(19, 2) NULL COMMENT '最新预算-人力成本',
--   `LATEST_BUDGET_PROJECTCOST` numeric(19, 2) NULL COMMENT '最新预算-项目费用',
--   `LATEST_BUDGET_TOTALCOST` numeric(19, 2) NULL COMMENT '最新预算-总成本',
--   `LATEST_BUDGET_TOTALWORKINGHOURS` numeric(19, 2) NULL COMMENT '最新预算-总工时（人天）',
--   `LATEST_BUDGET_HAIRLOSS` varchar(100) NULL COMMENT '最新预算-销毛',
--   `LATEST_BUDGET_GROSSSALESRATE` varchar(100) NULL COMMENT '最新预算-销毛率',
--   `ACTUAL_TOTAL_COST` numeric(19, 2) NULL COMMENT '实际总成本',
--   `ACTUAL_LABORCOSTS` numeric(19, 2) NULL COMMENT '实际人力成本',
--   `ACTUAL_PROJECTCOST` numeric(19, 2) NULL COMMENT '实际项目费用',
--   `ACTUAL_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '实际投入工时（人天）',
--   `BUDGET_COST_CONSUMPTIONPROGRESS` varchar(100) NULL COMMENT '预算成本消耗进度',
--   `BUDGET_MANPOWERCOST_CONSUMPTIONPROGRESS` varchar(100) NULL COMMENT '预算人力成本消耗进度',
--   `BUDGET_WORKCONSUMPTION_PROGRESS` varchar(100) NULL COMMENT '预算工时消耗进度',
--   `LABORCOSTS_VS_WORKINGHOURS` varchar(100) NULL COMMENT '人力成本执行VS工时执行',
--   `REMAINING_BUDGET_TOTALCOST` numeric(19, 2) NULL COMMENT '剩余预算总成本',
--   `REMAINING_BUDGET_LABORCOSTS` numeric(19, 2) NULL COMMENT '剩余预算人力成本',
--   `REMAINING_BUDGET_PROJECTCOST` numeric(19, 2) NULL COMMENT '剩余预算项目费用',
--   `REMAINING_BUDGET_WORKINGHOURS` varchar(100) NULL COMMENT '剩余工时',
--   `NUMBER_OFMILESTONES_TOBEACCEPTED` varchar(100) NULL COMMENT '待验收里程碑数量',
--   `NUMBER_OFACCEPTED_MILESTONES` varchar(100) NULL COMMENT '已验收里程碑数量',
--   `ACCEPTANCE_DATE` varchar(10) NULL COMMENT '验收日期',
--   `ACCEPTANCE_INCOME` numeric(19, 2) NULL COMMENT '验收收入',
--   `ACCEPTANCE_PROGRESS` varchar(10) NULL COMMENT '验收进度',
--   `RECEIVED_AMOUNT` numeric(19, 2) NULL COMMENT '已回款金额',
--   `RECEIVED_AMOUNT_PROGRESS` varchar(10) NULL COMMENT '回款进度',
--   `EXPECTED_COMPLETION_TIMEREQUIRED` varchar(10) NULL COMMENT '预计完工还需工时',
--   `ESTIMATED_LABORCOST_UNITPRICE` numeric(19, 2) NULL COMMENT '预计人力成本单价',
--   `EXPECTED_COMPLETION_LABORCOSTS` numeric(19, 2) NULL COMMENT '预计完工还需人力成本',
--   `EXPECTED_COMPLETION_PROJECTCOST` numeric(19, 2) NULL COMMENT '还需项目费用',
--   `EXPECTED_HAIRLOSS` varchar(100) NULL COMMENT '预计/实际完工销毛',
--   `EXPECTED_GROSSSALESRATE` varchar(100) NULL COMMENT '预计/实际完工销毛率',
--   PRIMARY KEY (`ID`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宽表标签信息表';





-- 用户信息权限表
DROP TABLE USER_INFO;
CREATE TABLE `USER_INFO`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USERNAME` varchar(32) NULL COMMENT '用户名',
  `PASSWORD` varchar(32) NULL COMMENT '密码',
  `ACCOUNT_LEVEL` varchar(10) NULL COMMENT '账户级别',
  `DEPARTMENT` varchar(100) NULL COMMENT '部门信息',
  `REMARKS` varchar(100) NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息权限表';


-- 宽表标签信息表
DROP TABLE WIDE_REPORT_TABLE;
CREATE TABLE `WIDE_REPORT_TABLE`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `PROJECT_NO` varchar(10) NULL COMMENT '项目编号',
  `PROJECT_NAME` varchar(255) NULL COMMENT '项目名称',
  `CUST_NAME` varchar(255) NULL COMMENT '客户名称',
  `CUST_INDUSTRY` varchar(100) NULL COMMENT '客户行业',
  `CONTRACT_NO` varchar(100) NULL COMMENT '合同编号',
  `CONTRACT_STATUS` varchar(10) NULL COMMENT '合同状态',
  `CONTRACT_SIGNING_TIME` varchar(10) NULL COMMENT '合同签订时间',
  `CONTRACT_AMOUNT` varchar(30) NULL COMMENT '合同金额',
  `INVOICE_TYPE` varchar(10) NULL COMMENT '发票类型',
  `TAX_RATE` varchar(30) NULL COMMENT '税率',
  `CONTRACT_PAYMENT_TERMS` varchar(500) NULL COMMENT '合同付款条件',
  `PROJECT_NATURE` varchar(100) NULL COMMENT '项目性质',
  `SALES_DEPARTMENT` varchar(100) NULL COMMENT '销售部门',
  `DELIVERY_SECONDARY_DEPARTMENT` varchar(100) NULL COMMENT '交付二级部门',
  `DELIVERY_THIRDLEVEL_DEPARTMENT` varchar(100) NULL COMMENT '交付三级部门',
  `THIRDLEVEL_DEPARTMENT` varchar(100) NULL COMMENT '三级',
  `PIC` varchar(100) NULL COMMENT '负责人',
  `PROJECT_DELIVERY_LOCATION` varchar(255) NULL COMMENT '项目交付地',
  `PROJECT_MANAGER` varchar(100) NULL COMMENT '项目经理',
  `RESPONSIBLE_SALES` varchar(100) NULL COMMENT '责任销售',
  `RESPONSIBLE_PRE_SALES` varchar(100) NULL COMMENT '责任售前',
  `PROJECT_START_TIME` varchar(12) NULL COMMENT '项目启动时间',
  `ESTIMATED_PROJECT_ENDTIME` varchar(12) NULL COMMENT '预计项目结束时间',
  `PROJECT_ACCEPTANCE_STATUS` varchar(6) NULL COMMENT '项目验收状态',
  `PROJECT_STATUS` varchar(6) NULL COMMENT '项目状态',
  `ESTIMATE_TOTALCOST` varchar(30) NULL COMMENT '概算-总成本',
  `ESTIMATE_LABORCOSTS` varchar(30) NULL COMMENT '概算-人力成本',
  `ESTIMATE_PROJECTCOST` varchar(30) NULL COMMENT '概算-项目费用',
  `ESTIMATE_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '概算-总工时（人天）',
  `ESTIMATE_HAIRLOSS` varchar(100) NULL COMMENT '概算-销毛',
  `ESTIMATE_GROSSSALESRATE` varchar(100) NULL COMMENT '概算-销毛率',
  `BUDGET_LABORCOSTS` varchar(30) NULL COMMENT '预算-人力成本',
  `BUDGET_REMAINING_COSTS` varchar(30) NULL COMMENT '工时系统剩余人力成本预算',
  `BUDGET_PROJECTCOST` varchar(30) NULL COMMENT '预算-项目费用',
  `BUDGET_TOTALCOST` varchar(30) NULL COMMENT '预算-总成本',
  `BUDGET_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '预算-总工时（人天）',
  `BUDGET_HAIRLOSS` varchar(100) NULL COMMENT '预算-销毛',
  `BUDGET_GROSSSALESRATE` varchar(100) NULL COMMENT '预算-销毛率',
  `BUDGET_CHANGE_LABORCOSTS` varchar(30) NULL COMMENT '预算变更-人力成本',
  `BUDGET_CHANGE_PROJECTCOST` varchar(30) NULL COMMENT '预算变更-项目费用',
  `BUDGET_CHANGE_TOTALWORKINGHOURS` varchar(30) NULL COMMENT '预算变更-工时（人天）',
  `LATEST_BUDGET_LABORCOSTS` varchar(30) NULL COMMENT '最新预算-人力成本',
  `LATEST_BUDGET_PROJECTCOST` varchar(30) NULL COMMENT '最新预算-项目费用',
  `LATEST_BUDGET_TOTALCOST` varchar(30) NULL COMMENT '最新预算-总成本',
  `LATEST_BUDGET_TOTALWORKINGHOURS` varchar(30) NULL COMMENT '最新预算-总工时（人天）',
  `LATEST_BUDGET_HAIRLOSS` varchar(100) NULL COMMENT '最新预算-销毛',
  `LATEST_BUDGET_GROSSSALESRATE` varchar(100) NULL COMMENT '最新预算-销毛率',
  `ACTUAL_TOTAL_COST` varchar(30) NULL COMMENT '实际总成本',
  `ACTUAL_LABORCOSTS` varchar(30) NULL COMMENT '实际人力成本',
  `ACTUAL_PROJECTCOST` varchar(30) NULL COMMENT '实际项目费用',
  `ACTUAL_TOTALWORKINGHOURS` varchar(100) NULL COMMENT '实际投入工时（人天）',
  `BUDGET_COST_CONSUMPTIONPROGRESS` varchar(100) NULL COMMENT '预算成本消耗进度',
  `BUDGET_MANPOWERCOST_CONSUMPTIONPROGRESS` varchar(100) NULL COMMENT '预算人力成本消耗进度',
  `BUDGET_WORKCONSUMPTION_PROGRESS` varchar(100) NULL COMMENT '预算工时消耗进度',
  `LABORCOSTS_VS_WORKINGHOURS` varchar(100) NULL COMMENT '人力成本执行VS工时执行',
  `REMAINING_BUDGET_TOTALCOST` varchar(30) NULL COMMENT '剩余预算总成本',
  `REMAINING_BUDGET_LABORCOSTS` varchar(30) NULL COMMENT '剩余预算人力成本',
  `REMAINING_BUDGET_PROJECTCOST` varchar(30) NULL COMMENT '剩余预算项目费用',
  `REMAINING_BUDGET_WORKINGHOURS` varchar(100) NULL COMMENT '剩余工时',
  `NUMBER_OFMILESTONES_TOBEACCEPTED` varchar(100) NULL COMMENT '待验收里程碑数量',
  `NUMBER_OFACCEPTED_MILESTONES` varchar(100) NULL COMMENT '已验收里程碑数量',
  `ACCEPTANCE_DATE` varchar(10) NULL COMMENT '验收日期',
  `ACCEPTANCE_INCOME` varchar(30) NULL COMMENT '验收收入',
  `ACCEPTANCE_PROGRESS` varchar(50) NULL COMMENT '验收进度',
  `RECEIVED_AMOUNT` varchar(30) NULL COMMENT '已回款金额',
  `RECEIVED_AMOUNT_PROGRESS` varchar(50) NULL COMMENT '回款进度',
  `EXPECTED_COMPLETION_TIMEREQUIRED` varchar(10) NULL COMMENT '预计完工还需工时',
  `ESTIMATED_LABORCOST_UNITPRICE` varchar(30) NULL COMMENT '预计人力成本单价',
  `EXPECTED_COMPLETION_LABORCOSTS` varchar(30) NULL COMMENT '预计完工还需人力成本',
  `EXPECTED_COMPLETION_PROJECTCOST` varchar(30) NULL COMMENT '还需项目费用',
  `EXPECTED_HAIRLOSS` varchar(100) NULL COMMENT '预计/实际完工销毛',
  `EXPECTED_GROSSSALESRATE` varchar(100) NULL COMMENT '预计/实际完工销毛率',
  `REMARKS` varchar(255) NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  INDEX `INDEX_PROJECT_NO`(`PROJECT_NO`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宽表标签信息表';


-- 里程碑信息表
DROP TABLE MILESTONE_INFORMATION_TABLE;
CREATE TABLE `MILESTONE_INFORMATION_TABLE`  (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `PROJECT_NO` varchar(20) NULL COMMENT '项目编号',
  `ACCEP_NODE` varchar(255) NULL COMMENT '验收节点',
  `ACCEP_PAY_TERMS` varchar(255) NULL COMMENT '验收付款条件',
  `PAYMENT_RATIO` varchar(100) NULL COMMENT '付款比例',
  `ACCEPT_RATIO` varchar(15) NULL COMMENT '验收比例',
  `REC_AMOUNT` varchar(20) NULL COMMENT '应收回款额',
  `ACTUAL_REPAY_AMOUNT` varchar(20) NULL COMMENT '实际回款额',
  `ACCEP_INCOME` varchar(20) NULL COMMENT '验收收入',
  `ACCEP_OR_NOT` varchar(10) NULL COMMENT '是否验收',
  `BASE_ACCEP_PLAN` varchar(12) NULL COMMENT '基线验收计划',
  `ACT_ACCEP_TIME` varchar(12) NULL COMMENT '实际验收时间',
  `LAT_EXP_ACCEPPLAN` varchar(12) NULL COMMENT '最新预计验收计划',
  `LAT_ACCEP_YEAR` varchar(12) NULL COMMENT '最新验收年份',
  `LAT_ACCEP_MONTH` varchar(12) NULL COMMENT '最新验收计划月份',
  `WHE_RECEIVE_PAYMENT` varchar(10) NULL COMMENT '是否回款',
  `REMARKS` varchar(2000) NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  INDEX `INDEX_PROJECT_NO`(`PROJECT_NO`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='里程碑信息表';


-- 用户操作日志记录表
DROP TABLE SYS_USER_LOG;
CREATE TABLE `SYS_USER_LOG`  (
 `account` varchar(32) NOT NULL COMMENT 'SessionId',
 `channel` varchar(10) NULL COMMENT '渠道',
 `functionName` varchar(100) NULL COMMENT '功能名称',
 `userName` varchar(32) NULL COMMENT '用户名称',
 `action` varchar(255) NULL COMMENT '响应类.方法',
 `url` varchar(255) NULL COMMENT 'URI',
 `ip` varchar(25) NULL COMMENT '请求IP',
 `params` varchar(255) NULL COMMENT '请求参数',
 `err_msg` varchar(255) NULL COMMENT '异常信息',
 `log_time` datetime(0) NULL COMMENT '操作时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户操作日志记录表';