package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 
 *  问题：使用一个栈实现另一个栈的排序。
 * 
 * </pre>
 */
public class StackSort {

	public static void main(String[] args) {
		Stack stack = new Stack();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int e = r.nextInt(100);
			System.out.println("push:" + e);
			stack.push(e);
		}
		sort(stack);

		while (!stack.isEmpty()) {
			System.out.println("pop:" + stack.pop());
		}
	}

	public static void sort(Stack stack) {

		Stack help = new Stack();// 辅助栈

		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!help.isEmpty() && cur > help.peek()) {
				stack.push(help.pop());
			}
			help.push(cur);
		}

		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
