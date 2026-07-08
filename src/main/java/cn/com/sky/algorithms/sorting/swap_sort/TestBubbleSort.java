package cn.com.sky.algorithms.sorting.swap_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 冒泡排序（Bubble Sort）【Easy】
 *
 * 题目：实现冒泡排序算法
 *
 * 算法原理：
 * 1. 相邻元素两两比较，如果逆序则交换
 * 2. 每趟排序将最大（或最小）元素"冒泡"到一端
 * 3. n个元素最多需要n-1趟排序
 *
 * 两种思路：
 * - 小的上浮（从后向前遍历）：每趟将最小元素冒泡到前面
 * - 大的下沉（从前向后遍历）：每趟将最大元素冒泡到后面
 *
 * 优化1（提前终止）：如果某趟排序没有发生交换，说明已有序，提前终止
 * 优化2（记录最后交换位置）：记录最后一次交换的位置，下一趟只需比较到该位置
 *
 * 时间复杂度：
 * - 最坏：O(n^2)（逆序）
 * - 最好：O(n)（已排序，带提前终止优化）
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * </pre>
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