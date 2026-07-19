package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * LeetCode 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists21 {

    /**
     * 方法一：迭代法（推荐）
     * 使用虚拟头节点简化边界处理，遍历两个链表并比较节点值。
     * <p>
     * 时间复杂度：O(n + m)，其中 n 和 m 分别是两个链表的长度
     * 空间复杂度：O(1)，只使用了常数级别的额外空间
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        // 创建虚拟头节点，简化边界条件处理
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // 遍历两个链表
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // 连接剩余的节点
        curr.next = list1 != null ? list1 : list2;

        return dummy.next;
    }

    /**
     * 方法二：递归法
     * 将问题分解为子问题：比较两个链表的头节点，较小的节点作为合并后链表的头节点，
     * 然后递归合并剩余部分。
     * <p>
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)，递归调用栈的深度
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // 递归终止条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 选择较小的节点作为当前节点
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    /**
     * 链表节点定义
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：1->2->4 和 1->3->4 ===");
        ListNode l1 = createLinkedList(new int[]{1, 2, 4});
        ListNode l2 = createLinkedList(new int[]{1, 3, 4});
        System.out.print("链表1: ");
        printLinkedList(l1);
        System.out.print("链表2: ");
        printLinkedList(l2);

        // 重新创建链表用于递归测试
        ListNode l1Recur = createLinkedList(new int[]{1, 2, 4});
        ListNode l2Recur = createLinkedList(new int[]{1, 3, 4});

        ListNode mergedIterative = mergeTwoListsIterative(l1, l2);
        System.out.print("迭代合并结果: ");
        printLinkedList(mergedIterative);

        ListNode mergedRecursive = mergeTwoListsRecursive(l1Recur, l2Recur);
        System.out.print("递归合并结果: ");
        printLinkedList(mergedRecursive);

        // 测试用例2：一个链表为空
        System.out.println("\n=== 测试用例2：空链表和 0->1 ===");
        ListNode l3 = null;
        ListNode l4 = createLinkedList(new int[]{0, 1});
        System.out.print("链表1: ");
        printLinkedList(l3);
        System.out.print("链表2: ");
        printLinkedList(l4);
        ListNode merged2 = mergeTwoListsIterative(l3, l4);
        System.out.print("合并结果: ");
        printLinkedList(merged2);

        // 测试用例3：两个链表都为空
        System.out.println("\n=== 测试用例3：两个空链表 ===");
        ListNode l5 = null;
        ListNode l6 = null;
        System.out.print("链表1: ");
        printLinkedList(l5);
        System.out.print("链表2: ");
        printLinkedList(l6);
        ListNode merged3 = mergeTwoListsIterative(l5, l6);
        System.out.print("合并结果: ");
        printLinkedList(merged3);

        // 测试用例4：单节点链表
        System.out.println("\n=== 测试用例4：单节点链表 ===");
        ListNode l7 = createLinkedList(new int[]{1});
        ListNode l8 = createLinkedList(new int[]{2});
        System.out.print("链表1: ");
        printLinkedList(l7);
        System.out.print("链表2: ");
        printLinkedList(l8);
        ListNode merged4 = mergeTwoListsIterative(l7, l8);
        System.out.print("合并结果: ");
        printLinkedList(merged4);
    }

    /**
     * 根据数组创建链表
     */
    private ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
    private void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }


}