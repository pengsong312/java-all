package com.all.arithmetic.sort.quick;

import com.google.gson.Gson;

import java.util.Random;

/**
 * @ClassName QuickSort
 * @Description 快速排序：
 * 排序思路：使用哨兵思想处理该问题，序列的最左边和最右边分别代表哨兵i和j，
 * 在排序序列中找个基准数，一般使用序列的第一个数作为基准数，然后从j从右至左，直到找到比基准数小的数后停下来，
 * 然后i从左至右边，直到找到比基准数大的数后停下来，最后将哨兵i与哨兵j的位置交换，然后继续下一步操作直至哨兵i与哨兵j相遇
 * @Author ps
 * @Date 2019/3.jpg/5.jpg 7.jpg:31 PM
 * @Version 1.jpg.0
 **/
public class QuickSort {

    /**
     * @param array 排序序列
     * @param left  最左边下标
     * @param right 最右边下标
     */
    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // 哨兵i
        int i = left;
        // 哨兵j
        int j = right;
        // 基准数
        int pivot = array[left];
        int temp;
        while (i < j) {
            // 哨兵j先出动，直到找到小于等于基准数的数
            while (pivot <= array[j] && i < j) {
                j--;
            }
            // 哨兵i后出动，直到找到大于等于基准数的数
            while (pivot >= array[i] && i < j) {
                i++;
            }

            // 找到了，交互哨兵对应的数据
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

        // 最后将基准数与i和j相等位置的数交换
        array[left] = array[i];
        array[i] = pivot;

        // 递归调用左半数组
        sort(array, left, i - 1);
        // 递归调用右半数组
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array2 = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array2[i] = random.nextInt(10000 - 0);
        }
        int[] array = {4, 2, 6, 5, 1, 3, 9, 7, 8, 10};
        sort(array, 0, array.length - 1);
        System.out.println("array : " + new Gson().toJson(array));
        //        int[] array2 = {4, 2, 6, 5, 1, 3, 9, 7, 8, 10};\
        long start = System.currentTimeMillis();
        sortRepeat(array2, 0, array2.length - 1);
        System.out.println("array2 : " + new Gson().toJson(array2) + " , costTime : " + (System.currentTimeMillis() - start));
    }

    /**
     * code 重复训练
     */
    public static void sortRepeat(int[] array, int left, int right) {
        if (left >= right)
            return;
        //哨兵i，j,临时变量，基准数
        int i, j, temp, pivot;
        i = left;
        j = right;
        pivot = array[left];

        while (i < j) {
            while (pivot <= array[j] && i < j) {
                j--;
            }

            while (pivot >= array[i] && i < j) {
                i++;
            }

            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        // 哨兵相遇，基准数与哨兵位置数交换
        array[left] = array[i];
        array[i] = pivot;

        sortRepeat(array, left, i - 1);
        sortRepeat(array, i + 1, right);
    }
}
