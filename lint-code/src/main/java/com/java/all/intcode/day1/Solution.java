package com.java.all.intcode.day1;

/**
 * @author: ps
 * @since: 2019/4/16  11:59 AM
 * @version: 1.0.0
 */
public class Solution {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 5, 7, 7, 8, 9, 9, 9};
        int target = 10;
        int result = binarySearch(nums, target);

        System.out.println(result);
    }
}
