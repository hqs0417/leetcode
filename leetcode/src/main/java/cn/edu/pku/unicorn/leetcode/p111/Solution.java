package cn.edu.pku.unicorn.leetcode.p111;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

    public static void main(String[] args) {

    }
}