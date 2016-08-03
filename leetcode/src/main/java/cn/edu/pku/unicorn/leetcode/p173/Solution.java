package cn.edu.pku.unicorn.leetcode.p173;

import cn.edu.pku.unicorn.leetcode.common.TreeNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/4/4.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = Util.buildTree("4,2,6,1,3,5,7,#");
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
