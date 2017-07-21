package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 628. Maximum Product of Three Numbers
 * 
 * Given an integer array, find three numbers whose product(乘积) is maximum and output the maximum product.
 * 
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * 1.The length of the given array will be in range [3,10^4] and all elements are in the range [-1000, 1000].
 * 2.Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 * 
 * </pre>
 */
public class MaximumProductOfThreeNumbers628 {
	@Test
	public void solution() {
		int[] nums = { 1, 2, 3, 4 };
		int n = maximumProduct(nums);
		System.out.println(n);
	}

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		// One of the Three Numbers is the maximum value in the array.

		int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
		int b = nums[0] * nums[1] * nums[nums.length - 1];
		return a > b ? a : b;
	}

}
