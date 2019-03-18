package com.all.base.jdk.dymanic;

import com.all.base.proxy.jdk.JDKProxyTargetClazz;
import com.all.base.proxy.jdk.JDKProxyTargetInterface;

/**
 * @ClassName JDKProxyTest
 * @Description jdk代理测试类
 * @Author ps
 * @Date 2019/3/15 2:08 PM
 * @Version 1.0
 **/
public class JDKProxyTest {

    public static void main(String[] args) {
        JDKProxyTargetClazz jdkProxyTargetClazz = new JDKProxyTargetClazz();
        JDKProxyFactory factory = new JDKProxyFactory(jdkProxyTargetClazz);
        JDKProxyTargetInterface instance = (JDKProxyTargetInterface)factory.newInstance();
        instance.execute();
    }
}
