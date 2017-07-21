package cn.com.sky.algorithms.interview.linkedlist;

import org.junit.Test;

/**
 * <pre>
 * 单链表删除中间节点
 * 
 * 思路：两个指针，快慢指针策略。
 * 
 */
public class SingleLinkedListRemoveMiddleNode {

	@Test
	public void solution() {

		int N = 10;
		Node head = init(N);
		print(head);

		Node node = findMiddleNode(head);
		if (node != null) {
			System.out.println("need remove node:" + node.data);
		}

		removeMiddleNode(head);

		print(head);
	}

	/**
	 * 思路：找到中间节点，使用快慢指针，fast走两步，slow走一步。
	 */
	public static Node findMiddleNode(Node head) {
		if (head == null) {
			return null;
		}

		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	/**
	 * 思路：找到并删除中间节点，使用快慢指针，fast走两步，slow走一步。
	 */
	public static Node removeMiddleNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		if (head.next.next == null) {
			head = head.next;
			return head;
		}

		Node fast = head.next.next;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	/**
	 * 构建单链表（头插入法，拥有头结点）
	 */
	// private Node init(int N) {
	// // 头结点
	// Node head = new Node(-1, null);
	// // 构建单链表（头插入）
	// for (int i = 1; i <= N; i++) {
	// Node node = new Node(i, head.next);
	// head.next = node;
	// }
	// return head;
	// }

	/**
	 * 构建单链表（头插入法，无头结点）
	 */
	private Node init(int N) {
		Node head = null;
		// 构建单链表（头插入）
		for (int i = 1; i <= N; i++) {
			Node node = new Node(i, head);
			head = node;
		}
		return head;
	}

	private void print(Node head) {
		System.out.print("链表：");
		for (Node p = head; p != null; p = p.next) {
			System.out.print(p.data + "->");
		}
		System.out.println();
	}

	/**
	 * 链表的节点
	 */
	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

}
