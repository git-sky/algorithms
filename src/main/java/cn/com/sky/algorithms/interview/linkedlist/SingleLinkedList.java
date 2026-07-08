package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 单链表反转（有头结点）【Easy】
 *
 * 题目：将有头结点的单链表进行反转
 *
 * 算法原理（迭代法 / 三指针法）：
 * 1. 使用三个指针 p, q, temp
 * 2. p指向当前节点，q指向下一个节点，temp暂存q的下一个节点
 * 3. 将q.next指向p，实现局部反转
 * 4. p和q同时后移，直到q为null
 * 5. 最后将头结点的next指向p
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        // 测试用例1：9个节点的链表
        System.out.println("=== 测试用例1：9个节点 ===");
        Node head = new Node(-1, null);
        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, head.next);
            head.next = node;
        }

        System.out.println("反转前:");
        print(head);

        reverse(head);

        System.out.println("反转后:");
        print(head);

        // 测试用例2：空链表
        System.out.println("\n=== 测试用例2：空链表 ===");
        Node head2 = new Node(-1, null);
        reverse(head2);
        print(head2);

        // 测试用例3：单节点链表
        System.out.println("\n=== 测试用例3：单节点链表 ===");
        Node head3 = new Node(-1, null);
        head3.next = new Node(1, null);
        reverse(head3);
        print(head3);
    }

    /**
     * 有头结点的单链表反转
     */
    public static void reverse(Node head) {
        if (head.next != null && head.next.next != null) {
            Node p = head.next;
            Node q = p.next;
            p.next = null;
            while (q != null) {
                Node temp = q.next;
                q.next = p;
                p = q;
                q = temp;
            }
            head.next = p;
        }
    }

    private static void print(Node head) {
        for (Node p = head.next; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println("null");
    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}