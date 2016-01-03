package cn.edu.pku.unicorn.leetcode.p217;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            } else {
                hashMap.put(nums[i], nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }
}


