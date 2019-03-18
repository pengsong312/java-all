package com.java.all.spring.aop.configuration.conf;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName AspectJ
 * @Description 切面配置
 * @Author ps
 * @Date 2019/3/18 4:58 PM
 * @Version 1.0
 **/
@Component
@Aspect
public class AspectJ {

    /**
     * 申明一个Pointcut切面空方法，创建一个引用，公用切点
     */
    @Pointcut("execution(public * com.java.all.spring.aop.configuration.service..*(..))")
    public void doPointcut() {

    }

    @Before("doPointcut()")
    public void before() {
        System.out.println("AspectJ before 前置通知");
    }

    @After("doPointcut()")
    public void after() {
        System.out.println("AspectJ before 后置通知");
    }

    @AfterReturning("doPointcut()")
    public void AfterReturning() {
        System.out.println("AspectJ AfterReturning 通知");
    }

    /**
     * 单独配置切点
     */
    @AfterThrowing("execution(public * com.java.all.spring.aop.configuration.service..exception(..))")
    public void AfterThrowing() {
        System.out.println("AspectJ AfterThrowing 异常通知");
    }

    @Around("doPointcut()")
    public void around() {
        System.out.println("AspectJ around ...............");
    }
}
