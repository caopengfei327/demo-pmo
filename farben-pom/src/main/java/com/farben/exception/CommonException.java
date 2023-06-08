package com.farben.exception;


/**
 * CommonException
 * 自定义异常
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -1340328704145759576L;

    /**
     * 错误Code
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 重载构造函数
     *
     * @param msg 异常消息
     */
    public CommonException(String msg){
//        super(msg,null,false,false);
        super(msg);
        this.errorMsg = msg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}