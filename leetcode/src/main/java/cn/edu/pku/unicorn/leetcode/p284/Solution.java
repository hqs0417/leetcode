/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.p284;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author v_zhengkun
 * @since 2016/5/13 20:46
 */
class PeekingIterator implements Iterator<Integer> {

    private Integer next = null;
    private boolean cached = false;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cached) {
            return next;
        }
        if (hasNext()) {
            next = iterator.next();
            cached = true;
            return next;
        }
        throw new IndexOutOfBoundsException();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cached) {
            cached = false;
            return next;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (!cached) {
            return iterator.hasNext();
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());

        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());

        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());

        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());

        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
    }
}
