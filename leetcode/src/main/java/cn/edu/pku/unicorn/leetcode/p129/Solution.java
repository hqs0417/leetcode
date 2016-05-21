package cn.edu.pku.unicorn.leetcode.p129;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * @author v_zhengkun
 * @since 2016/5/21 13:26
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sumPath(root, "", list);
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    private void sumPath(TreeNode root, String path, List<Integer> result) {
        // 空节点，不作处理
        if (root == null) {
            return;
        }
        path += root.val;
        // 叶子节点
        if (root.left == null && root.right == null) {
            // 将字符串转换为整数
            int i = Integer.parseInt(path);
            result.add(i);
            return;
        }
        sumPath(root.left, path, result);
        sumPath(root.right, path, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Util.buildTree("[1,2,3]");
        System.out.println(solution.sumNumbers(root));
    }
}
