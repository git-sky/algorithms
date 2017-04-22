package cn.com.sky.algorithms.sorting.other;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class TestBubbleSort {

	Random random = new Random();
	int[] array = new int[2000];

	public void init(int[] a) {
		for (int j = 0; j < 2000; j++) {
			a[j] = random.nextInt(100000);
		}
	}

	@Test
	public void bubbleSortTest() {
		init(array);
		Date dateStart = new Date();
		bubbleSort(array);
		Date dateEnd = new Date();
		System.out.println("冒泡排序耗费时间：" + (dateEnd.getTime() - dateStart.getTime()));

		log(array, 10);
		System.out.println("冒泡排序耗费时间：" + (dateEnd.getTime() - dateStart.getTime()));
	}

	@Test
	public void selectSortTest() {
		init(array);
		Date dateStart = new Date();
		selectSort(array);
		Date dateEnd = new Date();
		System.out.println("选择排序耗费时间：" + (dateEnd.getTime() - dateStart.getTime()));

		log(array, 10);
		System.out.println("选择排序耗费时间：" + (dateEnd.getTime() - dateStart.getTime()));
	}

	public void log(int[] a, int top) {
		for (int i = 0; i < top; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public void bubbleSort(int[] array) {
		int temp;
		// 第一层循环： 表明要比较的次数，比如list.count个数，肯定要比较count-1次
		for (int i = 0; i < array.length - 1; i++) {
			// list.count-1：取数据最后一个数下标，
			// j>i: 从后往前的的下标一定大于从前往后的下标，否则就超越了。
			for (int j = array.length - 1; j > i; j--) {
				// 如果前面一个数大于后面一个数则交换
				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	// 选择排序
	public void selectSort(int[] a) {
		int n = a.length;
		for (int k = 0; k < n - 1; k++) {
			int min = k;
			for (int i = k + 1; i < n; i++) {
				if (a[i] < a[min]) {
					min = i;
				}
			}
			if (k != min) {
				int temp = a[k];
				a[k] = a[min];
				a[min] = temp;
			}
		}
	}

}