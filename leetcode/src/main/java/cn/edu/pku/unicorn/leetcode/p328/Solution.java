package cn.edu.pku.unicorn.leetcode.p328;

import cn.edu.pku.unicorn.leetcode.common.ListNode;
import cn.edu.pku.unicorn.leetcode.common.Util;

/**
 * Created by v_zhengkun on 2016/2/21.
 * 328 Odd Even Linked List
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 4; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }

        Util.printList(head);
        Solution solution = new Solution();
        ListNode newHead = solution.oddEvenList(head);
        Util.printList(newHead);
    }

    public ListNode oddEvenList(ListNode head) {
        // 1 链表为空
        // 2 只有一个元素
        // 3 只有两个元素
        // 以上情况，不用处理，直接返回
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 存储偶数节点的链表
        ListNode oddHead = new ListNode(0);
        // 偶数节点链表的尾部
        ListNode oddTail = oddHead;
        int i = 2; // 位置
        ListNode p = head.next; // 当前元素
        ListNode q = head; // 当前元素的父元素
        while (p != null) {
            // 偶数节点
            if (i % 2 == 0) {
                oddTail.next = p;
                q.next = p.next;
                p = p.next;
                oddTail = oddTail.next;
                oddTail.next = null;
            } else {
                p = p.next;
                q = q.next;
            }
            i++;
        }
        // 处理完毕后，将偶数链表，挂到原链表后面
        q.next = oddHead.next;
        return head;
    }
}
