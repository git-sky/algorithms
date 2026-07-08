package cn.com.sky.algorithms.searching.statics.ordered_list.fibonacci_search;

/**
 * <pre>
 * 斐波那契查找（Fibonacci Search）【Medium】
 *
 * 题目：实现斐波那契查找算法
 *
 * 算法原理：
 * 1. 利用斐波那契数列的性质：F[k] = F[k-1] + F[k-2]
 * 2. 将数组长度扩展到最近的斐波那契数-1
 * 3. 使用斐波那契数列来确定分割点
 * 4. mid = low + F[k-1] - 1
 *
 * 为什么使用斐波那契？
 * - 黄金分割比例（约0.618）接近最优分割点
 * - 只涉及加减法，不涉及除法，效率高
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 *
 * 与二分查找对比：
 * - 二分查找：mid = (low+high)/2，除法运算
 * - 斐波那契：mid = low+F[k-1]-1，加减法运算（更快）
 * </pre>
 */
public class FibonacciSearch {

	public int fibonacciSearch(int[] a, int key) {
		int low, high, mid, k = 0;
		low = 0;
		high = a.length;
		while (a.length > fibonacci(k) - 1)
			k++;
		for (int i = a.length; i < fibonacci(k) - 1; i++)
			a[i] = a[a.length - 1];
		while (low <= high) {
			mid = low + fibonacci(k - 1) - 1;
			if (key < a[mid]) {
				high = mid - 1;
				k = k - 1;
			} else if (key > a[mid]) {
				low = mid + 1;
				k = k - 2;
			} else {
				if (mid <= a.length)
					return mid;
				else
					return a.length;
			}
		}
		return -1;
	}

	public int fibonacci(int n) {
		return n > 2 ? fibonacci(n - 1) + fibonacci(n - 2) : 1;
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int key = 3;

		FibonacciSearch fibonacci = new FibonacciSearch();
		int pos = fibonacci.fibonacciSearch(a, key);
		System.out.println(pos);
	}
}