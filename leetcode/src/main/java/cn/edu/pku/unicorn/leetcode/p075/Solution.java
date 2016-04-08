package cn.edu.pku.unicorn.leetcode.p075;

import java.util.Arrays;

/**
 * Created by v_zhengkun on 2016/4/3.
 * 75. Sort Colors
 *
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2, 0, 1, 2};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int redSt = 0, blueSt = nums.length - 1;
        int i = 0;
        while (i < blueSt + 1) {
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[redSt];
                nums[redSt] = t;

                redSt++;
                i++;
            } else if (nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[blueSt];
                nums[blueSt] = t;

                blueSt--;
            } else {
                i++;
            }
        }
    }

}

