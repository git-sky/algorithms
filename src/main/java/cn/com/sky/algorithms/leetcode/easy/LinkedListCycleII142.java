package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *
 *  判断链表是否有环，并且返回环的入口。
 *
 * 142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * </pre>
 */
public class LinkedListCycleII142 {

    @Test
    public void solution() {

        ListNode head = null;

        ListNode hasCycle = detectCycle(head);
        System.out.println(hasCycle);
    }

    /**
     * 快慢指针。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

    }


    /**
     * Time complexity : O(n)
     * <p>
     * Space complexity : O(n)
     */
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> visited = new HashSet<ListNode>();
//
//        ListNode node = head;
//        while (node != null) {
//            if (visited.contains(node)) {
//                return node;
//            }
//            visited.add(node);
//            node = node.next;
//        }
//
//        return null;
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
