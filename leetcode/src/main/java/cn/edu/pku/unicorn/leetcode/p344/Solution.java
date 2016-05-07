/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p344;

/**
 * @author v_zhengkun
 * @since 2016/5/7 14:24
 */
public class Solution {
    public static void main(String[] args) {
        String str = "abc";
        Solution solution = new Solution();
        System.out.println(solution.reverseString(str));
    }
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();

        int i = 0;
        int mid = (arr.length - 1) / 2;

        while (i <= mid) {
            char t = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = t;
            i++;
        }

        return new String(arr);
    }
}
