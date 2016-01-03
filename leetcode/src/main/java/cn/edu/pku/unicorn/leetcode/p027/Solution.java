package cn.edu.pku.unicorn.leetcode.p027;


public class Solution {
    public int removeElement(int[] nums, int val) {
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (p == -1) {
                if (nums[i] == val) {
                    p = i;
                }
            } else {
                if (nums[i] != val) {
                    nums[p] = nums[i];
                    nums[i] = val;
                    p++;
                }
            }
        }
        return p == -1 ? nums.length : p;
    }
}
