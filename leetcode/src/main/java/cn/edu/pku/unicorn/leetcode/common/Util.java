/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package cn.edu.pku.unicorn.leetcode.common;

import java.util.List;

/**
 * Created by v_zhengkun on 2016/2/21.
 */
public final class Util {
    private Util() {
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
            if (p != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static <E> void printList (List<E> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print("->");
            }
        }
        System.out.println();

    }
}
