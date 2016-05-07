package cn.edu.pku.unicorn.leetcode.p342;

/**
 * @author v_zhengkun
 * @since 2016/5/7 14:31
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(-1));
        System.out.println(solution.isPowerOfFour(1));
        System.out.println(solution.isPowerOfFour(4));
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(64));
    }

    public boolean isPowerOfFour(int num) {
        return (num > 0 && (num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
}
