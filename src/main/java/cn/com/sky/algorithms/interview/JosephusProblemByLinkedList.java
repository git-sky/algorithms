package cn.com.sky.algorithms.interview;

import org.junit.Test;

/**
 * <pre>
 * 约瑟夫环
 *
 * 链表模拟
 */
public class JosephusProblemByLinkedList {

    @Test
    public void solution() {

        int N = 10;
        Node head = init(N);
        print(head);

//        head = reverse(head);

        head = reverseByRecursion(head);

        print(head);

        int k = 4;

        del(head, N, k);
    }

    /**
     * 约瑟夫环的删除顺序。
     *
     * @param head
     * @param N
     */
    public static void del(Node head, int N, int k) {

        Node first = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = first;
        head = first;

        int x = N;

        while (x > 0) {

            for (int i = 2; i < k; i++) {
                head = head.next;
            }

            System.out.println(head.next.data);
            head.next = head.next.next;
            head = head.next;
            x--;
        }
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
     * 构建单链表（头插入法，无头结点）
     */
    private Node init(int N) {
        Node head = null;
        // 构建单链表（头插入）
        for (int i = 1; i <= N; i++) {
            char x = '0';
            if (i <= 26) {
                x = (char) ('a' - 1 + i);
            } else {
                x = (char) ('A' - 27 + i);
            }

            Node node = new Node(x, i, head);
            head = node;
        }
        return head;
    }

    private void print(Node head) {
        System.out.print("链表：");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.c + "=" + p.data + "->");
        }
        System.out.println();
    }

    /**
     * 链表的节点
     */
    static class Node {
        char c;
        int data;
        Node next;

        Node(char c, int data, Node next) {
            this.c = c;
            this.data = data;
            this.next = next;
        }
    }

}
