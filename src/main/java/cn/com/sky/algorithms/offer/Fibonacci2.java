package cn.com.sky.algorithms.offer;

import org.junit.Test;

/**
 * <pre>
 * 
 * 8.斐波那契数列相似问题
 * 
 * 问题1：
 * (a)一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法?
 * (b)我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法?
 * 
 * 问题2：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 
 */
public class Fibonacci2 {

	@Test
	public void solution() {

		for (int i = 1; i < 15; i++) {
			int item = jumpFloor(i);
			System.out.println(item);
		}

		for (int i = 1; i < 15; i++) {
			int item = jumpFloorII(i);
			System.out.println(item);
		}

	}

	/**
	 * 问题1:循环实现。时间复杂的O(n).f(n)=f(n-1)+f(n-2);
	 */
	public int jumpFloor(int number) {

		if (number <= 0)
			return 0;
		if (number == 1)
			return 1;
		if (number == 2)
			return 2;

		int jumpone = 1;
		int jumptwo = 2;
		int jumpn = 0;

		for (int i = 3; i <= number; i++) {
			jumpn = jumpone + jumptwo;
			jumpone = jumptwo;
			jumptwo = jumpn;
		}

		return jumpn;
	}

	/**
	 * 问题2：循环递归实现。f(n)=2^(n-1);
	 */
	public int jumpFloorII(int number) {
		int count = 0;
		if (number <= 0)
			return count;
		else if (number == 1)
			return 1;
		else if (number == 2)
			return 2;
		else {
			for (int k = 1; k <= number - 1; k++) {
				count += jumpFloorII(number - k);
			}
			count++;
		}
		return count;
	}
}
