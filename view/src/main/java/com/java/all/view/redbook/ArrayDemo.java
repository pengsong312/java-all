package com.java.all.view.redbook;

import com.google.gson.Gson;

/**
 * @author: ps
 * @since: 2019/5/5  6:10 PM
 * @version: 1.0.0
 * @desc 算法：给定一个数组 [1,0,4,6,0,3,7,0,0,19,0]，
 * 使用Java代码实现将0移至数组的最右边，其他数值在最左边，且不改变非0数值的相对位置
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 6, 0, 3, 7, 0, 0, 19, 0};
        System.out.println(new Gson().toJson(operate2(ints)));

        System.out.println(2>>>1);
        System.out.println(3>>1);
        System.out.println(2>>1);

    }

    /**
     * 空间复杂度 O(1)
     * 时间复杂度 O(n)
     */
    static int[] operate2(int[] ints) {
        if (ints == null || ints.length == 0) {
            return ints;
        }

        int index = 0;
        int temp;
        for (int i = 0; i < ints.length; i++) {
            // 判断第一个元素，直到第一个为0的元素
            if (i == 0) {
                index++;
                continue;
            }
            if (ints[i] > 0) {
                temp = ints[index];
                ints[index] = ints[i];
                ints[i] = temp;
                index++;
            }
        }
        return ints;
    }

    /**
     * 空间复杂度 O(n)
     * 时间复杂度 O(n)
     */
    static int[] operate1(int[] ints) {
        if (ints == null || ints.length == 0) {
            return ints;
        }

        int[] biggest = new int[ints.length];
        int index = 0;
        for (int num : ints) {
            if (num > 0) {
                biggest[index++] = num;
            }
        }
        return biggest;
    }
}
