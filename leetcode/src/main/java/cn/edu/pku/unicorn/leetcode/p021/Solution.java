package cn.edu.pku.unicorn.leetcode.p021;

import cn.edu.pku.unicorn.leetcode.common.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);//伪头结点
        ListNode tail = fake;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        System.out.println(listNode.val);
    }
}