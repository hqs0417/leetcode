package cn.edu.pku.unicorn.leetcode.p334;

/**
 * @author v_zhengkun
 * @since 2016/5/14 9:39
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= x1) x1 = num;
            else if(num <=x2) x2 = num;
            else return true;
        }
        return false;
    }
}
