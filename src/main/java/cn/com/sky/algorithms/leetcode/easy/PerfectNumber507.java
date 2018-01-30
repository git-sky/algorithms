package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 507. Perfect Number
 * 
 * 
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors(因子) except itself.
 * 
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 * 
 * </pre>
 */
public class PerfectNumber507 {

	@Test
	public void solution() {

		int num = 100000000;
		System.out.println(checkPerfectNumber(num));

	}

	// i从2开始。
	public boolean checkPerfectNumber(int num) {
		if (num <= 2) {
			return false;
		}
		int sum = 1;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i * i != num) {
					sum += num / i;
				}

			}
		}
		return sum == num;
	}

	// i从1开始，多加了num，所以最后要减去num。
	// public boolean checkPerfectNumber(int num) {
	// if (num <= 0) {
	// return false;
	// }
	// int sum = 0;
	// for (int i = 1; i * i <= num; i++) {
	// if (num % i == 0) {
	// sum += i;
	// if (i * i != num) {
	// sum += num / i;
	// }
	//
	// }
	// }
	// return sum - num == num;
	// }

	// 超时。。。
	// public boolean checkPerfectNumber(int num) {
	//
	// int sum = 0;
	// for (int i = 1; i <= num / 2; i++) {
	// if (num % i == 0) {
	// sum += i;
	// }
	// if (sum > num)
	// return false;
	// }
	//
	// return sum == num;
	// }
}
