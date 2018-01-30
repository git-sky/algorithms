package cn.com.sky.algorithms.interview.linkedlist;

/**
 * 单链表逆转(有头结点)
 */
public class SingleLinkedList {

	public static void main(String[] args) {

		// 头结点
		Node head = new Node(-1, null);

		// 构建单链表
		for (int i = 1; i < 10; i++) {
			Node node = new Node(i, head.next);
			head.next = node;
		}

		for (Node p = head.next; p != null; p = p.next) {
			System.out.println(p.data);
		}

		// 单链表逆转
		if (head.next != null && head.next.next != null) {
			Node p = head.next;
			Node q = p.next;
			p.next = null;
			while (q != null) {
				Node temp = q.next;
				q.next = p;
				p = q;
				q = temp;
			}
			head.next = p;
		}

		for (Node p = head.next; p != null; p = p.next) {
			System.out.println(p.data);
		}

	}

	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

}
