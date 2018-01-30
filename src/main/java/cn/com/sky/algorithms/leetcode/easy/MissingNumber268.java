package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 268. Missing Number
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * Example 1
 * 
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 
 * 要求：时间复杂度：O(n)，空间复杂度O(1)
 * 
 * </pre>
 */
public class MissingNumber268 {

	@Test
	public void solution() {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int miss = missingNumber(nums);
		System.out.println(miss);
	}

	public int missingNumber(int[] nums) {
		int missing = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		return missing;
	}

	// 高斯算法：等差数列求和公式　Sn=(a1+an)n/2
	// public int missingNumber(int[] nums) {
	// int expectedSum = nums.length * (nums.length + 1) / 2;
	// int actualSum = 0;
	// for (int num : nums)
	// actualSum += num;
	// return expectedSum - actualSum;
	// }

}
