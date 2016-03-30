package cn.edu.pku.unicorn.leetcode.p230;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/3/20.
 */
public class Solution {

    private int k = 0;
    private int result = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree("[4,2,6,1,3,5,7,#]");
        System.out.println(solution.kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        kthSmallestRecursive(root);
        return result;
    }

    private void kthSmallestRecursive(TreeNode root) {

        if (root == null) {
            return;
        }
        if (k > 0) {
            kthSmallestRecursive(root.left);
        }
        System.out.println("r" + root.val);
        if (--k == 0) {
            result = root.val;
        }
        if (k > 0) {
            kthSmallestRecursive(root.right);
        }
    }
}
