package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 
 * 问题：使用两个栈实现一个队列，支持队列的基本操作（add，poll，peek）
 * 
 * 需要保证2点：
 * 1.必须一次性把push中的数据全部押入pop中.
 * 2.如果pop不为空,push不能像pop中压入数据.
 * 
 * </pre>
 */
public class TwoStackQueue {

	public static void main(String[] args) {

		TwoStackQueue sq = new TwoStackQueue();

		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int e = i;// r.nextInt(10) + r.nextInt(10);
			sq.add(e);
			System.out.println("add:" + e);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("poll:" + sq.poll());
			System.out.println("peek:" + sq.peek());
		}

	}

	Stack stackPush = new Stack(10);
	Stack stackPop = new Stack(10);
	int length = 10;

	public TwoStackQueue() {
		stackPush = new Stack(length);
		stackPop = new Stack(length);
	}

	public TwoStackQueue(int size) {
		stackPush = new Stack(size);
		stackPop = new Stack(size);
		length = size;
	}

	public void add(int e) {
		if (stackPush.size() < length) {
			stackPush.push(e);
		} else {
			throw new RuntimeException("the queue is full...");
		}
	}

	public int poll() {
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				int e = stackPush.pop();
				stackPop.push(e);
			}
		}
		return stackPop.pop();

	}

	public int peek() {
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				int e = stackPush.pop();
				stackPop.push(e);
			}
		}
		return stackPop.peek();
	}

}
