package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * 
 * 33. Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * 
 * 
 * </pre>
 */
public class SearchInRotatedSortedArray33 {

	// public int search(int[] nums, int target) {
	// int minIdx = findMinIdx(nums);
	// if (target == nums[minIdx])
	// return minIdx;
	// int m = nums.length;
	// int start = (target <= nums[m - 1]) ? minIdx : 0;
	// int end = (target > nums[m - 1]) ? minIdx : m - 1;
	//
	// while (start <= end) {
	// int mid = start + (end - start) / 2;
	// if (nums[mid] == target)
	// return mid;
	// else if (target > nums[mid])
	// start = mid + 1;
	// else
	// end = mid - 1;
	// }
	// return -1;
	// }
	//
	// public int findMinIdx(int[] nums) {
	// int start = 0, end = nums.length - 1;
	// while (start < end) {
	// int mid = start + (end - start) / 2;
	// if (nums[mid] > nums[end])
	// start = mid + 1;
	// else
	// end = mid;
	// }
	// return start;
	// }

	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] > nums[end]) { // eg. 3,4,5,6,1,2
				if (target > nums[mid] || target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			} else { // eg. 5,6,1,2,3,4
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
		}
		if (start == end && target != nums[start])
			return -1;
		return start;
	}

}
