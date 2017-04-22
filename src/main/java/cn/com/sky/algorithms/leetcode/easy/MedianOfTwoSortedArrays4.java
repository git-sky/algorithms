package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log(m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 * </pre>
 */
public class MedianOfTwoSortedArrays4 {

	@Test
	public void solution() {
		// int[] nums1 = { 1, 3 };
		// int[] nums2 = { 2 };

		// int[] nums1 = { 1, 2 };
		// int[] nums2 = { 3, 4 };

		int[] nums1 = { 3, 7, 10 };
		int[] nums2 = { 1, 2, 4, 5, 6, 8, 9 };

		double sum = findMedianSortedArrays(nums1, nums2);
		System.out.println(sum);
	}

	/**
	 * 时间复杂度： O(m+n)
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int[] total = new int[nums1.length + nums2.length];

		int i = 0, j = 0;
		for (; i < nums1.length && j < nums2.length;) {
			if (nums1[i] < nums2[j]) {
				total[i + j] = nums1[i];
				i++;
			} else {
				total[i + j] = nums2[j];
				j++;
			}
		}

		while (i < nums1.length) {
			total[i + j] = nums1[i];
			i++;
		}

		while (j < nums2.length) {
			total[i + j] = nums2[j];
			j++;
		}

		for (int k = 0; k < total.length; k++) {
			System.out.println(total[k]);
		}

		if (total.length % 2 == 1) {
			return total[total.length / 2];
		} else {
			return (total[total.length / 2 - 1] + total[total.length / 2]) / 2d;
		}
	}
}
