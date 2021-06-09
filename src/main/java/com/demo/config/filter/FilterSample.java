package com.demo.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Slf4j
//@WebFilter
//@Component
public class FilterSample implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            log.error("FilterInit");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            log.error("doFilter");
    }

    @Override
    public void destroy() {
            log.error("destroy");
    }
}
