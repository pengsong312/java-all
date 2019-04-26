package com.all.collections;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ps
 * @since: 2019/4/18  5:56 PM
 * @version: 1.0.0
 * @desc 集合排序
 */
public class ListSortDemo {

    public static void main(String[] args) {
        List<Float> list = Lists.newArrayListWithCapacity(100);


        for(int i=0;i<100;i++){
            float rand = (float)(Math.random() * 10);
            list.add(rand);
        }

        // 升序
        list = list.stream().sorted().collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));

        // 升序
        list = list.stream().sorted((o1,o2)->{
            return o2 - o1 > 0 ? 1 : o1 - o2 == 0 ? 0 : -1;
        }).collect(Collectors.toList());
        System.out.println(new Gson().toJson(list));
    }
}
