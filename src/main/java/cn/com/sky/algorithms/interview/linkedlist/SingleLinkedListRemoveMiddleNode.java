package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 删除单链表中间节点【Easy】
 *
 * 题目：给定一个链表，删除链表的中间节点
 * 例如：1->2->3->4->5，删除3，变为1->2->4->5
 *       1->2->3->4，删除2，变为1->3->4
 *
 * 算法原理（快慢指针法）：
 * 1. 快指针每次走2步，慢指针每次走1步
 * 2. 当快指针到达末尾时，慢指针正好在中间
 * 3. 删除慢指针指向的节点
 *
 * 规则：
 * - 链表长度为1：不删除，返回头节点
 * - 链表长度为2：删除第1个节点
 * - 链表长度为n：删除第n/2个节点（向上取整）
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedListRemoveMiddleNode {

    public static void main(String[] args) {
        // 测试用例1：偶数个节点 N=10
        System.out.println("=== 测试用例1：N=10 ===");
        Node head1 = init(10);
        print(head1);
        Node mid1 = findMiddleNode(head1);
        System.out.println("中间节点: " + (mid1 != null ? mid1.data : "null"));
        head1 = removeMiddleNode(head1);
        print(head1);

        // 测试用例2：奇数个节点 N=7
        System.out.println("\n=== 测试用例2：N=7 ===");
        Node head2 = init(7);
        print(head2);
        head2 = removeMiddleNode(head2);
        print(head2);

        // 测试用例3：2个节点
        System.out.println("\n=== 测试用例3：N=2 ===");
        Node head3 = init(2);
        print(head3);
        head3 = removeMiddleNode(head3);
        print(head3);

        // 测试用例4：1个节点
        System.out.println("\n=== 测试用例4：N=1 ===");
        Node head4 = init(1);
        print(head4);
        head4 = removeMiddleNode(head4);
        print(head4);

        // 测试用例5：3个节点
        System.out.println("\n=== 测试用例5：N=3 ===");
        Node head5 = init(3);
        print(head5);
        head5 = removeMiddleNode(head5);
        print(head5);
    }

    /**
     * 找到中间节点（快慢指针法）
     * fast走2步，slow走1步，fast到末尾时slow在中间
     */
    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 删除中间节点
     * 使用快慢指针，slow指向待删除节点的前驱
     */
    public static Node removeMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        Node fast = head.next.next;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    /**
     * 构建单链表（头插法，无头结点）
     */
    private static Node init(int N) {
        Node head = null;
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

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}