package cn.edu.pku.unicorn.leetcode.p215;

import java.util.PriorityQueue;

/**
 * @author v_zhengkun
 * @since 2016/5/14 19:39
 */
public class Solution {

    /**
     * 使用QuickSelect算法
     * 每次选出一个元素作为pivot，将左右划分成两块，左边的都比pivot小，右边的都比pivot大
     * 如果pivot的位置恰好是k，则找到，如果比k小，在右半部分查找，否则在左半部分查找
     *
     * @param nums
     * @param k
     *
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return getKth(nums.length - k +1, nums, 0, nums.length - 1);
    }

    public int getKth(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    public void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    /**
     * 使用堆排序思想，可以使用Java自带的PriorityQueue
     *
     * @param nums
     * @param k
     *
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        // Java优先级队列，是小根堆
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = {3, 2, 1, 5, 6, 4};
        int[] nums = {99, 99};
        // System.out.println(solution.findKthLargest(nums, 2));
        System.out.println(solution.findKthLargest1(nums, 1));
        System.out.println(solution.findKthLargest(nums, 1));
    }
}
