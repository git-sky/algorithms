package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 爬N层台阶，有多少种走法。
 * 
 * 70. Climbing Stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * 
 * Example 1:
 * 
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * 
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * 
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * 
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * </pre>
 */
public class ClimbingStairs70 {

	@Test
	public void solution() {
		int n = 10;
		System.out.println(climbStairs(n));
	}

	/**
	 * 方案0：菲波那楔数列
	 * 
	 * Time complexity : O(n). Single loop upto n is required to calculate n ​th ​​ fibonacci
	 * number.
	 * 
	 * Space complexity : O(1). Constant space is used.
	 */
	// public int climbStairs(int n) {
	// if (n == 1) {
	// return 1;
	// }
	// int first = 1;
	// int second = 2;
	// for (int i = 3; i <= n; i++) {
	// int third = first + second;
	// first = second;
	// second = third;
	// }
	// return second;
	// }

	/**
	 * 方案1：动态规划
	 * 
	 * Time complexity : O(n). Single loop upto n.
	 * 
	 * Space complexity : O(n). dp array of size n is used.
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * 方案2：保存计算结果，不重复计算。（备忘录算法）
	 * 
	 * Time complexity : O(n) Size of recursion tree can go upto n.
	 * 
	 * Space complexity : O(n) The depth of recursion tree can go upto n.
	 */
	// public int climbStairs(int n) {
	// int[] memo = new int[n + 1];
	// return climb_Stairs(0, n, memo);
	// }
	//
	// public int climb_Stairs(int i, int n, int[] memo) {
	// if (i > n) {
	// return 0;
	// }
	// if (i == n) {
	// return 1;
	// }
	// if (memo[i] > 0) {
	// return memo[i];
	// }
	// memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
	// return memo[i];
	// }

	/**
	 * 方案3：递归，时间复杂度太高。
	 * 
	 * Time complexity : O(2^n), Size of recursion tree will be 2^n.
	 * 
	 * Space complexity : O(n). The depth of the recursion tree can go upto n.
	 */
	// public int climbStairs(int n) {
	// climb_Stairs(0, n);
	// }
	// public int climb_Stairs(int i, int n) {
	// if (i > n) {
	// return 0;
	// }
	// if (i == n) {
	// return 1;
	// }
	// return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	// }

	// 递归： Time Limit Exceeded
	// public int climbStairs(int n) {
	//
	// if (n == 1) {
	// return 1;
	// } else if (n == 2) {
	// return 2;
	// }
	// return climbStairs(n - 1) + climbStairs(n - 2);
	// }
}
