package cn.edu.pku.unicorn.leetcode.p064;

/**
 * Created by v_zhengkun on 2016/4/3.
 * 64. Minimum Path Sum
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] F = new int[m][n];
        F[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            F[0][j] = F[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            F[i][0] = F[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n;j ++) {
                F[i][j] = grid[i][j] + Math.min(F[i-1][j], F[i][j-1]);
            }
        }
        return F[m-1][n-1];
    }
}
