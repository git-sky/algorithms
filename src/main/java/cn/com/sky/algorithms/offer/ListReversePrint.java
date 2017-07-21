package cn.com.sky.algorithms.offer;

import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 4.从尾到头打印链表(逆置链表、不逆置链表)
 * 
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * 
 */
public class ListReversePrint {

	@Test
	public void solution() {

		Random r = new Random();
		int N = r.nextInt(1000) + 1000;

		Node head = init(N);
		print(head);

		// head = reverse(head);

		notReverse(head);

		System.out.println();

		print(head);
	}

	/**
	 * 思路：需要三个指针，pre,head,next;
	 */
	public static void notReverse(Node head) {

		if (head.next != null) {
			notReverse(head.next);
		}
		System.out.print(head.data + "->");

	}

	/**
	 * 思路：需要三个指针，pre,head,next;
	 */
	public static Node reverse(Node head) {

		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
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
