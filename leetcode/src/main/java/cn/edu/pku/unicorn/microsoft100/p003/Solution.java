package cn.edu.pku.unicorn.microsoft100.p003;

/**
 * 求子数组的最大和（数组）
 * Created by v_zhengkun on 2016/8/9.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(solution.maxSubArray(nums));
        System.out.println(solution.maxSubArray1(nums));
        nums = new int[] {-3, -2, -1};
        System.out.println(solution.maxSubArray(nums));
        System.out.println(solution.maxSubArray1(nums));
    }

    /**
     * 使用贪心算法
     *
     * @param nums
     *
     * @return
     */
    public int maxSubArray(int[] nums) {
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
            maxSum = Math.max(maxSum, maxHere);
        }
        return maxSum;
    }

    /**
     * 分治法
     *
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return maxSubArray1Helper(nums, 0, nums.length - 1);
    }

    private int maxSubArray1Helper(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        // 假设全在mid左侧
        int leftMax = maxSubArray1Helper(nums, start, mid);
        // 假设全在mid右侧
        int rightMax = maxSubArray1Helper(nums, mid + 1, end);
        // 跨越中间
        int leftMidSum = nums[mid];
        int leftMidMax = nums[mid];
        for (int i = mid - 1; i >= start; i--) {
            leftMidSum += nums[i];
            leftMidMax = Math.max(leftMidMax, leftMidSum);
        }
        int rightMidSum = nums[mid + 1];
        int rightMidMax = nums[mid + 1];
        for (int i = mid + 2; i <= end; i++) {
            rightMidSum += nums[i];
            rightMidMax = Math.max(rightMidMax, rightMidSum);
        }
        return Math.max(rightMidMax + leftMidMax, Math.max(leftMax, rightMax));
    }
}
