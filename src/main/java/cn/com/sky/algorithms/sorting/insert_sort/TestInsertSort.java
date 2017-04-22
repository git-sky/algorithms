package cn.com.sky.algorithms.sorting.insert_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

// 插入排序
public class TestInsertSort extends AbstractSort {

	@Test
	public void sort1() {
		methodName = "sort1";

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] > arr[i]) {
				int temp = arr[i];
				int j = i;
				while (j > 0 && arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
					j--;

					count++;
				}
				arr[j] = temp;
				count++;
			}
		}
	}

	@Test
	public void sort2() {
		methodName = "sort2";

		for (int i = 1; i < n; i++) {
			int tmp = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
				arr[j + 1] = arr[j];
				count++;
			}
			if (j + 1 != i) {
				arr[j + 1] = tmp;
				count++;
			}
		}
	}

	@Test
	public void sort3() {

		methodName = "sort3";

		for (int i = 1; i < n; i++) {
			int tmp = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
					count++;
				} else {
					count++;
					break;
				}
			}
			if (j + 1 != i) {
				arr[j + 1] = tmp;
				count++;
			}
		}
	}

	@Override
	public void sort() {

	}

}
