package cn.edu.pku.unicorn.leetcode.p073;

/**
 * @author v_zhengkun
 * @since 2016/5/14 12:46
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean cleanFirstRow = false;
        boolean cleanFirstColumn = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                cleanFirstColumn = true;
                break;
            }
        }
        for (int j = 0; j < column; j++) {
            if (matrix[0][j] == 0) {
                cleanFirstRow = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (cleanFirstRow) {
            for (int j = 0; j < column; j++) {
                matrix[0][j] = 0;
            }
        }
        if (cleanFirstColumn) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
