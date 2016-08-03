package cn.edu.pku.unicorn.leetcode.p357;

/**
 * Created by v_zhengkun on 2016/8/3.
 */
public class Solution {

    private static int[] arr = new int[11];
    static {
        // arr[0] = 1;
        arr[1] = 10;
        arr[2] = 9 * 9;
        for (int i = 3; i <= 10; i++) {
            arr[i] = arr[i - 1] * (10 - i + 1);
        }
        for (int i = 2; i <= 10; i++) {
            arr[i] += arr[i - 1];
        }
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        return arr[Math.min(n, 10)];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countNumbersWithUniqueDigits(0));
        System.out.println(solution.countNumbersWithUniqueDigits(1));
        System.out.println(solution.countNumbersWithUniqueDigits(2));
        System.out.println(solution.countNumbersWithUniqueDigits(3));
        System.out.println(solution.countNumbersWithUniqueDigits(4));

    }

}
