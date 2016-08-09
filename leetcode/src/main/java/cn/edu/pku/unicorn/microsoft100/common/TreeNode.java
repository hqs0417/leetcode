package cn.edu.pku.unicorn.microsoft100.common;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树节点
 * Created by v_zhengkun on 2016/8/9.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }
    public TreeNode(int v) {
        this.val = v;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
