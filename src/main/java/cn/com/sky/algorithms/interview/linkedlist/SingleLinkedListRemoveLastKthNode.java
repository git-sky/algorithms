package cn.com.sky.algorithms.interview.linkedlist;

import org.junit.Test;

/**
 * <pre>
 * 单链表中删除倒数第k个节点（注意：不知道链表长度，要求时间复杂度O(n)）。
 * 
 * 思路1：
 * 倒数第K个节点，就是正数第N-K节点。 第一遍遍历的值是：K-N,第二遍遍历是N-K时，K=0,刚好是需要删除的节点的前一个节点。
 * 这种思路需要遍历链表两次，第一次统计出链表中结点的个数，第二次才能找到倒数第k个结点。
 * 
 * 思路2(两个指针，先后指针策略，最优)： 
 * 为了能够只遍历一次就能找到倒数第k个节点，可以定义两个指针： 
 * （1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
 * （2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；
 * （3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
 * 
 * 
 * 相似的问题：
 * 1.求链表的中间节点。
 * 答案：快慢指针，快指针一次两步，慢指针一次一步。
 * 
 * 2.判断单链表是否有环。
 * 
 * 
 */
public class SingleLinkedListRemoveLastKthNode {

	@Test
	public void solution() {

		int N = 10;
		int K = 8;

		Node head = init(N);
		print(head);

		removeLastKthNode(head, K);

		print(head);
	}

	/**
	 * 思路1：找到并删除倒数第K个节点。（需要遍历链表两次，效率低）
	 */
	public void removeLastKthNode(Node head, int k) {
		if (head == null || k <= 0) {
			return;
		}

		Node p = head;
		while (p != null) {
			p = p.next;
			k--;
		}

		if (k == 0) {
			System.out.println("remove node:" + head.data);
			head = head.next;
			return;
		}

		if (k < 0) {
			p = head;
			while (++k != 0) {
				p = p.next;
			}
			System.out.println("remove node:" + p.next.data);
			p.next = p.next.next;
		}
		return;
	}

	/**
	 * 思路2：找到倒数第K个节点。（需要两个指针，遍历一次链表，效率高）
	 */
	public static Node FindKthToTail(Node head, int k) {
		if (head == null || k == 0) {
			return null;
		}

		Node ahead = head;
		Node behind = null;

		for (int i = 0; i < k - 1; i++) {
			if (ahead.next != null) {
				ahead = ahead.next;
			} else {
				return null;
			}
		}

		behind = head;
		while (ahead.next != null) {
			ahead = ahead.next;
			behind = behind.next;
		}

		return behind;
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
