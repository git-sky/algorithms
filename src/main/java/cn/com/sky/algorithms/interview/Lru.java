package cn.com.sky.algorithms.interview;

/**
 * 实现LRU缓存
 * 
 * 实现思路: put和get的时候把元素放到头部，当大于capacity的时候，移除最后一个元素。
 * 
 * 使用双向链表实现，带有头结点，头结点的next指向第一个元素，pre指向最后一个元素，最后一个元素的next指向头结点。
 */
public class Lru {

	private Entry<String> head = new Entry<String>(null, "head", null);

	private int capacity;
	private int count;

	Lru(int capacity) {
		this.capacity = capacity;
		init();
	}

	// 初始化，头结点自己指向自己.
	private void init() {
		head.next = head;
		head.pre = head;
	}

	public void put(String str) {
		String ret = get(str);
		if (ret == null) {
			if (count >= capacity) {
				removeOldest();
			}
			count++;
			add(str);
		}
	}

	/**
	 * 移除最后节点
	 */
	private void removeOldest() {
		Entry entry = head.pre;
		entry.pre.next = head;
		head.pre = entry.pre;

		// help GC
		entry.pre = null;
		entry.next = null;
	}

	/**
	 * 头部插入,head.pre指向最后一个节点，最后一个节点的next指向head节点。
	 */
	public void add(String str) {
		Entry<String> entry = new Entry<String>(head, str, head.next);
		head.next.pre = entry;
		head.next = entry;
	}

	public String get(String str) {
		for (Entry<String> e = head.next; e != head; e = e.next) {
			if (e.value.equals(str)) {
				recordAccess(e);
				return e.value;
			}
		}
		return null;
	}

	public void print() {
		for (Entry<String> e = head.next; e != head; e = e.next) {
			System.out.print(e.value);
			System.out.print("->");
		}
		System.out.println();
	}

	/**
	 * 每访问一次，就移动到头部
	 */
	private void recordAccess(Entry e) {
		// 摘除e节点
		e.next.pre = e.pre;
		e.pre.next = e.next;

		// 挂到head后面
		e.next = head.next;
		head.next.pre = e;

		head.next = e;
		e.pre = head;

	}

	class Entry<E> {
		Entry pre;
		E value;
		Entry next;

		Entry(Entry pre, E value, Entry next) {
			this.pre = pre;
			this.value = value;
			this.next = next;
		}
	}

}
