package cn.com.sky.algorithms.offer;

import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 
 * 12.在O(1)时间删除链表结点
 * 
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 
 */
public class LinkedListRemoveNode {

	@Test
	public void solution() {

		int N = 10;
		Node head = init(N);
		print(head);

		Random r = new Random();
		int pos = r.nextInt(10);
		Node p = getP(head, pos);

		System.out.println("p:" + p.data);

		removeNode(head, p);

		print(head);
	}

	public void removeNode(Node head, Node p) {
		if (p.next != null) {
			p.data = p.next.data;
			p.next = p.next.next;
		} else if (head == p) {
			head = null;
			p = null;
		} else {
			Node next = head;
			while (next.next != p) {
				next = next.next;
			}
			next.next = null;
		}

	}

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

	private Node getP(Node head, int pos) {

		int count = 0;
		for (Node p = head; p != null; p = p.next) {
			if (count == pos) {
				return p;
			}
			count++;
		}
		return null;
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
