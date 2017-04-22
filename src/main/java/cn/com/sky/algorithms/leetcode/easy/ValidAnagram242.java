package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 242. Valid Anagram   验证变形词
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * </pre>
 */
public class ValidAnagram242 {

	@Test
	public void solution() {
		// String s = "abcd";
		// String t = "abdc";

		String s = "中国人";
		String t = "国人中";

		boolean b = isAnagram2(s, t);
		System.out.println(b);
	}

	// 方式一
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if (--arr[t.charAt(i) - 'a'] < 0)
				return false;
		}

		return true;
	}

	// 方式二,可以满足unicode的字符
	public boolean isAnagram2(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		String sn = String.valueOf(sc);
		String tn = String.valueOf(tc);
		return sn.equals(tn);
	}

	// 方式三，用hashmap

}
