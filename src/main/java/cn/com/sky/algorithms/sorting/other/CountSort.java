package cn.com.sky.algorithms.sorting.other;

import java.util.Arrays;

/**
 * <pre>
 * 
 * 计数排序
 * 
 * 计数排序算法介绍:
 * 
 * 比较排序算法可以通过决策树模型证明，其下线是O(nlgn)。而本文介绍的是时间效率为O(n)的计数排序。所谓排序算法，无非就是把正确的元素放到正确的位置，
 * 计数排序就是计算相同key的元素各有多少个 ，然后根据出现的次数累加而获得最终的位置信息。
 * 但是计数排序有两个限制条件，那就是存在一个正整数K，使得数组里面的所有元素的key值都不大于N，且key值都是非负整数。
 * 
 * 计数排序算法步骤大概有三个步骤：
 * 1.建一个长度为K+1的的数组C，里面的每一个元素初始都置为0(Java里面默认就是0)。
 * 2.遍历待排序的数组，计算其中的每一个元素出现的次数，比如一个key为i的元素出现了3次，那么C[i]=3。 累加C数组，获得元素的排位，从0开始遍历C, C[i+1]=C[i]+C[i-1]
 * 3.建一个临时数组T，长度与待排序数组一样。从数组末尾遍历待排序数组，把元素都安排到T里面，直接从C里面就可以得到元素的具体位置， 不过记得每处理过一个元素之后都要把C里面对应位置的计数减1。
 */

public class CountSort {

	public static void main(String[] args) throws Exception {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0 };

		System.out.println("Before sort:");

		Arrays.toString(array);

		countSort(array, 9);

		System.out.println("After sort:");
		Arrays.toString(array);
	}

	public static void countSort(int[] array, int range) throws Exception {
		if (range <= 0) {
			throw new Exception("range can't be negative or zero.");
		}

		if (array.length <= 1) {
			return;
		}

		int[] countArray = new int[range + 1];
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if (value < 0 || value > range) {
				throw new Exception("array element overflow range.");
			}
			countArray[value] += 1;
		}

		for (int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i - 1];
		}

		int[] temp = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			int value = array[i];
			int position = countArray[value] - 1;

			temp[position] = value;
			countArray[value] -= 1;
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}
	}
}