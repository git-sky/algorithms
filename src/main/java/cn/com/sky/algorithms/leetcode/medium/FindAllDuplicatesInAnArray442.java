package cn.com.sky.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 442. Find All Duplicates in an Array
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 * 
 * 
 * </pre>
 */
public class FindAllDuplicatesInAnArray442 {

	@Test
	public void solution() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> list = findDuplicates(nums);
		System.out.println(Arrays.toString(list.toArray()));
	}

	/**
	 * 时间复杂度O(n)
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; ++i) {

			int index = Math.abs(nums[i]) - 1;

			if (nums[index] < 0) {
				res.add(Math.abs(index + 1));
			}

			nums[index] = -nums[index];
		}

		return res;
	}

	// /**
	// * 空间复杂度O(n)
	// *
	// * 时间复杂度O(n)
	// */
	// public List<Integer> findDuplicates(int[] nums) {
	//
	// List<Integer> list = new ArrayList<Integer>();
	//
	// int[] arr = new int[nums.length];
	//
	// for (int i = 0; i < nums.length; i++) {
	// arr[nums[i] - 1]++;
	// }
	//
	// for (int i = 0; i < arr.length; i++) {
	// if (arr[i] >= 2) {
	// System.out.println(i);
	// list.add(i + 1);
	// }
	// }
	//
	// return list;
	// }

}
