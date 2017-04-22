package cn.com.sky.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 491. Increasing Subsequences
 * 
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 * 
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * 1.The length of the given array will not exceed 15.
 * 2.The range of integer in the given array is [-100,100].
 * 3.The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * 
 * </pre>
 * 
 */
public class IncreasingSubsequences491 {
	@Test
	public void solution() {
		int[] nums = { 4, 6, 7, 7 };
		List<List<Integer>> n = findSubsequences(nums);
		System.out.println(Arrays.asList(n));
	}

	// TODO
	public List<List<Integer>> findSubsequences(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();

		return list;

	}

}
