package p083;

import common.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode p = head;
        while(p != null && p.next != null) {
        	
        	if(p.val == p.next.val) {
        		p.next = p.next.next;
        	} else {
        		p = p.next;
        	}
        	
        }
    	return p;
    }
    
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		ListNode p = n1;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
		System.out.println();
		
		Solution solution = new Solution();
		ListNode head = solution.deleteDuplicates(n1);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}


