package com.all.base.cglib;

import com.google.gson.Gson;

/**
 * @ClassName CglibProxyTargetClazz
 * @Description aop 代理类
 * @Author ps
 * @Date 2019/3/15 1:44 PM
 * @Version 1.0
 **/
public class CglibProxyTargetClazz<T> {

    public String proxyMethod() {
        System.out.println("Hello World !");
        return "Hello World !";
    }

    public T proxyMethod2(T var) {
        System.out.println(new Gson().toJson(var));
        return var;
    }
}
