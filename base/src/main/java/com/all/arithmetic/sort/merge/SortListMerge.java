package com.all.arithmetic.sort.merge;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ps
 * @since: 2019/4/26  10:08 AM
 * @version: 1.0.0
 * @desc 有序列表合并
 */
public class SortListMerge {

    public static final List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }

        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        int size1 = list1.size(), size2 = list2.size();
        List<Integer> mergeList = new ArrayList<>(size1 + size2);

        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            // 将元素小的添加到合并列表中
            if (list1.get(i) > list2.get(j)) {
                mergeList.add(list2.get(j));
                j++;
            } else {
                mergeList.add(list1.get(i));
                i++;
            }
        }

        // 列表长度不一致，将余下的继续追加到合并列表中
        while (size1 > i) {
            mergeList.add(list1.get(i));
            i++;
        }

        while (size2 > j) {
            mergeList.add(list2.get(j));
            j++;
        }
        return mergeList;
    }


    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        list1.add(3);
        list1.add(6);
        list1.add(7);
        list1.add(10);
        list1.add(13);

        List<Integer> list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(12);
        list2.add(15);
        list2.add(20);
        list2.add(21);
        List<Integer> mergeList = merge(list1, list2);

        System.out.println(new Gson().toJson(mergeList));
    }
}
