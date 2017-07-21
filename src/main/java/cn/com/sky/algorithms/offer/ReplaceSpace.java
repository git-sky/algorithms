package cn.com.sky.algorithms.offer;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

/**
 * <pre>
 * 3.替换空格
 *
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。　
 *
 *
 */
public class ReplaceSpace {

	@Test
	public void solution() {
		char[] source = init();

		System.out.println(Arrays.toString(source));

		char[] result = convert(source);

		System.out.println(Arrays.toString(result));

	}

	public char[] convert(char[] arr) {
		System.out.println("length:" + arr.length);
		int spaceNum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 32) {
				System.out.println("pos:" + i);
				spaceNum++;
			}
		}

		System.out.println("spaceNum = " + spaceNum);

		int incrNum = spaceNum * 2;

		char[] result = new char[incrNum + arr.length];

		for (int i = arr.length - 1, j = result.length - 1; i >= 0 && j >= 0;) {
			char c = arr[i];
			if (c == 32) {
				result[j--] = '0';
				result[j--] = '2';
				result[j--] = '%';
				i--;
			} else {
				result[j--] = arr[i--];
			}
		}

		return result;

	}

	// 65-90 A-Z;
	// 97-122 a-z;
	public char[] init() {

		Random ran = new Random();

		int len = ran.nextInt(30) + 10;
		char[] arr = new char[len];

		for (int i = 0; i < len; i++) {
			char small = (char) (ran.nextInt(25) + 97);
			arr[i] = small;
			int space = ran.nextInt(10);
			System.out.println(space);
			if (space % 10 == 1) {
				arr[i] = (char) 32;
			}
		}

		return arr;

	}
}
