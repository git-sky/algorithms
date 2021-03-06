package cn.com.sky.algorithms.interview.linkedlist;

import org.junit.Test;

/**
 * <pre>
 * 单链表逆转
 *
 * 时间复杂度O(n),空间复杂度O(1)。
 */
public class SingleLinkedListReverse {

    @Test
    public void solution() {

        int N = 6;
        Node head = init(N);
        print(head);

//        head = reverse(head);

        head = reverseByRecursion(head);

        print(head);
    }

    /**
     * 循环方法
     * <p>
     * 思路：需要三个指针，pre,head,next;
     */
    public static Node reverse(Node head) {

        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    //单链表的转置,递归方法
    public static Node reverseByRecursion(Node head) {
        //第一个条件是判断异常，第二个条件是结束判断
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseByRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;    //返回新链表的头指针
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

    private void print(Node head) {
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
