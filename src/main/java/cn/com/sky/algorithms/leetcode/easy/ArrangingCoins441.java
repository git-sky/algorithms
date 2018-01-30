package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 441. Arranging Coins
 * 
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * 
 * 
 * </pre>
 */
public class ArrangingCoins441 {

	@Test
	public void solution() {
		int n = 8;
		System.out.println(arrangeCoins(n));
	}

	public int arrangeCoins(int n) {
		int start = 0;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) >>> 1;
			if ((0.5 * mid * mid + 0.5 * mid) <= n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
	}
	
	// Time Limit Exceeded
	// public int arrangeCoins(int n) {
	//
	// if (n == 0)
	// return 0;
	//
	// int sum = 0;
	// int i = 0;
	// for (i = 1; i <= n; i++) {
	// sum += i;
	// if (sum >= n) {
	// break;
	// }
	// }
	// return sum == n ? i : i - 1;
	// }

}
