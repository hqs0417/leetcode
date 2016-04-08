package cn.edu.pku.unicorn.leetcode.p240;

/**
 * Created by v_zhengkun on 2016/4/6.
 * 240. Search a 2D Matrix II
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                        {1,     4,      7,      11,     15},
                        {2,     5,      8,      12,     19},
                        {3,     6,      9,      16,     22},
                        {10,    13,     14,     17,     24},
                        {18,    21,     23,     26,     30}
        };
        System.out.println(solution.searchMatrix(matrix, 14));
        System.out.println(solution.searchMatrix(matrix, 31));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int j = n - 1;
        for (int i = 0; i < m; i++) {
            while (j > 0 && matrix[i][j] > target) {
                j--;
            }
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }

}
