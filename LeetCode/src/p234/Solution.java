package p234;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
        	return true;
        }
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        ListNode leftStart;
        ListNode rightStart = slow.next;
        leftStart = head;
        
        
        
        //将链表后半部分进行反转
        ListNode fakeHead = new ListNode(-1);//后半部分的伪头结点，方便反转链表
        while(rightStart != null) {
        	ListNode t = rightStart;
        	rightStart = rightStart.next;
        	t.next = fakeHead.next;
        	fakeHead.next = t;
        }
        
        rightStart = fakeHead.next;
      //反转后与前半部分进行比较
        while(rightStart != null) {
        	if(rightStart.val != leftStart.val) {
        		return false;
        	}
        	rightStart = rightStart.next;
        	leftStart = leftStart.next;
        }
        
        return true;
    }
    
    /**
     * 使用额外空间，将节点内容存储到ArrayList中
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	//将链表中的内存复制到ArrayList中
    	while(head != null) {
    		list.add(head.val);
    	}
    	int i = 0, j = list.size() - 1;
    	while( i < j) {
    		if(list.get(i) != list.get(j)) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    public static void main(String[] args) {
		
	}
}
