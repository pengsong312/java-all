package com.all.base.pattern;

/**
 * @ClassName PatternMethod
 * @Description 范型方法
 * @Author ps
 * @Date 2019/3/15 2:50 PM
 * @Version 1.0
 **/
public class PatternMethod<K, V> {

    /**
     * @param <V> 范型方法标识，在方法返回类型前面使用<范型标识符> 才是范型方法
     */
    public <V> V getValue(V v) {
        return v;
    }
}
