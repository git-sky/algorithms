package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 344. Reverse String
 * 
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 * </pre>
 */
public class ReverseString344 {

	@Test
	public void solution() {
		// String s = "hello";
		String s = null;
		// String reverseString = reverseString(s);
		String reverseString = reverseString2(s);
		System.out.println(reverseString);
	}

	public String reverseString(String s) {

		StringBuilder sb = new StringBuilder();
		if (s != null) {
			for (int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i);
				sb.append(c);
			}
		}

		return sb.toString();

	}

	private String reverseString2(String s) {
		if (s == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString();
	}

}
