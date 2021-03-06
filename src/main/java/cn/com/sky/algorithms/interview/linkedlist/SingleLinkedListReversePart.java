package cn.com.sky.algorithms.interview.linkedlist;

import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 * 反转单链表的一部分。
 *
 * 给一个单链表head，两个整数from，to，反转第from个节点到第to个节点的部分。
 * 例如：
 * 给定： 1 3 5 7 9
 * from=2,to=4;
 * 翻转后:1 7 5 3 9
 *
 * 时间复杂度O(n),空间复杂度O(1)。
 */
public class SingleLinkedListReversePart {

    @Test
    public void solution() {
        Random r = new Random();
        int n = r.nextInt(10);
        int from = r.nextInt(5);
        int to = r.nextInt(10);
        while (from >= to || n < to) {
            n = r.nextInt(10) + 1;
            from = r.nextInt(5) + 1;
            to = r.nextInt(10) + 1;
        }

        System.out.println("n:" + n + ",from:" + from + ",to:" + to);

        Node head = init(n);
        print(head);
        head = reversePart(head, from, to);
        print(head);
    }

    /**
     * 思路：需要三个指针，pre,head,next;
     */
    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node innerPre = head;
        Node fPre = null;
        Node tPos = null;

        //1、找到from和to的节点Node
        while (innerPre != null) {
            len++;
            fPre = (len == from - 1) ? innerPre : fPre;
            tPos = (len == to + 1) ? innerPre : tPos;
            innerPre = innerPre.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        innerPre = (fPre == null) ? head : fPre.next;

        Node innerHead = innerPre.next;
        innerPre.next = tPos;
        Node innerNext = null;

        while (innerHead != tPos) {
            innerNext = innerHead.next;
            innerHead.next = innerPre;
            innerPre = innerHead;
            innerHead = innerNext;
        }

        if (fPre != null) {
            fPre.next = innerPre;
            return head;
        }
        return innerPre;
    }

    /**
     * 构建单链表（头插入法，拥有头结点）
     */
    // private Node init(int N) {
    // // 头结点
    // Node head = new Node(-1, null);
    // // 构建单链表（头插入）
    // for (int i = 1; i <= N; i++) {
    // Node node = new Node(i, head.next);
    // head.next = node;
    // }
    // return head;
    // }

    /**
     * 构建单链表（头插入法，无头结点）
     */
    private Node init(int N) {
        Node head = null;
        // 构建单链表（头插入）
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, head);
            head = node;
        }
        return head;
    }

    private static void print(Node head) {
        System.out.print("链表：");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println();
    }

    /**
     * 链表的节点
     */
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
