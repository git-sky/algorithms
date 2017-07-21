package cn.com.sky.algorithms.offer;

import java.util.Stack;

import org.junit.Test;

/**
 * 
 * <pre>
 * 
 * 栈的压入、弹出序列
 * 
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1，2，3，4，5是某栈的压栈序列，序列4，5，3，2，1是该压栈序列对应的一个弹出序列，但4，3，5，1，2就不可能是该压栈序列的弹出序列。
 */

import java.util.Stack;

/**
 * @author JInShuangQi
 * 
 *         2015年8月3日
 */
public class E22StackPushPopOrder {

	public boolean check(int[] pPush, int[] pPop) {
		boolean isPossible = false;
		if (pPush != null && pPop != null) {
			Stack<Integer> stack = new Stack<Integer>();
			int i = 0, j = 0;
			// 检查每个出栈
			while (j < pPop.length) {
				while (i < pPush.length && pPop[j] != pPush[i]) {
					stack.push(pPush[i]);
					i++;
				}
				// 相等的元素没有进栈
				++i;
				++j;
				int top = 0;
				// 出栈比较
				while ((!stack.empty()) && (top = stack.pop()) == pPop[j]) {
					++j;
				}
				if (j < pPop.length) {
					stack.push(top);
				}
				// 当已经找不到进栈元素时退出
				if (i >= pPush.length && !stack.empty()) {
					break;
				}
			}
			if (stack.empty()) {
				isPossible = true;
			}
		}
		return isPossible;
	}

	public static void main(String[] args) {
		// 进栈序列
		int[] pPush = { 1, 2, 3, 4, 5 };
		// 出栈序列
		int[] pPop = { 4, 3, 5, 2, 1 }; // {6,4, 3, 5, 2, 1 };//{4,3,5,1,2}
		boolean flag = new E22StackPushPopOrder().check(pPush, pPop);
		System.out.println(flag);
	}
}
