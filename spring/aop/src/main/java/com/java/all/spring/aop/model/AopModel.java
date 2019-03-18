package com.java.all.spring.aop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @ClassName AopModel
 * @Description AopModel
 * @Author ps
 * @Date 2019/3/18 4:06 PM
 * @Version 1.0
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AopModel {
    private String clazz;
    private String method;
    private String params;
}
