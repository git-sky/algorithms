package cn.com.sky.algorithms.interview.stack_queue;

/**
 * <pre>
 * 
 * 问题：如何仅使用递归函数和栈操作逆序一个栈
 * 
 * </pre>
 */
public class ReverseStack {

	public static void main(String[] args) {

		Stack stack = new Stack();

		for (int i = 1; i < 6; i++) {
			stack.push(i);
			System.out.println("push:" + i);
		}

		reverse(stack);// 逆转

		while (!stack.isEmpty()) {
			System.out.println("pop:" + stack.pop());
		}
	}

	public static int getAndRemoveLastElement(Stack stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack stack) {
		if (stack.isEmpty()) {
			return;
		}

		int e = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(e);

	}
}
