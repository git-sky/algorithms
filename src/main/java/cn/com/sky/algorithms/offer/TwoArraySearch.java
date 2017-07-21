package cn.com.sky.algorithms.offer;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 
 * 2.二维数组中的查找
 * 
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。　　
 * 
 * 解题思路：
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数字，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行。
 * 也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 * 
 */
public class TwoArraySearch {

	@Test
	public void solution() {
		int[][] array = init();
		Random ran = new Random();
		int k = ran.nextInt(100);

		print(array);
		System.out.println("k:" + k);

		// print(array);

		boolean exists = search(array, k);
		System.out.println("exists:" + exists);

	}

	public boolean search(int[][] array, int k) {

		int m = 0;// 行
		int n = array[0].length - 1;// 列

		// 从右上角开始；
		while (m <= array.length - 1 && n >= 0) {
			int tmp = array[m][n];
			if (tmp == k) {
				System.out.println("m:" + m + ",n:" + n);
				return true;
			} else {
				if (tmp > k) {
					n--;
				} else if (tmp < k) {
					m++;
				}
			}
		}

		return false;

	}

	public int[][] init() {

		Random ran = new Random();
		int m = ran.nextInt(5) + 1;
		int n = ran.nextInt(5) + 1;
		int[][] array = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = ran.nextInt(100);
				while ((j > 0 && array[i][j] < array[i][j - 1]) || (i > 0 && array[i][j] < array[i - 1][j])) {
					array[i][j] = ran.nextInt(100);
				}
			}
		}

		return array;
	}

	public void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
}
