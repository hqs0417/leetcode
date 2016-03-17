package cn.edu.pku.unicorn.leetcode.p094;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/3/12.
 * 94. Binary Tree Inorder Traversal
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = Util.buildTree("1,2,3,#,4,5");
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        Util.printList(list);
    }

    /**
     *
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        return null;
    }

    private void inorderTraversal1Recursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal1Recursive(root.left, result);
        result.add(root.val);
        inorderTraversal1Recursive(root.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

}
