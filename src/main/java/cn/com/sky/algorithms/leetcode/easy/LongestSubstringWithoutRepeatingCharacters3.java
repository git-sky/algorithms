package cn.com.sky.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * 
 * 求字符串中最长不重复子串长度.
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

	@Test
	public void solution() {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

	/**
	 * <pre>
	 * 使用hashset实现
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
	 * Space complexity : O(min(m, n)). Same as the previous approach. We need O(k) space for the sliding window, where k is the size of the Set. The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	/**
	 * 使用hashmap实现
	 */
	// public int lengthOfLongestSubstring(String s) {
	// int n = s.length(), ans = 0;
	// Map<Character, Integer> map = new HashMap<>(); // current index of character
	// // try to extend the range [i, j]
	// for (int j = 0, i = 0; j < n; j++) {
	// if (map.containsKey(s.charAt(j))) {
	// i = Math.max(map.get(s.charAt(j)), i);
	// }
	// ans = Math.max(ans, j - i + 1);
	// map.put(s.charAt(j), j + 1);
	// }
	// return ans;
	// }
}
