package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>

' * LeetCode 61. 旋转链表【Medium】
 * 
 * 题目描述：给定一个链表，将链表每个节点向右移动 k 个位置。
 * 
 * 示例：
 * 输入：1->2->3->4->5->NULL, k = 2
 * 输出：4->5->1->2->3->NULL
 * 
 * 算法原理（快慢指针 / 成环断开法）：
 * 1. 先遍历链表获取长度 i
 * 2. k %= i，取模避免不必要的旋转
 * 3. 慢指针从头走 i - k%i 步，到达新链表末尾
 * 4. 快指针指向链表末尾，将其连到头部形成环
 * 5. 新头节点为慢指针的下一个节点，断开慢指针的next
 * 
 * 关键步骤：
 * - 计算链表长度时，快指针停在末尾节点
 * - 将末尾连到头部形成环
 * - 找到断开点（第 i-k%i 个节点）
 * 
 * 时间复杂度：O(n)，遍历链表两次
 * 空间复杂度：O(1)
 * </pre>
 */
public class RotateList61 {

    public static void main(String[] args) {
        RotateList61 solution = new RotateList61();

        // 测试用例1：正常旋转
        ListNode head1 = solution.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution.rotateRight(head1, 2);
        solution.printList(result1); // 4->5->1->2->3

        // 测试用例2：k大于链表长度
        ListNode head2 = solution.createList(new int[]{1, 2, 3});
        ListNode result2 = solution.rotateRight(head2, 4);
        solution.printList(result2); // 3->1->2

        // 测试用例3：k等于0
        ListNode head3 = solution.createList(new int[]{1, 2, 3});
        ListNode result3 = solution.rotateRight(head3, 0);
        solution.printList(result3); // 1->2->3

        // 测试用例4：空链表
        ListNode result4 = solution.rotateRight(null, 1);
        solution.printList(result4); // null

        // 测试用例5：单节点
        ListNode head5 = solution.createList(new int[]{1});
        ListNode result5 = solution.rotateRight(head5, 1);
        solution.printList(result5); // 1
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int len;
        for (len = 0; fast.next != null; len++) {
            fast = fast.next;
        }

        for (int j = len - k % len; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    private ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}