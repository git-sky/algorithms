package cn.com.sky.algorithms.sorting.merge_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 
 * 归并排序
 * 
 * 归并排序 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 
 * 稳定性：稳定排序
 * 
 * 时间复杂度：O(nlogn)
 * 
 * 空间复杂度：O(n+logn)
 * 
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