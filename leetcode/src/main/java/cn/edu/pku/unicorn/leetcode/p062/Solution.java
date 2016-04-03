package cn.edu.pku.unicorn.leetcode.p062;

/**
 * Created by v_zhengkun on 2016/3/29.
 * 062. Unique Paths
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(0, 10));
        System.out.println(solution.uniquePaths(10, 10));
        System.out.println(solution.uniquePaths(1, 10));

        System.out.println(solution.uniquePaths1(0, 10));
        System.out.println(solution.uniquePaths1(10, 10));
        System.out.println(solution.uniquePaths1(1, 10));

    }

    /**
     * Dynamic Programming
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            A[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            A[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                A[i][j] = A[i - 1][j] + A[i][j - 1];
            }
        }
        return A[m - 1][n - 1];
    }

    /**
     * recursive
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        return helper(1, 1, m, n);
    }

    private int helper(int row, int col, int m, int n) {
        if (row > m || col > n) {
            return 0;
        }
        if (row == m && col == n) {
            return 1;
        }
        return helper(row + 1, col, m, n) + helper(row, col + 1, m, n);
    }


}
