package cn.com.sky.algorithms.sorting.insert_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

//希尔排序
public class TestShellSort extends AbstractSort {

	@Test
	public void sort1() {

		methodName = "TestShellSortByArray.sort1()";
		int j = 0;
		int temp = 0;
		for (int increment = n / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < n; i++) {
				temp = arr[i];
				for (j = i; j >= increment; j -= increment) {
					if (temp < arr[j - increment]) {
						arr[j] = arr[j - increment];
					} else {
						break;
					}
					count++;
				}
				arr[j] = temp;
			}

			// System.out.println("increment:" + increment + ";排序中：" + Arrays.toString(arr));
		}
	}

	@Test
	public void sort() {

		methodName = "TestShellSortByArray.sort()";
		int increment = n;

		do {
			increment = increment / 2;
			for (int i = increment; i < n; i++) {
				int tmp = arr[i];
				int j = 0;
				for (j = i - increment; j >= 0 && arr[j] > tmp; j -= increment) {
					arr[j + increment] = arr[j];
					count++;
				}
				if (j + increment != i) {
					arr[j + increment] = tmp;
				}
			}
		} while (increment > 1);

	}

	@Test
	public void sort2() {

		methodName = "TestShellSortByArray.sort2()";

		int increment = n;

		do {
			increment = increment / 2; // 增量序列
			for (int i = increment; i < n; i++) {
				if (arr[i] < arr[i - increment]) {
					int tmp = arr[i];
					int j = 0;
					for (j = i - increment; (j >= 0) && (tmp < arr[j]); j -= increment) // 记录后移，查找插入位置
					{
						arr[j + increment] = arr[j];
						count++;
					}
					arr[j + increment] = tmp; // 插入
				}
			}
		} while (increment > 1);
	}
}
