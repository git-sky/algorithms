package cn.com.sky.algorithms.offer;

import org.junit.Test;

/**
 * <pre>
 * 
 * 16.合并两个排序的链表
 * 
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。例如输入下图中的链表1和链表2，则合并之后的升序链表如链表3所示。
 * 
 */
public class MergeTwoSortedLinkedList {

	@Test
	public void solution() {

		int N = 10;

		int k1 = 3;
		int k2 = 2;
		Node head1 = init(N, k1);
		Node head2 = init(N, k2);

		print(head1);
		print(head2);

		Node head3 = merge(head1, head2);

		// Node head3 = merge2(head1, head2);

		// Node head3 = merge3(head1, head2);

		print(head1);
		print(head2);
		print(head3);

	}

	public Node merge3(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		Node head3 = null;

		if (head1.data <= head2.data) {
			head3 = head1;
			head3.next = merge3(head1.next, head2);
		} else {
			head3 = head2;
			head3.next = merge3(head1, head2.next);
		}

		return head3;

	}

	public Node merge2(Node head1, Node head2) {

		Node p1 = head1;
		Node p2 = head2;

		Node head3 = null;
		Node p3 = null;
		Node pre = null;

		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				p3 = p1;
				p1 = p1.next;
			} else {
				p3 = p2;
				p2 = p2.next;
			}

			if (pre == null) {
				pre = p3;
				head3 = pre;
			} else {
				pre.next = p3;
				pre = pre.next;
			}
		}

		while (p1 != null) {
			p3 = p1;
			p1 = p1.next;
			if (pre == null) {
				pre = p3;
				head3 = pre;
			} else {
				pre.next = p3;
				pre = pre.next;
			}
		}

		while (p2 != null) {
			p3 = p2;
			p2 = p2.next;
			if (pre == null) {
				pre = p3;
				head3 = pre;
			} else {
				pre.next = p3;
				pre = pre.next;
			}
		}

		return head3;

	}

	public Node merge(Node head1, Node head2) {

		Node head3 = new Node(-1, null);
		Node p1 = head1;
		Node p2 = head2;
		Node p3 = head3;
		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				p3.next = new Node(p1.data, null);
				p1 = p1.next;
			} else {
				p3.next = new Node(p2.data, null);
				p2 = p2.next;
			}
			p3 = p3.next;
		}

//		print(head1);
//		print(head2);
//		print(head3);

		while (p1 != null) {
			p3.next = new Node(p1.data, null);
			p1 = p1.next;
			p3 = p3.next;
		}

		while (p2 != null) {
			p3.next = new Node(p2.data, null);
			p2 = p2.next;
			p3 = p3.next;
		}

//		print(head3);

		return head3;

	}

	private void print(Node head) {
		System.out.print("链表：");
		for (Node p = head; p != null; p = p.next) {
			System.out.print(p.data + "->");
		}
		System.out.println();
	}

	/**
	 * 构建单链表（头插入法，无头结点）
	 */
	private Node init(int N, int k) {
		Node head = null;
		// 构建单链表（头插入）
		for (int i = N; i >= 1; i--) {
			Node node = new Node(i * k, head);
			head = node;
		}
		return head;
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
