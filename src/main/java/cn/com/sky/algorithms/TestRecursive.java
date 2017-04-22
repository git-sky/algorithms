package cn.com.sky.algorithms;

import org.junit.Test;

/**
 * <pre>
 * 
 * 为什么递归的效率低？
 * java将为每个线程维护一个栈，栈里将为每个方法保存一个栈帧，栈帧代表了一个方法的运行状态。 也就是我们常说的方法栈。最后一个为当前运行的栈帧。
 * 那么每一次方法调用会涉及：
 * 1.为新调用方法的生成一个栈帧
 * 2.保存当前方法的栈帧状态
 * 3.栈帧上下文切换，切换到最新的方法栈帧。
 * 递归实现将导致在栈内存的消耗(往往需要调整Xss参数)和因为创建栈帧和切换的性能开销，最终大大的影响效率！
 * 递归有可能出现堆栈溢出的情况。
 * 
 * 尾递归就是从最后开始计算, 每递归一次就算出相应的结果, 也就是说, 函数调用出现在调用者函数的尾部,
 * 因为是尾部, 所以根本没有必要去保存任何局部变量. 直接让被调用的函数返回时越过调用者, 返回到调用者的调用者去。
 * 尾递归就是把当前的运算结果（或路径）放在参数里传给下层函数。
 * 
 * </pre>
 */
public class TestRecursive {

	// 0 1 1 2 3 5 8 13
	@Test
	public void test() {
		// for (int i = 0; i < 100; i++) {
		// int total = FibonacciRecursive(i);// 普通递归
		// int total = FibonacciTailRecursive(i, 0, 1);//尾递归
		int total = FibonacciLoop(100);

		System.out.println(total);
		// System.out.println("========================================" + i);
		// }
	}

	/**
	 * 普通递归
	 */
	int FibonacciRecursive(int n) {
		if (n < 2)
			return n;
		return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
	}

	/**
	 * 尾递归
	 */
	int FibonacciTailRecursive(int n, int ret1, int ret2) {
		if (n == 0)
			return ret1;
		return FibonacciTailRecursive(n - 1, ret2, ret1 + ret2);
	}

	/**
	 * 循环实现Fibonacci
	 */
	public int FibonacciLoop(int n) {

		if (n < 2)
			return n;

		int a = 0;
		int b = 1;
		int total = a + b;

		int i = 2;
		while (i <= n) {
			i++;
			System.out.println(total);
			System.out.println("==================================" + i);
			a = b;
			b = total;
			total = a + b;
		}
		return total;

	}
}
