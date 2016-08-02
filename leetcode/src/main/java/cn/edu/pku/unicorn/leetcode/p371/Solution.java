package cn.edu.pku.unicorn.leetcode.p371;

/**
 * Created by unicorn on 2016/8/2.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getSum(1, 3));
    }

    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b; // 进位标志
            a = a ^ b; //  不同的位
            b = carry << 1;
        }
        return a;
    }
}
