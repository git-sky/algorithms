package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 747. Largest Number At Least Twice of Others
 * 
 * 
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *  
 * 
 * Example 2:
 * 
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * 
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * 
 * </pre>
 */

public class LargestNumberAtLeastTwiceOfOthers747 {

	@Test
	public void solution() {
		int[] A = { 3, 1};
		System.out.println(dominantIndex(A));
	}

	/**
	 * 遍历一次
	 */
	public int dominantIndex(int[] nums) {
		int max = nums[0];
		int secondMax = 0;
		int index = 0;

		for (int i = 1; i < nums.length; i++) {
			int n = nums[i];
			if (n > max) {
				index = i;
				secondMax = max;
				max = n;
			} else if (n > secondMax) {
				secondMax = n;
			}
		}
		return max >= 2 * secondMax ? index : -1;
	}

	/**
	 * 遍历两次
	 */
	// public int dominantIndex(int[] nums) {
	// int maxIndex = 0;
	// for (int i = 0; i < nums.length; ++i) {
	// if (nums[i] > nums[maxIndex])
	// maxIndex = i;
	// }
	// for (int i = 0; i < nums.length; ++i) {
	// if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
	// return -1;
	// }
	// return maxIndex;
	// }

}
