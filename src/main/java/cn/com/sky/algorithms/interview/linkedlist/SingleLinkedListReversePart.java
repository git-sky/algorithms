package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 反转单链表的一部分【Medium】
 *
 * 题目：给定一个单链表head，两个整数from和to，反转第from个节点到第to个节点的部分。
 * 例如：给定 1->3->5->7->9，from=2, to=4
 * 翻转后：1->7->5->3->9
 *
 * 算法原理：
 * 1. 先遍历链表找到from的前驱节点fPre和to的后继节点tPos
 * 2. 反转fPre.next到tPos前一个节点之间的部分
 * 3. 将反转后的子链表重新连接到fPre和tPos之间
 *
 * 边界情况：
 * - from < 1 或 to > 链表长度 或 from > to：不操作
 * - from == 1：fPre为null，反转后的新头就是链表的新头
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedListReversePart {

    public static void main(String[] args) {
        // 测试用例1：from=2, to=4
        System.out.println("=== 测试用例1：from=2, to=4 ===");
        Node head1 = init(5);
        print(head1);
        head1 = reversePart(head1, 2, 4);
        print(head1);

        // 测试用例2：from=1, to=3（从头开始反转）
        System.out.println("\n=== 测试用例2：from=1, to=3 ===");
        Node head2 = init(5);
        print(head2);
        head2 = reversePart(head2, 1, 3);
        print(head2);

        // 测试用例3：from=1, to=5（反转整个链表）
        System.out.println("\n=== 测试用例3：from=1, to=5 ===");
        Node head3 = init(5);
        print(head3);
        head3 = reversePart(head3, 1, 5);
        print(head3);

        // 测试用例4：from=3, to=3（只反转一个节点）
        System.out.println("\n=== 测试用例4：from=3, to=3 ===");
        Node head4 = init(5);
        print(head4);
        head4 = reversePart(head4, 3, 3);
        print(head4);

        // 测试用例5：from=4, to=5（反转末尾部分）
        System.out.println("\n=== 测试用例5：from=4, to=5 ===");
        Node head5 = init(5);
        print(head5);
        head5 = reversePart(head5, 4, 5);
        print(head5);
    }

    /**
     * 反转链表的第from个到第to个节点
     *
     * @param head 链表头节点
     * @param from 起始位置（从1开始）
     * @param to   结束位置
     * @return 反转后的链表头节点
     */
    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node cur = head;
        Node fPre = null;
        Node tPos = null;

        // 遍历链表，找from的前驱和to的后继
        while (cur != null) {
            len++;
            fPre = (len == from - 1) ? cur : fPre;
            tPos = (len == to + 1) ? cur : tPos;
            cur = cur.next;
        }

        if (from > to || from < 1 || to > len) {
            return head;
        }

        // 确定反转部分的起始节点
        Node innerPre = (fPre == null) ? head : fPre.next;

        // 反转 [innerPre, tPos) 之间的节点
        Node innerCur = innerPre.next;
        innerPre.next = tPos;
        Node innerNext;

        while (innerCur != tPos) {
            innerNext = innerCur.next;
            innerCur.next = innerPre;
            innerPre = innerCur;
            innerCur = innerNext;
        }

        // 将反转后的子链表连接回原链表
        if (fPre != null) {
            fPre.next = innerPre;
            return head;
        }
        return innerPre;
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