package cn.edu.pku.unicorn.leetcode.p023;


import cn.edu.pku.unicorn.leetcode.common.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int currSize = lists.length;
        
        
    	
    	return null;
    }
    /**(
     * 
     * @param lists
     * @param currSize 当前数组中有几个
     */
    private void mergeKListsCore(ListNode[] lists, int currSize) {
    	
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);//伪头结点
        ListNode tail = fake;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		tail.next = l1;
        		l1 = l1.next;
        	} else {
        		tail.next =  l2;
        		l2 = l2.next;
        	}
        	tail = tail.next;
        }
        if(l1 != null) {
        	tail.next = l1;
        }
        if(l2 != null) {
        	tail.next = l2;
        }
    	return fake.next;
    }
}

