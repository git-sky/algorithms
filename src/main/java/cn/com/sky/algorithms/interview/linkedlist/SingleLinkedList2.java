package cn.com.sky.algorithms.interview.linkedlist;

/**
 * <pre>
 * 单链表综合操作【Medium】
 *
 * 包含以下功能：
 * 1. 单链表反转（迭代法和递归法）
 * 2. 判断单链表是否有环（快慢指针法）
 * 3. 求环的入口位置
 *
 * 算法原理：
 *
 * 反转链表：
 * - 迭代法：使用pre/cur两个指针，逐个反转节点指向，O(n)时间O(1)空间
 * - 递归法：递归到末尾后逐层反转，O(n)时间O(n)空间
 *
 * 判断有环（Floyd判圈算法）：
 * - 快指针每次走2步，慢指针每次走1步
 * - 如果有环，快慢指针必在环内相遇
 * - 如果无环，快指针先到达末尾
 *
 * 求环入口：
 * - 快慢指针相遇后，将其中一个指针移回链表头部
 * - 两个指针同时每次走1步，再次相遇的位置就是环入口
 * - 数学证明：设head到入口距离a，入口到相遇点距离b，环长c
 *   快指针走2(a+b)，慢指针走a+b，2(a+b) - (a+b) = nc，即a+b = nc
 *   所以a = nc - b = (n-1)c + (c-b)，即从head走a步等于从相遇点走c-b步
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleLinkedList2 {

    public static void main(String[] args) {
        // 测试用例1：链表反转
        System.out.println("=== 测试用例1：链表反转 ===");
        Node head1 = createByTail(5);
        print(head1);
        head1 = reverse(head1);
        print(head1);

        // 测试用例2：判断有环
        System.out.println("\n=== 测试用例2：判断有环 ===");
        Node head2 = createLoop(10, 2);
        boolean hasLoop = findLoop(head2) != null;
        System.out.println("是否有环: " + hasLoop);

        // 测试用例3：无环链表
        System.out.println("\n=== 测试用例3：无环链表 ===");
        Node head3 = createByTail(5);
        boolean hasLoop3 = findLoop(head3) != null;
        System.out.println("是否有环: " + hasLoop3);

        // 测试用例4：求环入口
        System.out.println("\n=== 测试用例4：求环入口 ===");
        Node head4 = createLoop(10, 3);
        getLoopPos(head4);

        // 测试用例5：单节点无环
        System.out.println("\n=== 测试用例5：单节点无环 ===");
        Node head5 = new Node(1, null);
        System.out.println("是否有环: " + (findLoop(head5) != null));
    }

    /**
     * 迭代法反转链表（无头节点）
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public static Node reverse(Node head) {
        if (head != null && head.next != null) {
            Node pre = null;
            Node cur = head;
            while (cur != null) {
                Node temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
        return head;
    }

    /**
     * 查找链表是否有环（快慢指针法）
     *
     * @return 相遇节点，无环返回null
     */
    public static Node findLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    /**
     * 求环的入口位置
     * 快慢指针相遇后，一个指针回到头部，两个指针同时每次走1步
     * 再次相遇的位置就是环入口
     */
    public static void getLoopPos(Node head) {
        Node meet = findLoop(head);
        if (meet == null) {
            System.out.println("无环");
            return;
        }

        Node p1 = head;
        Node p2 = meet;
        int pos = 0;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            pos++;
        }
        System.out.println("环入口位置(从0开始): " + pos + ", 节点值: " + p1.data);
    }

    /**
     * 构建单链表（头插法）
     */
    private static Node create(int length) {
        Node head = null;
        for (int i = 0; i < length; i++) {
            Node node = new Node(i, head);
            head = node;
        }
        return head;
    }

    /**
     * 构建单链表（尾插法，顺序排列）
     */
    private static Node createByTail(int length) {
        Node head = null;
        Node p = null;
        for (int i = 0; i < length; i++) {
            Node node = new Node(i, null);
            if (i == 0) {
                head = node;
                p = node;
            } else {
                p.next = node;
                p = node;
            }
        }
        return head;
    }

    /**
     * 构建有环单链表
     *
     * @param length 链表长度
     * @param pos    环的入口位置（从0开始）
     */
    private static Node createLoop(int length, int pos) {
        Node head = null;
        Node last = null;
        for (int i = 0; i < length; i++) {
            Node node = new Node(i, head);
            if (head == null) {
                last = node;
            }
            if (length - pos == i) {
                last.next = node;
            }
            head = node;
        }
        return head;
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("^");
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