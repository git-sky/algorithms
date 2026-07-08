package cn.com.sky.algorithms.searching.statics.ordered_list.binary_search;

import org.junit.Test;

/**
 * <pre>
 * 二分查找（Binary Search）【Easy】
 *
 * 题目：在有序数组中查找目标值的位置
 *
 * 算法原理：
 * 1. 取中间位置元素与目标值比较
 * 2. 如果相等，返回当前位置
 * 3. 如果目标值小于中间值，在左半部分继续查找
 * 4. 如果目标值大于中间值，在右半部分继续查找
 * 5. 重复直到找到或区间为空
 *
 * 前提条件：数组必须有序
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：
 * - 递归实现：O(log n)（栈空间）
 * - 迭代实现：O(1)
 * </pre>
 */
public class TestBinarySearch {
	// 获取递归的次数
	private int recursiveCount = 0;
	// 获取循环的次数
	private int loopCount = 0;

	public int getRecursiveCount() {
		return recursiveCount;
	}

	public void setRecursiveCount(int recursiveCount) {
		this.recursiveCount = recursiveCount;
	}

	public int getLoopCount() {
		return loopCount;
	}

	public void setLoopCount(int loopCount) {
		this.loopCount = loopCount;
	}

	/**
	 * 执行递归二分查找，返回第一次出现该值的位置
	 * 
	 * @param sortedData
	 *            已排序的数组
	 * @param start
	 *            开始位置
	 * @param end
	 *            结束位置
	 * @param findValue
	 *            需要找的值
	 * @return 值在数组中的位置，从0开始。找不到返回-1
	 */
	public int searchRecursive(int[] sortedData, int start, int end, int findValue) {
		recursiveCount++;
		if (start <= end) {
			// 中间位置
			int middle = (start + end) >> 1; // 相当于(start+end)/2
			// 中值
			int middleValue = sortedData[middle];

			if (findValue == middleValue) {
				// 等于中值直接返回
				return middle;
			} else if (findValue < middleValue) {
				// 小于中值时在中值前面找
				return searchRecursive(sortedData, start, middle - 1, findValue);
			} else {
				// 大于中值在中值后面找
				return searchRecursive(sortedData, middle + 1, end, findValue);
			}
		} else {
			// 找不到
			return -1;
		}
	}

	/**
	 * 循环二分查找，返回第一次出现该值的位置
	 * 
	 * @param sortedData
	 *            已排序的数组
	 * @param findValue
	 *            需要找的值
	 * @return 值在数组中的位置，从0开始。找不到返回-1
	 */
	public int searchLoop(int[] sortedData, int findValue) {
		int low = 0;
		int high = sortedData.length - 1;

		while (low <= high) {
			loopCount++;
			// 中间位置
			int middle = (low + high) >> 1; // 相当于(start+end)/2
			// 中值
			int middleValue = sortedData[middle];

			if (findValue == middleValue) {
				// 等于中值直接返回
				return middle;
			} else if (findValue < middleValue) {
				// 小于中值时在中值前面找
				high = middle - 1;
			} else {
				// 大于中值在中值后面找
				low = middle + 1;
			}
		}
		// 找不到
		return -1;
	}

	@Test
	public void testSearch() {
		TestBinarySearch bs = new TestBinarySearch();

		int[] sortedData = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10 };
		int findValue = 9;
		int length = sortedData.length;

		// 递归查找
		int pos = bs.searchRecursive(sortedData, 0, length - 1, findValue);
		System.out.println("Recursice:" + findValue + " found in pos " + pos + ";count:" + bs.getRecursiveCount());

		// 循环查找
		int pos2 = bs.searchLoop(sortedData, findValue);
		System.out.println("Loop:" + findValue + " found in pos " + pos2 + ";count:" + bs.getLoopCount());
	}
}