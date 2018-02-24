package cn.com.sky.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * 
 * 219. Contains Duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * </pre>
 */
public class ContainsDuplicateII219 {

	@Test
	public void solution() {

		int[] nums = { 1, 3, 5, 7, 5, 8, 2, 3, 5, 6 };
		int k = 3;

		System.out.println(containsNearbyDuplicate(nums, k));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}

}
