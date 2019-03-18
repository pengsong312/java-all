package com.java.all.spring.ioc.service.impl;

import com.java.all.spring.ioc.service.IOCService;
import org.springframework.stereotype.Service;

/**
 * @ClassName IOCServiceImpl
 * @Description service组件实现
 * @Author ps
 * @Date 2019/3/18 2:29 PM
 * @Version 1.0
 **/
@Service(value = "iOCService")
public class IOCServiceImpl implements IOCService<String, String> {

    @Override
    public String iocMethod(String s) {
        return "Hello World !";
    }
}
