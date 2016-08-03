package cn.edu.pku.unicorn.leetcode.p279;

/**
 * Created by v_zhengkun on 2016/3/6.
 */
public class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = i;
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + solution.numSquares(i));
        }
    }
}
