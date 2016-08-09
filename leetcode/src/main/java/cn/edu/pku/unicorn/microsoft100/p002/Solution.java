package cn.edu.pku.unicorn.microsoft100.p002;

/**
 * 最小栈
 * 像栈一样工作，又能取得最小值
 * Created by v_zhengkun on 2016/8/9.
 */
public class Solution {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        for (int i : arr) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            System.out.println("min " + stack.min());
            System.out.println("top " + stack.pop());
        }
    }
}

class MinStack {
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private int[] data1;
    private int[] data2;

    public MinStack() {
        data1 = new int[INITIAL_CAPACITY];
        data2 = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void push(int x) {
        ensureCapacity();
        data1[size] = x;
        if (size == 0) {
            data2[size] = x;
        } else {
            data2[size] = Math.min(x, data2[size - 1]);
        }
        size++;
    }

    public int pop() {
        int x = peek();
        size--;
        return x;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data1[size - 1];
    }

    public int min() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data2[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (data1.length == size) {
            int[] newData1 = new int[data1.length * 2];
            int[] newData2 = new int[data2.length * 2];
            System.arraycopy(data1, 0, newData1, 0, data1.length);
            System.arraycopy(data2, 0, newData2, 0, data2.length);
            data1 = newData1;
            data2 = newData2;
        }
    }
}

class EmptyStackException extends RuntimeException {
    @Override
    public String getMessage() {
        return "stack is empty";
    }

    public EmptyStackException() {

    }
}
