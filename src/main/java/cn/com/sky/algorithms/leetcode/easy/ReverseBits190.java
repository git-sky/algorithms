package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 190. Reverse Bits
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * 
 * </pre>
 */
public class ReverseBits190 {

	@Test
	public void solution() {

		int n = 43261596;

		int count = reverseBits(n);
		System.out.println(count);
	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {

	}
}
