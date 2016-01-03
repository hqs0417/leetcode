package cn.edu.pku.unicorn.leetcode.p198;

/**
 * @author Unicorn
 */
public class Solution {
    public static int rob(int[] num) {

        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int A[] = new int[num.length];
        A[0] = num[0];
        A[1] = num[0] > num[1] ? num[0] : num[1];

        for (int i = 2; i < num.length; i++) {
            if (A[i - 1] > A[i - 2] + num[i]) {
                A[i] = A[i - 1];
            } else {
                A[i] = A[i - 2] + num[i];
            }
        }

        return A[num.length - 1];
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(rob(num));
    }
}
