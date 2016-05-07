package cn.edu.pku.unicorn.leetcode.p343;

import java.util.Map;
import java.util.regex.Matcher;

/**
 * @author v_zhengkun
 * @since 2016/5/7 15:19
 * Integer Break
 * 尽量拆分成3，剩下的再拆分成2
 * 如
 *    5 = 3 = 2
 *    6 = 3 + 3
 *    7 = 3 + 2 + 2 // 由于 3 * 1 < 2 * 2 所以剩下4时需要拆分成2 + 2
 *    8 = 3 + 3 + 2
 *    9 = 3 + 3 + 3
 *   10 = 3 + 3 + 2 + 2
 *   ....
 *
 */
public class Solution {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] DP = new int[n + 1];
        DP[2] = 2;
        DP[3] = 3;
        for (int i = 4; i <= n; i++) {
            DP[i] = Math.max(DP[i - 2] * 2, DP[i - 3] * 3);
        }
        return DP[n];
    }

    /**
     * O(1) 解法
     * @return
     */
    public int integerBreak1(int n ) {
        if (n <= 3) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, (n - 4) / 3) * 4);
        } else {
            return (int) (Math.pow(3, (n - 2) / 3)) * 2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 2; i < 20; i++) {
            System.out.println(i + " " + solution.integerBreak(i));
            System.out.println(i + " " + solution.integerBreak1(i));
        }
    }
}
