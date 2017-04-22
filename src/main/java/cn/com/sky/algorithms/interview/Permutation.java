package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 
 * 输出一个集合的子集全排列. 
 * 例如
 * 输入：{"a","b"}
 * 输出：a,b,ab,ba
 * 
 * </pre>
 */
public class Permutation {

	public static void main(String[] args) {
		String[] array = new String[] { "a", "b", "c", "d" };
		// String[] array = new String[] { "a", "b", "b" };
		perm(array, 0, 2, array.length - 1);
	}

	private static void perm(String[] array, int begin, int m, int end) {

		if (begin == m) {// 结束条件
			print(array, m);
			return;
		}

		for (int i = begin; i <= end; i++) {
			if (needSwap(array, begin, i)) {// 重复数据不排序
				swap(array, begin, i);
				perm(array, begin + 1, m, end);
				swap(array, begin, i);
			}
		}

	}

	private static void swap(String[] arr, int i, int j) {
		if (i == j)
			return;
		String tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 判断是否需要交换位置，相同元素不用交换。例如abb中，第二个b和第三个b不需要交换。
	private static boolean needSwap(String[] arr, int i, int j) {
		for (; i < j; i++) {
			if (arr[i] == arr[j]) {
				return false;
			}
		}
		return true;

	}

	private static void print(String[] array, int end) {
		for (int i = 0; i <= end; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}

}