package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 
 * 问题：使用两个队列实现一个栈.
 * 
 * </pre>
 */
public class TwoQueueStack {

	public static void main(String[] args) {

		TwoQueueStack stack = new TwoQueueStack();

		Random r = new Random();
		System.out.println("push: ");
		for (int i = 0; i < 10; i++) {
			int e = r.nextInt(10) + r.nextInt(10);
			stack.push(e);
			System.out.print(e + " ");
		}

		System.out.print("\r\npop: \r\n");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	int length = 10;
	int count = 0;
	Queue qleft = new Queue(10);
	Queue qright = new Queue(10);

	public TwoQueueStack() {
		qleft = new Queue(length);
		qright = new Queue(length);
	}

	public TwoQueueStack(int size) {
		qleft = new Queue(size);
		qright = new Queue(size);
		length = size;
	}

	public void push(int e) {
		if (count < length) {
			count++;
			if (!qleft.isEmpty()) {
				qleft.enqueue(e);
			} else {
				qright.enqueue(e);
			}
		} else {
			throw new RuntimeException("the stack is full...");
		}
	}

	public int pop() {
		if (count > 0) {
			count--;
			if (!qleft.isEmpty()) {
				while (qleft.size() > 1) {
					qright.enqueue(qleft.dequeue());
				}
				return qleft.dequeue();
			} else {
				while (qright.size() > 1) {
					qleft.enqueue(qright.dequeue());
				}
				return qright.dequeue();
			}

		} else {
			throw new RuntimeException("the stack is empty...");
		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

}
