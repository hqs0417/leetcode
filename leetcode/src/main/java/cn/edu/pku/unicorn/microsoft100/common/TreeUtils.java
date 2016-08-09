package cn.edu.pku.unicorn.microsoft100.common;

/**
 * Created by v_zhengkun on 2016/8/9.
 */
public class TreeUtils {
    /**
     * 向二叉查找树中插入节点
     * @return 根节点
     */
    public static TreeNode insertBST(TreeNode root, TreeNode x) {
        if (root == null) {
            return x;
        }
        // 往左子树中插入
        if (x.val < root.val) {
            root.left = insertBST(root.left, x);
        } else if (x.val > root.val) {
            root.right = insertBST(root.right, x);
        } else {
            // 相等，不处理
            // 不存储相等的元素
        }
        return root;
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.val + " ");
        inorderTraverse(root.right);
    }
}
