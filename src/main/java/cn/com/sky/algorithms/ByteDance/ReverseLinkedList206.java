package cn.com.sky.algorithms.ByteDance;

import org.junit.Test;

public class ReverseLinkedList206 {

    @Test
    public void test() {
        // 测试用例1：正常链表
        System.out.println("=== 测试用例1：正常链表 1->2->3->4->5 ===");
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.print("原始链表: ");
        printLinkedList(head1);

        ListNode reversed1 = reverseListIterative(head1);
        System.out.print("迭代反转: ");
        printLinkedList(reversed1);

        // 重新创建链表测试递归法
        ListNode head1Recur = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1Recur = reverseListRecursive(head1Recur);
        System.out.print("递归反转: ");
        printLinkedList(reversed1Recur);

        // 测试用例2：空链表
        System.out.println("\n=== 测试用例2：空链表 ===");
        ListNode head2 = null;
        System.out.print("原始链表: ");
        printLinkedList(head2);
        ListNode reversed2 = reverseListIterative(head2);
        System.out.print("反转结果: ");
        printLinkedList(reversed2);

        // 测试用例3：单节点链表
        System.out.println("\n=== 测试用例3：单节点链表 ===");
        ListNode head3 = createLinkedList(new int[]{1});
        System.out.print("原始链表: ");
        printLinkedList(head3);
        ListNode reversed3 = reverseListIterative(head3);
        System.out.print("反转结果: ");
        printLinkedList(reversed3);

        // 测试用例4：两个节点链表
        System.out.println("\n=== 测试用例4：两个节点链表 ===");
        ListNode head4 = createLinkedList(new int[]{1, 2});
        System.out.print("原始链表: ");
        printLinkedList(head4);
        ListNode reversed4 = reverseListIterative(head4);
        System.out.print("反转结果: ");
        printLinkedList(reversed4);
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

    // 方法一：迭代法（推荐）
    // 使用双指针遍历链表，逐个节点反转指针方向。
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;  // 前一个节点
        ListNode curr = head;  // 当前节点

        while (curr != null) {
            ListNode nextTemp = curr.next;  // 保存下一个节点
            curr.next = prev;               // 反转指针
            prev = curr;                    // 移动 prev
            curr = nextTemp;                // 移动 curr
        }
        return prev;  // prev 最终指向新的头节点
    }

    // 方法二：递归法
    public ListNode reverseListRecursive(ListNode head) {
        // 递归终止条件：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后续链表
        ListNode newHead = reverseListRecursive(head.next);

        // 反转当前节点指针
        head.next.next = head;
        head.next = null;  // 防止循环

        return newHead;
    }

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
}