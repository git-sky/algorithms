package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 删除单链表倒数第k个节点【Medium】
 *
 * 题目：在不知道链表长度的情况下，删除单链表的倒数第k个节点，要求时间复杂度O(n)
 *
 * 算法原理（先后指针策略）：
 * 方法1（遍历两次）：第一次遍历统计节点数N，第二次遍历到第N-k个节点删除
 *   - 时间复杂度O(n)，但需要遍历两次
 *
 * 方法2（遍历一次，最优）：使用两个指针ahead和behind
 *   1. ahead先走k-1步
 *   2. 然后ahead和behind同时走，直到ahead到达链表末尾
 *   3. 此时behind正好指向倒数第k个节点
 *   - 原理：两个指针之间始终保持k-1的距离
 *
 * 相似问题：
 * 1. 求链表中间节点：快慢指针，快指针走2步，慢指针走1步
 * 2. 判断链表是否有环：快慢指针法
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedListRemoveLastKthNode {

    public static void main(String[] args) {
        // 测试用例1：N=10, k=8
        System.out.println("=== 测试用例1：N=10, k=8 ===");
        Node head1 = init(10);
        print(head1);
        System.out.println("倒数第8个节点: " + FindKthToTail(head1, 8).data);

        // 测试用例2：k=1（删除最后一个节点）
        System.out.println("\n=== 测试用例2：N=5, k=1 ===");
        Node head2 = init(5);
        print(head2);
        System.out.println("倒数第1个节点: " + FindKthToTail(head2, 1).data);

        // 测试用例3：k等于链表长度（删除头节点）
        System.out.println("\n=== 测试用例3：N=5, k=5 ===");
        Node head3 = init(5);
        print(head3);
        System.out.println("倒数第5个节点: " + FindKthToTail(head3, 5).data);

        // 测试用例4：k大于链表长度
        System.out.println("\n=== 测试用例4：N=5, k=10 ===");
        Node head4 = init(5);
        Node result = FindKthToTail(head4, 10);
        System.out.println("倒数第10个节点: " + (result == null ? "null" : result.data));

        // 测试用例5：单节点链表
        System.out.println("\n=== 测试用例5：N=1, k=1 ===");
        Node head5 = init(1);
        System.out.println("倒数第1个节点: " + FindKthToTail(head5, 1).data);
    }

    /**
     * 方法1：遍历两次法
     * 倒数第k个 = 正数第N-k+1个
     */
    public static Node removeLastKthNode(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        Node p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }

        if (k > n) {
            return head;
        }

        if (k == n) {
            return head.next;
        }

        p = head;
        for (int i = 1; i < n - k; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    /**
     * 方法2（最优）：先后指针法，只遍历一次
     *
     * @param head 链表头节点
     * @param k    倒数第k个
     * @return 倒数第k个节点，不存在返回null
     */
    public static Node FindKthToTail(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        Node ahead = head;
        Node behind = head;

        // ahead先走k-1步
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                return null;
            }
        }

        // ahead和behind同时走
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        return behind;
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