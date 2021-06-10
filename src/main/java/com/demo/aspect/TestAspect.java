package com.demo.aspect;

import com.demo.message.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Spring-Aop
 *
 * Advice 主要类型
 * @Before           标注在业务模块代码执行之前,不阻止业务代码模块的执行,除非标注的方法抛出异常
 * @AfterReturning   标注在业务模块代码执行之后
 * @AfterThrowing    标注在业务模块代码执行报错后
 * @Around           环绕在业务模块代码执行前后 :在Before 之前和After之后
 * @After            标注在业务模块代码所有都执行完成后,类似于tra{}catch{}finally{}中的finally
 */

/**
 * @Component 切面类中必须有此注解,告诉Spring这也是一个组件
 */
@Component
@Aspect
@Slf4j
public class TestAspect {

    /**
     * Before   Advice
     */

    @Before("this(com.demo.module.selectTable.controller.AllTableInfo)")
    //@Pointcut("this(com.demo.module.selectTable.controller.AllTableInfo)")
    public void aspectBefore(){
        log.error("Advice Before");
    }

    /**
     * After Advice
     */
    @After("execution(public * com.demo.module.selectTable.controller.AllTableInfo.getTableName(..))")
    public void aspectAfter(){
        log.error("Advice After");
    }


    /**
     * AfterThrowing Advice
     */
    @AfterThrowing("execution(public * com.demo.module.selectTable.controller.AllTableInfo.getTableName(..))")
    public void afterThrowing(){
        log.error("AfterThrowing");
    }

    /**
     * Around Advice
     */
    @Around("execution(public * com.demo.module.selectTable.controller.AllTableInfo.getTableName(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.error("Around Before");
        Object result = pjp.proceed();

        /**
         * 此时request就是被增强的方法返回值
         */
        Response response = (Response) result;
        //log.error("result"+response.getMsg()+response.getBody());
        log.error("after around advice");
        return result;
    }
    /**
     * AfterReturning Advice
     */
    @AfterReturning("execution(public * com.demo.module.selectTable.controller.AllTableInfo.getTableName(..))")
    public void aspectAfterReturning(){
        log.error("AfterReturning");
    }
}
