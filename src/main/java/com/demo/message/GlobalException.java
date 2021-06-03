package com.demo.message;

/**
 * @author 沙建斌  A-8626 2021-06-01 全局异常捕获类
 */
public class GlobalException extends  RuntimeException{

    private  static final long serialVersionUID = -6370612118603891564L;

    private final ErrorCodeAndMsg response;

    public GlobalException(ErrorCodeAndMsg response){
        this.response = response;
    }

    public ErrorCodeAndMsg getResponse(){
        return response;
    }
}
