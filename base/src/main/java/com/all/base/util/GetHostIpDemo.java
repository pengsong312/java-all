package com.all.base.util;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.net.*;
import java.util.Enumeration;
import java.util.Map;

/**
 * @ClassName GetHostIpDemo
 * @Description 获取本机IP地址
 * @Author ps
 * @Date 2019/3/12 7:07 PM
 * @Version 1.0
 **/
public class GetHostIpDemo {

    public static void main(String[] args) throws ClassNotFoundException{
        //        System.out.println(GetHostIpDemo.method1());
        System.out.println(GetHostIpDemo.method2());
        System.out.println((1 << 16) - 1);
        Class<?> clazz = Class.forName("java.util.HashMap");
        TypeVariable[] types = clazz.getTypeParameters();
        for(Method method : clazz.getMethods()){
            System.out.println(method.getParameters());
        }

        Map<String,String> map = Maps.newHashMap();
        map.put("1","1");
        map.put("2,","2");
        map.put("3,","3");

        Map<String,String> map1 = map;
        map1.put("1","1.1");
        map1.put("4","4");

        System.out.println(new Gson().toJson(map));
    }

    public static final String method1() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(new String(address.getAddress(), "gbk") + "," + address.getCanonicalHostName() + "," + address.getHostAddress() + ","
                    + address.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static final String method2() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            System.out.println("enumeration : " + new Gson().toJson(enumeration));
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = enumeration.nextElement();
                System.out.println("networkInterface : " + new Gson().toJson(networkInterface));
                // mac os name:en0 linux name:eth0
                if (!"en0".equals(networkInterface.getName())) {
                    continue;
                }
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    if (address instanceof Inet6Address) {
                        continue;
                    }
                    ip = address.getHostAddress();
                    break;
                }

            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
