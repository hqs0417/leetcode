package cn.edu.pku.unicorn.leetcode.p054;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.DISCARDING;

/**
 * Created by v_zhengkun on 2016/3/30.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3},{8, 9 ,4},{7, 6, 5}};
        int[][] matrix1 = {{1}};
        int[][] matrix2 = {{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        // System.out.println(solution.spiralOrder(matrix));
        System.out.println(solution.spiralOrder1(matrix));
        // System.out.println(solution.spiralOrder(matrix1));
        // System.out.println(solution.spiralOrder(matrix2));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] mark = new boolean[m][n]; // 标记是否访问过
        int i = 0, j = 0; // 当前位置
        mark[0][0] = true;
        result.add(matrix[0][0]);
        int count = 1;
        Direction currDir = Direction.RIGHT; // 当前方向
        while (count < m * n) {
            if (currDir == Direction.RIGHT) {
                if (j + 1< n && !mark[i][j+1]) {
                    mark[i][j++] = true;
                    result.add(matrix[i][j]);
                    count++;
                } else {
                    currDir = Direction.DOWN;
                }
            } else if (currDir == Direction.DOWN) {
                if (i + 1< m && !mark[i + 1][j]) {
                    mark[i++][j] = true;
                    result.add(matrix[i][j]);
                    count++;
                } else {
                    currDir = Direction.LEFT;
                }
            } else if (currDir == Direction.LEFT) {
                if (j - 1 >= 0 && !mark[i][j - 1]) {
                    mark[i][j--] = true;
                    result.add(matrix[i][j]);
                    count++;
                } else {
                    currDir = Direction.TOP;
                }
            } else if (currDir == Direction.TOP){
                if (i - 1>= 0 && !mark[i-1][j]) {
                    mark[i--][j] = true;
                    result.add(matrix[i][j]);
                    count++;
                } else {
                    currDir = Direction.RIGHT;
                }
            }
        }
        return result;
    }

    enum Direction{
        TOP,DOWN, RIGHT, LEFT
    }


    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1; // 左右边界
        int top = 0, down = matrix.length - 1; // 上下边界

        while (left <= right && top <= down) {
            // right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            // down
            for (int i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // left
            for (int j = right; j >= left && top <= down; j--) {
                result.add(matrix[down][j]);
            }
            down--;
            // top
            for (int i = down; i >= top && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
