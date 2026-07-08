package cn.com.sky.algorithms.sorting.select_sort;

import java.util.Arrays;

/**
 * <pre>
 * 堆排序（Heap Sort）【Medium】
 *
 * 题目：实现堆排序算法
 *
 * 算法原理（利用大根堆）：
 * 1. 建堆：从最后一个非叶节点开始，自底向上调整为大根堆
 * 2. 排序：将堆顶（最大值）与末尾元素交换，堆大小减1，重新调整堆
 * 3. 重复步骤2，直到堆大小为1
 *
 * 大根堆性质：
 * - 完全二叉树，用数组存储
 * - 父节点 >= 左右子节点
 * - 节点i的父节点：(i-1)/2
 * - 节点i的左子节点：2*i+1
 * - 节点i的右子节点：2*i+2
 *
 * 堆调整（maxHeapify）：
 * - 比较当前节点与左右子节点，找出最大值
 * - 如果最大值不是当前节点，交换并递归调整被交换的子树
 *
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(1)（原地排序）
 * 稳定性：不稳定
 * </pre>
 */
public class HeapSort {
	private static int[] sort = new int[] { 1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11 };

	public static void main(String[] args) {

		System.out.println("初始数组："+Arrays.toString(sort));

		buildMaxHeapify(sort);

		heapSort(sort);

		print(sort);

		System.out.println();
		System.out.println("排序后数组："+Arrays.toString(sort));
	}

	private static void buildMaxHeapify(int[] data) {
		// 没有子节点的才需要创建最大堆，从最后一个的父节点开始
		int startIndex = getParentIndex(data.length - 1);
		// 从尾端开始创建最大堆，每次都是正确的堆
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(data, data.length, i);
		}
	}

	/**
	 * 创建最大堆
	 *
	 * @param data
	 * @param heapSize 需要创建最大堆的大小
	 *            ，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
	 * @param index 当前需要创建最大堆的位置
	 */
	private static void maxHeapify(int[] data, int heapSize, int index) {
		// 当前点与左右子节点比较
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);

		int largest = index;
		if (left < heapSize && data[index] < data[left]) {
			largest = left;
		}
		if (right < heapSize && data[largest] < data[right]) {
			largest = right;
		}
		// 得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
		if (largest != index) {
			int temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
			maxHeapify(data, heapSize, largest);
		}
	}

	/**
	 * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的。
	 */
	private static void heapSort(int[] data) {
		// 末尾与头交换，交换后调整最大堆
		for (int i = data.length - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			maxHeapify(data, i, 0);
		}
	}

	/**
	 * 父节点位置
	 */
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	/**
	 * 左子节点position注意括号，加法优先级更高
	 */
	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	/**
	 * 右子节点position
	 */
	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}

	private static void print(int[] data) {
		int pre = -2;
		for (int i = 0; i < data.length; i++) {
			if (pre < (int) getLog(i + 1)) {
				pre = (int) getLog(i + 1);
				System.out.println();
			}
			System.out.print(data[i] + "|");
		}
	}

	/**
	 * 以2为底的对数
	 */
	private static double getLog(double param) {
		return Math.log(param) / Math.log(2);
	}
}