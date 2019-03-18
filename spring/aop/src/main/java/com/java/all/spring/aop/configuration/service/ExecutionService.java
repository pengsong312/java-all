package com.java.all.spring.aop.configuration.service;

/**
 * @ClassName ExecutionService
 * @Description 目标执行类
 * @Author ps
 * @Date 2019/3/18 5:06 PM
 * @Version 1.0
 **/
public class ExecutionService {

    public void execute() {
        System.out.println("ExecutionService execute ...");
    }

    public void exception() {
        System.out.println("ExecutionService exception ...");
        int i = 1 / 0;
    }
}
