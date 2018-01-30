package cn.com.sky.algorithms.sorting.swap_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * 冒泡排序
 * 
 * n个关键字，最多n-1趟循环，每个关键字最多n-1次比较.
 * 
 * 从小到大排序： 两种思路：1、小的上浮（从后向前遍历）；2、大的下沉(从前向后遍历)
 */
public class TestBubbleSort extends AbstractSort {

	@Test
	public void sort() {

		methodName = "TestBubbleSortByArray.sort()";

		for (int i = 1; i <= n - 1; i++) {
			for (int j = n - 2; j >= i - 1; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
				count++;
			}
		}

	}

	@Test
	public void sort_good() {
		methodName = "TestBubbleSortByArray.sort_good()";

		boolean hasSwap = true;

		for (int i = 1; i <= n - 1 && hasSwap; i++) {

			hasSwap = false;

			for (int j = n - 2; j >= i - 1; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					hasSwap = true;
				}
				count++;
			}
		}

	}

	@Test
	public void sort_good2() {

		methodName = "TestBubbleSortByArray.sort_good2()";

		int temp = 0;
		int flag = 0;
		for (int i = 0; i < n - 1; i++) /* 外循环控制排序的总趟数 */
		{
			flag = 0; /* 本趟排序开始前，交换标志应为假 */
			for (int j = n - 1; j > i; j--) /* 内循环控制一趟排序的进行 */
			{
				if (arr[j] < arr[j - 1]) /* 相邻元素进行比较，若逆序就交换 */
				{
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					flag = 1; /* 发生了交换，故将交换标志置为真 */
				}

				count++;

			}
			if (flag == 0) /* 本趟排序未发生交换，提前终止算法 */
				break;
		}
	}
}
