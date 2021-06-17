package com.demo.message;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * @author A-8626 沙建斌 20200603
 * @description 请求返回类
 *              所有返回数据在这个类中进行包装然后返回
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -4505655309658789999L;

    /**请求成功返回码为 000000**/
    private static final String successCode="000000";

    /**返回数据**/
    private  T body;

    /**返回码**/
    private  String code;

    /**返回描述**/
    private  String msg;

    /**无参构造方法**/
    public Response(){
        this.code   = successCode;
        this.msg    = "请求成功";
    }

    public Response(String code,String msg){
        this();
        this.code   = code;
        this.msg    = msg;
    }

    public Response(String code,String msg,T body){
        this();
        this.code  = code;
        this.msg   = msg;
        this.body = body;
    }

    public Response(T body){
        this();
        this.body = body;
    }


    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
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
