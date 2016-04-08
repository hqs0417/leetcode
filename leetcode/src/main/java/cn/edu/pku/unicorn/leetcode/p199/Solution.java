package cn.edu.pku.unicorn.leetcode.p199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/4/8.
 * 199 Binary Tree Right Side View
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree("1,2,3,4,5,6,7,8,#");
        System.out.println(solution.rightSideView(root));
    }
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        if (root != null) {
            queue.add(root);
            size = 1;
        }
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
            if (--size == 0) {
                result.add(p.val);
                size = queue.size();
            }
        }
        return result;
    }
}
