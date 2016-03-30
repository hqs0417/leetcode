package cn.edu.pku.unicorn.leetcode.p213;

/**
 * Created by v_zhengkun on 2016/3/19.
 * 213. House Rob II
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1};
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(subRob(nums, 0, nums.length - 2), subRob(nums, 1, nums.length - 1));
    }

    public int subRob(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] F = new int[n];
        F[0] = nums[start];
        F[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            F[i] = Math.max(F[i - 2] + nums[start + i], F[i - 1]);
        }
        return F[n - 1];
    }
}
