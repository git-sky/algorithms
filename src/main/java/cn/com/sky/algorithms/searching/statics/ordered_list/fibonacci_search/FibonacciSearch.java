package cn.com.sky.algorithms.searching.statics.ordered_list.fibonacci_search;

/**
 * 斐波那契查找
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