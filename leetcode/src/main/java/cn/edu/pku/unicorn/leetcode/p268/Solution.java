package cn.edu.pku.unicorn.leetcode.p268;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 268 Missing Number
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
}
