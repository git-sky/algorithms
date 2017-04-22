package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * 
 * 鸡尾酒排序又叫定向冒泡排序，来回排序，涟漪排序，搅拌排序，快乐小时排序，他其实是冒泡排序的一种变形。它和冒泡排序的不同之处就在于：冒泡排序是单向进行的，而鸡尾酒排序是以双向在序列中进行排序的。
 * 
 * 鸡尾酒算法原理
 * 
 * i. 先对数组从左到右进行升序的冒泡排序；
 * ii. 再对数组进行从右到左的降序的冒泡排序；
 * iii. 以此类推，持续的、依次的改变冒泡的方向，并不断缩小没有排序的数组范围；
 * 
 * 如图所示：
 * 
 * 图示鸡尾酒排序过程
 * 
 * 例： 88 7 79 64 55 98 48 52 4 13
 * 第一趟: 7 79 64 55 88 48 52 4 13 98
 * 第二趟： 4 7 79 64 55 88 48 42 13 98
 * 第三趟： 4 7 64 55 79 48 42 13 88 98
 * 第四趟： 4 7 13 64 55 79 48 42 88 98
 * 第五趟： 4 7 13 55 64 48 42 79 88 98
 * 第六趟： 4 7 13 42 55 64 48 79 88 98
 * 第七趟： 4 7 13 42 55 48 64 79 88 98
 * 第八趟： 4 7 13 42 48 55 64 79 88 98
 * 
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