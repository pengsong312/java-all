package com.java.all.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author: ps
 * @since: 2019/3/29  6:00 PM
 * @version: 1.0.0
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/dubbo-provider-config.xml");
        context.start();

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(name -> System.out.println(name));

        System.in.read();
    }
}
