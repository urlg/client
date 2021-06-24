package com.demo.message;

/**
 * @author  A-8626 沙建斌  2021-06-03
 * @description 统一的异常编码枚举
 */
public enum ErrorCodeAndMsg {
    FILE_NOT_FIND("FNF001","文件未找到"),
    IS_DIRECTORY("ISD001","是目录非文件"),
    IS_NULL_RECORD("ISN001","查询无记录"),
    IS_NOT_READY("ISN002","流未准备好读取"),
    IS_NOT_POSTMAPPING("ISN003","此方法无PostMapping注解"),
    NETWORK_ERROR("9999","网路连接异常");

    private String code;
    private String msg;

    ErrorCodeAndMsg(){

    }

    /**
     * 这块地构造方法有点没有理解
     * @param code
     * @param msg
     */
    ErrorCodeAndMsg(String code,String msg){
        this.code = code;
        this.msg  = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
