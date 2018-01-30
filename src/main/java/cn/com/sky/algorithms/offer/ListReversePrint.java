package cn.com.sky.algorithms.offer;

import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 * 4.从尾到头打印链表(逆置链表、不逆置链表)
 *
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class ListReversePrint extends SingleLinkedListParent {

    @Test
    public void solution() {

        Random r = new Random();
        int N = r.nextInt(1000) + 1000;

        Node head = init(N);

        print(head);

        // head = reverse(head);

        notReverse(head);

        System.out.println();

        print(head);
    }

    /**
     * 思路：递归实现，递归可以实现反转，类似于栈的结构。
     */
    public static void notReverse(Node head) {

        if (head.next != null) {
            notReverse(head.next);
        }
        System.out.print(head.data + "->");

    }

    /**
     * 思路：单链表反转。需要三个指针，pre,head,next;
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


}
