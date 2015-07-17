package p232;

import java.util.Stack;

class MyQueue {
	private Stack<Integer> a = new Stack<Integer>();
	private Stack<Integer> b = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        a.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(b.isEmpty()) {
        	while(!a.isEmpty()) {
        		b.push(a.pop());
        	}
        }
        if(!b.isEmpty()) {
        	b.pop();
        }
    }

    // Get the front element.
    public int peek() {
    	if(b.isEmpty()) {
    		while(!a.isEmpty()) {
        		b.push(a.pop());
        	}
    	}
    	if(!b.isEmpty()) {
        	return b.peek();
        }
    	return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	
        return (a.isEmpty() && b.isEmpty())? true : false;
    }
}