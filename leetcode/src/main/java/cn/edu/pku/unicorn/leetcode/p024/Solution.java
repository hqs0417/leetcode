package cn.edu.pku.unicorn.leetcode.p024;

import cn.edu.pku.unicorn.leetcode.common.ListNode;

/**
 * @author v_zhengkun
 * @since 2016/5/7 17:10
 * Swap Nodes in Pairs
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }
}
