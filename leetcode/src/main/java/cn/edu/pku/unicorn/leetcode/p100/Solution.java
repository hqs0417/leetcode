package cn.edu.pku.unicorn.leetcode.p100;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by unicorn on 15-9-26.<br/>
 * p100 Same Tree <br/>
 * Given two binary trees, write a function to check if they are equal or not.<br/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.<br/>
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(1);
        TreeNode q = null;
        System.out.println(solution.isSameTree(p, q));
    }
}
