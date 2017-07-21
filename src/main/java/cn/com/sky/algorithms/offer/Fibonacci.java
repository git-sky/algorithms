package cn.com.sky.algorithms.offer;

import org.junit.Test;

/**
 * <pre>
 * 
 * 8.斐波那契数列
 * 
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。斐波那契数列的定义如下：　
 * f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2);
 * 
 * 例如：1 1 2 3 5 8 13 21 34 55 89
 * 
 * 相同问题：   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 */
public class Fibonacci {

	@Test
	public void solution() {
		for (int i = 1; i < 15; i++) {
			int item = findItem(i);
			System.out.println(item);
		}

		for (int i = 1; i < 15; i++) {
			int item = findItemCycle(i);
			System.out.println(item);
		}

	}

	/**
	 * 循环实现。时间复杂的O(n).
	 */
	public int findItemCycle(int n) {
		int a = 0;
		int b = 0;
		int total = 0;

		// 1 1 2 3 5 8 13 21 34 55 89
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == 2) {
				a = 1;
				b = 1;
				total = 1;
			} else {
				total = a + b;
				a = b;
				b = total;
			}
		}

		return total;
	}

	/**
	 * 递归算法，效率太低。时间复杂的O(2^n)??.
	 */
	public int findItem(int n) {
		if (n <= 1) {
			return n;
		} else {
			return findItem(n - 1) + findItem(n - 2);
		}
	}
}
