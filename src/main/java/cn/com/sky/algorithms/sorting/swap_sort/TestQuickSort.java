package cn.com.sky.algorithms.sorting.swap_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 快速排序（Quick Sort）- 多种分区方案【Medium】
 *
 * 题目：实现快速排序算法（Lomuto分区 + Hoare分区 + 优化版）
 *
 * 算法原理（分治法）：
 * 1. 选取基准元素（pivot）
 * 2. 分区：将小于pivot的放左边，大于pivot的放右边
 * 3. 递归排序左右子数组
 *
 * 三种分区方案：
 * - sort()：Lomuto分区，选最后一个元素为pivot
 * - sort2()：Hoare分区，选第一个元素为pivot，双向扫描
 * - partition3()：优化版，减少不必要的交换
 *
 * 时间复杂度：
 * - 平均：O(n log n)
 * - 最坏：O(n^2)（已排序数组 + 选首/末元素为pivot）
 * 空间复杂度：O(log n)（递归栈）
 * 稳定性：不稳定
 * </pre>
 */
public class TestQuickSort extends AbstractSort {

	@Test
	public void sort() {
		methodName = "sort";
		subQuickSort(arr, 0, n - 1);
	}

	private void subQuickSort(int[] arr, int start, int end) {
		if (arr == null || (end - start + 1) < 2) {
			return;
		}

		int part = partition(arr, start, end);

		if (part == start) {
			subQuickSort(arr, part + 1, end);
		} else if (part == end) {
			subQuickSort(arr, start, part - 1);
		} else {
			subQuickSort(arr, start, part - 1);
			subQuickSort(arr, part + 1, end);
		}
	}

	private int partition(int[] arr, int start, int end) {
		int tmp = arr[end];
		int index = start - 1;

		for (int i = start; i < end; i++) {
			if (arr[i] < tmp) {
				index++;
				if (index != i) {
					swap(arr, index, i);
				}
			}
			count++;
		}

		if ((index + 1) != end) {
			swap(arr, index + 1, end);
		}

		return index + 1;
	}

	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	@Test
	public void sort2() {
		methodName = "sort2";
		qSort(arr, 0, n - 1);
	}

	private void qSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition2(arr, low, high);
			// int pivot = partition3(arr, low, high);// 优化不必要的交换
			qSort(arr, low, pivot - 1);
			qSort(arr, pivot + 1, high);
		}
	}

	private int partition2(int[] arr, int low, int high) {
		int tmp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;
				count++;
			}
			swap(arr, low, high);
			while (low < high && arr[low] <= tmp) {
				low++;
				count++;
			}
			swap(arr, low, high);
		}

		return low;
	}

	// 优化不必要的交换
	private int partition3(int[] arr, int low, int high) {
		int tmp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= tmp) {
				high--;
				count++;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] <= tmp) {
				low++;
				count++;
			}
			arr[high] = arr[low];
		}

		arr[low] = tmp;

		return low;
	}
}