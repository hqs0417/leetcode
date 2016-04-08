package cn.edu.pku.unicorn.leetcode.p300;

/**
 * Created by v_zhengkun on 2016/4/4.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] F = new int[n];
        for (int i = 0; i < n; i++) {
            F[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    F[i] = Math.max(F[i], F[j] + 1);
                }
            }
        }
        int max = F[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, F[i]);
        }
        return max;
    }


}
