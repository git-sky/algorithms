package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 307. Range Sum Query - Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * 
 * Example:
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * 
 * </pre>
 */
public class RangeSumQueryMutable307 {

	@Test
	public void solution() {

		int[] nums = { 1, 3, 5 };

		NumArray obj = new NumArray(nums);

		int a = obj.sumRange(0, 2);
		System.out.println(a);

		obj.update(1, 2);

		int b = obj.sumRange(0, 2);
		System.out.println(b);

	}

	class NumArray {

		private int[] b;
		private int len;
		private int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
			double l = Math.sqrt(nums.length);
			len = (int) Math.ceil(nums.length / l);
			b = new int[len];
			for (int i = 0; i < nums.length; i++)
				b[i / len] += nums[i];
		}

		public int sumRange(int i, int j) {
			int sum = 0;
			int startBlock = i / len;
			int endBlock = j / len;
			if (startBlock == endBlock) {
				for (int k = i; k <= j; k++)
					sum += nums[k];
			} else {
				for (int k = i; k <= (startBlock + 1) * len - 1; k++)
					sum += nums[k];
				for (int k = startBlock + 1; k <= endBlock - 1; k++)
					sum += b[k];
				for (int k = endBlock * len; k <= j; k++)
					sum += nums[k];
			}
			return sum;
		}

		public void update(int i, int val) {
			int b_l = i / len;
			b[b_l] = b[b_l] - nums[i] + val;
			nums[i] = val;
		}
	}

}
