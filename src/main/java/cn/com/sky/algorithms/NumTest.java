package cn.com.sky.algorithms;

import org.junit.Test;

public class NumTest {

	@Test
	public void test() {

		int i = 17;
		int a = i % 2;
		int count = 0;
		while ((i >>= 1) > a) {
			// if (i == 0)
			// break;
			System.out.println(i);
			count++;
		}
		System.out.println(count);
	}
}
