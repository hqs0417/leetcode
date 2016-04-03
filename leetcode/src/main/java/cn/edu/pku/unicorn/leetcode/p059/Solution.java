package cn.edu.pku.unicorn.leetcode.p059;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/4/2.
 * 59. Spiral Matrix II
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(2)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(4)));
    }
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, down = n - 1;
        int k = 1;
        while (left <= right && top <= down) {
            // right
            for (int j = left; j <= right; j++) {
                nums[top][j] = k++;
            }
            top++;
            // down
            for (int i = top; i <= down; i++) {
                nums[i][right] = k++;
            }
            right--;
            // left
            for (int j = right; j >= left && top <= down; j--) {
                nums[down][j] = k++;
            }
            down--;
            // top
            for (int i = down; i >= top && left <= right; i--) {
                nums[i][left] = k++;
            }
            left++;

        }
        return nums;
    }
}
