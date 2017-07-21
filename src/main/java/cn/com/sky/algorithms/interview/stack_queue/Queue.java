package cn.com.sky.algorithms.interview.stack_queue;

/**
 * 队列的简单实现
 */
public class Queue {

	private int[] items;
	private int count = 0;// 元素数量
	private int putIndex = 0;// 入队位置
	private int takeIndex = 0;// 出队位置

	public Queue() {
		items = new int[10];
	}

	public Queue(int n) {
		items = new int[n];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public void enqueue(int e) {
		if (count < items.length) {
			items[putIndex] = e;
			count++;
			putIndex = incr(putIndex);
		} else {
			throw new RuntimeException("the queue is full...");
		}

	}

	public int dequeue() {
		if (count > 0) {
			int e = items[takeIndex];
			count--;
			takeIndex = incr(takeIndex);
			return e;
		} else {
			throw new RuntimeException("the queue is empty...");
		}
	}

	private int incr(int i) {
		// return ++i % items.length;
		return (++i == items.length) ? 0 : i;
	}

}
