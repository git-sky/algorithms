package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 303. Range Sum Query - Immutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 * </pre>
 */
public class RangeSumQueryImmutable303 {

	@Test
	public void solution() {

		int[] nums = { -2, 0, 3, -5, 2, -1 };

		NumArray obj = new NumArray(nums);

		int i = 2;
		int j = 5;
		int result = obj.sumRange(i, j);

		System.out.println(result);

	}

	class NumArray {
		private int[] sum;

		public NumArray(int[] nums) {
			sum = new int[nums.length + 1];
			for (int i = 0; i < nums.length; i++) {
				sum[i + 1] = sum[i] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			return sum[j + 1] - sum[i];
		}
	}

//	class NumArray {
//
//		private int[] nums;
//
//		public NumArray(int[] nums) {
//			this.nums = nums;
//		}
//
//		/**
//		 * <pre>
//		 * 
//		 * Time Limit Exceeded
//		 * 
//		 * Complexity analysis:
//		 * 
//		 * Time complexity : O(n) time per query. Each sumRange query takes O(n) time.
//		 * 
//		 * Space complexity : O(1). Note that data is a reference to nums and is not a copy of it.
//		 * 
//		 * </pre>
//		 */
//		public int sumRange(int i, int j) {
//
//			int total = 0;
//			for (int x = i; x <= j; x++) {
//				total += nums[x];
//			}
//			return total;
//		}
//
//	}

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray obj = new
	 * NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */

}
