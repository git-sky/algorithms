package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 
 * 问题：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的getMin函数。在该栈中，调用getMin、push及pop的时间复杂度都是O(1).
 * 
 * 最小值思路：用一个辅助栈stack2记住每次入栈stack1的当前最小值:在stack1入栈时，往stack2中加入当前最小值；stack1元素出栈时，stack2也出栈一个元素。最小值从stack2中获取及栈顶元素。O(1)
 * 
 * 最大值思路：同上O(1)
 * 
 * 中间值思路：对栈排序，取中间值，但是时间不是O(1)
 * 
 * </pre>
 */
public class MinStack {

	public static void main(String[] args) {

		MinStack minStack = new MinStack();
		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			minStack.push(r.nextInt(10) + r.nextInt(10) + 1);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("min=" + minStack.getMin());
			System.out.println("pop=" + minStack.pop());
		}

	}

	Stack stackData = new Stack(10);
	Stack stackMin = new Stack(10);
	Integer min = null;

	public void push(int e) {
		stackData.push(e);
		if (min == null || min > e) {
			min = e;
			stackMin.push(min);
		} else {
			stackMin.push(min);
		}
	}

	public int pop() {
		stackMin.pop();
		return stackData.pop();
	}

	public int getMin() {
		return stackMin.peek();
	}

	public int peek() {
		return stackData.peek();
	}

}
