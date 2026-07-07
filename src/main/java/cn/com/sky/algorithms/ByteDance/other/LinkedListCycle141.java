package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 141. 环形链表【Easy】（字节跳动高频）
 * 
 * 给定一个链表，判断链表中是否有环。
 * 
 * 算法原理（快慢指针/Floyd判圈算法）：
 * 1. 使用两个指针，慢指针每次走一步，快指针每次走两步
 * 2. 如果链表有环，快慢指针最终会相遇（快指针追上慢指针）
 * 3. 如果链表无环，快指针会先到达链表末尾（遇到null）
 * 
 * 为什么快指针走两步？
 * - 如果快指针走一步，和慢指针速度相同，永远不会相遇
 * - 如果快指针走三步或更多，可能会跳过慢指针，导致错过相遇点
 * - 走两步是最优选择，保证如果有环一定能相遇
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class LinkedListCycle141 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle141 solution = new LinkedListCycle141();
        
        // 测试用例1：有环（标准情况）
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // 环：-4 -> 2
        System.out.println("测试用例1(有环): " + solution.hasCycle(head1)); // true
        
        // 测试用例2：有环（单节点自环）
        ListNode head2 = new ListNode(1);
        head2.next = head2;
        System.out.println("测试用例2(单节点自环): " + solution.hasCycle(head2)); // true
        
        // 测试用例3：无环（正常链表）
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        System.out.println("测试用例3(无环): " + solution.hasCycle(head3)); // false
        
        // 测试用例4：空链表
        System.out.println("测试用例4(空链表): " + solution.hasCycle(null)); // false
        
        // 测试用例5：单节点无环
        ListNode head5 = new ListNode(1);
        System.out.println("测试用例5(单节点无环): " + solution.hasCycle(head5)); // false
        
        // 测试用例6：两个节点无环
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        System.out.println("测试用例6(两节点无环): " + solution.hasCycle(head6)); // false
        
        // 测试用例7：两个节点有环
        ListNode head7 = new ListNode(1);
        head7.next = new ListNode(2);
        head7.next.next = head7;
        System.out.println("测试用例7(两节点有环): " + solution.hasCycle(head7)); // true
    }

    public boolean hasCycle(ListNode head) {
        // 边界情况：空链表或单节点无环
        if (head == null || head.next == null) {
            return false;
        }
        
        // 初始化快慢指针
        ListNode slow = head;
        ListNode fast = head.next; // 快指针先走一步
        
        // 循环直到相遇或快指针到达末尾
        while (slow != fast) {
            // 快指针到达末尾，无环
            if (fast == null || fast.next == null) {
                return false;
            }
            
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 相遇，有环
        return true;
    }
}