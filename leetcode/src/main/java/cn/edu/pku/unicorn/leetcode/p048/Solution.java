package cn.edu.pku.unicorn.leetcode.p048;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/4/3.
 * 48. Rotate Image
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        // 先沿着左下，右上的对角线对换
        // 再沿着上下对换
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = t;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = t;
            }
        }
    }
}
