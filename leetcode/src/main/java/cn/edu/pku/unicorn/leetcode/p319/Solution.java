package cn.edu.pku.unicorn.leetcode.p319;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 319 Bulb Switcher
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 100; i ++) {
            System.out.println(i + "==>" + solution.bulbSwitch(i) + " " + solution.bulbSwitch1(i));
        }
    }
    // 暴力求解
    // 运行时间复杂度是O(n^2)
    public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        Arrays.fill(bulbs, true);
        for (int i = 2; i <= n; i ++) {
            for (int j = i - 1; j < n; j += i) {
                bulbs[j] = !bulbs[j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i ++) {
            if (bulbs[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 简单算法
     * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
     * 1 1 1 2 2 2 2 2 3 3  3  3  3  3  3  4  4  4  4  4  4  4  4  4
     *   3        5               7                   9
     * @param n
     * @return
     */
    public int bulbSwitch1(int n) {
        return (int)Math.sqrt(n);
    }
}
