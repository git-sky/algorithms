package cn.com.sky.algorithms.sorting.select_sort;

import java.util.Arrays;

/**
 * <pre>
 * 
 * 二、堆排序
 * 
 * 堆排序(Heapsort)是指利用堆积树（堆）这种数据结构所设计的一种排序算法，它是选择排序的一种。可以利用数组的特点快速定位指定索引的元素。
 * 堆分为大根堆和小根堆，是完全二叉树。
 * 大根堆和小根堆： 根结点（亦称为堆顶）的关键字是堆里所有结点关键字中最小者的堆称为小根堆，又称最小堆。 
 * 根结点（亦称为堆顶）的关键字是堆里所有结点关键字中最大者，称为大根堆，又称最大堆。
 * 注意：①堆中任一子树亦是堆 。②以上讨论的堆实际上是二叉堆（Binary Heap），类似地可定义k叉堆。
 * 
 * 时间复杂度 O(N*logN)。 由于建初始堆所需的比较次数较多，所以堆排序不适宜于记录数较少的文件。 堆排序是就地排序，辅助空间为O(1）。
 * 它是不稳定的排序方法。（排序的稳定性是指如果在排序的序列中，存在前后相同的两个元素的话，排序前 和排序后他们的相对位置不发生变化）。
 * 
 * </pre>
 * 
 */
public class HeapSort {
	private static int[] sort = new int[] { 1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11 };

	public static void main(String[] args) {

		System.out.println(Arrays.toString(sort));

		buildMaxHeapify(sort);
		heapSort(sort);
		print(sort);

		System.out.println();
		System.out.println(Arrays.toString(sort));
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
	 * @param heapSize需要创建最大堆的大小
	 *            ，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
	 * @param index当前需要创建最大堆的位置
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