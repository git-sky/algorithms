package cn.com.sky.algorithms.interview.linkedlist;

import org.junit.Test;

/**
 * <pre>
 * 题目描述：输入一个单向链表，判断链表是否有环？
 *
 * 分析：通过两个指针，分别从链表的头节点出发，一个每次向后移动一步，另一个移动两步，两个指针移动速度不一样，如果存在环，那么两个指针一定会在环里相遇。
 */
public class SingleLinkedListHasCircle {

    @Test
    public void solution() {

        int N = 10;
        Node head = init(N);
        print(head);

        Node node = hasCircle(head);
        if (node != null) {
            System.out.println("need remove node:" + node.data);
        }
        System.out.println(node);

        print(head);
    }

    /**
     * 思路：找到中间节点，使用快慢指针，fast走两步，slow走一步。
     */
    //判断单链表是否存在环,参数circleNode是环内节点，后面的题目会用到
    Node hasCircle(Node head) {
        Node slow, fast;
        slow = fast = head;
        Node circleNode = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                circleNode = fast;
                return circleNode;
            }
        }

        return circleNode;
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
