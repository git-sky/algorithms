package cn.com.sky.algorithms.sorting.radix_sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.com.sky.algorithms.sorting.AbstractSort;

/**
 * <pre>
 * 基数排序（Radix Sort）【Medium】
 *
 * 题目：实现基数排序算法（LSD最低位优先）
 *
 * 算法原理：
 * 1. 将所有待比较数值统一为同样的数位长度，数位较短的数前面补零
 * 2. 从最低位开始，依次对每一位进行排序（使用稳定的排序算法，如计数排序）
 * 3. 从最低位排序一直到最高位排序完成后，数列就变成有序序列
 *
 * LSD（最低位优先）vs MSD（最高位优先）：
 * - LSD：从最低位开始排序，逐位向高位推进
 * - MSD：从最高位开始排序，逐位向低位推进，需要递归处理
 *
 * 为什么基数排序是稳定的？
 * - 每一位的排序必须使用稳定排序（如计数排序）
 * - 相同位值的元素保持之前的相对顺序
 *
 * 时间复杂度：O(d * (n + k))，d为位数，k为基数（十进制k=10）
 * 空间复杂度：O(n + k)
 * 稳定性：稳定
 * </pre>
 */
public class RadixSort extends AbstractSort {

	@Test
	public void sort() {

		// 首先确定排序的趟数;
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}

		// 建立10个队列;
		List<List<Integer>> queue = new ArrayList<List<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}

		// 进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < arr.length; j++) {
				// 得到数字的第time+1位数;
				int x = arr[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				List<Integer> queue2 = queue.get(x);
				queue2.add(arr[j]);
				queue.set(x, queue2);
			}

			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					List<Integer> queue3 = queue.get(k);
					arr[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}
}