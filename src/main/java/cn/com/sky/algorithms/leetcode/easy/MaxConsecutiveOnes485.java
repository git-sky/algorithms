package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 485. Max Consecutive Ones
 * 
 * Given a binary array, find the maximum number of consecutive(连贯的) 1s in this array.
 * 
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 *     
 * Note:
 * 1.The input array will only contain 0 and 1.
 * 2.The length of input array is a positive integer and will not exceed 10,000
 * 
 * </pre>
 */
public class MaxConsecutiveOnes485 {

	@Test
	public void solution() {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		// 3;

		int n = findMaxConsecutiveOnes(nums);
		System.out.println(n);
	}

	/**
	 * solution 1
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxHere = 0, max = 0;
		for (int n : nums)
			max = Math.max(max, maxHere = (n == 0 ? 0 : maxHere + 1));
		return max;
	}

	/**
	 * solution 2
	 */
	// public int findMaxConsecutiveOnes(int[] nums) {
	//
	// int max = 0;
	// int curMax = 0;
	//
	// for (int i = 0; i < nums.length; i++) {
	// if (nums[i] == 0) {
	// if (curMax > max) {
	// max = curMax;
	// }
	// curMax = 0;
	// continue;
	// }
	// curMax++;
	// }
	//
	// return max > curMax ? max : curMax;
	// }
}
