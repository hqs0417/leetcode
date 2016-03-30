package cn.edu.pku.unicorn.leetcode.p337;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

/**
 * Created by v_zhengkun on 2016/3/19.
 * 337. House Rob III
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ret = robHelper(root);
        return Math.max(ret[0], ret[1]);
    }

    /**
     * @return
     */
    public int[] robHelper(TreeNode root) {
        // 第一个值代表当前节点计算在内的最大值
        // 第二个值代表不计算当前节点的最大值
        int[] ret = new int[2];
        if (root == null) {
            return ret;
        }
        int[] lRet = robHelper(root.left);
        int[] rRet = robHelper(root.right);
        ret[0] = lRet[1] + rRet[1] + root.val;
        ret[1] = Math.max(lRet[0], lRet[1]) + Math.max(rRet[0], rRet[1]);

        return ret;
    }

}
