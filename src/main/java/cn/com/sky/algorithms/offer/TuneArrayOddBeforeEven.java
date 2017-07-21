package cn.com.sky.algorithms.offer;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 13.调整数组顺序使奇数位于偶数前面.
 * 
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 
 * </pre>
 */
public class TuneArrayOddBeforeEven {

	@Test
	public void solution() {

		int[] arr = init();
		System.out.println(Arrays.toString(arr));
		tune2(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 双指针法,时间复杂度O(n)
	 */
	public void tune2(int[] arr) {

		if (arr == null || arr.length <= 0) {
			return;
		}

		int ahead = 0;
		int behind = arr.length - 1;

		while (ahead < behind) {

			while ((ahead < behind) && (arr[ahead] % 2 == 1)) {
				ahead++;
			}

			while ((ahead < behind) && (arr[behind] % 2 == 0)) {
				behind--;
			}

			// 偶数在前，奇数在后，交换位置。
			if (ahead < behind) {
				int tmp = arr[ahead];
				arr[ahead] = arr[behind];
				arr[behind] = tmp;
				System.out.println("swap");
			}

			System.out.println(Arrays.toString(arr));

		}

	}

	/**
	 * 简单方法,时间复杂度O(n^2)
	 */
	public void tune1(int[] arr) {
		int count = arr.length - 1;
		for (int i = 0; i < count; i++) {
			if (arr[i] % 2 == 0) {
				int tmp = arr[i];
				for (int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
				arr[arr.length - 1] = tmp;
				count--;
				i--;

				System.out.println(Arrays.toString(arr));
			}

		}
	}

	public int[] init() {

		Random r = new Random();
		int len = r.nextInt(5) + 5;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt(i * i + 10) + 1;
		}

		return arr;
	}

}
