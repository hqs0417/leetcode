package cn.edu.pku.unicorn.leetcode.p016;

import java.util.Arrays;

/**
 * P016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 2};
        System.out.println(solution.threeSumClosest(arr, 3));
    }

    public int threeSumClosest(int[] nums, int target) {
        final int n = nums.length;
        if (n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closestVal = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - closestVal) > Math.abs(target - sum)) {
                    closestVal = sum;
                } else if (sum < target) {
                    left++;
                } else if (sum >= target) {
                    right--;
                }
            }
        }
        return closestVal;
    }
} 
