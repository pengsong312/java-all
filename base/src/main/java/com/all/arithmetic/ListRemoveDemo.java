package com.all.arithmetic;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.Iterator;
import java.util.List;

/**
 * @author: ps
 * @since: 2020/4/12  2:33 PM
 * @version: 1.0.0
 */
public class ListRemoveDemo {
    public static void main(String[] args) {
        // 原始待处理list
        List<Integer> orginal = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 对比list，orginal中的元素在compareList中的就删除
        List<Integer> compareList = Lists.newArrayList(3, 6, 9);

        for (Integer compareInteger : compareList) {
            Iterator<Integer> iterator = orginal.iterator();

            while (iterator.hasNext()) {
                Integer integer = iterator.next();
                if (integer.equals(compareInteger)) {
                    iterator.remove();
                }
            }
        }

        System.out.println("筛选移除后的orginal:" + new Gson().toJson(orginal));



    }
}
