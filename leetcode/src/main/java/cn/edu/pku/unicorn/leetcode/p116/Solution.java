package cn.edu.pku.unicorn.leetcode.p116;

import cn.edu.pku.unicorn.leetcode.common.TreeLinkNode;

/**
 * Created by v_zhengkun on 2016/3/20.
 * 116. Populating Next Right Pointers in Each Node.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode p = root;
        TreeLinkNode firstLeaf = null;
        while (p != null) {
            if (firstLeaf == null) {
                firstLeaf = p.left;
            }
            if (p.left != null) {
                p.left.next = p.right;
            } else {
                break;
            }
            if (p.next != null) {
                p.right.next = p.next.left;
                p = p.next;
            } else {
                p = firstLeaf;
                firstLeaf = null;
            }
        }
    }
}
