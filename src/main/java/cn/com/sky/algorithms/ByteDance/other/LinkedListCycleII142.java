package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 142. 环形链表 II【Medium】（字节跳动高频）
 * 
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 
 * 算法原理（Floyd判圈算法扩展）：
 * 1. 使用快慢指针找到相遇点
 * 2. 将慢指针移到链表头，快慢指针以相同速度移动
 * 3. 再次相遇的位置就是环的入口
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class LinkedListCycleII142 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycleII142 solution = new LinkedListCycleII142();
        
        // 测试用例1：有环
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // 环：-4 -> 2
        ListNode result1 = solution.detectCycle(head1);
        System.out.println("测试用例1(有环): " + (result1 != null ? result1.val : null)); // 2
        
        // 测试用例2：无环
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode result2 = solution.detectCycle(head2);
        System.out.println("测试用例2(无环): " + (result2 != null ? result2.val : null)); // null
        
        // 测试用例3：单节点自环
        ListNode head3 = new ListNode(1);
        head3.next = head3;
        ListNode result3 = solution.detectCycle(head3);
        System.out.println("测试用例3(单节点自环): " + (result3 != null ? result3.val : null)); // 1
        
        // 测试用例4：空链表
        ListNode result4 = solution.detectCycle(null);
        System.out.println("测试用例4(空链表): " + (result4 != null ? result4.val : null)); // null
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        // 步骤1：找到相遇点
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                break;
            }
        }
        
        // 如果没有相遇，说明无环
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // 步骤2：将慢指针移到头部，快慢指针以相同速度移动
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}