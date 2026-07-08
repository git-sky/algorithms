package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 约瑟夫环 - 链表模拟法【Medium】
 *
 * 题目：N个人围成一圈，从第1个人开始报数，报到k的人出列，
 * 然后从下一个人重新开始报数，求出列顺序。
 *
 * 算法原理（循环链表模拟）：
 * 1. 构建单向链表，将尾节点指向头节点形成循环链表
 * 2. 每次数k-1步，删除当前节点的下一个节点
 * 3. 循环直到只剩一个节点
 *
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(n)
 *
 * 注意：此方法效率低于公式法O(n)，但直观易懂
 * 最优解法见 JosephusProblem.java 的公式法 f(n,k) = (f(n-1,k) + k) % n
 * </pre>
 */
public class JosephusProblemByLinkedList {

    public static void main(String[] args) {
        // 测试用例1：N=10, k=4
        System.out.println("=== 测试用例1：N=10, k=4 ===");
        Node head1 = createList(10);
        print(head1);
        System.out.println("--- 约瑟夫环出列顺序 ---");
        josephus(head1, 10, 4);

        // 测试用例2：N=5, k=2
        System.out.println("\n=== 测试用例2：N=5, k=2 ===");
        Node head2 = createList(5);
        print(head2);
        System.out.println("--- 约瑟夫环出列顺序 ---");
        josephus(head2, 5, 2);

        // 测试用例3：N=1, k=1
        System.out.println("\n=== 测试用例3：N=1, k=1 ===");
        Node head3 = createList(1);
        josephus(head3, 1, 1);

        // 测试用例4：验证链表反转
        System.out.println("\n=== 测试用例4：链表反转 ===");
        Node head4 = createList(6);
        print(head4);
        head4 = reverse(head4);
        print(head4);
        head4 = reverseByRecursion(head4);
        print(head4);
    }

    /**
     * 约瑟夫环的删除顺序（循环链表法）
     *
     * @param head 链表头节点
     * @param N    总人数
     * @param k    报数到k出列
     */
    public static void josephus(Node head, int N, int k) {
        if (head == null || N <= 0 || k <= 0) {
            return;
        }

        // 将链表首尾相连形成循环链表
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        Node current = head;
        int remaining = N;

        while (remaining > 0) {
            // 数k-1步，找到待删除节点的前驱
            for (int i = 2; i < k; i++) {
                current = current.next;
            }
            // 删除current的下一个节点
            System.out.println("出列: " + current.next.data);
            current.next = current.next.next;
            current = current.next;
            remaining--;
        }
    }

    /**
     * 迭代法反转链表
     * 思路：使用三个指针 pre, current, next
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static Node reverse(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归法反转链表
     *
     * 原理：递归到链表末尾，从后往前逐个反转指针方向
     * 例如：1->2->3->null
     * 递归到3，然后 2->3 变为 2<-3，1->2 变为 1<-2
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)（递归栈）
     */
    public static Node reverseByRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 构建单链表（尾插法，顺序排列）
     */
    private static Node createList(int N) {
        if (N <= 0) return null;
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= N; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        return head;
    }

    private static void print(Node head) {
        System.out.print("链表：");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println("^");
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}