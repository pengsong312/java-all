package com.all.base.proxy.jdk.dymanic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxyFactory
 * @Description 代理工厂，基于接口实现代理对象的子类
 * @Author ps
 * @Date 2019/3/15 2:09 PM
 * @Version 1.0
 **/
public class JDKProxyFactory<T> implements InvocationHandler{

    private T target;

    public JDKProxyFactory(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("cglib invoke 代理前置");
        Object object = method.invoke(target,args);
        System.out.println("cglib invoke 代理前置");

        return object;
    }

    /**
     * 使用Lamda表达式优化代码结构
     */
    public Object newInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("cglib 代理前置");
            Object returnValue = method.invoke(target, args);
            System.out.println("cglib 代理后置");
            return returnValue;
        });
    }

    /**
     * 使用匿名内部类实现InvocationHandler的子类
     */
    public Object newInstance2() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("cglib 代理前置");
                //执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("cglib 代理后置");
                return returnValue;
            }
        });
    }
}
