package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * 大数据相加
 */
public class AddStrings415 {

	@Test
	public void solution() {

		String num1 = "123";
		String num2 = "999123";

		String s = addStrings(num1, num2);
		System.out.println(s);

	}

	// 方案1
	// public String addStrings(String num1, String num2) {
	// StringBuilder sb = new StringBuilder();
	// int carry = 0;
	// for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--,
	// j--) {
	// int x = i < 0 ? 0 : num1.charAt(i) - '0';
	// int y = j < 0 ? 0 : num2.charAt(j) - '0';
	// sb.append((x + y + carry) % 10);
	// carry = (x + y + carry) / 10;
	// }
	// return sb.reverse().toString();
	// }

	// 方案2
	public String addStrings(String digit1, String digit2) {
		String result = "";
		char[] s1 = digit1.toCharArray();
		char[] s2 = digit2.toCharArray();
		char[] jg = new char[Math.max(s1.length, s2.length) + 1];// 结果数组比最常参数再长一位
		int carry = 0;// 表示进位
		for (int i = 0; i < jg.length; i++) {
			char a1 = '0';
			char a2 = '0';
			if (s1.length - 1 - i >= 0) {
				a1 = s1[s1.length - 1 - i];
			}
			if (s2.length - 1 - i >= 0) {
				a2 = s2[s2.length - 1 - i];
			}
			if (a1 < '0' || a1 > '9' || a2 < '0' || a2 > '9') {
				throw new RuntimeException("Parameters can only contain Numbers.");
			}
			char a = (char) (a1 + a2 - '0' + carry);
			if (a > '9') {
				carry = 1;
				a = (char) (a - 10);
			} else {
				carry = 0;
			}
			jg[jg.length - 1 - i] = a;
		}
		for (int i = 0; i < jg.length; i++) {
			if (i == 0 && jg[i] == '0') {
			} else {
				result += jg[i];
			}
		}
		return result;
	}

}
