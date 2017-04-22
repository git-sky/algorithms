package cn.com.sky.algorithms.linearlist.linked_list;

/**
 * <pre>
 * 
 * 		   head								tail
 * 		    |							  	 |	
 * 		    |       					  	 |
 * 		    V							  	 V
 * 		|head||-->|elem0||-->|elem1||-->|elem2|^|
 * 
 * </pre>
 * 
 * 单链表
 * 
 */
public class SingleLinkedList {

	public static void main(String[] args) {

		createByHead();// 头插入法建表

		System.out.println("========================遍历单链表==========================");
		Node node = createByTail();// 尾插入法建表

		System.out.println("========================单链表逆转==========================");
		reverse(node);// 逆转

	}

	public static void createByHead() {

	}

	public static Node createByTail() {
		Node head = new Node("head", null);// 头结点
		Node tail = head;// 尾节点

		// 生成单链表
		for (int i = 0; i < 10; i++) {
			Node node = new Node("element_" + i, null);
			tail.setNext(node);
			tail = node;
		}

		// 遍历单链表
		Node s = head;
		while (s != null) {
			System.out.println(s.getValue());
			s = s.getNext();
		}

		return head;

	}

	public static void reverse(Node head) {

		// 单链表逆转
		Node s1 = head;
		Node s2 = s1.getNext();
		Node s3 = null;
		if (s2 != null) {
			s3 = s2.getNext();
		}
		head.setNext(null);

		while (s2 != null) {
			s2.setNext(s1);
			s1 = s2;
			s2 = s3;
			if (s2 == null) {
				break;
			}
			if (s3 != null) {
				s3 = s3.getNext();
			}
		}

		// 遍历逆转之后的单链表
		Node s = s1;
		while (s != null) {
			System.out.println(s.getValue());
			s = s.getNext();
		}
	}
}

 class Node {

	private String value;
	private Node next;

	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
