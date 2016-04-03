package cn.edu.pku.unicorn.leetcode.p153;

/**
 * Created by v_zhengkun on 2016/3/30.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 8, 9, 1, 2, 3, 4};
        System.out.println(solution.findMin(nums));
        int[] nums1 = {1, 2};
        System.out.println(solution.findMin(nums1));
    }

    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[e]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return nums[s];
    }
}
