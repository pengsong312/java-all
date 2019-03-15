package com.all.base.proxy.jdk;

/**
 * @ClassName JDKProxyTargetClazz
 * @Description 被JDK代理对象,必须要实现一个接口
 * @Author ps
 * @Date 2019/3/15 1:59 PM
 * @Version 1.0
 **/
public class JDKProxyTargetClazz implements JDKProxyTargetInterface {

    @Override
    public void execute() {
        System.out.println("Hello World !");
    }
}
