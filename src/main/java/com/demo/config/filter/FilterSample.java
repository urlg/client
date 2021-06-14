package com.demo.config.filter;

import com.demo.config.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
             * redis缓存+token验证是否需要重新登录
             *  首先检查客户端请求头是否带有Token,客户端请求头不带token则直接进行用户身份验证并且生成token且放置到redis缓存和返回请求体中
             *  客户端请求头带有token,查询redis是否具有token缓存,redis中无token缓存(可能token失效或者无token此时处理方式都是认为token有问题重新登录获取token)
             *  redis缓存中有token则进行token验证(验证的是客户端传递过来的token是否和redis缓存中的token一致),token一致则进行下一个filter且不进行重新登录
             *  redis缓存中的token和客户端传递过来的token不一致,认为token有问题则进行重新登录权限验证重新生成token
             *
             * redis缓存中token时效性
             *      Filter中应该是每次都验证Token的正确性,Token验证成功了须刷新Token有效期
             * **/
            String token = httpServletRequest.getHeader("Postman-Token");//用来验证Token是否正确
            if(redisUtil.get("Postman-Token") !=  "" || redisUtil.get("Postman-Token") != null){
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
         * redis无token则进行登录验证,验证成功后生成一个token并设置到返回体中
        */
        if(redisUtil.get("Postman-Token") == "" ||redisUtil.get("Postman-Token") == null){
            httpServletResponse.setHeader("Postman-Token","abscdesfajlfajfljdfl");
            chain.doFilter(request,response);
        }

    }


    @Override
    public void destroy() {
            log.error("destroy");
    }
}

