package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * 
 * 给一个整数,判断它是不是2的N(N>=0,整数)次方。
 * 
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 */
public class PowerOfTwo231 {

	@Test
	public void solution() {
		int n = 1024;
		System.out.println(isPowerOfTwo(n));
	}

	public boolean isPowerOfTwo(int n) {
		return n > 0 && ((n - 1) & n) == 0;
	}

	// public boolean isPowerOfTwo(int n) {
	// if (n <= 0)
	// return false;
	//
	// int ones = 0;
	// for (int i = 1; i <= 32; ++i) {
	// ones += n & 1;
	// n = n >> 1;
	// }
	// return ones == 1;
	// }

	// 二进制中，"1"的个数是1，则符合。
	// public boolean isPowerOfTwo(int n) {
	// return n > 0 && Integer.bitCount(n) == 1;
	// }

	// 普通方式
	// public boolean isPowerOfTwo(int n) {
	//
	// if (n == 1)
	// return true;
	//
	// while (n > 2) {
	// if (n % 2 != 0) {
	// break;
	// }
	// n /= 2;
	// }
	// if (n == 2)
	// return true;
	// else
	// return false;
	// }
}
