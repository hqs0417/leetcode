package cn.edu.pku.unicorn.leetcode.p169;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 简答粗暴的解法
     * 使用map统计每个元素的个数，找出个数大于n/2的
     * 依赖于map，时间复杂度是O(n)
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);

            if (count == null) {
                count = new Integer(1);
            } else {
                count++;
            }
            map.put(nums[i], count);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 先选择第一个数字为备选数字
     * 逐个与其他数字比较，如果相同，则个数加一，不同则减一
     * 为0时重新选择备选数字
     * 时间复杂度为O(n)
     * 经测试运行效率要低于第一个
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement1(int[] nums) {
        int candinate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candinate = nums[i];
                count = 1;
            } else {
                if (candinate != nums[i]) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return candinate;
    }

    /**
     * 思路同上
     * 采用链表，类似于栈
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement2(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i : nums) {
            int size = list.size();
            if (size > 0) {
                if (list.get(size - 1) != nums[i]) {
                    list.remove(size - 1);
                } else {
                    list.add(nums[i]);
                }
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(list.size() - 1);
    }

    /**
     * 分治
     * 时间复杂度O(lgn)
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement3(int[] nums) {
        return majorityElement3Core(nums, 0, nums.length - 1);
    }

    private int majorityElement3Core(int[] nums, int j, int k) {
        if (j == k) {
            return nums[j];
        }
        int m = j + (k - j) / 2;
        int left = majorityElement3Core(nums, j, m);
        int right = majorityElement3Core(nums, m + 1, k);
        if (left == right) {
            return left;
        }

        int leftCount = getCount(nums, j, k, left);
        int rightCount = getCount(nums, j, k, right);
        if (leftCount >= rightCount) {
            return left;
        }
        return right;
    }

    private int getCount(int[] nums, int j, int k, int e) {
        int count = 0;
        for (int i = j; i <= k; i++) {
            if (e == nums[i]) {
                count++;
            }
        }
        return count;
    }
}