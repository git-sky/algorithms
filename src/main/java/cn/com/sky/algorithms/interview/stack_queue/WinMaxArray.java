package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 * 
 *  问题：生成窗口最大值数组，时间复杂度O(n)。
 * 
 * </pre>
 */
public class WinMaxArray {

	@Test
	public void solution() {

		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		int[] result = getMaxArray(arr, w);

		System.out.println(Arrays.toString(result));

	}

	// n*w
	public int[] getMaxArray(int[] arr, int w) {

		int len = arr.length - w + 1;

		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			Integer max = Integer.MIN_VALUE;
			for (int j = i; j < w + i; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			result[i] = max;
		}
		return result;
	}
}
