package com.farben.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUserLog implements Serializable {
    /**
     * SessionId
     */
    private String account;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 功能名称
     */
    private String functionName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 响应类.方法
     */
    private String action;
    /**
     * URI
     */
    private String url;
    /**
     * 请求IP
     */
    private String ip;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 异常信息
     */
    private String errMsg;
    /**
     * 操作时间
     */
    private Date logTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "SysUserLog{" +
                "account='" + account + '\'' +
                ", channel='" + channel + '\'' +
                ", functionName='" + functionName + '\'' +
                ", userName='" + userName + '\'' +
                ", action='" + action + '\'' +
                ", url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", params='" + params + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", logTime=" + logTime +
                '}';
    }
}
