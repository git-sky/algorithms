package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 136. Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * </pre>
 */
public class SingleNumber136 {

	@Test
	public void solution() {
		int[] nums = { 1, 3, 1, 2, 3, 5, 2 };
		System.out.println(Arrays.toString(nums));
		int n = singleNumber(nums);
		System.out.println(n);
	}

	/**
	 * 利用异或的特性，x^y^x=y^x^x=y。
	 * 
	 * 使用异或， 相同为0，不同为1。
	 */
	public int singleNumber(int[] nums) {

		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			n ^= nums[i];
		}

		return n;

	}
}
