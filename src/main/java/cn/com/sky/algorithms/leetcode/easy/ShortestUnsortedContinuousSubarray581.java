package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 581. Shortest Unsorted Continuous Subarray
 * 
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * 
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * 
 * 
 * </pre>
 */
public class ShortestUnsortedContinuousSubarray581 {

	@Test
	public void solution() {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };

		System.out.println(findUnsortedSubarray(nums));
	}

	public int findUnsortedSubarray(int[] A) {

		int n = A.length;
		int begin = -1;
		int end = -2;
		int min = A[n - 1];
		int max = A[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, A[i]);
			min = Math.min(min, A[n - 1 - i]);

			if (A[i] < max)
				end = i;
			if (A[n - 1 - i] > min)
				begin = n - 1 - i;
		}
		return end - begin + 1;
	}
}
