package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 171. Excel Sheet Column Number
 * 
 * Related to question Excel Sheet Column Title.
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 * AB -> 28
 * 
 * 
 * 
 */
public class ExcelSheetColumnNumber171 {

	@Test
	public void solution() {

		String s = "AA";

		System.out.println(titleToNumber(s));

	}

	public int titleToNumber(String s) {

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}

		return result;
	}
}
