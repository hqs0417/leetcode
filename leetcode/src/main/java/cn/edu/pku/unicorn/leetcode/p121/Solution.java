package cn.edu.pku.unicorn.leetcode.p121;

/**
 * Created by v_zhengkun on 2016/3/10.
 * 121 Best Time to Buy and Sell Stock
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {5, 4, 3, 5, 6, 7, 8, 9, 2, 7 ,8};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}