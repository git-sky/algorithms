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
public class SwapTwoNumber {

	@Test
	public void solution() {
		Random r = new Random();
		int a = r.nextInt(100);
		int b = r.nextInt(50);

		// System.out.println(a);
		// System.out.println(b);

		// swapWithPlus(a, b);
		swapWithXor(a, b);

		// System.out.println(a);
		// System.out.println(b);

	}

	public void swapWithPlus(int a, int b) {

		System.out.println(a);
		System.out.println(b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(a);
		System.out.println(b);
	}

	public void swapWithXor(int a, int b) {

		System.out.println(a);
		System.out.println(b);

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);
	}
}
