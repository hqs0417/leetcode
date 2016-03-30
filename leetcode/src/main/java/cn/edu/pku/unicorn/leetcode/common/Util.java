package cn.edu.pku.unicorn.leetcode.common;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/2/21.
 */
public final class Util {
    private Util() {
    }

    /**
     * 打印链表
     *
     * @param head 链表头结点
     */
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

    /**
     * 打印列表list
     *
     * @param list 列表
     * @param <E>  类型
     */
    public static <E> void printList(List<E> list) {
        if (list == null) {
            System.out.println("null");
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

    /**
     * 从层次遍历字符串构造二叉树
     * 字符串的格式是 null代表叶子节点
     * [1,2,3,#,#,4,#,#,5]
     *
     * @param treeStr
     *
     * @return
     */
    public static TreeNode buildTree(String treeStr) {
        if (treeStr.startsWith("[")) {
            treeStr = treeStr.substring(1);
        }
        if (treeStr.endsWith("]")) {
            treeStr = treeStr.substring(0, treeStr.length() - 1);
        }
        String[] nodeStrArr = treeStr.split(",");
        LinkedList<TreeNode> nodes = new LinkedList<>();
        for (String nodeStr : nodeStrArr) {
            if ("#".equals(nodeStr)) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.parseInt(nodeStr)));
            }
        }
        LinkedList<TreeNode> kids = new LinkedList<>();
        for (TreeNode node : nodes) {
            kids.add(node);
        }

        TreeNode root = kids.pop();
        for (TreeNode node : nodes) {
            if (node != null) {
                if (!kids.isEmpty()) {
                    node.left = kids.pop();
                }
                if (!kids.isEmpty()) {
                    node.right = kids.pop();
                }
            }
        }
        return root;
    }

}
