package cn.com.sky.algorithms.sorting.select_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 选择排序(Selection Sort)的基本思想是：每一趟从待排序的序列中选出关键字最小的记录，顺序放在已排好序的子序列的最后，直到全部关键字按照指定顺序排序完成。 　
 * 常用的选择排序方法有简单选择排序和堆排序。
 * 
 * 一、简单选择排序
 * 
 * 时间复杂度O(n2)
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
