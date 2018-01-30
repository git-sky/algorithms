package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 最低成本攀登楼梯（动态规划）
 * 
 * 746. Min Cost Climbing Stairs
 * 
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * 
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * 
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * 
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 *
 * </pre>
 */
public class MinCostClimbingStairs746 {

	@Test
	public void solution() {
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost));
	}

	/**
	 * 动态规划
	 * 
	 * Time Complexity: O(N)O(N) where NN is the length of cost.
	 * 
	 * Space Complexity: O(1)O(1), the space used by f1, f2.
	 */
	public int minCostClimbingStairs(int[] cost) {
		int f1 = 0, f2 = 0;
		for (int i = cost.length - 1; i >= 0; --i) {
			int f0 = cost[i] + Math.min(f1, f2);
			f2 = f1;
			f1 = f0;
		}
		return Math.min(f1, f2);
	}

	//
	// public int minCostClimbingStairs(int[] cost) {
	// int a = cost[0];
	// int b = cost[1];
	// int result = Math.min(a, b);
	//
	// for (int i = 2; i <= cost.length; i++) {
	// int c = i == cost.length? 0: cost[i];
	// result = Math.min(a + c, b + c);
	// a = b;
	// b = result;
	// }
	//
	// return result;
	// }
}
