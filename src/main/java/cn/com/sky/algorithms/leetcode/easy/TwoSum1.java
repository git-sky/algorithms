package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 
 * 1. Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * </pre>
 */
public class TwoSum1 {

	@Test
	public void solution() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] sum = twoSum(nums, target);
		System.out.println(Arrays.toString(sum));
	}

//	public int[] twoSum(int[] nums, int target) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			map.put(nums[i], i);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			int complement = target - nums[i];
//			if (map.containsKey(complement) && map.get(complement) != i) {
//				return new int[] { i, map.get(complement) };
//			}
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}
//
//	public int[] twoSum(int[] nums, int target) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			int complement = target - nums[i];
//			if (map.containsKey(complement)) {
//				return new int[] { map.get(complement), i };
//			}
//			map.put(nums[i], i);
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
