package cn.com.sky.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int[] nums1 = { 4, 6, 7, 7 };
		List<List<Integer>> result1 = findSubsequences(nums1);
		System.out.println("测试用例1: " + result1);
		
		int[] nums2 = { 1, 2, 3, 4 };
		List<List<Integer>> result2 = findSubsequences(nums2);
		System.out.println("测试用例2: " + result2);
		
		int[] nums3 = { 4, 4, 3, 2, 1 };
		List<List<Integer>> result3 = findSubsequences(nums3);
		System.out.println("测试用例3: " + result3);
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, 0, new ArrayList<>(), result);
		return result;
	}
	
	private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
		if (path.size() >= 2) {
			result.add(new ArrayList<>(path));
		}
		
		Set<Integer> used = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			// 跳过重复元素
			if (used.contains(nums[i])) {
				continue;
			}
			
			// 如果路径不为空且当前元素小于路径最后一个元素，跳过
			if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
				continue;
			}
			
			used.add(nums[i]);
			path.add(nums[i]);
			backtrack(nums, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}
}