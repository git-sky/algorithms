package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 476. 数字的补数【Easy】
 * 
 * 题目描述：给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 注意：不考虑二进制表示中的前导零。
 * 
 * 示例1：
 * 输入：5（二进制 101）
 * 输出：2（二进制 010）
 * 
 * 示例2：
 * 输入：1（二进制 1）
 * 输出：0（二进制 0）
 * 
 * 算法原理（掩码异或法）：
 * 1. 构造一个与 num 二进制位数相同的全1掩码 mask
 * 2. mask = 最高位1左移一位后减1
 *    - 例如：num = 5(101), 最高位1在第3位，mask = 1000 - 1 = 111
 * 3. 补数 = mask ^ num
 *    - 5(101) ^ 7(111) = 2(010)
 * 
 * 构造 mask 的过程：
 * - 不断将 temp 右移，同时将 mask 左移
 * - 当 temp 变为0时，mask 就是全1掩码
 * 
 * 时间复杂度：O(log n)，n 的位数
 * 空间复杂度：O(1)
 * </pre>
 */
public class NumberComplement476 {

    public static void main(String[] args) {
        NumberComplement476 solution = new NumberComplement476();

        // 测试用例1：5 -> 2
        System.out.println("测试用例1: " + solution.findComplement(5));  // 2

        // 测试用例2：1 -> 0
        System.out.println("测试用例2: " + solution.findComplement(1));  // 0

        // 测试用例3：2 -> 1
        System.out.println("测试用例3: " + solution.findComplement(2));  // 1

        // 测试用例4：7 -> 0
        System.out.println("测试用例4: " + solution.findComplement(7));  // 0

        // 测试用例5：10 -> 5
        System.out.println("测试用例5: " + solution.findComplement(10)); // 5

        // 测试用例6：大数
        System.out.println("测试用例6: " + solution.findComplement(2147483647)); // 0
    }

    public int findComplement(int num) {
        int temp = num;
        int mask = 1;
        while (temp > 0) {
            temp >>= 1;
            mask <<= 1;
        }
        return (mask - 1) ^ num;
    }
}