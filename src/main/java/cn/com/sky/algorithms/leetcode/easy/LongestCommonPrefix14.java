package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * </pre>
 */
public class LongestCommonPrefix14 {

	@Test
	public void solution() {
		String[] strs1 = { "abcdedf", "abxd", "abcdxy" };
		System.out.println("测试用例1: " + longestCommonPrefix1(strs1));
		
		String[] strs2 = { "flower", "flow", "flight" };
		System.out.println("测试用例2: " + longestCommonPrefix1(strs2));
		
		String[] strs3 = { "dog", "racecar", "car" };
		System.out.println("测试用例3: " + longestCommonPrefix1(strs3));
		
		String[] strs4 = {};
		System.out.println("测试用例4: " + longestCommonPrefix1(strs4));
	}

	/**
	 * 水平比较法
	 * 时间复杂度: O(S)，S是所有字符串字符总数
	 */
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	/**
	 * 垂直比较法
	 * 时间复杂度: O(S)
	 * 空间复杂度: O(1)
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}