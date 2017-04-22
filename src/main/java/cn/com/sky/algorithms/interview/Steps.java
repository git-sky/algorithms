package cn.com.sky.algorithms.interview;

import org.junit.Test;

/**
 * 上台阶问题，有N个台阶，1步或者2步上台阶，有多少走法。
 */
public class Steps {

	@Test
	public void step() {
		int n = 3;
		int sum = getStep(n);
		System.out.println(sum);
	}

	public int getStep(int n) {
		if (n == 1)
			return 1;
		if (n == 2) {
			return 2;
		}
		return getStep(n - 1) + 1 + getStep(n - 2) + 2;

	}
}
