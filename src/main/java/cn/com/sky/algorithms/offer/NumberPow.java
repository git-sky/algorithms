package cn.com.sky.algorithms.offer;

import org.junit.Test;

/**
 * <pre>
 * 
 * 10.数值的整数次方
 * 
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 
 * 
 */
public class NumberPow {

	@Test
	public void solution() {

		for (int i = 1; i < 15; i++) {
			double result = power(2.1d, i);
			System.out.println(result);
		}
	}

	/**
	 * 没有考虑exponent小于0的情况.
	 */
	public double power(double base, int exponent) {
		// return Math.pow(base, exponent);
		double total = 1.0;
		for (int i = 1; i <= exponent; i++) {
			total *= base;
		}
		return total;
	}

}
