package cn.com.sky.algorithms.ByteDance;

import org.junit.Test;

/**
 * <pre>
 *
 * 234. Palindrome Linked List
 *
 * 判断单链表是否为回文链表。
 *
 * 问题描述：
 * Given a singly linked list, determine if it is a palindrome(回文).
 *
 * 进阶要求：
 * Could you do it in O(n) time and O(1) space?
 *
 * 解题思路：
 * 使用快慢指针找到链表中点，然后反转后半部分链表，最后比较前后两部分是否相同。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * </pre>
 */
public class PalindromeLinkedList234_v1 {

    /**
     * 链表节点定义
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    /**
     * 主测试方法
     */
    @Test
    public void testSolution() {
        // 测试用例1: 偶数长度的回文链表
        ListNode palindromeEven = createPalindromeEven();
        System.out.println("测试用例1(偶数回文): " + isPalindrome(palindromeEven)); // 预期: true

        // 测试用例2: 奇数长度的回文链表
        ListNode palindromeOdd = createPalindromeOdd();
        System.out.println("测试用例2(奇数回文): " + isPalindrome(palindromeOdd)); // 预期: true

        // 测试用例3: 非回文链表
        ListNode nonPalindrome = createNonPalindrome();
        System.out.println("测试用例3(非回文): " + isPalindrome(nonPalindrome)); // 预期: false

        // 测试用例4: 空链表
        ListNode emptyList = null;
        System.out.println("测试用例4(空链表): " + isPalindrome(emptyList)); // 预期: true

        // 测试用例5: 单节点链表
        ListNode singleNode = new ListNode(1);
        System.out.println("测试用例5(单节点): " + isPalindrome(singleNode)); // 预期: true
    }

    /**
     * 判断链表是否为回文
     *
     * @param head 链表头节点
     * @return 如果是回文返回true，否则返回false
     */
    public boolean isPalindrome(ListNode head) {
        // 边界情况：空链表或单节点链表都是回文
        if (head == null || head.next == null) {
            return true;
        }

        // 步骤1: 使用快慢指针找到链表中点
        ListNode fast = head; // 快指针，每次移动2步
        ListNode slow = head; // 慢指针，每次移动1步

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针移动2步
            slow = slow.next;      // 慢指针移动1步
        }

        // 步骤2: 处理奇数长度情况
        // 如果fast不为null，说明链表长度为奇数，跳过中间节点
        if (fast != null) {
            slow = slow.next;
        }

        // 步骤3: 反转后半部分链表
        slow = reverseList(slow);
        fast = head; // 重置fast指针到链表头部

        // 步骤4: 比较前后两部分链表
        while (slow != null) {
            if (fast.val != slow.val) {
                return false; // 值不相等，不是回文
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true; // 所有节点值都相等，是回文
    }

    /**
     * 反转链表（迭代方式）
     *
     * @param head 要反转的链表头节点
     * @return 反转后的链表头节点
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null; // 前一个节点
        ListNode curr = head; // 当前节点

        while (curr != null) {
            ListNode nextTemp = curr.next; // 保存下一个节点
            curr.next = prev;              // 反转当前节点的指针
            prev = curr;                   // prev指针前进
            curr = nextTemp;               // curr指针前进
        }

        return prev; // prev现在是新的头节点
    }

    /**
     * 创建偶数长度的回文链表: 1 -> 2 -> 2 -> 1
     */
    private ListNode createPalindromeEven() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        return head;
    }

    /**
     * 创建奇数长度的回文链表: 1 -> 2 -> 3 -> 2 -> 1
     */
    private ListNode createPalindromeOdd() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        return head;
    }

    /**
     * 创建非回文链表: 1 -> 2 -> 3 -> 4 -> 5
     */
    private ListNode createNonPalindrome() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    /**
     * 打印链表（辅助方法）
     */
    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}