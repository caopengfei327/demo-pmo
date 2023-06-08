package com.farben.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 封装Json返回信息
 *
 */
public class JsonResult<T> {

    @ApiModelProperty(name = "success", value = "请求响应结果（true为正常，false为异常）")
    private Boolean success;

    @ApiModelProperty(name = "status", value = "请求响应状态码")
    private String status;

    @ApiModelProperty(name = "msg", value = "请求响应消息")
    private String msg;

    @ApiModelProperty(name = "obj", value = "返回数据内容")
    private T obj;

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
