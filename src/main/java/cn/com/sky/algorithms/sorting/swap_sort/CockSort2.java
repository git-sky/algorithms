package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * 鸡尾酒排序（Cocktail Sort / 双向冒泡排序）【Easy】
 *
 * 题目：实现双向冒泡排序
 *
 * 算法原理：
 * 冒泡排序的变体，双向交替进行：
 * 1. 从左到右：将最大元素"冒泡"到右端（升序）
 * 2. 从右到左：将最小元素"沉底"到左端（降序）
 * 3. 重复上述过程，每次缩小未排序范围
 *
 * 为什么比普通冒泡快？
 * - 普通冒泡每趟只能确定一个极值（最大或最小）
 * - 鸡尾酒排序每趟能同时确定两个极值（最大和最小）
 * - 对于某些特定数据（如大部分有序），效率提升明显
 *
 * 示例：
 * 原始: 88 7 79 64 55 98 48 52 4 13
 * 第1趟(→): 7 79 64 55 88 48 52 4 13 98 (98到位)
 * 第2趟(←): 4 7 79 64 55 88 48 52 13 98 (4到位)
 * 第3趟(→): 4 7 64 55 79 48 52 13 88 98 (88到位)
 * ...
 *
 * 时间复杂度：O(n^2)（平均），O(n)（已有序）
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * </pre>
 */
public class CockSort2 {

	

	public static void main(String[] args) {

		// 定义数组num存放10个1-100之间的随机数字
		int num[] = new int[10];
		
		init(num);
		System.out.println(Arrays.toString(num));
		sort(num);
		System.out.println(Arrays.toString(num));

	}
	
	public static void init(int[] num) {

		Random random = new Random();
		// 生成10个1-100随机数算法
		for (int i = 0; i < 10; i++) {
			num[i] = random.nextInt(100) + 1;
			for (int j = 0; j < i; j++) {
				if (num[j] == num[i]) {
					i--;
					break;
				}
			}
		}
//		// 打印数组对象num
//		System.out.println("生成10个随机数，顺序杂乱无章");
//		for (int i = 0; i < num.length; i++) {
//			System.out.print("num[" + i + "]=" + num[i] + " ");
//		}
	}

	public static void sort(int[] num) {
		String direction = "right";
		int small_flag = 1;
		// 开始鸡尾酒排序算
		for (int k = 10; k > 5; k--) {

			if (direction.equals("right")) {

				for (int i = small_flag; i < k; i++) {

					if (num[i] < num[i - 1]) {
						int p = num[i - 1];
						num[i - 1] = num[i];
						num[i] = p;
					}
				}
				direction = "left";
			} else {
				for (int i = k - 1; i > small_flag - 1; i--) {
					if (num[i] < num[i - 1]) {
						int p = num[i - 1];
						num[i - 1] = num[i];
						num[i] = p;
					}
				}
				small_flag++;
				k++;
				direction = "right";
			}

			// 打印数组对象nu
//			System.out.println();
//			System.out.println("使用冒泡排序排列后的顺序:");
//			for (int i = 0; i < num.length; i++)
//				System.out.print("num[" + i + "]=" + num[i] + " ");
		}
	}
}