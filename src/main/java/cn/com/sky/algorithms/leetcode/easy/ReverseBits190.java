package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * Related problem: Reverse Integer
 *
 * </pre>
 */
public class ReverseBits190 {

	@Test
	public void solution() {
		int n = 43261596;
		System.out.println("输入: " + n);
		System.out.println("二进制: " + Integer.toBinaryString(n));
		
		int result1 = reverseBits1(n);
		System.out.println("方法1结果: " + result1);
		System.out.println("方法1二进制: " + Integer.toBinaryString(result1));
		
		int result2 = reverseBits2(n);
		System.out.println("方法2结果: " + result2);
		
		int result3 = reverseBits3(n);
		System.out.println("方法3结果: " + result3);
	}

	/**
	 * 方法1：逐位处理
	 */
	public int reverseBits1(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n >>>= 1; // 无符号右移
			if (i < 31) // 最后一位不移位
				result <<= 1;
		}
		return result;
	}

	/**
	 * 方法2：另一种逐位处理方式
	 */
	public int reverseBits2(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			result += n & 1;
			n >>>= 1;
		}
		return result;
	}

	/**
	 * 方法3：使用Java内置函数
	 */
	public int reverseBits3(int n) {
		return Integer.reverse(n);
	}
}