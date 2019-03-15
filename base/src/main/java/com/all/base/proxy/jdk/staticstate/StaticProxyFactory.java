package com.all.base.proxy.jdk.staticstate;

import com.all.base.proxy.jdk.JDKProxyTargetClazz;
import com.all.base.proxy.jdk.JDKProxyTargetInterface;

/**
 * @ClassName StaticProxyFactory
 * @Description 静态代理对象
 * @Author ps
 * @Date 2019/3/15 2:35 PM
 * @Version 1.0
 **/
public class StaticProxyFactory implements JDKProxyTargetInterface {

    private JDKProxyTargetClazz target;

    public StaticProxyFactory(JDKProxyTargetClazz target) {
        this.target = target;
    }

    @Override
    public void execute() {
        System.out.println("JDK 静态代理前置");
        target.execute();
        System.out.println("JDK 静态代理后置");
    }
}
