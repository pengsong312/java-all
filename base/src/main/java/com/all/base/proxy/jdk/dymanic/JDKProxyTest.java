package com.all.base.proxy.jdk.dymanic;

import com.all.base.proxy.jdk.JDKProxyTargetClazz;
import com.all.base.proxy.jdk.JDKProxyTargetInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxyTest
 * @Description jdk代理测试类
 * @Author ps
 * @Date 2019/3/15 2:08 PM
 * @Version 1.0
 **/
public class JDKProxyTest {

    public static void main(String[] args) {
        /**
         * 动态代理获取代理类
         */
        JDKProxyTargetClazz jdkProxyTargetClazz = new JDKProxyTargetClazz();
        JDKProxyFactory factory = new JDKProxyFactory(jdkProxyTargetClazz);
        JDKProxyTargetInterface instance = (JDKProxyTargetInterface)factory.newInstance();
        instance.execute();


        /**
         * 动态代理使用方法
         */
        JDKProxyTargetInterface interfaces = (JDKProxyTargetInterface) Proxy.newProxyInstance(JDKProxyTargetClazz.class.getClassLoader(),
                JDKProxyTargetClazz.class.getInterfaces(),
                new JDKProxyFactory<>(new JDKProxyTargetClazz()));
        interfaces.execute();

        boolean isPublic = Modifier.isPublic(JDKProxyTargetClazz.class.getModifiers());
        Constructor<?>[] constructors = JDKProxyTargetClazz.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
            Class<?>[] classes = constructor.getParameterTypes();
            for (Class clazz : classes){
                System.out.println(clazz.getName());
            }
        }
    }
}
