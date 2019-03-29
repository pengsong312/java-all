package com.java.all.spring.aop.xml;

import com.java.all.spring.aop.xml.service.AopService;
import com.java.all.spring.aop.model.AopModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName XmlAopApplication
 * @Description main clazz
 * @Author ps
 * @Date 2019/3/18 4:15 PM
 * @Version 1.0
 **/
public class XmlAopApplication {
    private static ApplicationContext context;
    private static AopService aopService;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring-context.xml");
        aopService = (AopService) context.getBean("aopService");

        AopModel model = AopModel.builder().clazz("com.java.all.spring.aop.xml.XmlAopApplication").method("main").params("args").build();
        aopService.execute(model);
        synchronized (XmlAopApplication.class) {
            while (true) {
                try {
                    XmlAopApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
