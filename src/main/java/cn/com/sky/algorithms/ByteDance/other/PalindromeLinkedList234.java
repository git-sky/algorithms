package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 234. 回文链表【Easy】
 * 
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * 
 * 算法原理（快慢指针+链表反转）：
 * 1. 使用快慢指针找到链表中点
 * 2. 反转后半部分链表
 * 3. 比较前后两部分是否相同
 * 4. 恢复原链表（可选）
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class PalindromeLinkedList234 {

    public static class ListNode {
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

    public static void main(String[] args) {
        PalindromeLinkedList234 solution = new PalindromeLinkedList234();
        
        // 测试用例1：偶数长度回文
        ListNode head1 = createList(new int[]{1, 2, 2, 1});
        System.out.println("测试用例1(偶数回文): " + solution.isPalindrome(head1)); // true
        
        // 测试用例2：奇数长度回文
        ListNode head2 = createList(new int[]{1, 2, 3, 2, 1});
        System.out.println("测试用例2(奇数回文): " + solution.isPalindrome(head2)); // true
        
        // 测试用例3：非回文
        ListNode head3 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("测试用例3(非回文): " + solution.isPalindrome(head3)); // false
        
        // 测试用例4：空链表
        System.out.println("测试用例4(空链表): " + solution.isPalindrome(null)); // true
        
        // 测试用例5：单节点
        ListNode head5 = new ListNode(1);
        System.out.println("测试用例5(单节点): " + solution.isPalindrome(head5)); // true
        
        // 测试用例6：两个相同节点
        ListNode head6 = new ListNode(1, new ListNode(1));
        System.out.println("测试用例6(两个相同): " + solution.isPalindrome(head6)); // true
        
        // 测试用例7：两个不同节点
        ListNode head7 = new ListNode(1, new ListNode(2));
        System.out.println("测试用例7(两个不同): " + solution.isPalindrome(head7)); // false
    }

    /**
     * 创建链表
     */
    private static ListNode createList(int[] arr) {
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

    public boolean isPalindrome(ListNode head) {
        // 边界情况：空链表或单节点都是回文
        if (head == null || head.next == null) {
            return true;
        }

        // 步骤1: 使用快慢指针找到链表中点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 步骤2: 处理奇数长度情况
        if (fast != null) {
            slow = slow.next;
        }

        // 步骤3: 反转后半部分链表
        slow = reverseList(slow);
        fast = head;

        // 步骤4: 比较前后两部分链表
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    /**
     * 反转链表（迭代方式）
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}