package cn.edu.pku.unicorn.leetcode.p108;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by v_zhengkun on 2016/3/19.
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int s, int e) {
        if (s == e) {
            return new TreeNode(nums[s]);
        }
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (s < mid) {
            root.left = helper(nums, s, mid - 1);
        }
        if (mid < e) {
            root.right = helper(nums, mid + 1, e);
        }
        return root;
    }
}
