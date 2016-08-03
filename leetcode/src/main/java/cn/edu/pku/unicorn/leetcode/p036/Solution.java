package cn.edu.pku.unicorn.leetcode.p036;

import java.util.HashSet;

/**
 * Created by v_zhengkun on 2016/2/21.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 横向判断
        for (int i = 0; i < 9; i ++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (!set.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }

        // 纵向判断
        for (int j = 0; j < 9; j++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int i = 0; i < 9; i++) {
                if (!set.add(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
            }
        }

        // 正方形单元格判断
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> set = new HashSet<Character>();
                for (int x = 0; i < 3; i ++) {
                    for (int y = 0; y < 3; y ++) {
                        char c = board[i+x][j+y];
                        if (!set.add(c) && c != '.') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}