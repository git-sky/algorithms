package cn.com.sky.algorithms.sorting.other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <pre>
 * 桶排序（Bucket Sort）【Medium】
 *
 * 题目：实现桶排序算法
 *
 * 算法原理：
 * 1. 将数组元素按照映射函数分配到不同的桶中（如按数值范围）
 * 2. 对每个桶内的元素单独排序（可使用其他排序算法）
 * 3. 按顺序合并所有桶中的元素
 *
 * 性能分析：
 * - 分配过程：O(N)
 * - 排序过程：∑ O(Ni*logNi)，Ni为第i个桶的数据量
 * - 总复杂度：O(N + N*(logN - logM))，M为桶数量
 *
 * 极限情况：当N=M时（每桶只有一个元素），时间复杂度为O(N)
 *
 * 时间复杂度：平均O(N + C)，C = N*(logN - logM)
 * 空间复杂度：O(N + M)
 * 稳定性：稳定
 * </pre>
 */
public class BucketSort {
	public static final int ARRAY_SIZE = 10000;
	public static final int BUCKET_SIZE = 10;

	public static void sort(int[] array) {
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < BUCKET_SIZE; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < array.length; i++) {
			int k = array[i] / 10;
			bucket.get(k).add(array[i]);
		}
		for (ArrayList<Integer> list : bucket)
			Collections.sort(list);
		for (ArrayList<Integer> list : bucket)
			System.out.println(list);
	}

	public static int[] init() {
		int[] array = new int[ARRAY_SIZE];
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("d:/score.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String string = new String();
		int i = 0;
		try {
			while ((string = br.readLine()) != null) {
				array[i] = Integer.valueOf(string);
				i++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static void main(String[] argv) {

		int[] array = init();
		sort(array);

	}

}