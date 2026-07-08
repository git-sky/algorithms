package cn.com.sky.algorithms.sorting.insert_sort;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 希尔排序（Shell Sort）【Medium】
 *
 * 题目：实现希尔排序算法（缩小增量排序）
 *
 * 算法原理：
 * 1. 按照一定的步长（增量）将数组分成若干子序列
 * 2. 对每个子序列进行直接插入排序
 * 3. 逐步减小步长，重复上述过程，直到步长为1
 *
 * 为什么希尔排序比直接插入排序快？
 * - 直接插入排序对基本有序的数组效率很高（接近O(n)）
 * - 希尔排序通过大步长先让元素快速移动到大致位置
 * - 最后步长为1时，数组已经基本有序，效率高
 *
 * 步长选择：
 * - 常用：n/2, n/4, n/8, ..., 1（Shell原始序列）
 * - 更优：Hibbard序列、Sedgewick序列等
 *
 * 时间复杂度：取决于步长序列，平均O(n^1.3)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
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