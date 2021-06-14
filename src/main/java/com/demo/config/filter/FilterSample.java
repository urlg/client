package com.demo.config.filter;

import com.demo.config.redis.RedisUtil;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
@Slf4j
@WebFilter
@Component
public class FilterSample implements Filter {
    /**
     * 注入Redis的工具类
     * **/
    @Autowired
    private  RedisUtil redisUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            log.error("FilterInit");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /**
         *  {@param ServletRequest request}  --interface
         *  1:ServletRequest对象作用
         * **/
        //获取当前协议类型   example:HTTP/1.1
        log.error(request.getProtocol());
        //获取当前字符编码格式 example:utf-8
        log.error(request.getCharacterEncoding());
        //获取当前Scheme
        log.error(request.getScheme());
        //获取主机IP或者Name
        log.error(request.getServerName());
        //设置字符编码格式
        request.setCharacterEncoding("utf8");
        //向ServletRequest对象中设置参数
        request.setAttribute("user","王晓民");

        /**
         *
         * {@param ServletRequest request}
         * {@param HttpServletRequest httpRequest}
         *                            HttpServletRequest接口继承了ServletRequest接口,因此HttpServletRequest具有ServletRequest所有方法
         * 1:主要是可以将ServletRequest对像转换为HttpServletRequest对象,而HttpServletRequest对象可以进行多样操作
         * **/
        HttpServletRequest   httpServletRequest  = (HttpServletRequest)request;
        HttpServletResponse  httpServletResponse = (HttpServletResponse)response;

            //获取当前请求方法
            log.error("Method:"+httpServletRequest.getMethod());
            //当前请求URL
            log.error("RequestURL:"+httpServletRequest.getRequestURL());
            //获取真实的Authentic
            log.error("Authentic:"+httpServletRequest.getAuthType());

            //获取请求头中的信息
            log.error("date:"+httpServletRequest.getHeader("date"));
            log.error("Content-type:"+httpServletRequest.getHeader("Content-type"));
            log.error("Content-Length:"+httpServletRequest.getHeader("Content-Length"));
            log.error("Host:"+httpServletRequest.getHeader("Host"));
            log.error("User-Agent:"+httpServletRequest.getHeader("User-Agent"));
            log.error("Accept:"+httpServletRequest.getHeader("Accept"));
            log.error("Accept-Encoding:"+httpServletRequest.getHeader("Accept-Encoding"));
            log.error("Connection:"+httpServletRequest.getHeader("Connection"));

            httpServletRequest.setAttribute("setAtribute","Atribute");
            //获取Cookie
        Cookie [] cookie = ((HttpServletRequest) request).getCookies();
            if(cookie != null) {
                for (Cookie cookie1 : cookie) {
                    log.error("cookie:" + cookie1);
                }
            }

            /**
             * redis缓存+验证token
             * 1：在redist缓存中检查是否有token
             *      1.1：redis缓存中有token的话检查token是否过期
             *      1.2：token未过期的话继续下一个Filter
             *      1.3: token过期则返回错误信息让重新登录
             * 2：redis中无token的话则让重新登录
             * **/
            String token = httpServletRequest.getHeader("Postman-Token");//用来验证Token是否正确
            log.error("Postman-Token:"+redisUtil.get("Postman-Token"));
            if(redisUtil.get("Postman-Token") !=  "" || redisUtil.get("Postman-Token") != null){
                log.error("当前请求头有token");
                log.error("Token过期时间："+redisUtil.getExpire("Postman-Token"));
                if(redisUtil.getExpire("Postman-Token")>6000){
                    log.error("Postman-Token");
                    //这里应该是抛出异常信息
                }

                /***
                 * 这里进行token的验证,验证成功继续下一个Filter失败给出错误信息重新登录
                 * */
                chain.doFilter(request,response);
            }
        /**
         * redis无token则进行登录验证,验证成功后生成一个token并放在请求头
        */
        if(redisUtil.get("Postman-Token") == "" ||redisUtil.get("Postman-Token") == null){
            log.error("没有找到token");
            log.error("setToken:"+redisUtil.set("Postman-Token","abscdesfajlfajfljdfl",10));
            httpServletResponse.setHeader("Postman-Token","abscdesfajlfajfljdfl");
            //chain.doFilter(request,response);
        }

    }


    @Override
    public void destroy() {
            log.error("destroy");
    }
}

