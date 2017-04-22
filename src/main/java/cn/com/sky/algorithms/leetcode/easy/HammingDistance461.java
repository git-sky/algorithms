package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 461. Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 2^31.
 * 
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are different.
 * 
 * 
 * </pre>
 */
public class HammingDistance461 {

	@Test
	public void solution() {
		int x = 1;
		int y = 4;
		int n = hammingDistance(x, y);
		System.out.println(n);
	}

	/**
	 * <pre>
	 * 
	 * Java中有三种移位运算符
	 * <<  :  左移运算符，num << 1,相当于num乘以2
	 * >>  :  右移运算符，num >> 1,相当于num除以2
	 * >>> :  无符号右移，忽略符号位，空位都以0补齐
	 * 
	 * >>   表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
	 * >>>  表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
	 * 
	 * </pre>
	 * 
	 */
	public int hammingDistance(int x, int y) {
		int result = 0;
		Integer z = x ^ y;
		do {
			result += z & 1;
		} while ((z >>>= 1) > 0);

		return result;
	}

	/**
	 * 转换成字符串
	 */
	// public int hammingDistance(int x, int y) {
	// int result = 0;
	// Integer z = x ^ y;
	//
	// String xStr = Integer.toBinaryString(x);
	// String yStr = Integer.toBinaryString(y);
	// String zStr = Integer.toBinaryString(z);
	// System.out.println(xStr);
	// System.out.println(yStr);
	// System.out.println(zStr);
	//
	// for (char c : zStr.toCharArray()) {
	// if (c == '1') {
	// result++;
	// }
	// }
	// return result;
	// }

	/**
	 * Integer方法实现
	 */
	// public int hammingDistance(int x, int y) {
	// return Integer.bitCount(x ^ y);
	// }
}
