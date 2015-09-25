package cn.edu.pku.unicorn.leetcode.p283;

import java.util.Arrays;

/**
 * Created by unicorn on 15-9-25.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zone element
 * For example, given nums = [0, 1, 0, 3, 12]. after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int p = -1;
        for(int i = 0; i < nums.length; i++) {
            if( p == -1) {
                if(nums[i] == 0) {
                    p = i;
                }
            } else {
                if(nums[i] != 0) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                    p++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 0, 1};
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
