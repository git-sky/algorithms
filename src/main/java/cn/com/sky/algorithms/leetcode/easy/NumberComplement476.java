package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * Given a positive（正数） integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * 1.The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * 2.You could assume no leading zero bit in the integer’s binary representation.
 * 
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * 
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * 
 * </pre>
 */
public class NumberComplement476 {
	@Test
	public void solution() {
		int n = findComplement(1);
		System.out.println(n);
	}

	public int findComplement(int num) {
		int temp = num;
		int mask = 1;
		while (temp > 0) {
			temp >>= 1;
			mask <<= 1;
		}
		return ((mask - 1) ^ num);
	}
}
