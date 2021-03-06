package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * 
 * 求数组交集
 * 
 * 349. Intersection of Two Arrays
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * </pre>
 * 
 */
public class IntersectionofTwoArrays349 {

	@Test
	public void solution() {
		int[] nums1 = {};
		int[] nums2 = {};
		int[] c = intersection(nums1, nums2);
		System.out.println(c);
	}

	/**
	 * Time complexity: O(n)
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				intersect.add(nums2[i]);
			}
		}
		int[] result = new int[intersect.size()];
		int i = 0;
		for (Integer num : intersect) {
			result[i++] = num;
		}
		return result;
	}
	
	/**
	 * Time complexity: O(nlogn)
	 */
//	 public int[] intersection(int[] nums1, int[] nums2) {
//	        Set<Integer> set = new HashSet<>();
//	        Arrays.sort(nums1);
//	        Arrays.sort(nums2);
//	        int i = 0;
//	        int j = 0;
//	        while (i < nums1.length && j < nums2.length) {
//	            if (nums1[i] < nums2[j]) {
//	                i++;
//	            } else if (nums1[i] > nums2[j]) {
//	                j++;
//	            } else {
//	                set.add(nums1[i]);
//	                i++;
//	                j++;
//	            }
//	        }
//	        int[] result = new int[set.size()];
//	        int k = 0;
//	        for (Integer num : set) {
//	            result[k++] = num;
//	        }
//	        return result;
//	    }
}
