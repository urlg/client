package com.demo.config.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        request.getHeaderNames();
        Enumeration<String> HeaderNames = request.getHeaderNames();
        while (HeaderNames.hasMoreElements()){
            log.error(HeaderNames.nextElement());
        }
            log.error("InterceptorHandler");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            log.error("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            log.error("afterCompletion");
    }
}
