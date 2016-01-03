package cn.edu.pku.unicorn.leetcode.p228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0, j = 0;
        int n = nums.length;
        while (i < n && j < n) {
            if (j + 1 < n && nums[j] + 1 == nums[j + 1]) {
                j++;
            } else {
                if (j == i) {//只有一个元素
                    result.add(nums[i] + "");
                } else {
                    result.add(nums[i] + "->" + nums[j]);
                }
                j++;
                i = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2, 4, 5, 7};

        System.out.println(solution.summaryRanges(nums));
    }
}