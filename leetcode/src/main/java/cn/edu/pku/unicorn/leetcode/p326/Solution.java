/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p326;

import cn.edu.pku.unicorn.leetcode.p056.Interval;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 326 Power of Three
 */
public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i ++) {
//            double a = Math.pow(3, i);
//            BSTIterator solution = new BSTIterator();
//            System.out.println(solution.isPowerOfThree((int)a));
//        }

        int i = 1;
        while (Math.pow(3, i) < Integer.MAX_VALUE) {
            i++;
        }
        System.out.println("3^" + (i - 1) + "=" + Math.pow(3, i - 1));
        // 1 2 3 4 5 6 7 8 9 10
        // 3^x
        System.out.println(Math.log(1162261467) / Math.log(3));
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return 1162261467 % n == 0;
    }
}
