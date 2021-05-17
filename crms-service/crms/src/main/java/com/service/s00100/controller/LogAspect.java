package com.service.s00100.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.service.s00100.controller.DeptController.*(..))")
    public void LogAspect(){};

    @Before("LogAspect()")
    public  void  doBefore(){
        System.out.println("Do before");
    }


}
