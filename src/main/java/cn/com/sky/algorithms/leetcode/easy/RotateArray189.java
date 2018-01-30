package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 189. Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * </pre>
 */
public class RotateArray189 {

	@Test
	public void solution() {
		int[] x = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(x, k);
		System.out.println(Arrays.toString(x));
	}

	// public void rotate(int[] nums, int k) {
	//
	// }

	/**
	 * <pre>
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). n elements are reversed a total of three times.
	 * Space complexity : O(1). No extra space is used.
	 */
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * <pre>
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). One pass is used to put the numbers in the new array. And another pass to copy the new array to the original one.
	 * Space complexity : O(n). Another array of the same size is used.
	 */
	// public void rotate(int[] nums, int k) {
	// int[] a = new int[nums.length];
	// for (int i = 0; i < nums.length; i++) {
	// a[(i + k) % nums.length] = nums[i];
	// }
	// for (int i = 0; i < nums.length; i++) {
	// nums[i] = a[i];
	// }
	// }

	/**
	 * Time complexity : O(n*k). All the numbers are shifted by one step(O(n)) k times(O(k)).
	 * 
	 * Space complexity : O(1). No extra space is used.
	 */
	// public void rotate(int[] nums, int k) {
	// int temp, previous;
	// for (int i = 0; i < k; i++) {
	// previous = nums[nums.length - 1];
	// for (int j = 0; j < nums.length; j++) {
	// temp = nums[j];
	// nums[j] = previous;
	// previous = temp;
	// }
	// }
	// }

}
