package cn.edu.pku.unicorn.leetcode.p338;

import java.util.Arrays;

/**
 * @author v_zhengkun
 * @since 2016/5/13 17:09
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(7)));
    }

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        int n = 1; // 外部循环次数
        int i = 1; //

        while (i <= num) {
            double pow = Math.pow(2, n);
            for (int j = 0; j < pow && i <= num; j++) {
                arr[i++] = arr[j++] + 1;
            }
            n++;
        }
        return arr;
    }
}
