package cn.edu.pku.unicorn.leetcode.p173;

/**
 * Created by v_zhengkun on 2016/4/4.
 */

import java.util.LinkedList;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private LinkedList<TreeNode>  stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("no more elements!");
        } else {
            TreeNode top = stack.pop();
            TreeNode p = top.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            return top.val;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */