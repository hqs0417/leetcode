package cn.edu.pku.unicorn.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
            if ( p != null ) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
