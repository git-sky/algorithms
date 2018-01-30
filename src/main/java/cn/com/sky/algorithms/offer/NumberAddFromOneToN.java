package cn.com.sky.algorithms.offer;

import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 * 求1+2+3+....+n
 * 
 * 
 * 题目：
 * 求1+2+3+...+n，要求不能使用乘除法，for,while,if,else,switch,case等关键字及条件判断语句(a?b:c)。
 * 
 * </pre>
 */
public class NumberAddFromOneToN {

	int sum = 0;

	@Test
	public void solution() {

		Random r = new Random();
		int count = r.nextInt(100);
		add(count);
		System.out.println(count);
		System.out.println(sum);

	}

	/**
     * 递归可以实现循环的功能.
	 */
	public boolean add(int n) {
		sum += n;
		return (n > 0) && add(n - 1);
	}

}
