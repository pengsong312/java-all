package com.java.all.spring.web.controller;

import com.java.all.spring.web.service.impl.WebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WebController
 * @Description controller
 * @Author ps
 * @Date 2019/3/18 7:16 PM
 * @Version 1.0
 **/
@RestController
public class WebController {

    @Autowired
    private WebServiceImpl webService;

    @RequestMapping(value="/spring/say")
    public String say() {
        return webService.say();
    }
}
