package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 448. Find All Numbers Disappeared(消失的) in an Array
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * </pre>
 */
public class FindAllNumbersDisappearedInAnArray448 {

	@Test
	public void solution() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1, 1 };

		List<Integer> list = findDisappearedNumbers(nums);
		System.out.println(Arrays.toString(list.toArray()));
	}

	/**
	 * solution 1
	 * 
	 * 最优解决方案
	 * 
	 * 解题思路:每个位置的元素取反，最后正数的就是所求。
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;// Subtracting by 1 is so that we can map all integers
											// from 1 to n using the current array (array indexing
											// starts at 0 so value 1 in the array maps to 0 index
											// etc.)
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
			System.out.println(val + ":" + nums[val]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}

	/**
	 * solution 2
	 */
	// public List<Integer> findDisappearedNumbers(int[] nums) {
	// List<Integer> res = new ArrayList<>();
	// int n = nums.length;
	// for (int i = 0; i < nums.length; i++)
	// nums[(nums[i] - 1) % n] += n;
	//
	// for (int i = 0; i < nums.length; i++)
	// if (nums[i] <= n)
	// res.add(i + 1);
	// return res;
	// }

	/**
	 * solution 3
	 */
	// public List<Integer> findDisappearedNumbers(int[] nums) {
	// List<Integer> list = new ArrayList<>();
	//
	// BitSet bs = new BitSet(nums.length);
	// for (int n : nums) {
	// bs.set(n);
	// }
	// for (int i = 1; i <= nums.length; i++) {
	// if (!bs.get(i)) {
	// list.add(i);
	// }
	// }
	//
	// return list;
	// }
}
