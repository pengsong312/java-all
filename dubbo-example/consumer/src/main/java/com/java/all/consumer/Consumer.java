package com.java.all.consumer;

import com.java.all.api.DemoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ps
 * @since: 2019/3/29  6:00 PM
 * @version: 1.0.0
 */
public class Consumer {
    private static final Logger logger = LogManager.getLogger(Consumer.class);

    public static void main(String[] args) {

        try {
            Class.forName("com.yzb.omp.frigate.client.bootstrap.FrigateLoader");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/dubbo-consumer-config.xml");
        context.start();

        int i = 0;
        while (true) {
            DemoService demoService = context.getBean(DemoService.class);
            String word = demoService.say("World !" + i);
            i++;
            logger.info("word : " + word);

        }
    }
}
