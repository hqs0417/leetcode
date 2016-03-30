package cn.edu.pku.unicorn.leetcode.p053;

/**
 * Created by v_zhengkun on 2016/3/29.
 * 53. Maximum Subarray
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, -4};
        System.out.println(solution.maxSubArray(nums));
        System.out.println(solution.maxSubArray1(nums));
    }
    /**
     * 解法1，分治法 时间复杂度为O(nlgn)
     * 将数组从中间进行分割成两部分
     * 最大子数组的出现有三种可能，
     * 1，在左半部分
     * 2，在右半部分
     * 3，跨越中间的节点，
     * 对于1,2两种情况，可以变成子问题的求解，
     * 对于第3种情况，可以从中间向左和向右，找出最大的左边和右侧的位置，求出最大值
     * 将上面三种进行比较，得出最大子数组的位置
     *
     * @param nums
     *
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    /**
     * @param nums 数组
     * @param s    start
     * @param e    end
     *
     * @return
     */
    public int maxSubArrayHelper(int[] nums, int s, int e) {
        if (s > e) {
            return Integer.MIN_VALUE;
        }
        if (s == e) {
            return nums[s];
        }
        int mid = s + (e - s) / 2;
        int leftMax = maxSubArrayHelper(nums, s, mid); // 左半部分
        int rightMax = maxSubArrayHelper(nums, mid + 1, e); // 右半部分
        // 求跨越中间的部分
        int midLeftMax = nums[mid];
        int leftSum = nums[mid];
        for (int i = mid - 1; i >= s; i--) {
            leftSum += nums[i];
            midLeftMax = Math.max(midLeftMax, leftSum);
        }
        int midRightMax = nums[mid];
        int rightSum = nums[mid];
        for (int i = mid + 1; i <= e; i++) {
            rightSum += nums[i];
            midRightMax = Math.max(midRightMax, rightSum);
        }
        int midMax = midLeftMax + midRightMax - nums[mid]; //多计算了一次，减去

        return Math.max(midMax, Math.max(leftMax, rightMax));
    }


    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int maxHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxHere <= 0) {
                maxHere = nums[i];
            } else {
                maxHere += nums[i];
            }
            if (maxHere > maxSum) {
                maxSum = maxHere;
            }
        }
        return maxSum;
    }
}
