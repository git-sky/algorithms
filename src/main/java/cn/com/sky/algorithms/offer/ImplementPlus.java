package cn.com.sky.algorithms.offer;

import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 
 * 不用加减乘除做加法
 * 
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得适用+，-，* ，./  四则运算符号
 */
public class ImplementPlus {

	@Test
	public void solution() {
		Random r = new Random();
		int a = r.nextInt(100);
		int b = r.nextInt(50);

		int result = plus(a, b);

		System.out.println(a);
		System.out.println(b);
		System.out.println(result);

	}

	/**
	 * 循环实现
	 */
	public int add(int num1, int num2) {

		int sum, carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;

	}

	/**
	 * 递归实现
	 */
	public int plus(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		int r1 = (a ^ b);// 异或,相当于相加不进位
		int r2 = (a & b) << 1;// 与,相当于得到进位
		return plus(r1, r2);

	}
}
