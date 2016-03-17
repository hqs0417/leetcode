package cn.edu.pku.unicorn.leetcode.p144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 144 Binary Tree Preorder Traversal
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree("[1,2,3,#,#,4,#,#,5]");
        List<Integer> preorderTraversalList = solution.preorderTraversal(root);

        Util.printList(preorderTraversalList);
        preorderTraversalList = solution.preorderTraversalIterative(root);
        Util.printList(preorderTraversalList);

    }

    /**
     * 二叉树先序遍历，递归算法
     *
     * @param root
     *
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalRecursive(root, list);
        return list;
    }

    /**
     * 递归体
     *
     * @param root
     * @param list
     */
    public void preorderTraversalRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalRecursive(root.left, list);
        preorderTraversalRecursive(root.right, list);
    }

    /**
     * 非递归前序遍历
     * @return 前序遍历结果
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
