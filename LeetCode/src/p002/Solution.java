package p002;

import common.ListNode;



public class Solution {

	public static void main(String[] args) {
		ListNode[] listNodes = new ListNode[10];
		
		listNodes[0].val = 9;
		listNodes[0].next = null;
		
		listNodes[3].val = 9;
		listNodes[3].next = listNodes[4];
		listNodes[4].val = 9;
		listNodes[4].next = null;
		
		
		printList(listNodes[0]);
		printList(listNodes[3]);
		

		ListNode listNode = addTwoNumbers(listNodes[0], listNodes[3]);
		printList(listNode);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode front = null;
		ListNode rear = null;
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		
 		ListNode p = l1, q = l2;//指针，分别指向链表头
 		boolean carry = false;//进位标识
 		while (p != null && q != null) {
 			int val = p.val + q.val;
 			if(carry) {
 				val ++;
 			}
 			ListNode t = new ListNode(val % 10);
 			carry = (val > 9);
 			if(front == null) {//链表头，第一次进行判断
 				front = t;
 				rear = front;
 			} else {
 				rear.next = t;
 	 			rear = t;
 			}
 			
 			q = q.next;
 			p = p.next;
		}
 		
 		while(p != null) {
 			int val = p.val;
 			if(carry) {
 				val ++;
 			}
 			ListNode t = new ListNode(val % 10);
 			carry = (val > 9);
 			if(front == null) {
 				front = t;
 				rear = front;
 			}
 			rear.next = t;
 			rear = t;
 			p = p.next;
 		}
 		while(q != null) {
 			int val = q.val;
 			if(carry) {
 				val ++;
 			}
 			ListNode t = new ListNode(val % 10);
 			carry = (val > 9);
 			if(front == null) {
 				front = t;
 				rear = front;
 			}
 			rear.next = t;
 			rear = t;
 			q = q.next;
 		}
 		
 		if(p == null && q == null && carry) {
 			ListNode listNode = new ListNode(1);
 			rear.next = listNode;
 		}
		return front;
	}
	
	public static void printList(ListNode listNode) {
		/*
		if(listNode != null) {
			System.out.println(listNode.val);
			printList(listNode.next);
		}
		*/
		
		while(listNode != null) {
			System.out.print(listNode.val);
			if(listNode.next != null) {
				System.out.print("->");
			}
			
			listNode = listNode.next;
		}
		System.out.println();
	}

}
