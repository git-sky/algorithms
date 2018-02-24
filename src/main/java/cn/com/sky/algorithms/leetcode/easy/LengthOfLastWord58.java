package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 58. Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * 
 * Output: 5
 * 
 * 
 * </pre>
 */
public class LengthOfLastWord58 {

	@Test
	public void solution() {
		String s = "Hello World";
		System.out.println(lengthOfLastWord(s));
	}

	public int lengthOfLastWord(String s) {

		int count = 0;
		boolean flag = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				flag = true;
				count++;
			} else if (flag) {
				break;
			}
		}

		return count;
	}

}
