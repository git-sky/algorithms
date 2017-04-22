package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 520. Detect Capital
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * 
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 
 * 1.All letters in this word are capitals, like "USA".
 * 2.All letters in this word are not capitals, like "leetcode".
 * 3.Only the first letter in this word is capital if it has more than one letter, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * Example 1:
 * Input: "USA"
 * Output: True
 * 
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * 
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * 
 * 
 * </pre>
 */

public class DetectCapital520 {

	// A-Z 65-90
	// a-z 97-122
	@Test
	public void solution() {
		String[] words = { "USA", "leetcode", "Google", "FlAaG", "AAbb" };
		for (String word : words) {
			boolean b = detectCapitalUse(word);
			System.out.println(b);
		}
	}

	/**
	 * 正则表达式
	 */
	// public boolean detectCapitalUse(String word) {
	// return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	// }

	/**
	 * solution
	 * 
	 */
	public boolean detectCapitalUse(String word) {
		int cnt = 0;
		for (char c : word.toCharArray()) {
			if ('Z' - c >= 0) {
				cnt++;
			}
		}
		return ((cnt == 0 || cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
	}

	/**
	 * solution
	 */
	// public boolean detectCapitalUse(String word) {
	// int firstLetter = 0;
	// int middleLetter = 0;
	// for (char c : word.toCharArray()) {
	// if (firstLetter == 0) {
	// if (c >= 97) {
	// firstLetter = 1;// 小写字母
	// } else if (c <= 90) {
	// firstLetter = -1;// 大写字母
	// }
	// } else if (firstLetter == 1) {// 第一个是小写
	// if (c <= 90)
	// return false;
	//
	// } else if (firstLetter == -1) {// 第一个是大写
	// int curLetter = c >= 97 ? 1 : -1;
	// if (middleLetter == 0) {
	// middleLetter = curLetter;
	// }
	// if (middleLetter != 0) {
	// if (curLetter != middleLetter)
	// return false;
	// }
	// }
	// }
	// return true;
	// }

}
