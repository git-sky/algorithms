package cn.com.sky.algorithms.offer;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 7.旋转数组的最小数字
 * 
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * 思路:我们注意到旋转之后的数组实际上可以划分为两个排序的子数组，而且前面的子数组的元素都大于或者等于后面子数组的元素。
 * 我们还注意到最小的元素刚好是这两个子数组的分界线。在排序的数组中我们可以用二分查找法实现O(logn)的查找。
 * 
 */
public class RotateTheSmallNumber {

	@Test
	public void solution() {

		int[] arr = init();
		int min = getMin(arr);
		System.out.println("min:" + min);
	}

	/**
	 * 解决方案1
	 */
	public int getMin(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return Integer.MIN_VALUE;
		}

		int index1 = 0;
		int index2 = numbers.length - 1;
		// 把indexMid初始化为index1的原因：
		// 一旦发现数组中第一个数字小于最后一个数字，表明该数组是排序的
		// 就可以直接返回第一个数字了
		int indexMid = index1;

		while (numbers[index1] >= numbers[index2]) {
			// 如果index1和index2指向相邻的两个数，
			// 则index1指向第一个递增子数组的最后一个数字，
			// index2指向第二个子数组的第一个数字，也就是数组中的最小数字
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}
			indexMid = (index1 + index2) / 2;
			// 特殊情况：如果下标为index1、index2和indexMid指向的三个数字相等，则只能顺序查找
			if (numbers[index1] == numbers[indexMid] && numbers[indexMid] == numbers[index2]) {
				return getMinInOrder(numbers, index1, index2);
			}
			// 缩小查找范围
			if (numbers[indexMid] >= numbers[index1]) {
				index1 = indexMid;
			} else if (numbers[indexMid] <= numbers[index2]) {
				index2 = indexMid;
			}
		}
		System.out.println("pos:" + indexMid);
		return numbers[indexMid];
	}

	public int getMinInOrder(int[] numbers, int index1, int index2) {
		int result = numbers[index1];
		for (int i = index1 + 1; i <= index2; ++i) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}
		return result;
	}

	public int[] init() {

		Random r = new Random();
		int len = r.nextInt(5) + 5;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt(i * i + 10) + 1;
			while (i > 0 && arr[i] < arr[i - 1]) {
				arr[i] = r.nextInt(i * i + 10) + 1;
			}
		}

		System.out.println("before:" + Arrays.toString(arr));

		int num = r.nextInt(5) + 1;

		System.out.println("num:" + num);

		for (int i = 0; i < num; i++) {// 移动次数
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[arr.length - 1] = temp;
		}

		System.out.println("after:" + Arrays.toString(arr));

		return arr;
	}
}
