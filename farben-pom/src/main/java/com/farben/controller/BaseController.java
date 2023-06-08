package com.farben.controller;

import com.farben.entity.JsonResult;

/**
 * 基础控制器
 *
 */
public class BaseController {

    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected <T> JsonResult<T> renderError() {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(false);
        result.setStatus("500");
        return result;
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected <T> JsonResult<T> renderError(String msg) {
        JsonResult<T> result = renderError();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染失败数据（带状态码、消息）
     *
     * @param status 状态码
     * @param msg 需要返回的消息
     * @return result
     */
    protected <T> JsonResult<T> renderError(String status, String msg) {
        JsonResult<T> result = renderError();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected <T> JsonResult<T> renderSuccess() {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setStatus("200");
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @param status 指定状态码
     * @return result
     */
    protected <T> JsonResult<T> renderSuccessStatus(String status) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setStatus(status);
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected <T> JsonResult<T> renderSuccess(String msg) {
        JsonResult<T> result = renderSuccess();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    protected <T> JsonResult<T> renderSuccess(T obj) {
        JsonResult<T> result = renderSuccess();
        result.setObj(obj);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 返回对象
     * @param msg 返回备注
     * @return 返回结果
     */
    protected <T> JsonResult<T> renderSuccess(T obj, String msg) {
        JsonResult<T> result = renderSuccess();
        result.setObj(obj);
        result.setMsg(msg);
        return result;
    }
}
