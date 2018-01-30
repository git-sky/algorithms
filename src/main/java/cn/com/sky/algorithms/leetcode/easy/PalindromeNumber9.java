package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 回文数字
 * 
 * 9. Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * </pre>
 */
public class PalindromeNumber9 {

	@Test
	public void solution() {
		int x = 123432;
		System.out.println(isPalindrome(x));
	}

	// 逆值数字
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int y = x;

		int reverse = 0;

		while (y != 0) {
			reverse = reverse * 10 + y % 10;
			y /= 10;
			System.out.println("reverse:" + reverse);
			System.out.println("y:" + y);
		}

		return x == reverse;
	}
}
