package com.java.all.intcode.day2;

/**
 * @author: ps
 * @since: 2019/4/18  5:25 PM
 * @version: 1.0.0
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }

            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"ABCD", "ABEF", "ACEF"};
        System.out.println(longestCommonPrefix(strs));
    }
}
