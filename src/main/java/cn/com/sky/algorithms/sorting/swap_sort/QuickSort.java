package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * 快速排序（Quick Sort）【Medium】
 *
 * 题目：实现快速排序算法
 *
 * 算法原理（分治法）：
 * 1. 选择一个基准元素（pivot），通常取中间元素
 * 2. 从两端向中间扫描，将小于pivot的放左边，大于pivot的放右边
 * 3. 递归地对左右两部分进行快速排序
 *
 * 分区过程（Hoare分区方案）：
 * - 左指针i从左向右找第一个>=pivot的元素
 * - 右指针j从右向左找第一个<=pivot的元素
 * - 交换i和j位置的元素，i++，j--
 * - 当i > j时分区完成
 *
 * 快速排序为什么快？
 * - 每次分区将数组近似对半分，递归深度约log n
 * - 每层分区操作总比较次数约n
 * - 平均时间O(n log n)，常数因子小
 *
 * 最坏情况：数组已排序且pivot选择不当，退化为O(n^2)
 * 优化方法：随机选择pivot或三数取中法
 *
 * 时间复杂度：平均O(n log n)，最坏O(n^2)
 * 空间复杂度：平均O(log n)，最坏O(n)（递归栈）
 * 稳定性：不稳定
 * </pre>
 */
public class QuickSort {

	public static void main(String[] args) {
		// 测试用例1：随机数组
		System.out.println("=== 测试用例1：随机数组 ===");
		int[] arr1 = {5, 3, 8, 1, 9, 2, 7, 4, 6};
		System.out.println("排序前: " + Arrays.toString(arr1));
		sort(arr1, 0, arr1.length - 1);
		System.out.println("排序后: " + Arrays.toString(arr1));

		// 测试用例2：已排序数组
		System.out.println("\n=== 测试用例2：已排序数组 ===");
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("排序前: " + Arrays.toString(arr2));
		sort(arr2, 0, arr2.length - 1);
		System.out.println("排序后: " + Arrays.toString(arr2));

		// 测试用例3：逆序数组
		System.out.println("\n=== 测试用例3：逆序数组 ===");
		int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("排序前: " + Arrays.toString(arr3));
		sort(arr3, 0, arr3.length - 1);
		System.out.println("排序后: " + Arrays.toString(arr3));

		// 测试用例4：含重复元素
		System.out.println("\n=== 测试用例4：含重复元素 ===");
		int[] arr4 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
		System.out.println("排序前: " + Arrays.toString(arr4));
		sort(arr4, 0, arr4.length - 1);
		System.out.println("排序后: " + Arrays.toString(arr4));

		// 测试用例5：单元素
		System.out.println("\n=== 测试用例5：单元素 ===");
		int[] arr5 = {1};
		sort(arr5, 0, 0);
		System.out.println("排序后: " + Arrays.toString(arr5));

		// 测试用例6：两元素
		System.out.println("\n=== 测试用例6：两元素 ===");
		int[] arr6 = {2, 1};
		sort(arr6, 0, 1);
		System.out.println("排序后: " + Arrays.toString(arr6));

		// 测试用例7：空数组
		System.out.println("\n=== 测试用例7：空数组 ===");
		int[] arr7 = {};
		if (arr7.length > 0) {
			sort(arr7, 0, arr7.length - 1);
		}
		System.out.println("排序后: " + Arrays.toString(arr7));
	}

	/**
	 * 快速排序（Hoare分区方案）
	 *
	 * @param arr   待排序数组
	 * @param left  左边界
	 * @param right 右边界
	 */
	public static void sort(int[] arr, int left, int right) {
		if (arr == null || left >= right) {
			return;
		}

		int i = left;
		int j = right;
		int pivot = arr[(left + right) / 2];

		do {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);

		if (left < j) sort(arr, left, j);
		if (right > i) sort(arr, i, right);
	}
}