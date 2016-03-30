package cn.edu.pku.unicorn.leetcode.p141;

import cn.edu.pku.unicorn.leetcode.common.ListNode;

/**
 * Created by v_zhengkun on 2016/3/19.
 */
public class Solution {

    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
