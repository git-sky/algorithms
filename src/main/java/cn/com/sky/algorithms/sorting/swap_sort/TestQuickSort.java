package cn.com.sky.algorithms.sorting.swap_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 
 * 二、快速排序算法
 * 
 * 快速排序算法介绍:
 * 
 * 快速排序和归并排序都使用分治法来设计算法，区别在于归并排序把数组分为两个基本等长的子数组，分别排好序之后还要进行归并(Merge)操作，
 * 而快速排序拆分子数组的时候显得更有艺术，取一个基准元素，拆分之后基准元素左边的元素都比基准元素小，右边的元素都不小于基准元素，这样只需要分别对两个子数组排序即可，不再像归并排序一样需要归并操作。
 * 基准元素的选取对算法的效率影响很大，最好的情况是两个子数组大小基本相当。为简单起见，我们选择最后一个元素，更高级的做法可以先找一个中位数并把中位数与最后一个元素交换，之后再进行相同的操作步骤。
 * 拆分是快速排序的核心。快速排序的最坏运行时间是O(n2)，但期望的运行时间是O(nlgn)。
 * 
 * 快速排序算法Java实现：
 * 
 * 1.把数组拆分为两个子数组加上一个基准元素: 选取最后一个元素作为基准元素，index变量记录最近一个小于基准元素的元素所在的位置，初始化为start-1，发现新的小于基准元素的元素，index加1。
 * 从第一个元素到倒数第二个元素，依次与基准元素比较，小于基准元素，index加1，交换位置index和当前位置的元素。循环结束之后index+1得到基准元素应该在的位置，交换index+1和最后一个元素。
 * 2.分别排序[start, index], 和[index+2, end]两个子数组
 * 
 * 
 * 稳定性：不稳定排序
 * 
 * 时间复杂度：O(nlogn)
 * 
 * 空间复杂度：O(logn)
 * 
 * </pre>
 * 
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