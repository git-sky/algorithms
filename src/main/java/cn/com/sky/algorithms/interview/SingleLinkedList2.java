package cn.com.sky.algorithms.interview;

import org.junit.Test;

/**
 * 链表操作算法
 */
public class SingleLinkedList2 {

	/**
	 * 单链表逆转(无头节点)
	 */
	@Test
	public void testReverse() {
		int length = 10;// 链表长度
		 Node head = create(length);
//		Node head = createByTail(length);

		print(head);

		head = reverse(head);

		print(head);
	}

	/**
	 * 判断单链表是否有环
	 */
	@Test
	public void testHasLoop() {
		int length = 10;// 链表长度
		int pos = 2;// 环的入口

		Node head = createLoop(length, pos);
		// print(head);

		findLoop(head);

	}

	/**
	 * 判断单链表是否有环,环的入口位置。
	 * 
	 * 按照 fast每次两步，slow 每次一步的方式走，发现 fast 和 slow 重合，确定了单向链表有环路了。
	 * 接下来，让fast回到链表的头部，然后fast和slow每次走1步，那么当 fast和 slow 再次相遇的时候，就是环路的入口了。
	 */
	@Test
	public void testGetLoopPos() {
		int length = 10;// 链表长度
		int pos = 2;// 环的入口

		Node head = createLoop(length, pos);
		// print(head);

		getLoopPos(head);

	}

	private static void getLoopPos(Node head) {

		Node slow = findLoop(head);

		if (slow == null) {
			return;
		}

		// 查找入口
		int pos = 0;
		Node fast = head;
		slow = slow.next;
		pos = 1;
		while (true) {
			if (slow == fast) {
				System.out.println("have a loop,pos=" + pos);
				break;
			}
			fast = fast.next;
			slow = slow.next;
			pos++;
		}

	}

	/**
	 * 查找是否有环
	 */
	private static Node findLoop(Node head) {
		Node slow = head;
		Node fast = head.next;
		int pos = 1;
		while (true) {
			if (slow == fast) {
				System.out.println("have a loop,pos=" + pos);
				return slow;
			}

			for (int i = 0; i < 2; i++) {
				if (fast == null) {
					System.out.println("not have loop");
					return null;
				}
				fast = fast.next;
			}
			slow = slow.next;
			pos++;
		}
	}

	/**
	 * 单链表逆转
	 */
	private static Node reverse(Node head) {
		if (head != null && head.next != null) {
			Node cur = null;
			for (cur = head.next, head.next = null; cur != null;) {
				Node temp = cur.next;
				cur.next = head;
				head = cur;
				cur = temp;
			}
		}
		return head;
	}

	private static void print(Node head) {
		System.out.println();
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			System.out.print("->");
			temp = temp.next;
		}
		System.out.print("^");
	}

	/**
	 * 构建单链表,头插法
	 * 
	 * @param length
	 *            链表长度
	 * @return
	 */
	private static Node create(int length) {
		Node head = null;
		for (int i = 0; i < length; i++) {
			Node node = new Node(i, head);
			head = node;
		}
		return head;
	}

	/**
	 * 构建单链表,尾插法
	 * 
	 * @param length
	 *            链表长度
	 * @return
	 */
	private static Node createByTail(int length) {
		Node head = null;
		Node p = null;
		for (int i = 0; i < length; i++) {
			Node node = new Node(i, null);
			if (i == 0) {
				head = node;
				p = node;
			} else {
				p.next = node;
				p = node;
			}
		}
		return head;
	}

	/**
	 * 
	 * 构建有环单链表,头插法
	 * 
	 * @param length
	 *            链表长度
	 * @param pos
	 *            环的入口
	 * @return
	 */
	private static Node createLoop(int length, int pos) {
		Node head = null;
		Node last = null;
		for (int i = 0; i < length; i++) {
			Node node = new Node(i, head);
			if (head == null) {
				last = node;
			}
			if (length - pos == i) {
				last.next = node;
			}
			head = node;
		}
		return head;
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
