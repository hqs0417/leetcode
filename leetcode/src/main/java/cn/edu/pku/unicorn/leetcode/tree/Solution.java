package cn.edu.pku.unicorn.leetcode.tree;

import java.util.LinkedList;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by v_zhengkun on 2016/3/20.
 * 二叉树专题
 */
public class Solution {
    /**
     * 前序遍历（递归）
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 前序遍历（非递归）
     */
    public void preOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.println(root.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉树中序遍历（递归）
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 二叉树中序遍历（非递归）
     */
    public void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null) {
                stack.push(cur.left);
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                if (cur.right != null) {
                    stack.push(cur);
                }
            }
        }
    }



    /**
     * 二叉树后序遍历（非递归）
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        boolean pushLeft = true;
        stack.push(cur);
        while (cur != null || !stack.isEmpty()) {
            if (pushLeft) {
                stack.push(cur);
                cur = cur.left;
            } else {
                pushLeft = false;
                cur = stack.peek();
                if (pre == cur.right) {
                    cur = stack.pop();
                    System.out.println(cur.val + ",");
                } else {
                    cur = cur.right;
                    pushLeft = true;
                }
            }
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.removeFirst();
            System.out.println(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.addLast(p.right);
            }
        }
    }
}
