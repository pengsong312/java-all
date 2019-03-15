package com.all.base.pattern;

/**
 * ClassName PatternInterface
 * Description 范型接口
 * Author ps
 * Date 2019/3/15 2:46 PM
 * Version 1.0
 **/
public interface PatternInterface<K,V> {

    V getValue(K k);
}
