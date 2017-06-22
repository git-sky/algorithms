package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 387. First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * 
 * </pre>
 */
public class FirstUniqueCharacterInAString387 {

	@Test
	public void solution() {

		String s = "leetcode";
		int index = firstUniqChar(s);
		System.out.println(index);
	}

	public int firstUniqChar(String s) {

		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;

	}
}
