package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 * 给你一个用数组表示的数，求加一之后的结果，结果还是用数组表示。
 * 
 * 66. Plus One
 * 
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * 
 * </pre>
 */
public class PlusOne66 {

	@Test
	public void solution() {

		int[] digits = { 9, 9, 9 };

		int[] result = plusOne(digits);
		System.out.println(Arrays.toString(result));
	}

	public int[] plusOne(int[] digits) {

		if (digits.length == 0) {
			return digits;
		}

		int acc = 0;
		int temp = digits[digits.length - 1] + 1;
		digits[digits.length - 1] = temp % 10;
		acc = temp / 10;

		for (int i = digits.length - 2; i >= 0; i--) {
			temp = acc + digits[i];
			digits[i] = temp % 10;
			acc = temp / 10;
		}

		if (acc > 0) {
			int[] result = new int[digits.length + 1];
			result[0] = acc;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		} else {
			return digits;
		}
	}
	
	
	//leetcode更优的方式
	// public int[] plusOne(int[] digits) {
	//
	// int n = digits.length;
	// for(int i=n-1; i>=0; i--) {
	// if(digits[i] < 9) {
	// digits[i]++;
	// return digits;
	// }
	//
	// digits[i] = 0;
	// }
	//
	// int[] newNumber = new int [n+1];
	// newNumber[0] = 1;
	//
	// return newNumber;
	// }
	
}
