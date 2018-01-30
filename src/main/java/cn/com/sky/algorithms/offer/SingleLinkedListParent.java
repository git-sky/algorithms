package cn.com.sky.algorithms.offer;

/**
 *
 */
public class SingleLinkedListParent {


    /**
     * 构建单链表（头插入法，拥有头结点）
     */
    protected Node initWithHead(int N) {
        // 头结点
        Node head = new Node(-1, null);
        // 构建单链表（头插入）
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, head.next);
            head.next = node;
        }
        return head;
    }

    /**
     * 构建单链表（头插入法，无头结点）
     */
    protected Node init(int N) {
        Node head = null;
        // 构建单链表（头插入）
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, head);
            head = node;
        }
        return head;
    }

    protected void print(Node head) {
        System.out.print("链表：");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println();
    }

    /**
     * 链表的节点
     */
    protected static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}
