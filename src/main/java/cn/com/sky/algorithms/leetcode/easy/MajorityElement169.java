package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 
 * 169. Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than └n/2┘  times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * </pre>
 */
public class MajorityElement169 {

	@Test
	public void solution() {
		int[] nums = { 6, 5 };
		System.out.println(Arrays.toString(nums));
		int n = majorityElement(nums);
		System.out.println(n);
	}

	/**
	 * <pre>
	 * 
	 * 向上向下取整函数, 只会对小数点后面的数字不为零的数进行操作,
	 * 要是给它一个整数, 它就返回整数本身。
	 * 对小数不为零的数操作:
	 * 给定 4.9
	 * 调用用向下取整函数,得到的是 4
	 * 调用用向上取整函数,得到的是 5
	 * 向上取整：比自己大的最小整数；
	 * 向下取整：比自己小的最大整数；
	 * 
	 * 向下取整的运算称为Floor，用数学符号└┘表示；向上取整的运算称为Ceiling，用数学符号┌┐表示.
	 * 
	 * └5/2┘ 是向下取整，取比5/2小的最大整数,是2。
	 * 
	 * ┌5/2┐ 是向上取整，取比5/2大的最小整数，是3。
	 * 
	 * </pre>
	 */
	public int majorityElement(int[] nums) {

		// 向上取整用Math.ceil(double a)
		//
		// 向下取整用Math.floor(double a)

		int n = nums.length / 2;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
			if (map.get(a) > n)
				return a;
		}

		return -1;

	}
}
