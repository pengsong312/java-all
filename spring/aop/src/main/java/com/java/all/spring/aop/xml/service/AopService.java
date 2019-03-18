package com.java.all.spring.aop.xml.service;

import com.google.gson.Gson;

/**
 * ClassName AopService
 * Description aop service 接口
 * Author ps
 * Date 2019/3/18 4:04 PM
 * Version 1.0
 **/
public class AopService<AopModel> {

    public void execute(AopModel... params) {
        for (AopModel model : params) {
            System.out.println(new Gson().toJson(model));
        }
    }
}
