package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
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

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}

}
