package cn.com.sky.algorithms.sorting.other;

import java.util.Arrays;

/**
 * <pre>
 * 计数排序（Counting Sort）【Medium】
 *
 * 题目：实现计数排序算法
 *
 * 算法原理：
 * 1. 统计每个元素出现的次数，存入计数数组C
 * 2. 对计数数组累加，C[i]表示小于等于i的元素个数
 * 3. 从后往前遍历原数组，根据C中记录的位置将元素放入临时数组T
 * 4. 每处理一个元素，C中对应位置减1
 *
 * 限制条件：
 * - 元素必须是非负整数
 * - 元素范围不能太大（否则计数数组过大）
 *
 * 为什么从后往前遍历？保证稳定性
 * - 相同元素后出现的放在后面，保持原始相对顺序
 *
 * 时间复杂度：O(n + k)，k为元素范围
 * 空间复杂度：O(n + k)
 * 稳定性：稳定
 * </pre>
 */

public class CountSort {

	public static void main(String[] args) throws Exception {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0 };

		System.out.println("Before sort:");

		Arrays.toString(array);

		countSort(array, 9);

		System.out.println("After sort:");
		Arrays.toString(array);
	}

	public static void countSort(int[] array, int range) throws Exception {
		if (range <= 0) {
			throw new Exception("range can't be negative or zero.");
		}

		if (array.length <= 1) {
			return;
		}

		int[] countArray = new int[range + 1];
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if (value < 0 || value > range) {
				throw new Exception("array element overflow range.");
			}
			countArray[value] += 1;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}

		int[] temp = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			int value = array[i];
			int position = countArray[value] - 1;

			temp[position] = value;
			countArray[value] -= 1;
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
	}
}