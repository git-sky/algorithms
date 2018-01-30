package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 判断单链表是不是回文。
 * 
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome(回文).
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */
public class PalindromeLinkedList234 {

	@Test
	public void solution() {

		ListNode head = create(10);

		boolean flag = isPalindrome(head);
		System.out.println(flag);
	}

	private static ListNode create(int length) {
		ListNode head = null;
		for (int i = 0; i < length; i++) {
			ListNode node = new ListNode(i, head);
			head = node;
		}
		return head;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x, ListNode next) {
			val = x;
			this.next = next;
		}
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd nodes: let right half smaller
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
