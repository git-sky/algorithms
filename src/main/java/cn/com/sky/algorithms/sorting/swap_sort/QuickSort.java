package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Random;

/**
 * <pre>
 *  快速排序
 *  
 *  最差时间复杂度为：O(n^2)
 *  平均时间复杂度：O(nlogn)
 *  
 * 最优的情况下空间复杂度为：O(logn)  ；每一次都平分数组的情况
 * 最差的情况下空间复杂度为：O( n )      ；退化为冒泡排序的情况
 * 
 * </pre>
 */
public class QuickSort {
	/* 快速排序 　　 */
	public static void main(String[] args) {
		Random random = new Random();
		int[] pData = new int[10];
		for (int i = 0; i < pData.length; i++) { // 随机生成10个排序数
			Integer a = random.nextInt(100);
			pData[i] = a;
			System.out.print(pData[i] + " ");
		}
		System.out.println();
		int left = 0;
		int right = pData.length - 1;

		// 排序方法
		Sort(pData, left, right);

		// 排序后：
		for (int i = 0; i < pData.length; i++) {

			System.out.print(pData[i] + " ");
		}
		System.out.println();
	}

	public static int[] Sort(int[] pData, int left, int right) {
		int middle, strTemp;
		int i = left;
		int j = right;
		middle = pData[(left + right) / 2];
		do {
			while ((pData[i] < middle) && (i < right))
				i++;
			while ((pData[j] > middle) && (j > left))
				j--;
			if (i <= j) {
				strTemp = pData[i];
				pData[i] = pData[j];
				pData[j] = strTemp;
				i++;
				j--;
			}
			for (int k = 0; k < pData.length; k++) {
				System.out.print(pData[k] + " ");
			}
			System.out.println(" 趟");
		} while (i < j);// 如果两边扫描的下标交错，完成一次排序 　　
		if (left < j)
			Sort(pData, left, j); // 递归调用 　　
		if (right > i)
			Sort(pData, i, right); // 递归调用 　
		return pData;
	}
}