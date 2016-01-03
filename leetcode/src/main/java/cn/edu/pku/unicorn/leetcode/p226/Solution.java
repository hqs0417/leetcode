package cn.edu.pku.unicorn.leetcode.p226;

/**
 * Invert Binary Tree
 *
 * @author Unicorn
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null != root) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;

    TreeNode(int x) {
        val = x;
    }

    TreeNode right;
}
