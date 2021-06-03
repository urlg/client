package com.demo.message;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExcptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(GlobalException.class)
    @ResponseBody
    public Response handelerGlobalException(HttpServletRequest request,GlobalException ex){
        Response response;
        response = new Response(ex.getResponse().getCode(),ex.getResponse().getMsg());
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handlerException(HttpServletRequest request,Exception exception){
        Response response;
        response = new Response(ErrorCodeAndMsg.NETWORK_ERROR.getCode(),ErrorCodeAndMsg.NETWORK_ERROR.getMsg());
        return response;
    }
}
