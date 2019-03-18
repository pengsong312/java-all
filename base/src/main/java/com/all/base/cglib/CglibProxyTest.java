package com.all.base.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxyTest
 * @Description CGLIB 代理使用demo
 * @Author ps
 * @Date 2019/3/15 1:43 PM
 * @Version 1.0
 **/
public class CglibProxyTest implements MethodInterceptor{

    public Object newInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxyTest 方法前置");
        // 调用 代理对象的
        Object object = methodProxy.invokeSuper(target,args);
        System.out.println(methodProxy.getSignature().getName()+","+methodProxy.getSuperName()+","+methodProxy.getSuperIndex());
        System.out.println("CglibProxyTest 方法后置");

        return object;
    }

    public static void main(String[] args) {
        CglibProxyTargetClazz clazz = (CglibProxyTargetClazz)new CglibProxyTest().newInstance(CglibProxyTargetClazz.class);
        clazz.proxyMethod();
//        clazz.proxyMethod2("luffy");
    }
}
