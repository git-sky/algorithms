package cn.com.sky.algorithms.sorting.merge_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 归并排序（Merge Sort）【Medium】
 *
 * 题目：实现归并排序算法
 *
 * 算法原理（分治法）：
 * 1. 分：将数组递归地分成两半，直到每个子数组只有一个元素
 * 2. 治：将两个有序子数组合并为一个有序数组
 * 3. 合并过程：使用双指针，比较两个子数组的当前元素，取较小者
 *
 * 归并排序 vs 快速排序：
 * - 归并排序：稳定，时间O(n log n)恒定，但需要O(n)额外空间
 * - 快速排序：不稳定，平均O(n log n)但最坏O(n^2)，原地排序
 *
 * 时间复杂度：O(n log n)（任何情况都是）
 * 空间复杂度：O(n)
 * 稳定性：稳定
 * </pre>
 */
public class TestMergeSort extends AbstractSort {

	@Test
	public void sort() {
		subSort(arr, 0, n - 1);
	}

	private void subSort(int[] arr, int low, int high) {

		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			subSort(arr, low, mid);
			// 右边
			subSort(arr, mid + 1, high);
			// 左右归并
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = arr[j++];
		}

		// 把新数组中的数覆盖arr数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			arr[k2 + low] = temp[k2];
		}
	}

	@Test
	public void sort2() {
		subSort2(arr, 0, n - 1);
	}

	private void subSort2(int[] data, int left, int right) {
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			subSort2(data, left, center);
			// 对右边数组进行递归
			subSort2(data, center + 1, right);
			// 合并
			merge2(data, left, center, right);

		}
	}

	private void merge2(int[] data, int left, int center, int right) {
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		// third记录中间数组的索引
		int third = left;
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入中间数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入中间数组
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}

}