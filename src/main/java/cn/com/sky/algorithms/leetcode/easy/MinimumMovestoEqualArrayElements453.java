package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 453. Minimum Moves to Equal Array Elements
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * </pre>
 */
public class MinimumMovestoEqualArrayElements453 {

	@Test(timeout = 1000)
	public void solution() {
		int[] nums = { 1, 2147483647 };
		int n = minMoves(nums);
		System.out.println(n);
	}

	/**
	 * <pre>
	 * 给数组中的n-1个元素加1的操作等价于数组中“不加1的那个元素“减去1，然后数组中的所有元素都加1。
	 * 我们知道，给所有的元素都加1并不能改变原数组中的数之间的差值。所以这题就转化为求最少的减1操作。
	 * 而要使数组中的元素全部相等，又要使用减法。那么最少的次数就是让这些元素全部都等于数组中最小的数。
	 * 所以得到的结果就是sum（所有元素和）-n*数组中最小元素。
	 * 
	 * 该方法是最优的解法
	 * </pre>
	 */
	public int minMoves(int[] nums) {
		int min = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			sum += nums[i];
		}
		return sum - min * nums.length;
	}

	/**
	 * 该方法超时，复杂度太高。
	 */
	public int minMoves2(int[] nums) {

		int count = 0;

		Arrays.sort(nums);
		while (nums[0] != nums[nums.length - 1]) {
			count++;
			for (int i = 0; i < nums.length - 1; i++) {
				nums[i]++;
			}
			Arrays.sort(nums);
		}

		return count;

	}
}
