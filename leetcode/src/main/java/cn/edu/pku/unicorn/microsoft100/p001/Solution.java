package cn.edu.pku.unicorn.microsoft100.p001;

import cn.edu.pku.unicorn.microsoft100.common.TreeNode;
import cn.edu.pku.unicorn.microsoft100.common.TreeUtils;

/**
 * 把二元查找树转变成排序的双向链表（树）
 * 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只调整指针的指向。
 * 10
 * /   \
 * 6    14
 * / \   / \
 * 4   8 12 16
 * 转换为 4 ←→ 6 ←→ 8 ←→ 10 ←→ 12
 * Created by v_zhengkun on 2016/8/9.
 */
public class Solution {

    private TreeNode tree2List(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = mostLeftNode(root);

        TreeNode tail = tree2ListHelper(root, null);
        return head;
    }

    private TreeNode tree2ListHelper(TreeNode root, TreeNode tail) {
        if (root == null) {
            return null;
        }
        // 处理左子树
        if (root.left == null) {
            if (tail != null) {
                tail.right = root;
            }
            root.left = tail;
        } else {
            TreeNode leftTail = tree2ListHelper(root.left, tail);
            if (leftTail != null) {
                leftTail.right = root;
            }
        }
        tail = root;
        // 处理右子树
        if (root.right == null) {

        } else {
            TreeNode rightTail = tree2ListHelper(root.right, tail);
            if (rightTail != null) {
                tail = rightTail;
            }
        }
        return tail;
    }

    /**
     * 找出左子树最左侧的节点
     *
     * @param root
     *
     * @return
     */
    private TreeNode mostLeftNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        TreeNode root = null;
        for (int x : arr) {
            TreeNode node = new TreeNode(x);
            root = TreeUtils.insertBST(root, node);
        }
        TreeUtils.inorderTraverse(root);
        System.out.println();

        Solution solution = new Solution();
        TreeNode head = solution.tree2List(root);
        solution.printList(head);

    }
}
