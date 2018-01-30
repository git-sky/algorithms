package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 
 * 168. Excel Sheet Column Title
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 * 
 * </pre>
 */
public class ExcelSheetColumnTitle168 {

	@Test
	public void solution() {
		int n = 27;
		System.out.println(convertToTitle(n));
	}

	public String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
	}
}
