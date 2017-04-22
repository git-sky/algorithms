package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * (判断字符串字符是否在一行)
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * 1.You may use one character in the keyboard more than once.
 * 2.You may assume the input string will only contain letters(字母) of alphabet.
 * </pre>
 */
public class KeyboardRow500 {
	@Test
	public void solution() {
		String[] words = { "Hello", "Alaska", "Dad", "Peace" };
		// String[] words = { "a", "b" };
		String[] n = findWords(words);
		System.out.println(Arrays.toString(n));
	}

	public String[] findWords(String[] words) {
		char[] first = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		char[] second = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
		char[] third = { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };

		List<String> list = new ArrayList<>();

		for (String word : words) {
			char[] targetLine = null;
			boolean findOut = false;
			boolean istTarget = true;
			char cf = word.toCharArray()[0];
			if (!findOut) {
				if ((targetLine = findTargetLine(first, cf)) == null) {
					if ((targetLine = findTargetLine(second, cf)) == null) {
						targetLine = findTargetLine(third, cf);
					}
				}
				if (targetLine != null) {
					findOut = true;
				}
			}
			if (!findOut) {
				return null;
			}

			for (char c : word.toCharArray()) {
				if (!findInTarget(targetLine, c)) {
					istTarget = false;
					break;
				}
			}
			if (istTarget) {
				list.add(word);
			}
		}
		return list.toArray(new String[] {});

	}

	private boolean findInTarget(char[] targetLine, char c) {
		for (char target : targetLine) {
			if (eq(c, target)) {
				return true;
			}
		}
		return false;
	}

	private boolean eq(char c, char target) {
		char b = (char) (target - 32);
		return c == target || c == b;
	}

	private char[] findTargetLine(char[] first, char c) {
		char[] targetLine = null;
		for (char target : first) {
			if (eq(c, target)) {
				targetLine = first;
				break;
			}
		}
		return targetLine;
	}
}
