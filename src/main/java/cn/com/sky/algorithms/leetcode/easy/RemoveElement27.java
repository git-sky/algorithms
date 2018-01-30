package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 给定数组和值,删除该值的所有实例并返回新的长度。
 * 
 * 27. Remove Element
 * 
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * 
 * </pre>
 */
public class RemoveElement27 {

	@Test
	public void solution() {

		int[] nums = { 3, 2, 2, 3 };
		int val = 3;

		int count = removeElement(nums, val);
		System.out.println(count);
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

}
