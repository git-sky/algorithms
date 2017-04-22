package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 371. Sum of Two Integers
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * </pre>
 */
public class SumofTwoIntegers371 {

	@Test
	public void solution() {
		int a = -1;
		int b = -1000;
		int n = getSum(a, b);
		System.out.println(n);
	}

	public int getSum(int a, int b) {

		return add(a, b);

	}

	/**
	 * 异或是1的不需要进位，与操作是1的需要进位。一直递归调用，直到不需要进位，也就是与操作为0的时候。
	 */
	private int add(int a, int b) {
		if (0 == b)
			return a;
		int cxor = a ^ b;
		int cand = a & b;
		return add(cxor, cand << 1);
	}

}
