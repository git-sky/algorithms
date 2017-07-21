package cn.com.sky.algorithms.offer;

import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 11.打印1到最大的n位数
 * 
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */
public class PrintN {

	@Test
	public void solution() {
		Random r = new Random();
		int n =  5;
		System.out.println("n:" + n);
		// print1(n);

		Print1ToMaxOfNDigits(n);
	}

	/**
	 * 大数问题
	 */
	public void Print1ToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n + 1];
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}
		number[n] = '\0';

		// Increment实现在表示数字的字符串number上增加1
		while (!Increment(number)) {
			// PrintNumber负责打印出number
			PrintNumber(number);
		}

		number = null;
	}

	private boolean Increment(char[] number) {
		boolean isOverflow = false;
		int takeOver = 0;
		int length = number.length - 1;

		for (int i = length - 1; i >= 0; i--) {
			int sum = number[i] - '0' + takeOver;
			if (i == length - 1) {
				sum++;
			}

			if (sum >= 10) {
				if (i == 0) {
					// 标识已经溢出了
					isOverflow = true;
				} else {
					sum -= 10;
					takeOver = 1;
					number[i] = (char) ('0' + sum);
				}
			} else {
				number[i] = (char) ('0' + sum);
				break;
			}
		}

		return isOverflow;
	}

	private void PrintNumber(char[] number) {
		boolean isBeginning0 = true;

		for (int i = 0; i < number.length; i++) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}

			if (!isBeginning0) {
				// Console.Write("{0}", number[i]);
				System.out.print(number[i]);
			}
		}

		// Console.Write("\t");
		System.out.println("      ");
	}

	private char[] init(int n) {

		char[] c = new char[n + 1];

		c[0] = '0';
		for (int i = 1; i < n; i++) {
			c[i] = '0';
		}

		return c;

	}

	/**
	 * int可以标识的范围。
	 */
	public void print1(int n) {

		int i = 0;
		int number = 1;
		while (i++ < n) {
			number *= 10;
		}

		for (int j = 1; j < number; j++) {
			System.out.println(j);
		}
	}

}
