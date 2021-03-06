package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 125. Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * </pre>
 */
public class ValidPalindrome125 {

	@Test
	public void solution() {

		String s = "hello";

		boolean flag = isPalindrome(s);
		System.out.println(flag);
	}

	public boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		for (int i = 0, j = c.length - 1; i < j;) {
			if (!Character.isLetterOrDigit(c[i]))
				i++;
			else if (!Character.isLetterOrDigit(c[j]))
				j--;
			else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
				return false;
		}
		return true;
	}

}
