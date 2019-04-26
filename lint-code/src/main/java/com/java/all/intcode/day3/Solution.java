package com.java.all.intcode.day3;

/**
 * @author: ps
 * @since: 2019/4/23  10:31 AM
 * @version: 1.0.0
 * @desc 使用二分查找法，控制时间复杂度为：O(log n)
 */
public class Solution {

    /**
     * @param nums   旋转完成的数组列表
     * @param target 需要查找的元素
     * @return target 在数据中的下标index ： 不存在-1
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 数组中间位置下标，将数据分成3段：
            // 1: left -> (mid -1)
            // 2: mid
            // 3: (mid + 1) -> right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
            else {
                // 大前提：判断nums[mid]所属位置
                if (target > nums[mid])
                {
                    if (nums[mid] > nums[0])
                    {
                        // nums[mid]在前半段，target>nums[mid]，因此target 在nums[mid]后面
                        // 将left向后靠
                        left = mid + 1;
                    } else {
                        // nums[mid] < nums[0] && target > nums[0] 说明 nums[mid] 右半段，target在前半段，right 左移靠近
                        if (target > nums[0])
                            right = mid - 1;
                        else
                            left = mid + 1;
                    }
                } else {
                    if (nums[mid] > nums[0]) {
                        if (target < nums[0])
                            left = mid + 1;
                        else
                            right = mid - 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 0;

        System.out.println(new Solution().search(nums, target));

        target = 3;
        System.out.println(new Solution().search(nums, target));
    }
}
