package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.(判断链表是否有环。)
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * </pre>
 */
public class LinkedListCycle141 {

    @Test
    public void solution() {

        ListNode head=null;

        boolean hasCycle = hasCycle(head);
        System.out.println(hasCycle);
    }

    /**
     * 快慢指针。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hashtable方式，需要额外的空间。
     * Complexity analysis
     * <p>
     * Time complexity : O(n). We visit each of the nn elements in the list at most once. Adding a node to the hash table costs only O(1) time.
     * <p>
     * Space complexity: O(n). The space depends on the number of elements added to the hash table, which contains at most nn elements.
     */
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }


    //      Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
