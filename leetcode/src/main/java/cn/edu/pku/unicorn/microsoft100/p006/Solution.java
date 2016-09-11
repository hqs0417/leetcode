package cn.edu.pku.unicorn.microsoft100.p006;

import cn.edu.pku.unicorn.microsoft100.common.TreeNode;

/**
 * 二叉树遍历
 * Created by v_zhengkun on 2016/8/10.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

}
