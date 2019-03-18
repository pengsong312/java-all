package com.java.all.spring.aop.xml.aspect;

/**
 * @ClassName AspectConfiguration
 * @Description 切面
 * @Author ps
 * @Date 2019/3/18 4:29 PM
 * @Version 1.0
 **/
public class AspectConfiguration {

    public void beforeExecute(){
        System.out.println("AspectConfiguration beforeExecute 前置通知");
    }

    public void afterExecute(){
        System.out.println("AspectConfiguration beforeExecute 后置通知");
    }

    public void around(){
        System.out.println("AspectConfiguration around 环绕通知");
    }
}
