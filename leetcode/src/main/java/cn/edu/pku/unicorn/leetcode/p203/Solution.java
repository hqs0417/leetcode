/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p203;

import cn.edu.pku.unicorn.leetcode.common.ListNode;
import cn.edu.pku.unicorn.leetcode.common.Pair;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 203. Remove Linked List Elements
 */
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        // 伪头结点，只为了方便操作
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode p = fakeHead.next; // 当前节点
        ListNode q = fakeHead; // 当前节点的父节点
        while (p != null) {
            if (p.val == val) {
                q.next = p.next;
                p.next = null;
                p = q.next;
            } else {
                q = p;
                p = p.next;
            }
        }
        return fakeHead.next;
    }
}
