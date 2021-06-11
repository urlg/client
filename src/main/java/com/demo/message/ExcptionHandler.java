package com.demo.message;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@SuppressWarnings("all")
public class ExcptionHandler {

    /**
     * 这里捕获的是自定义的异常并返回到ResponseBody中
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public Response handelerGlobalException(HttpServletRequest request,GlobalException ex){
        Response response;
        response = new Response(ex.getResponse().getCode(),ex.getResponse().getMsg());
        return response;
    }

    /**
     * 这里捕获的是自定义异常外的异常
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handlerException(HttpServletRequest request,Exception exception){
        Response response;
        response = new Response(ErrorCodeAndMsg.NETWORK_ERROR.getCode(),ErrorCodeAndMsg.NETWORK_ERROR.getMsg());
        return response;
    }
}
