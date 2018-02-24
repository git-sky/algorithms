package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 633. Sum of Square Numbers
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.
 * 
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * Example 2:
 * Input: 3
 * Output: False
 * 
 * </pre>
 */
public class SumOfSquareNumbers633 {

	@Test
	public void solution() {

		int c = 3;
		System.out.println(judgeSquareSum(c));
	}

	/**
	 * Two Pointers
	 * 
	 * 双指针方案
	 */
	public boolean judgeSquareSum(int c) {
		if (c < 0) {
			return false;
		}
		int left = 0, right = (int) Math.sqrt(c);
		while (left <= right) {
			int cur = left * left + right * right;
			if (cur < c) {
				left++;
			} else if (cur > c) {
				right--;
			} else {
				return true;
			}
		}
		return false;
	}

	// public boolean judgeSquareSum(int c) {
	// for (long a = 0; a * a <= c; a++) {
	// double b = Math.sqrt(c - a * a);
	// if (b == (int) b)
	// return true;
	// }
	// return false;
	// }

}
