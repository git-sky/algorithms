package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 680. Valid Palindrome II
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * 
 * Example 1:
 * Input: "aba"
 * Output: True
 * 
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * 
 * 
 * </pre>
 */
public class ValidPalindromeII680 {

	@Test
	public void solution() {

		String s = "axyza";
		System.out.println(validPalindrome(s));
	}

	/**
	 * <pre>
	 * 
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(N) where N is the length of the string. Each of two checks of whether some substring is a palindrome is O(N).
	 * 
	 * Space Complexity: O(1) additional complexity. Only pointers were stored in memory.
	 * 
	 * </pre>
	 */
	public boolean validPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i;
				return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
			}
		}
		return true;
	}

	private boolean isPalindromeRange(String s, int i, int j) {
		for (int k = i; k <= i + (j - i) / 2; k++) {
			if (s.charAt(k) != s.charAt(j - k + i))
				return false;
		}
		return true;
	}

}
