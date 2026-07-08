package cn.com.sky.algorithms.sorting.select_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 选择排序（Selection Sort）【Easy】
 *
 * 题目：实现简单选择排序算法
 *
 * 算法原理：
 * 1. 每一趟从待排序序列中选出最小元素
 * 2. 将最小元素与待排序序列的第一个元素交换
 * 3. 已排序序列长度加1，待排序序列长度减1
 * 4. 重复直到全部排序完成
 *
 * 选择排序 vs 冒泡排序：
 * - 冒泡排序：相邻元素两两比较交换，每次交换可能改变多个元素位置
 * - 选择排序：每趟只记录最小值下标，一趟结束后最多交换一次
 * - 选择排序交换次数更少，但比较次数相同
 *
 * 时间复杂度：O(n^2)（任何情况都是）
 * 空间复杂度：O(1)
 * 稳定性：不稳定（交换可能改变相等元素的相对顺序）
 * </pre>
 */
public class TestSelectSort extends AbstractSort {

	@Test
	public void sort() {
		methodName = "TestSelectSortByArray.sort()";
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				count++;
			}

			if (min != i) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}

	@Test
	public void sort2() {
		methodName = "TestSelectSortByArray.sort2()";
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}