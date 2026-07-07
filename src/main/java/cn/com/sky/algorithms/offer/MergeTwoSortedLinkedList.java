package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 25. 合并两个排序的链表【Easy】
 *
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *
 * 算法原理：
 * 方法1（迭代法）【推荐】：
 *   使用哑节点(dummy)简化头节点处理，逐个比较两个链表的节点值，
 *   将较小的节点接到结果链表末尾，最后接上剩余部分。
 *
 * 方法2（递归法）：
 *   比较两个链表头节点，较小的作为合并后的头节点，
 *   其next指向剩余部分的合并结果。
 *
 * 时间复杂度：O(m + n)，需要遍历两个链表的所有节点
 * 空间复杂度：迭代法O(1)，递归法O(m + n)（递归栈）
 * </pre>
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        MergeTwoSortedLinkedList solution = new MergeTwoSortedLinkedList();

        // 测试用例1：正常合并
        System.out.println("=== 测试用例1：正常合并 ===");
        Node head1 = solution.buildList(new int[]{1, 3, 5, 7});
        Node head2 = solution.buildList(new int[]{2, 4, 6, 8});
        System.out.print("链表1: "); solution.print(head1);
        System.out.print("链表2: "); solution.print(head2);
        Node merged1 = solution.mergeIterative(head1, head2);
        System.out.print("合并后: "); solution.print(merged1);

        // 测试用例2：一个链表为空
        System.out.println("\n=== 测试用例2：一个链表为空 ===");
        Node head3 = solution.buildList(new int[]{1, 2, 3});
        Node merged2 = solution.mergeIterative(head3, null);
        System.out.print("合并后: "); solution.print(merged2);

        // 测试用例3：两个链表都为空
        System.out.println("\n=== 测试用例3：两个链表都为空 ===");
        Node merged3 = solution.mergeIterative(null, null);
        System.out.print("合并后: "); solution.print(merged3);

        // 测试用例4：单节点链表
        System.out.println("\n=== 测试用例4：单节点链表 ===");
        Node head4 = solution.buildList(new int[]{1});
        Node head5 = solution.buildList(new int[]{2});
        Node merged4 = solution.mergeIterative(head4, head5);
        System.out.print("合并后: "); solution.print(merged4);

        // 测试用例5：递归法测试
        System.out.println("\n=== 测试用例5：递归法测试 ===");
        Node head6 = solution.buildList(new int[]{1, 3, 5});
        Node head7 = solution.buildList(new int[]{2, 4, 6});
        System.out.print("链表1: "); solution.print(head6);
        System.out.print("链表2: "); solution.print(head7);
        Node merged5 = solution.mergeRecursive(head6, head7);
        System.out.print("递归合并后: "); solution.print(merged5);

        // 测试用例6：有重复值
        System.out.println("\n=== 测试用例6：有重复值 ===");
        Node head8 = solution.buildList(new int[]{1, 2, 3});
        Node head9 = solution.buildList(new int[]{1, 2, 3});
        Node merged6 = solution.mergeIterative(head8, head9);
        System.out.print("合并后: "); solution.print(merged6);
    }

    /**
     * 迭代法合并两个排序链表
     *
     * @param head1 第一个排序链表的头节点
     * @param head2 第二个排序链表的头节点
     * @return 合并后的排序链表头节点
     */
    public Node mergeIterative(Node head1, Node head2) {
        // 哑节点，简化头节点处理
        Node dummy = new Node(-1);
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // 接上剩余部分
        current.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }

    /**
     * 递归法合并两个排序链表
     *
     * @param head1 第一个排序链表的头节点
     * @param head2 第二个排序链表的头节点
     * @return 合并后的排序链表头节点
     */
    public Node mergeRecursive(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergedHead;
        if (head1.data <= head2.data) {
            mergedHead = head1;
            mergedHead.next = mergeRecursive(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeRecursive(head1, head2.next);
        }

        return mergedHead;
    }

    /**
     * 根据数组构建链表
     */
    private Node buildList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
    private void print(Node head) {
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.println("null");
    }

    /**
     * 链表节点
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}