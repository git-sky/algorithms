package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 统计小于N的质数。
 * 质数（prime number）又称素数，有无限个。质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数的数称为质数。
 * 100以内质数表: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
 * https://leetcode.com/problems/count-primes/#/description
 * 埃拉托色尼筛选法(the Sieve of Eratosthenes)简称埃氏筛法，是古希腊数学家埃拉托色尼(Eratosthenes)提出的一种筛选法。 是针对自然数列中的自然数而实施的，用于求一定范围内的质数。
 * 
 * 
 * 204. Count Primes
 * 
 * Description:
 * 
 * Count the number of prime numbers(质数) less than a non-negative(非负的；正的) number, n.
 * 
 * </pre>
 */
public class CountPrimes204 {

	@Test
	public void solution() {
		int n = countPrimes(100);
		System.out.println(n);
	}

	/**
	 * 时间复杂度
	 * 
	 * 空间复杂度O(n)
	 */
	public int countPrimes(int n) {

		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		return count;
	}

	/**
	 * 时间复杂度 O(n^1.5)
	 */
	// public int countPrimes(int n) {
	// int count = 0;
	// for (int i = 1; i < n; i++) {
	// if (isPrime(i))
	// count++;
	// }
	// return count;
	// }
	//
	// private boolean isPrime(int num) {
	// if (num <= 1)
	// return false;
	// // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
	// // to avoid repeatedly calling an expensive function sqrt().
	// for (int i = 2; i * i <= num; i++) {
	// if (num % i == 0)
	// return false;
	// }
	// return true;
	// }

	/**
	 * 时间复杂度 O(n^2)
	 */
	// public int countPrimes(int n) {
	// int result = 0;
	// for (int i = 2; i < n; i++) {
	// boolean flag = isPrime(i);
	// if (flag) {
	// System.out.println(i);
	// result++;
	// }
	// }
	// return result;
	// }
	//
	// private boolean isPrime(int n) {
	// for (int i = 2; i < n; i++) {
	// int r = n % i;
	// if (r == 0) {// 不是质数
	// return false;
	// }
	// }
	// return true;
	// }
}
