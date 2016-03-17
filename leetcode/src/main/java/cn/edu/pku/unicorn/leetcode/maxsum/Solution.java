package cn.edu.pku.unicorn.leetcode.maxsum;

import java.util.Map;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 最大子段和
 * 最大m子段和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, -1, 3, 4, -4, -5, -6, -7};
        System.out.println(solution.maxSum(nums));
        System.out.println(solution.maxSum1(nums));
        System.out.println(solution.maxSum2(nums));
        System.out.println(solution.maxSum3(nums));
    }
    /**
     * 最大子段和，暴力求解
     * 遍历所有的可能，计算出最优解
     *
     * @param nums 输入的序列
     *
     * @return
     */
    public int maxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = nums[i];
                for(int k = i + 1; k <= j; k ++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    /**
     * 最大子段和，暴力求解（优化）
     * 去除第三个循环
     */
    public int maxSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int thisSum = 0;
            for (int j = i; j < n; j++) {
                thisSum += nums[j];
                sum = Math.max(thisSum, sum);
            }
        }
        return sum;
    }

    /**
     * 最大子段和
     * 分治法，递归
     * @param nums 输入的数组
     * @return 最大子段和
     */
    public int maxSum2(int[] nums) {
        return maxSum2Recursive(nums, 0, nums.length - 1);
    }

    /**
     * 最大子段和，分治法，递归体
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int maxSum2Recursive(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int leftMaxSum = maxSum2Recursive(nums, start, mid);
        int rightMaxSum = maxSum2Recursive(nums, mid + 1, end);
        int lSum = 0;
        int lMax = nums[mid];
        for(int i = mid; i >= start; i--) {
            lSum += nums[i];
            lMax = Math.max(lMax, lSum);
        }
        int rSum = 0;
        int rMax = nums[mid + 1];
        for (int j = mid + 1; j <= end; j++) {
            rSum += nums[j];
            rMax = Math.max(rMax, rSum);
        }
        int maxSum = lSum + rSum;
        if (maxSum < leftMaxSum) {
            maxSum = leftMaxSum;
        }
        if (maxSum < rightMaxSum) {
            maxSum = rightMaxSum;
        }
        return maxSum;
    }

    /**
     * 最大子段和
     * 动态规划
     * @param a
     * @return
     */
    public int maxSum3(int[] a) {
        int n = a.length;
        int sum=0;//sum保存的是当前连续几个数的和的最大值，只是记录目前算得得最大值。
        int tem=0;//tem表示决策第i个数时所保存的第i-1个数决策状态。
        int begin, end;
        for(int i=0;i<n;i++){
            if(tem>0)
                tem+=a[i];//如果tem>0，说明tem可
            else{
                tem=a[i];
                begin=i;//如果tem小于等于零，说明重新计算最大字段和，记下开始位置
            }
            if(tem>sum){
                sum=tem;
                end=i;//如果tem>sum，说明刷新了最大子段和的值，记下结束位置
            }
        }
        return sum;
    }


}
