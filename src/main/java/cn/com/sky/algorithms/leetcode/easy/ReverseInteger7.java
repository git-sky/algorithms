package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 7. 整数反转【Easy】
 * 
 * 题目描述：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位有符号整数的范围，则返回 0。
 * 
 * 示例1：输入 123，输出 321
 * 示例2：输入 -123，输出 -321
 * 示例3：输入 120，输出 21
 * 
 * 算法原理（数学方法 + 溢出检测）：
 * 1. 每次取出最后一位数字（x % 10），拼接到结果上
 * 2. 拼接前检查是否会溢出：如果 (newResult - tail) / 10 != result，说明溢出
 * 3. 这种检测方式可以正确处理 Integer.MIN_VALUE 的情况
 * 
 * 溢出检测原理：
 * - result * 10 + tail = newResult
 * - 反向验证：(newResult - tail) / 10 应该等于 result
 * - 如果溢出，反向计算的结果不等于 result
 * 
 * 时间复杂度：O(log|x|)，x 的位数
 * 空间复杂度：O(1)
 * </pre>
 */
public class ReverseInteger7 {

    public static void main(String[] args) {
        ReverseInteger7 solution = new ReverseInteger7();

        // 测试用例1：正数
        System.out.println("测试用例1: " + solution.reverse(123));    // 321

        // 测试用例2：负数
        System.out.println("测试用例2: " + solution.reverse(-123));   // -321

        // 测试用例3：末尾有0
        System.out.println("测试用例3: " + solution.reverse(120));    // 21

        // 测试用例4：0
        System.out.println("测试用例4: " + solution.reverse(0));      // 0

        // 测试用例5：溢出情况
        System.out.println("测试用例5: " + solution.reverse(1534236469)); // 0（溢出）

        // 测试用例6：最小负数
        System.out.println("测试用例6: " + solution.reverse(-2147483648)); // 0（溢出）

        // 测试用例7：个位数
        System.out.println("测试用例7: " + solution.reverse(5));      // 5
    }

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}