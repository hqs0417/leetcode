package p225;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
	
	Queue<Integer> a = new ArrayDeque<Integer>();
	Queue<Integer> b = new ArrayDeque<Integer>();
    // Push element x onto stack.
    public void push(int x) {
    	
        if(a.isEmpty()) {
        	a.add(x);
        	while(!b.isEmpty()) {
        		a.add(b.poll());
        	}
        } else {
        	b.add(x);
        	while(!a.isEmpty()) {
        		b.add(a.poll());
        	}
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!a.isEmpty()) {
        	a.poll();
        }
        if(!b.isEmpty()) {
        	b.poll();
        }
    }

    // Get the top element.
    public int top() {
    	if(!a.isEmpty()) {
        	return a.peek();
        }
        if(!b.isEmpty()) {
        	return b.peek();
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}