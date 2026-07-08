package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 单链表反转【Easy】
 *
 * 题目：将单链表进行反转
 *
 * 算法原理：
 * 方法1（迭代法，最优）：使用pre/next两个辅助指针
 *   - 逐个反转节点指向：next保存当前节点的下一个，当前节点指向pre，pre和head后移
 *   - 时间复杂度O(n)，空间复杂度O(1)
 *
 * 方法2（递归法）：递归到链表末尾，从后往前逐个反转
 *   - 递归到head.next==null时返回，此时newHead是最后一个节点
 *   - head.next.next = head：将下一个节点的next指向当前节点
 *   - head.next = null：断开当前节点的原next指向
 *   - 时间复杂度O(n)，空间复杂度O(n)（递归栈）
 *
 * 时间复杂度：迭代法O(n)，递归法O(n)
 * 空间复杂度：迭代法O(1)，递归法O(n)
 * </pre>
 */
public class SingleLinkedListReverse {

    public static void main(String[] args) {
        // 测试用例1：6个节点
        System.out.println("=== 测试用例1：6个节点 ===");
        Node head1 = init(6);
        print(head1);
        head1 = reverse(head1);
        print(head1);
        head1 = reverseByRecursion(head1);
        print(head1);

        // 测试用例2：1个节点
        System.out.println("\n=== 测试用例2：1个节点 ===");
        Node head2 = init(1);
        print(head2);
        head2 = reverse(head2);
        print(head2);

        // 测试用例3：2个节点
        System.out.println("\n=== 测试用例3：2个节点 ===");
        Node head3 = init(2);
        print(head3);
        head3 = reverse(head3);
        print(head3);

        // 测试用例4：空链表
        System.out.println("\n=== 测试用例4：空链表 ===");
        Node head4 = null;
        head4 = reverse(head4);
        print(head4);
    }

    /**
     * 迭代法反转链表（最优）
     * 思路：使用pre和next两个辅助指针，逐个反转节点指向
     * 时间复杂度O(n)，空间复杂度O(1)
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
     * 原理：递归到链表末尾，从后往前逐个反转指针方向
     * 例如：1->2->3->null
     * 递归到3，然后 2->3 变为 2<-3，1->2 变为 1<-2
     * 时间复杂度O(n)，空间复杂度O(n)
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