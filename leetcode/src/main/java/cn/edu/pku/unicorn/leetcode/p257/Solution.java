/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p257;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 257. Binary Tree Paths
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.right = new TreeNode(5);
        Solution solution = new Solution();
        List<String> list = solution.binaryTreePaths(root);
        Util.printList(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();

        binaryTreePathsCore(root, result, "");
        return result;
    }

    public void binaryTreePathsCore(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }
        if (path.equals("")) {
            path = path + root.val;
        } else {
            path = path + "->" + root.val;
        }
        // leaf
        if (root.left == null && root.right == null) {
            result.add(path);
        } else {
            binaryTreePathsCore(root.left, result, path);
            binaryTreePathsCore(root.right, result, path);
        }

    }
}
