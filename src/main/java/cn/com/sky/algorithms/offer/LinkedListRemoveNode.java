package cn.com.sky.algorithms.offer;

import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 *
 * 12.在O(1)时间删除链表结点
 *
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 */
public class LinkedListRemoveNode extends SingleLinkedListParent {

    @Test
    public void solution() {

        int N = 10;
        Node head = init(N);
        print(head);

        Random r = new Random();
        int pos = r.nextInt(10);
        Node p = getP(head, pos);

        System.out.println("p:" + p.data);

        removeNode(head, p);

        print(head);
    }

    public void removeNode(Node head, Node p) {
        if (p.next != null) {
            p.data = p.next.data;
            p.next = p.next.next;
        } else if (head == p) {
            head = null;
            p = null;
        } else {
            Node next = head;
            while (next.next != p) {
                next = next.next;
            }
            next.next = null;
        }

    }


    private Node getP(Node head, int pos) {

        int count = 0;
        for (Node p = head; p != null; p = p.next) {
            if (count == pos) {
                return p;
            }
            count++;
        }
        return null;
    }


}
