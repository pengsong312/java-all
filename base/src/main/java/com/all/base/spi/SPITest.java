package com.all.base.spi;

import com.sun.tools.javac.util.ServiceLoader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Iterator;

/**
 * @author: ps
 * @since: 2019/4/15  4:13 PM
 * @version: 1.0.0
 * @desc SPI ，全称为 Service Provider Interface，是一种服务发现机制。它通过在ClassPath路径下的META-INF/services文件夹查找文件，自动加载文件里所定义的类
 */
public class SPITest {

    public static void main(String[] args) {
        // 使用 ServiceLoader 加载 SPIDemoService 实现类
        ServiceLoader<SPIDemoService> loader = ServiceLoader.load(SPIDemoService.class,ClassLoader.getSystemClassLoader());
        Iterator<SPIDemoService> iterator = loader.iterator();
        while (iterator.hasNext()){
            SPIDemoService service = iterator.next();
            service.hello("ServiceLoader");
        }
        //
        SPIDemoService[] services = PolicyUtils.ServiceProvider.load(SPIDemoService.class,ClassLoader.getSystemClassLoader());
        for(SPIDemoService service : services){
            service.hello("ServiceProvider");
        }
    }
}
