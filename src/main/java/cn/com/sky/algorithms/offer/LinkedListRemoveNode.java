package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 18. 在O(1)时间删除链表结点【Medium】
 *
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * 算法原理（覆盖法）：
 * 1. 一般情况：将待删除节点的下一个节点的值复制到当前节点，然后删除下一个节点
 *    这样不需要从头遍历找到前驱节点，时间复杂度O(1)
 * 2. 尾节点：无法使用覆盖法，需要从头遍历找到前驱节点，时间复杂度O(n)
 * 3. 只有一个节点：删除后头节点置为null
 *
 * 平均时间复杂度分析：
 *   n-1个非尾节点：O(1)
 *   1个尾节点：O(n)
 *   平均：(n-1)*O(1) + O(n)) / n = O(1)
 *
 * 时间复杂度：平均O(1)，最坏O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class LinkedListRemoveNode extends SingleLinkedListParent {

    public static void main(String[] args) {
        LinkedListRemoveNode solution = new LinkedListRemoveNode();

        // 测试用例1：删除中间节点
        System.out.println("=== 测试用例1：删除中间节点 ===");
        Node head1 = solution.init(5);
        solution.print(head1);
        Node toDelete1 = solution.getNode(head1, 2);
        System.out.println("删除节点: " + toDelete1.data);
        head1 = solution.removeNode(head1, toDelete1);
        solution.print(head1);

        // 测试用例2：删除头节点
        System.out.println("\n=== 测试用例2：删除头节点 ===");
        Node head2 = solution.init(5);
        solution.print(head2);
        Node toDelete2 = head2;
        System.out.println("删除节点: " + toDelete2.data);
        head2 = solution.removeNode(head2, toDelete2);
        solution.print(head2);

        // 测试用例3：删除尾节点
        System.out.println("\n=== 测试用例3：删除尾节点 ===");
        Node head3 = solution.init(5);
        solution.print(head3);
        Node toDelete3 = solution.getNode(head3, 4);
        System.out.println("删除节点: " + toDelete3.data);
        head3 = solution.removeNode(head3, toDelete3);
        solution.print(head3);

        // 测试用例4：只有一个节点
        System.out.println("\n=== 测试用例4：只有一个节点 ===");
        Node head4 = solution.init(1);
        solution.print(head4);
        head4 = solution.removeNode(head4, head4);
        solution.print(head4);

        // 测试用例5：删除后只剩一个节点
        System.out.println("\n=== 测试用例5：两个节点删除第一个 ===");
        Node head5 = solution.init(2);
        solution.print(head5);
        head5 = solution.removeNode(head5, head5);
        solution.print(head5);
    }

    /**
     * 在O(1)时间删除链表节点
     *
     * @param head       链表头节点
     * @param toDelete   待删除的节点
     * @return 删除后的链表头节点
     */
    public Node removeNode(Node head, Node toDelete) {
        if (head == null || toDelete == null) {
            return head;
        }

        // 情况1：待删除节点不是尾节点，使用覆盖法
        if (toDelete.next != null) {
            Node next = toDelete.next;
            toDelete.data = next.data;
            toDelete.next = next.next;
            return head;
        }

        // 情况2：只有一个节点
        if (head == toDelete) {
            return null;
        }

        // 情况3：待删除的是尾节点，需要从头遍历找前驱
        Node current = head;
        while (current.next != toDelete) {
            current = current.next;
        }
        current.next = null;

        return head;
    }

    /**
     * 获取指定位置的节点
     */
    private Node getNode(Node head, int pos) {
        int count = 0;
        for (Node p = head; p != null; p = p.next) {
            if (count == pos) {
                return p;
            }
            count++;
        }
        return null;
    }
}