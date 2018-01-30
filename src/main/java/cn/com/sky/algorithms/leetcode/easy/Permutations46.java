package cn.com.sky.algorithms.leetcode.easy;

import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 46. Permutations(全排列)
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 
 * 
 * </pre>
 */
public class Permutations46 {

	@Test
	public void solution() {

		int[] nums = { 1, 2, 3 };

		permute(nums);
	}

	public List<List<Integer>> permute(int[] nums) {

	}

}
