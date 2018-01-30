package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 返回needle(关键字)在haystack(字符串)中第一次出现的位置,如果needle不在haystack中,则返回-1。
 * 
 * 28. Implement strStr()
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * </pre>
 */
public class ImplementStr28 {

	@Test
	public void solution() {

		String haystack = "hello";
		String needle = "ll";

		int index = strStr(haystack, needle);
		System.out.println(index);
	}

	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

}
