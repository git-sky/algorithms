package cn.com.sky.algorithms.strings;

import org.junit.Test;

/**
 * 朴素的模式匹配算法
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
