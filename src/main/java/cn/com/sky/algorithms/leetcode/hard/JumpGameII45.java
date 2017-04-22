package cn.com.sky.algorithms.leetcode.hard;

import org.junit.Test;

/**
 * <pre>
 * 
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:
 * You can assume that you can always reach the last index.
 * 
 * </pre>
 * 
 */
public class JumpGameII45 {

	@Test
	public void solution() {
		int[] nums = { 2, 3, 1, 1, 4 };
		int n = jump(nums);
		System.out.println(n);
	}

	public int jump(int[] A) {
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;

		for (int i = 0; i < A.length - 1; i++) {
			current_jump_max = Math.max(current_jump_max, i + A[i]);
			if (i == last_jump_max) {
				step_count++;
				last_jump_max = current_jump_max;
			}
		}

		return step_count;
	}

	// public int jump(int[] nums) {
	// if (nums.length <= 1)
	// return 0;
	// int right = 0 + nums[0], step = 1;
	// int cover = right;
	// for (int i = 0; i <= right; ++i) {
	// if (right >= nums.length - 1)
	// return step;
	// if (nums[i] + i > cover)
	// cover = nums[i] + i;
	// if (i == right) {
	// right = cover;
	// ++step;
	// }
	// }
	// return 0;
	// }

	/**
	 * O(n), BFS solution
	 */
	// public int jump(int[] nums) {
	//
	// int n = nums.length;
	// if (n < 2)
	// return 0;
	//
	// int level = 0;
	// int currentMax = 0;
	// int i = 0;
	// int nextMax = 0;
	//
	// while (currentMax - i + 1 > 0) { // nodes count of current level>0
	// level++;
	// for (; i <= currentMax; i++) { // traverse current level , and update the max reach of
	// // next level
	// nextMax = max(nextMax, nums[i] + i);
	// if (nextMax >= n - 1)
	// return level; // if last element is in level+1, then the min jump=level
	// }
	// currentMax = nextMax;
	// }
	// return 0;
	// }
	//
	// private int max(int a, int b) {
	// if (a > b)
	// return a;
	// return b;
	// }

}
