package cn.com.sky.algorithms.interview;

/**
 * 题目描述如下：输入两个整数n 和m，从数列1，2，3.......n 中随意取几个数，
 * 
 * 使其和等于m ，要求将其中所有的可能组合列出来。
 * 
 * 分析:
 * 
 * 1、本体其实就是考察数的组合，对于此类问题，通常手段都是递归，而我们的目标就在于找出递归式。
 * 
 * 2、问题其实本质上就是0/1背包问题，对于每一个n，我们采用贪婪策略，先考察是否取n，如果取n，那么子问题就变成了find(n-1,m-n)，而如果舍弃n，子问题则为find(n-1,m)。
 * 
 * 3、那么，如何制定解的判定策略？我们知道，递归需要边界条件，而针对背包问题，边界条件只有两种，如果n<1或者m<1，那么便相当于“溢出”，无法combo出m，
 * 而另一种可能就是在剩余的n个里恰好满足m==n，即此时 背包刚好填充满，输出一组解单元。除此之外，再无其他。
 * 
 * 
 * 求解思路：
 * 
 * 1.首先判断，如果n>m，则n中大于m的数不可能参与组合，此时置n = m;
 * 
 * 2.将最大数n加入且n == m,则满足条件，输出；
 * 
 * 3.将n分两种情况求解，（1）n没有加入，取n = n - 1; m = m;递归下去；（2）n加入，取n = n - 1l, m = m - n,递归下去
 * 
 */
public class Combination {

	public static void main(String[] args) {
		int n = 10;
		int m = 15;
		int[] items = new int[n];

		findCombination(n, m, items);
	}

	public static void findCombination(int n, int m, int[] items) {
		if (n < 1 || m < 1)
			return;
		if (n > m)
			n = m;
		if (n == m) {
			items[n - 1] = 1;
			print(items);
			items[n - 1] = 0;
		}

		items[n - 1] = 1;
		findCombination(n - 1, m - n, items);
		items[n - 1] = 0;
		findCombination(n - 1, m, items);
	}

	private static void print(int[] items) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == 1)
				System.out.println(i + 1);
		}
		System.out.println();
	}

}
