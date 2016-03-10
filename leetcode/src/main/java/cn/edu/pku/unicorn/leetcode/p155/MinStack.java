package cn.edu.pku.unicorn.leetcode.p155;

import java.util.LinkedList;

/**
 * Created by v_zhengkun on 2016/3/6.
 * P155 Min Stack
 */
public class MinStack {

    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> minStack = new LinkedList<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
