package cn.edu.pku.unicorn.leetcode.p101;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by Unicorn on 2015/10/1.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isReverse(root.left, root.right);
    }

    private boolean isReverse(TreeNode left, TreeNode right) {
        if(left == null) {
            return right == left;
        }
        if(right == null) {
            return left == null;
        }
        return left.val == right.val && isReverse(left.left, right.right) && isReverse(left.right, right.left);
    }
}
