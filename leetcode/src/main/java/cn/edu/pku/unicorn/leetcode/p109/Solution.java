package cn.edu.pku.unicorn.leetcode.p109;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import cn.edu.pku.unicorn.leetcode.common.ListNode;
import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by v_zhengkun on 2016/3/19.
 * 109. Convert Sorted List to Binary Search Tree
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        return null;
    }

    /**
     * 使用广度优先，逐层创建
     * 创建节点个数为n的平衡树
     * @param n 节点个数
     * @return 创建完成的树的根节点
     */
    private TreeNode makeTree(int n ) {
        TreeNode root = new TreeNode(0);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        n--;
        while (true) {
            if (n == 0){
                break;
            }
            TreeNode x = queue.pop();
            x.left = new TreeNode(0);
            queue.push(x.left);
            n--;
            if (n == 0) {
                break;
            }
            x.right = new TreeNode(0);
            queue.push(x.right);
            n--;
            if (n == 0) {
                break;
            }
        }
        return root;
    }

    ListNode inorder(TreeNode root, ListNode node) {
        if (root.left != null) {
            inorder(root.left, node);
        }
        root.val = node.val;
        node = node.next;
        if (root.right != null) {
            inorder(root.right, node);
        }
        return node;
    }

}
