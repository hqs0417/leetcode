package cn.edu.pku.unicorn.microsoft100.p004;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.unicorn.microsoft100.common.TreeNode;

/**
 * 找出二叉树中和为某一值的所有路径
 * Created by v_zhengkun on 2016/8/9.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n12 = new TreeNode(12);
        root.left = n5;
        root.right = n12;

        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        n5.left = n3;
        n5.right = n7;

        Solution solution = new Solution();
        List<List<Integer>> result = solution.binaryTreeSumPath(root, 22);
        System.out.println(result);
    }

    /**
     * 深度搜索 回溯 递归
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> binaryTreeSumPath(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        binaryTreeSumPathHelper(root, result, new ArrayList<>(), target);
        return result;
    }

    private void binaryTreeSumPathHelper(TreeNode root, List<List<Integer>> result, List<Integer> path, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.val == target) {
            result.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                binaryTreeSumPathHelper(root.left, result, path, target - root.val);
            }
            if (root.right != null) {
                binaryTreeSumPathHelper(root.right, result, path, target - root.val);
            }
        }
        path.remove(path.size() - 1);
    }
}
