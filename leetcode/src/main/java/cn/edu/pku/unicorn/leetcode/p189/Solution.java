package cn.edu.pku.unicorn.leetcode.p189;

/**
 * Created by v_zhengkun on 2016/3/7.
 * 189 Rotate Array
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 2};
        solution.rotate(nums, 0);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void rotate(int[] nums, int n) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        n = n % nums.length;
        if (n == 0) {
            return;
        }

        reverse(nums, 0, nums.length - n - 1);
        reverse(nums, nums.length - n, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        for (int i = start; i <= mid; i++) {
            int t = nums[i];
            nums[i] = nums[end - i + start];
            nums[end - i + start] = t;
        }
    }
}
