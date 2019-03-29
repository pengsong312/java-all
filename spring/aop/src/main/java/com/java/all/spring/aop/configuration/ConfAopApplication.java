package com.java.all.spring.aop.configuration;

import com.java.all.spring.aop.configuration.service.ExecutionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName XmlAopApplication
 * @Description main clazz
 * @Author ps
 * @Date 2019/3/18 4:15 PM
 * @Version 1.0
 **/
public class ConfAopApplication {
    private static ApplicationContext context;
    private static ExecutionService executionService;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring-context.xml");
        executionService = (ExecutionService)context.getBean("executionService");
        executionService.execute();
        System.out.println("*********************************************************************");
//        executionService.exception();

//        synchronized (ConfAopApplication.class) {
//            while (true) {
//                try {
//                    ConfAopApplication.class.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
