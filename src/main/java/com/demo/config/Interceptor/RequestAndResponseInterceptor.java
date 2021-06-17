package com.demo.config.Interceptor;

import com.demo.message.Response;
import com.demo.module.clientmanager.controller.PersonController;
import com.demo.module.clientmanager.entry.Person;
import com.demo.module.selectTable.entity.AllTable;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @author  A-8626 沙建斌
 *
 * 对请求和返回信息进行拦截组装
 *
 * 请求链顺序为： preHandle -> controller -> postHandle ->afterCompletion
 * @preHandle :请求进入controller之
 */
@Slf4j
@Component(value = "requestAndResponseInterceptor")
@Order(1)
public class RequestAndResponseInterceptor implements HandlerInterceptor {

    /**
     * @descraption  可以在这里进行字段检查【必输非必输之类】
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String string = new R_StreamContent().readHttpRequestContent(request);
        //readStreamContent.readFileContent("d:server_log.txt");
        //System.out.println(string);
        //JSONObject jsonObject = new JSONObject(string);
        //System.out.println("date:"+jsonObject.getString("date"));
//        log.info("RequestURL"+request.getRequestURL());
//        log.info("CharacterEncoding"+request.getCharacterEncoding());
//        log.info("ContextPath"+request.getContextPath());
//        log.info("ContentType"+request.getContentType());
//        log.info("ContentLength"+request.getContentLength());
//        log.info("RemoteUser"+request.getRemoteUser());
//        log.info("RemoteHost"+request.getRemoteHost());
//        log.info("ServerPort"+request.getServerPort());
//        log.info("LocalAddr()"+request.getLocalAddr());
//        log.info("LocalName"+request.getLocalName());
//        log.info("LocalPort"+request.getLocalPort());
//        log.info("PathInfo"+request.getPathInfo());
//        request.getHeaderNames();
//        System.out.println(request.getAttribute("setAtribute"));
//        Enumeration<String> HeaderNames = request.getHeaderNames();
//        while (HeaderNames.hasMoreElements()){
//            log.error(HeaderNames.nextElement());
//        }
//        response.addHeader("name","value");
//        Cookie cookie = new Cookie("cookie","value");
//        cookie.setHttpOnly(true);
//        cookie.setComment("serComment");
//        /**设置Cookie失效时间**/
//        cookie.setMaxAge(60);
//        //cookie.setSecure(true);
//        response.addCookie(cookie);
        log.error("handler"+handler);
        /**
         * 进行必输非必输字段检查思路
         *     @PostMapping(value = "QryPerson0001")
         *     public Response getPersonById(){}
         *  1:可以用过滤器 + 反射机制获取到此时需要过滤的Handler的value值。此时为"QryPerson0001"
         *  2：数据库中进行配置字段的必输于非必输。此时可以设计一张表专门记录请求/返回。必输/非必输等信息
         */
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        OutputStream out = null;

        JSONObject res = new JSONObject();
        res.put("name","shajianbin");
        res.put("msg","交易成功");

        out = response.getOutputStream();
        out.write(5);
        //response.reset();

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.error("afterCompletion");
        log.error("handler:--"+handler);
    }
}
