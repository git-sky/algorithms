package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 191. Number of 1 Bits
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * </pre>
 */
public class NumberOf1Bits {

	@Test
	public void solution() {
		int n = 1024;
		System.out.println(hammingWeight(n));
	}

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {

		int sum = 0;
		for (int i = 1; i <= 32; ++i) {
			sum += n & 1;
			n = n >> 1;
		}
		return sum;
	}

	// public int hammingWeight(int n) {
	// int sum = 0;
	// while (n != 0) {
	// sum++;
	// n &= (n - 1);
	// }
	// return sum;
	// }

}
