package cn.edu.pku.unicorn.leetcode.p122;

/**
 * Created by v_zhengkun on 2016/3/11.
 * 122 Best Time to Buy and Sell Stock
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {5, 4, 3, 5, 2, 6, 9, 7, 8};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
