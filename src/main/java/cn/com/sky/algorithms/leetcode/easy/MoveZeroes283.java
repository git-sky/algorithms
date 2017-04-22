package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 283. Move Zeroes
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * </pre>
 */
public class MoveZeroes283 {

	@Test
	public void solution() {

		// int[] nums = { 0, 1, 0, 3, 12 };
		int[] nums = { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };

		System.out.println(Arrays.toString(nums));

		moveZeroes(nums);

		// assertTrue(Arrays.equals(nums, expected));
		System.out.println(Arrays.toString(nums));
	}

	public void moveZeroes(int[] nums) {

		int len = nums.length;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				nums[idx++] = nums[i];
			}
		}

		for (int i = idx; i < len; i++) {
			nums[i] = 0;
		}
	}

	// public void moveZeroes(int[] nums) {
	//
	// int firstZero = -1;
	//
	// for (int i = 0; i <= nums.length - 2; i++) {
	// if (nums[i] == 0L) {
	//
	// if (firstZero == -1) {
	// firstZero = i;
	// }
	//
	// if (nums[i + 1] != 0) {
	// for (int j = i; j >= firstZero; j--) {
	// int tmp = nums[j + 1];
	// nums[j + 1] = nums[j];
	// nums[j] = tmp;
	// }
	// firstZero++;
	// // System.out.println(firstZero);
	// // System.out.println(Arrays.toString(nums));
	// }
	// }
	// }
	//
	// }
}
