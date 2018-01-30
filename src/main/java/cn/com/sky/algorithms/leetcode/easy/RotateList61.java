package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * 
 * 61. Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * 
 * Example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * 
 * return 4->5->1->2->3->NULL.
 * 
 * 
 * </pre>
 */
public class RotateList61 {

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i;
		for (i = 0; fast.next != null; i++)
			// Get the total length
			fast = fast.next;

		for (int j = i - n % i; j > 0; j--)
			// Get the i-n%i th node
			slow = slow.next;

		fast.next = dummy.next; // Do the rotation
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}

	//
	// public ListNode rotateRight(ListNode head, int k) {
	//
	// if (head == null)
	// return null;
	//
	// ListNode p = head;
	// ListNode q = head;
	// for (int i = 1; i < k; i++) {
	// q = q.next;
	// }
	//
	// while (q.next != null) {
	// p = p.next;
	// q = q.next;
	// }
	// q.next = head;
	//
	// head = p.next;
	// p.next = null;
	//
	// return q;
	//
	// }

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
