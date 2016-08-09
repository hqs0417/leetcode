package cn.edu.pku.unicorn.leetcode.p080;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/8/8.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3};
        int n = solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
