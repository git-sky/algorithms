package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 191. 位1的个数【Easy】
 * 
 * 题目描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 '1' 的个数（汉明重量）。
 * 
 * 示例：输入 11（二进制 00000000000000000000000000001011），输出 3
 * 
 * 算法原理（Brian Kernighan 算法）：
 * 1. n & (n-1) 可以消除 n 中最低位的1
 *    - 例如：n = 1010, n-1 = 1001, n & (n-1) = 1000
 * 2. 每次执行该操作，1的个数减1
 * 3. 重复直到 n 为0，执行次数即为1的个数
 * 
 * 优势：相比逐位检查（固定32次），此方法只需执行"1的个数"次
 * 
 * 时间复杂度：O(k)，k 为1的个数
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        // 测试用例1：正常情况
        System.out.println("测试用例1: " + solution.hammingWeight(11));         // 3 (1011)

        // 测试用例2：0
        System.out.println("测试用例2: " + solution.hammingWeight(0));          // 0

        // 测试用例3：全1（-1的补码）
        System.out.println("测试用例3: " + solution.hammingWeight(-1));         // 32

        // 测试用例4：2的幂
        System.out.println("测试用例4: " + solution.hammingWeight(1024));        // 1

        // 测试用例5：交替1和0
        System.out.println("测试用例5: " + solution.hammingWeight(0x55555555)); // 16

        // 测试用例6：1
        System.out.println("测试用例6: " + solution.hammingWeight(1));          // 1
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}