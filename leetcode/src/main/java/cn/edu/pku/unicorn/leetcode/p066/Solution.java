package cn.edu.pku.unicorn.leetcode.p066;

import java.util.Arrays;

/**
 * Created by Unicorn on 2015/10/1.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + flag;
            if (val >= 10) {
                digits[i] = val % 10;
                flag = 1;
            } else {
                digits[i] = val;
                flag = 0;
            }
        }
        if (flag == 0) {
            return digits;
        }
        int[] resultDigits = new int[digits.length + 1];
        System.arraycopy(digits, 0, resultDigits, 1, digits.length);
        resultDigits[0] = 1;
        return resultDigits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(nums)));
    }
}