package cn.edu.pku.unicorn.leetcode.p026;

import java.util.Arrays;

/**
 * Created by Unicorn on 2015/10/1.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int currVal = nums[0];
        int emptyPos = 0;
        for(int i = 1; i < nums.length; i++ ){
            if(emptyPos == 0) {
                if(nums[i] != currVal) {
                    currVal = nums[i];
                } else {
                    emptyPos = i;
                }
            } else {
                if(nums[i] != currVal) {
                    nums[emptyPos++] = nums[i];
                    currVal = nums[i];
                }
            }
        }
        return emptyPos == 0? nums.length : emptyPos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};
        int size = solution.removeDuplicates(nums);
        System.out.println(size);
        System.out.println(Arrays.toString(nums));
    }
}
