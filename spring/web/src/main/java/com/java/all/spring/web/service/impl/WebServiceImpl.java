package com.java.all.spring.web.service.impl;

import com.java.all.spring.web.service.WebService;
import org.springframework.stereotype.Service;

/**
 * @ClassName WebServiceImpl
 * @Description service
 * @Author ps
 * @Date 2019/3/18 7:17 PM
 * @Version 1.0
 **/
@Service("webService")
public class WebServiceImpl implements WebService {
    @Override
    public String say() {
        return "hello World !";
    }
}
