package cn.edu.pku.unicorn.leetcode.p102;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Unicorn on 2015/10/1.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            while(size > 0) {
                TreeNode node = queue.removeFirst();
                levelList.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            result.add(levelList);
        }
        return result;
    }
}
