package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 141. 环形链表【Easy】（字节跳动高频）
 * 
 * 给定一个链表，判断链表中是否有环。
 * 
 * 算法原理（快慢指针/Floyd判圈算法）：
 * 1. 使用两个指针，慢指针每次走一步，快指针每次走两步
 * 2. 如果链表有环，快慢指针最终会相遇
 * 3. 如果链表无环，快指针会先到达链表末尾（null）
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
        
        // 测试用例1：有环
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
        
        // 测试用例3：无环
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        System.out.println("测试用例3(无环): " + solution.hasCycle(head3)); // false
        
        // 测试用例4：空链表
        System.out.println("测试用例4(空链表): " + solution.hasCycle(null)); // false
        
        // 测试用例5：单节点无环
        ListNode head5 = new ListNode(1);
        System.out.println("测试用例5(单节点无环): " + solution.hasCycle(head5)); // false
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            // 快指针到达末尾，无环
            if (fast == null || fast.next == null) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}