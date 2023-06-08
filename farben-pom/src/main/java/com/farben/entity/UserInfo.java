package com.farben.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    /**
     * 用户Id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 账户级别
     */
    private String accountLevel;
    /**
     * 部门信息
     */
    private String department;
    /**
     * 备注
     */
    private String remarks;

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountLevel='" + accountLevel + '\'' +
                ", department='" + department + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}