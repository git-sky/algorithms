package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 7. Reverse Integer
 * 
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output:  321
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * 
 * 
 * 
 */
public class ReverseInteger7 {

	@Test
	public void solution() {

		int x = 123;

		int y = reverse(x);
		System.out.println(y);
	}

	public int reverse(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}

}
