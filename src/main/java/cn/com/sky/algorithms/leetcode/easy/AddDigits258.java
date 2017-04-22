package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 258. Add Digits
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * </pre>
 */
public class AddDigits258 {

	@Test
	public void solution() {
		int n = addDigits(38);
		System.out.println(n);
	}

	public int addDigits(int num) {
		return add(0, num);

	}

	private int add(int n, int m) {

		int c = n + m;
		if (c < 10)
			return c;

		int a = c % 10;
		int b = c / 10;

		return add(a, b);
	}
}
