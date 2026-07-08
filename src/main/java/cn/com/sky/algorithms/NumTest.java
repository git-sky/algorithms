package cn.com.sky.algorithms;

import org.junit.Test;

/**
 * <pre>
 * 位运算测试 - 右移与取模【Easy】
 *
 * 算法原理：
 * 1. i % 2：判断整数的奇偶性（0=偶数，1=奇数）
 * 2. i >>= 1：右移一位，等价于 i = i / 2（整数除法）
 * 3. 右移操作逐位消除最低位，可用于计算整数的二进制位数
 *
 * 示例分析（i=17，二进制10001）：
 * - a = 17 % 2 = 1（奇数）
 * - 第1次右移：i = 1000 = 8 > 1，count=1
 * - 第2次右移：i = 100 = 4 > 1，count=2
 * - 第3次右移：i = 10 = 2 > 1，count=3
 * - 第4次右移：i = 1 = 1，不大于1，退出循环
 * - 结果：count=3，即17的二进制10001去掉最低位后，大于1的位数为3
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumTest {

	@Test
	public void test() {
		// 测试用例1：i=17（奇数）
		System.out.println("=== 测试用例1：i=17 ===");
		int i = 17;
		int a = i % 2;
		int count = 0;
		int temp = i;
		while ((i >>= 1) > a) {
			System.out.println(i);
			count++;
		}
		System.out.println("count=" + count + ", 原始值=" + temp + ", 奇偶=" + (a == 0 ? "偶数" : "奇数"));

		// 测试用例2：i=16（偶数）
		System.out.println("\n=== 测试用例2：i=16 ===");
		i = 16;
		a = i % 2;
		count = 0;
		temp = i;
		while ((i >>= 1) > a) {
			System.out.println(i);
			count++;
		}
		System.out.println("count=" + count + ", 原始值=" + temp + ", 奇偶=" + (a == 0 ? "偶数" : "奇数"));

		// 测试用例3：i=1
		System.out.println("\n=== 测试用例3：i=1 ===");
		i = 1;
		a = i % 2;
		count = 0;
		temp = i;
		while ((i >>= 1) > a) {
			System.out.println(i);
			count++;
		}
		System.out.println("count=" + count + ", 原始值=" + temp);

		// 测试用例4：i=8
		System.out.println("\n=== 测试用例4：i=8 ===");
		i = 8;
		a = i % 2;
		count = 0;
		temp = i;
		while ((i >>= 1) > a) {
			System.out.println(i);
			count++;
		}
		System.out.println("count=" + count + ", 原始值=" + temp);
	}
}