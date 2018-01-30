package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 给定非空非负整数数组，数组的度是指数组中出现次数最多元素的个数。寻找最小连续子数组，使得子数组的度与原数组的度相同。返回子数组的长度。
 * 
 * 697. Degree of an Array
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * 
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * 
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * 
 * </pre>
 */
public class DegreeOfAnArray697 {

	@Test
	public void solution() {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(findShortestSubArray(A));
	}

	public int findShortestSubArray(int[] nums) {

	}

}
