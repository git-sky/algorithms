package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 142. 环形链表 II【Medium】（字节跳动高频）
 * 
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 
 * 算法原理（Floyd判圈算法扩展）：
 * 
 * 阶段1（找相遇点）：
 * 1. 使用快慢指针，慢指针每次走一步，快指针每次走两步
 * 2. 如果有环，快慢指针会在环内相遇
 * 
 * 阶段2（找环入口）：
 * 1. 将慢指针移到链表头
 * 2. 快慢指针以相同速度移动（每次一步）
 * 3. 再次相遇的位置就是环的入口
 * 
 * 数学证明：
 * 设：
 * - a：链表头到环入口的距离
 * - b：环入口到相遇点的距离
 * - c：相遇点到环入口的距离（环的剩余部分）
 * 
 * 慢指针走过的距离：a + b
 * 快指针走过的距离：a + b + c + b = a + 2b + c
 * 
 * 因为快指针速度是慢指针的2倍：
 * 2(a + b) = a + 2b + c
 * => a = c
 * 
 * 所以当慢指针从头走a步，快指针从相遇点走c步，会在环入口相遇。
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
        
        // 测试用例1：有环（标准情况）
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // 环入口：2
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
        
        // 测试用例5：整个链表就是一个环
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = head5; // 环入口：1
        ListNode result5 = solution.detectCycle(head5);
        System.out.println("测试用例5(整个链表是环): " + (result5 != null ? result5.val : null)); // 1
        
        // 测试用例6：短环
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);
        head6.next.next.next = head6.next; // 环入口：2
        ListNode result6 = solution.detectCycle(head6);
        System.out.println("测试用例6(短环): " + (result6 != null ? result6.val : null)); // 2
    }

    public ListNode detectCycle(ListNode head) {
        // 边界情况
        if (head == null || head.next == null) {
            return null;
        }
        
        // 阶段1：找到相遇点
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // 找到相遇点
            if (slow == fast) {
                break;
            }
        }
        
        // 如果没有相遇，说明无环
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // 阶段2：找环入口
        // 将慢指针移到头部
        slow = head;
        
        // 快慢指针以相同速度移动
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 返回环入口
        return slow;
    }
}