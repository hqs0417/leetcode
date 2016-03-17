package cn.edu.pku.unicorn.leetcode.p123;

import java.util.Map;

/**
 * Created by v_zhengkun on 2016/3/11.
 * 123 Best Time to Buy and Sell Stock III
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 1, valley = prices[0]; i < n; i++) {
            valley = Math.min(valley, prices[i]);
            f[i] = Math.max(prices[i] - valley, f[i - 1]);
        }
        for (int i = n - 2, peak = prices[n - 1]; i >= 0; i--) {
            peak = Math.max(peak, prices[i]);
            g[i] = Math.max(peak - prices[i], g[i + 1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, f[i] + g[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{3, 4, 5, 6, 7, 8, 1, 10};
        System.out.println(solution.maxProfit(prices));
    }
}
