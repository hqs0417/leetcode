package cn.edu.pku.unicorn.leetcode.p074;

import cn.edu.pku.unicorn.leetcode.common.Pair;

/**
 * Created by v_zhengkun on 2016/4/5.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix1(matrix, 3));
        int[][] m = {{1}};
        System.out.println(solution.searchMatrix1(m, 0));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m * n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int t = matrix[mid / n][mid % n];
            if (target == t) {
                return true;
            } else if (target < t) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 第一次二分找出所在的行
        int s = 0, e = m - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        if (e < 0) {
            return false;
        }
        int row = e;
        s = 0;
        e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target <= matrix[row][mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return false;
    }
}