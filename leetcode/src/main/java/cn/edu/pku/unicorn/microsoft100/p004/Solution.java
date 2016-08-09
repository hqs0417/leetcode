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

    }

    /**
     * 深度搜索
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
        // TODO 注意可能会重复添加
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        path.add(root.val);
        target = target - root.val;
        binaryTreeSumPathHelper(root.left, result, path, target);
        binaryTreeSumPathHelper(root.right, result, path, target);
    }
}
