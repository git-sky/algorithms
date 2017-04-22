package cn.com.sky.algorithms.others;

import java.util.Scanner;

/**
 * 大整数相乘
 */
public class DealBigData {
	public String mul(String str1, String str2) {
		StringBuffer bstr = new StringBuffer();
		int i = 0, j = 0;
		for (i = 0; i < str1.length() + str2.length(); i++) {
			bstr.append('0');
		}
		int k = bstr.length() - 1, add = 0, temp = 0;
		for (j = str2.length() - 1; j >= 0; j--) {
			if (str2.charAt(j) != '0') {
				for (i = str1.length() - 1; i >= 0; i--) {
					k = i + j + 1;
					temp = (str2.charAt(j) - '0') * (str1.charAt(i) - '0') + (bstr.charAt(k) - '0');
					bstr.setCharAt(k--, (char) ('0' + temp % 10));
					add = temp / 10;
					while (add != 0) {
						temp = add + bstr.charAt(k) - '0';
						bstr.setCharAt(k--, (char) ('0' + temp % 10));
						add = temp / 10;
					}
				}
			}
		}
		return bstr.substring(firstNotZeroIndex(bstr));
	}

	private int firstNotZeroIndex(StringBuffer str) {
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) != '0')
				return i;
		return str.length() - 1;
	}

	public static void main(String[] args) {
		DealBigData mul = new DealBigData();
		Scanner cin = new Scanner(System.in);

		System.out.print("请输入第一个整数：");
		String str1 = cin.next();
		System.out.print("请输入第二个整数：");
		String str2 = cin.next();
		System.out.print("结果是：");
		System.out.println(mul.mul(str1, str2));

		cin.close();
	}
}
