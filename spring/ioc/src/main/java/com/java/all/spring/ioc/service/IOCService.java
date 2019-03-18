package com.java.all.spring.ioc.service;

/**
 * ClassName IOCService
 * Description 组件顶级接口
 * Author ps
 * Date 2019/3/18 2:28 PM
 * Version 1.0
 **/
public interface IOCService<K,V> {
    V iocMethod(K k);
}
