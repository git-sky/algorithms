package cn.com.sky.algorithms.offer;

import org.junit.Test;

/**
 * <pre>
 * 9.二进制中1的个数
 * 
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * 
 * 相关问题:
 * (a) 用一条语句判断一个整数是不是2的整数次方.
 * 答案: x&(x-1)==0;
 * (b) 输入两个整数 m 和 n ,计算需要改变 m 的二进制表示中的多少位才能得到 n.
 * 答案:首先求两个数的异或 m^n,然后统计结果中1的个数.
 * 
 * 
 */
public class NumberOf1InBinary {

	@Test
	public void solution() {

		// for (int i = 1; i < 15; i++) {
		// int count = NumberOf1Solution1(i);
		// System.out.println("i:" + i);
		// System.out.println("binary:" + Integer.toBinaryString(i));
		// System.out.println("count:" + count);
		// }

		// for (int i = 1; i < 15; i++) {
		// int count = NumberOf1Solution2(i);
		// System.out.println("i:" + i);
		// System.out.println("binary:" + Integer.toBinaryString(i));
		// System.out.println("count:" + count);
		// }

		for (int i = 1; i < 15; i++) {
			int count = NumberOf1Solution3(i);
			System.out.println("i:" + i);
			System.out.println("binary:" + Integer.toBinaryString(i));
			System.out.println("count:" + count);
		}

	}

	/**
	 * <pre>
	 * 方案3:
	 * 高效新颖的解法: 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
	 */
	public int NumberOf1Solution3(int n) {
		int count = 0;

		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}

		return count;
	}

	/**
	 * <pre>
	 * 方案2:
	 * 为了避免死循环，我们可以不右移输入的数字i：
	 * （1）首先把i和1做与运算，判断i的最低位是不是为1。
	 * （2）接着把1左移一位得到2，再和i做与运算，就能判断i的次低位是不是1。
	 * （3）这样反复左移，每次都能判断i的其中一位是不是1。
	 */
	public int NumberOf1Solution2(int n) {
		int count = 0;
		int flag = 1;
		while (flag >= 1) {
			if ((n & flag) > 0) {
				count++;
			}
			flag = flag << 1;
			System.out.println("flag:" + flag);
			System.out.println("flag binary:" + Integer.toBinaryString(flag));
		}

		return count;
	}

	/**
	 * <pre>
	 * 方案1：
	 * 如果n是负值,会死循环.
	 */
	public int NumberOf1Solution1(int n) {
		int count = 0;
		while (n != 0) {
			int result = (n & 1);
			if (result == 1) {
				count++;
			}
			n >>= 1;
			// System.out.println(Integer.toBinaryString(n));
		}

		return count;
	}
}
