package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 141. 环形链表【Easy】（字节跳动高频）
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 算法原理（快慢指针/Floyd判圈算法）：
 * 1. 使用两个指针，慢指针每次走一步，快指针每次走两步
 * 2. 如果链表有环，快慢指针最终会相遇（快指针追上慢指针）
 * 3. 如果链表无环，快指针会先到达链表末尾（遇到null）
 * <p>
 * 为什么快指针走两步？
 * - 如果快指针走一步，和慢指针速度相同，永远不会相遇
 * - 选 2 步而非 3 步的真正原因是简单且效率最优（相遇最快）
 * - 走两步是最优选择，保证如果有环一定能相遇
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class LinkedListCycle141 {


    /**
     * <pre>
     *
     * 一句话记忆法
     * "慢走一步，快走两步，遇上就是环"
     *
     * </pre>
     */
    public boolean hasCycle(ListNode head) {
        // ① 初始化：快慢指针都从头节点开始
        ListNode slow = head;   // 慢指针（乌龟）
        ListNode fast = head;   // 快指针（兔子）

        // ② 循环条件：快指针及其下一个节点都不能为 null
        //    如果 fast 或 fast.next 为 null，说明链表有尽头，无环
        while (fast != null && fast.next != null) {

            // ③ 先移动指针！（这一步位置很关键）
            slow = slow.next;          // 慢指针走 1 步
            fast = fast.next.next;     // 快指针走 2 步

            // ④ 再判断是否相遇
            //    用 == 比较的是引用地址（是否指向同一个节点对象）
            if (slow == fast) {
                return true;
            }
        }

        // ⑤ 快指针到达末尾 → 无环
        return false;
    }


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

}