package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Arrays;

public class CockSort {

	public static void main(String[] args) {
		// int[] x = { 6, 2, 4, 1, 5, 9 };

		int[] x = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(x));
		selection_sort(x);
		System.out.println(Arrays.toString(x));
	}

	public static void selection_sort(int[] arr) {
		boolean swapped = false;
		do {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
				}
			}

			swapped = false;
			for (int j = arr.length - 1; j >= 1; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}

}
