package com.java.all.vm;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @ClassName VmDemo
 * @Description
 * 1、os级别的设置使用System.getenv获取
 * 2、系统参数 System.getProperty System.setProperty 设置、获取，在启动命令中使用-Dkey=value添加
 * @Author ps
 * @Date 2019/3/18 12:05 PM
 * @Version 1.0
 **/
public class VmDemo {

    public static void main(String[] args) {
        System.out.println("开始获取启动命令参数....");
        String env = System.getenv("name");
        Map<String,String> map = System.getenv();
        System.out.println(new Gson().toJson(map));
        String property = System.getProperty("property");
        String applicationName = System.getProperty("pinpoint.applicationName");
        String PATH = System.getenv("PATH");
        System.out.println("启动命令参数 : env = " + env + " , property = " + property + " , PATH =" + PATH+" , applicationName = "+applicationName);
    }
}
