package com.java.all.spring.ioc;

import com.google.gson.Gson;
import com.java.all.spring.ioc.pojo.IOCPojo;
import com.java.all.spring.ioc.service.IOCService;
import com.java.all.spring.ioc.service.impl.IOCServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName IocApplication
 * @Description 启动类
 * spring启动后自动加载组件。控制反转，将bean交由spring管理
 * @Author ps
 * @Date 2019/3/18 2:11 PM
 * @Version 1.0
 **/
public class IocApplication {

    private static ApplicationContext context;
    private static IOCPojo pojo;
    private static IOCService iocService;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-context.xml");

        pojo = (IOCPojo) context.getBean("pojo");
        System.out.println("pojo : "+new Gson().toJson(pojo));
        iocService = (IOCServiceImpl) context.getBean("iOCService");

        String apple = (String) iocService.iocMethod("apple");
        System.out.println("apple : " + apple);

        synchronized (IocApplication.class) {
            while (true) {
                try {
                    IocApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
