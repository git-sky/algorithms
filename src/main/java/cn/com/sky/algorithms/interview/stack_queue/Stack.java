package cn.com.sky.algorithms.interview.stack_queue;

public class Stack {

	private int[] arr;
	private int length = 10;// 容量
	private int top = 0;
	private int count = 0;// 元素数量

	public Stack() {
		arr = new int[length];
	}

	public Stack(int n) {
		arr = new int[n];
		length = n;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public void push(int e) {
		if (top < length) {
			arr[top++] = e;
			count++;
		} else {
			throw new RuntimeException("the stack is full...");
		}

	}

	public int pop() {
		if (top > 0) {
			count--;
			return arr[--top];
		} else {
			throw new RuntimeException("the stack is empty...");
		}
	}

	public int peek() {
		if (top > 0) {
			return arr[top - 1];
		} else {
			throw new RuntimeException("the stack is empty...");
		}
	}
}
