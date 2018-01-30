package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 *  237. Delete Node in a Linked List
 *
 *  Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 *
 * </pre>
 */
public class DeleteNodeInALinkedList237 {

    @Test
    public void solution() {

        ListNode node = null;

        deleteNode(node);
    }

    /**
     * 使用下一个节点数据覆盖当前节点数据。
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
