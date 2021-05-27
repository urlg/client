package com.demo.config.Interceptor;

import com.demo.untils.File.R_StreamContent;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author  A-8626 沙建斌
 *
 * 对请求和返回信息进行拦截组装
 *
 * 请求链顺序为： preHandle -> controller -> postHandle ->afterCompletion
 * @preHandle :请求进入controller之
 */
@Slf4j
public class requestAndresponseInterseptor  implements HandlerInterceptor {

    /**
     * @descraption  可以在这里进行字段检查【必输非必输之类】 【登录信息等】
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String string = new R_StreamContent().readHttpRequestContent(request);
        System.out.println(string);
        JSONObject jsonObject = new JSONObject(string);
        System.out.println("date:"+jsonObject.getString("date"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
