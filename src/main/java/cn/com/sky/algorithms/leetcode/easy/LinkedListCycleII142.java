package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 142. Linked List Cycle II【Medium】
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
 *
 * </pre>
 */
public class LinkedListCycleII142 {

    @Test
    public void solution() {
        ListNode head1 = createListWithCycle(new int[]{3, 2, 0, -4}, 1);
        ListNode result1 = detectCycle(head1);
        System.out.println("测试用例1(有环): " + (result1 != null ? result1.val : null));

        ListNode head2 = createListWithCycle(new int[]{1, 2}, -1);
        ListNode result2 = detectCycle(head2);
        System.out.println("测试用例2(无环): " + (result2 != null ? result2.val : null));

        ListNode head3 = createListWithCycle(new int[]{1}, 0);
        ListNode result3 = detectCycle(head3);
        System.out.println("测试用例3(单节点自环): " + (result3 != null ? result3.val : null));
    }

    /**
     * Floyd判圈算法（最优解）
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    private ListNode createListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode cycleNode = null;

        for (int i = 0; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleNode = current;
            }
        }

        if (pos >= 0 && cycleNode != null) {
            current.next = cycleNode;
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}