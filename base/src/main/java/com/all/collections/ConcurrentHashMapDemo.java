package com.all.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ps
 * @since: 2019/5/8  4:46 PM
 * @version: 1.0.0
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<Integer,Integer> cMap = new ConcurrentHashMap();
        for(int i=0;i<10;i++){
            cMap.put(i,i);
        }

        cMap.get(5);

        System.out.println(16>>>3);
        System.out.println(16>>>2);
        System.out.println(16>>>1);
        System.out.println(16>>>0);
    }
}
