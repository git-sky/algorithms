package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 *
 *  26. Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * Example:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 *
 * </pre>
 */
public class RemoveDuplicatesFromSortedArray26 {

	@Test
	public void solution() {

		int[] nums = { 1, 1, 2 };

		int count = removeDuplicates(nums);
		System.out.println(count);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * Time complextiy : O(n) Assume that n is the length of array. Each of i and j traverses at
	 * most n steps.
	 * 
	 * Space complexity : O(1) .
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
