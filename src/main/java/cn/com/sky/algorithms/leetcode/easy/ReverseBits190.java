package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 190. 颠倒二进制位【Easy】
 * 
 * 题目描述：颠倒给定的 32 位无符号整数的二进制位。
 * 
 * 示例：
 * 输入：43261596（二进制 00000010100101000001111010011100）
 * 输出：964176192（二进制 00111001011110000010100101000000）
 * 
 * 算法原理（逐位处理）：
 * 1. 初始化结果为 0
 * 2. 每次取 n 的最低位（n & 1），加到结果中
 * 3. 结果左移一位，n 右移一位
 * 4. 重复 32 次
 * 
 * 进阶：如果函数被多次调用，可以使用查表法或分治法优化
 * - 查表法：预计算 256 个字节的反转结果
 * - 分治法：依次交换16位、8位、4位、2位、1位
 * 
 * 时间复杂度：O(1)，固定32次操作
 * 空间复杂度：O(1)
 * </pre>
 */
public class ReverseBits190 {

    public static void main(String[] args) {
        ReverseBits190 solution = new ReverseBits190();

        // 测试用例1：正常情况
        int n1 = 43261596;
        System.out.println("测试用例1: 输入=" + n1);
        System.out.println("结果: " + solution.reverseBits(n1)); // 964176192

        // 测试用例2：全0
        System.out.println("测试用例2: " + solution.reverseBits(0)); // 0

        // 测试用例3：全1（-1的补码）
        System.out.println("测试用例3: " + solution.reverseBits(-1)); // -1

        // 测试用例4：1
        System.out.println("测试用例4: " + solution.reverseBits(1)); // -2147483648

        // 测试用例5：2的31次方
        System.out.println("测试用例5: " + solution.reverseBits(Integer.MIN_VALUE)); // 1
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}