package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * 
 * 217. Contains Duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 *
 * </pre>
 */
public class ContainsDuplicate217 {

	@Test
	public void solution() {
		int[] nums = { 1, 2, 3, 1 };
		boolean b = containsDuplicate(nums);
		System.out.println(b);
	}

	public boolean containsDuplicate(int[] nums) {

		if (nums.length <= 1) {
			return false;
		}
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == nums[i - 1])
				return true;
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums) {

		Set<Integer> set = new HashSet<>(nums.length);
		for (int x : nums) {
			if (set.contains(x))
				return true;
			set.add(x);
		}
		return false;
	}

}
