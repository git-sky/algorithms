package cn.com.sky.algorithms.interview;

/**
 * 输出1+2+3+...+n 的值
 */
public class PrintSum {

	public static void main(String[] args) {
		int n = 100;
		int total = calcRecursive(n);
		System.out.println(total);

		int total2 = calcLoop(n);
		System.out.println(total2);
	}

	/**
	 * 递归实现
	 */
	private static int calcRecursive(int n) {
		if (n == 1) {
			return 1;
		}

		return n + calcRecursive(n - 1);
	}

	/**
	 * 循环实现
	 */
	private static int calcLoop(int n) {
		int total = 0;
		while (n > 0) {
			total += n;
			n--;
		}
		return total;
	}

}
