package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 624. Maximum Distance in Arrays
 * 
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 * 
 * Example 1:
 * Input: 
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * Output: 4
 * Explanation: 
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * 
 * Note:
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 * 
 * </pre>
 */
public class MaximumDistanceInArrays624 {

	@Test
	public void solution() {
		List<List<Integer>> arrays = new ArrayList<>();

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);

		List<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(5);

		arrays.add(list1);
		arrays.add(list2);
		arrays.add(list3);

		int n = maxDistance(arrays);
		System.out.println(n);
	}

	public int maxDistance(List<List<Integer>> arrays) {
		int result = Integer.MIN_VALUE;
		int max = arrays.get(0).get(arrays.get(0).size() - 1);
		int min = arrays.get(0).get(0);

		for (int i = 1; i < arrays.size(); i++) {
			result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
			result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
			max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
			min = Math.min(min, arrays.get(i).get(0));
		}

		return result;
	}

}
