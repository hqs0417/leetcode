package cn.edu.pku.unicorn.leetcode.p022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesisCore1(n, n, "", result);
        return result;
    }

    /**
     * @param left   左括号的个数
     * @param right  右括号的个数
     * @param path   已经处理号的括号字符串
     * @param result 结果
     */
    private void generateParenthesisCore(int left, int right, String path, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(path);
            return;
        }
        if (right == left) {
            generateParenthesisCore(left - 1, right, path + '(', result);
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    if (left > 0) {
                        generateParenthesisCore(left - 1, right, path + '(', result);
                    }
                }
                if (i == 1) {
                    if (right > 0) {
                        generateParenthesisCore(left, right - 1, path + ')', result);
                    }

                }
            }
        }
    }

    /**
     * @param left
     * @param right
     * @param path
     * @param result
     */
    private void generateParenthesisCore1(int left, int right, String path, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(path);
        }
        if (left > 0) {
            generateParenthesisCore1(left - 1, right, path + '(', result);
        }
        if (right > 0 && left < right) {
            generateParenthesisCore1(left, right - 1, path + ')', result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));

    }
}