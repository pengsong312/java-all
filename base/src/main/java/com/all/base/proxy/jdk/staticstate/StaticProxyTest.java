package com.all.base.proxy.jdk.staticstate;

import com.all.base.proxy.jdk.JDKProxyTargetClazz;

/**
 * @ClassName StaticProxyTest
 * @Description 静态代理 test
 * @Author ps
 * @Date 2019/3/15 2:35 PM
 * @Version 1.0
 **/
public class StaticProxyTest {

    public static void main(String[] args) {
        new StaticProxyFactory(new JDKProxyTargetClazz()).execute();
    }
}
