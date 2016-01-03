package cn.edu.pku.unicorn.leetcode.p019;

import cn.edu.pku.unicorn.leetcode.common.ListNode;

/**
 * 移除链表中倒数第n个元素
 * 第n个元素总是存在的
 *
 * @author Unicorn
 */
public class Solution {
    /**
     * @param head 链表头
     * @param n    倒数第n个元素
     *
     * @return 删除后的链表头
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {//找到链表尾和计算出链表的长度
            tail = tail.next;
            count++;
        }
        int m = count - n;//正数第m个
        if (m == 0) {//特殊处理
            ListNode p = head.next;
            head.next = null;
            return p;
        }
        ListNode p = head, prev = head;
        while (m > 0) {
            prev = p;
            p = p.next;
            m--;
        }
        //delete p;
        prev.next = p.next;
        p.next = null;

        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode p = head, q = head, prev = fake;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        while (q != null && q.next != null) {
            prev = p;
            p = p.next;
            q = q.next;
        }
        prev.next = p.next;

        return fake.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        Solution solution = new Solution();
        ListNode p = solution.removeNthFromEnd1(head, 1);
        while (p != null) {
            System.out.println(head.val);
            p = p.next;
        }
    }
}