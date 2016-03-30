package cn.edu.pku.unicorn.leetcode.p309;

/**
 * Created by v_zhengkun on 2016/3/29.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        int[] prices1 = {2, 1};
        int[] prices2 = {1, 4, 2};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit(prices1));
        System.out.println(solution.maxProfit(prices2));
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 表示当天最终未持股的情况下，当天结束后的累计最大利润
        int[] sellDp = new int[prices.length];
        // 表示当天最终持股的情况下，当天结束后的累计最大利润
        int[] buyDp = new int[prices.length];

        // 考虑初始情况
        buyDp[0] = -prices[0];
        sellDp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
            if (i >= 2) {
                buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
            } else {
                buyDp[i] = Math.max(buyDp[i - 1], -prices[i]);
            }
        }
        return sellDp[prices.length - 1];
    }
}
