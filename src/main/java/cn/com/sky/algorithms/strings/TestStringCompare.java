package cn.com.sky.algorithms.strings;

import org.junit.Test;

/**
 * <pre>
 * 朴素字符串匹配（Brute Force）【Easy】
 *
 * 题目：在主串中查找子串的位置
 *
 * 算法原理（暴力匹配）：
 * 1. 从主串第一个字符开始，与子串逐个比较
 * 2. 如果匹配失败，主串回溯到下一个位置重新比较
 * 3. 直到找到匹配或主串遍历完毕
 *
 * 时间复杂度：O(m*n)，m为主串长度，n为子串长度
 * 空间复杂度：O(1)
 *
 * 缺点：当出现大量部分匹配时，效率很低
 * 改进：使用KMP算法，时间复杂度O(m+n)
 * </pre>
 */
public class TestStringCompare {

	@Test
	public void compare() {

		String mainStr = "abcdefgoogleaaaaa";
		String subStr = "googles";

		int n = mainStr.length();
		int m = subStr.length();

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (mainStr.charAt(i) == subStr.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		// System.out.println(i);
		// System.out.println(j);
		if (j >= m) {
			System.out.println("matched............");
			System.out.println(i - m);

		} else {
			System.out.println("not matched...........");

		}
	}

}