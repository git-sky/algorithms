package cn.com.sky.algorithms.strings;

import java.util.Arrays;

import org.junit.Test;

/**
 * KMP模式匹配算法
 */
public class TestStringCompareKMP {

	@Test
	public void compare() {

		int i = 0;
		int j = 0;

		String S = "abcdefgoogleaaaaa";

		// String T = "abcdex";// 0, 1, 1, 1, 1, 1

		String T = "abcabx";// 0, 1, 1, 1, 2, 3
		//
		T = "ababaaaba";// 0, 1, 1, 2, 3, 4, 2, 2, 3
//		T = "ABCDABD";//0, 0, 0, 0, 1, 2, 0, 0
//		T = "ababababca";// 0, 0, 1, 2, 3, 4, 5, 6, 0, 1

		// T = "ababcaabc";

		int next[] = new int[T.length() + 1];

//		getNext(T, next);

		System.out.println(Arrays.toString(next));

		System.out.println(Arrays.toString(getNext(T)));

		makeNext(T, next);
		System.out.println(Arrays.toString(next));

		while (i < S.length() && j < T.length()) {

			if (j == 0 || S.charAt(i) == T.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
			}
		}
		if (j >= T.length()) {
			System.out.println(i - T.length());
		}

	}

	private int[] getNext(String T) {
		int len = T.length();
		int j = 0;

		int next[] = new int[len + 1];// next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
		next[0] = next[1] = 0;

		for (int i = 1; i < len; i++)// i表示字符串的下标，从0开始
		{// j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
			while (j > 0 && T.charAt(i) != T.charAt(j))
				j = next[j];
			if (T.charAt(i) == T.charAt(j))
				j++;
			next[i + 1] = j;
		}

		return next;
	}

	private void getNext(String T, int[] next) {
		int i = 1;
		int j = 0;
		next[0] = 0;
		while (i < T.length()) {
			if (T.charAt(i) == T.charAt(j)) {
				++j;
				next[i] = j;
			} else {
				j = next[j];
			}
			++i;
		}
	}

	void makeNext(String T, int next[]) {
		int q, k;// q:模版字符串下标；k:最大前后缀长度
		int m = T.length();// 模版字符串长度
		next[0] = 0;// 模版字符串的第一个字符的最大前后缀长度为0
		for (q = 1, k = 0; q < m; ++q)// for循环，从第二个字符开始，依次计算每一个字符对应的next值
		{
			while (k > 0 && T.charAt(q) != T.charAt(k))
				// 递归的求出P[0]···P[q]的最大的相同的前后缀长度k
				k = next[k - 1]; // 不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解
			if (T.charAt(q) == T.charAt(k))// 如果相等，那么最大相同前后缀长度加1
			{
				k++;
			}
			next[q] = k;
		}
	}

}
