package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 一，题目：输入n,用最快的方法求Fibonacci数列的第n项。
 * 
 * 二，定义：Fibonacci数列如下：
 * 
 * f(n)= 1 n=1,2
 * f(n-1)+f(n-2) n>2
 * 
 * 结果： 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597..........
 */
public class Fab {

	public static void main(String[] args) {
		int n = 10;
		int number = fab(n);
		System.out.println(number);
	}

	private static int fab(int n) {
		if (n == 1 || n == 2)
			return 1;

		return fab(n - 1) + fab(n - 2);

	}
}
