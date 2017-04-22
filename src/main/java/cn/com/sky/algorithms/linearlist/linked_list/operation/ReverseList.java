package cn.com.sky.algorithms.linearlist.linked_list.operation;

/**
 * 单链表逆转
 * 
 */
public class ReverseList {
	public static void main(String[] args) {
		Node head = add(null, "a");
		add(head, "b");
		add(head, "c");
		add(head, "d");
		add(head, "e");
		print(head);
		head = reverse(head);
		print(head);
	}

	public static Node reverse(Node head) {
		if (head == null) {
			return null;
		}
		Node p = head;
		Node q = head.next;
		p.next = null; // 这个必须的，否则链表就成有环的了。
		while (q != null) {
			Node temp = q.next;
			q.next = p;
			p = q;
			q = temp;
		}

		return p;

	}

	public static Node add(Node head, String data) {
		if (head == null) {
			return new Node(data);
		} else {
			Node p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = new Node(data);
			return head;
		}
	}

	public static void print(Node head) {
		if (head == null) {
			System.out.println("null");
		} else {
			Node p = head;
			while (p != null) {
				System.out.print(p.data + "->");
				p = p.next;
			}
			System.out.print("^\n");
		}
	}
}

class Node {

	String data;
	Node next;

	public Node(String data) {
		this.data = data;
	}

	public String toString() {
		return data;
	}

}