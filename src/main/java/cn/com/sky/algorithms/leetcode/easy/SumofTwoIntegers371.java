package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 371. 两整数之和【Medium】
 * 
 * 题目描述：不使用运算符 + 和 -，计算两整数之和。
 * 
 * 示例1：输入 a = 1, b = 2，输出 3
 * 示例2：输入 a = -2, b = 3，输出 1
 * 
 * 算法原理（位运算模拟加法）：
 * 1. 异或运算（^）模拟不进位的加法
 *    - 0 ^ 0 = 0, 0 ^ 1 = 1, 1 ^ 0 = 1, 1 ^ 1 = 0
 *    - 正好对应加法中不考虑进位的结果
 * 2. 与运算（&）+ 左移（<<1）模拟进位
 *    - 1 & 1 = 1 表示需要进位，左移一位表示进位的位置
 * 3. 递归：将不进位结果和进位结果相加，直到没有进位（b = 0）
 * 
 * 示例：a = 3(011), b = 5(101)
 * - 异或：011 ^ 101 = 110（不进位结果）
 * - 与：011 & 101 = 001，左移 = 010（进位）
 * - 继续递归：110 + 010 → 最终 1000 = 8
 * 
 * 时间复杂度：O(log n)，递归深度
 * 空间复杂度：O(log n)，递归栈
 * </pre>
 */
public class SumofTwoIntegers371 {

    public static void main(String[] args) {
        SumofTwoIntegers371 solution = new SumofTwoIntegers371();

        // 测试用例1：正数
        System.out.println("测试用例1: " + solution.getSum(1, 2));      // 3

        // 测试用例2：负数
        System.out.println("测试用例2: " + solution.getSum(-1, -1000)); // -1001

        // 测试用例3：正负混合
        System.out.println("测试用例3: " + solution.getSum(-2, 3));     // 1

        // 测试用例4：0
        System.out.println("测试用例4: " + solution.getSum(0, 0));      // 0

        // 测试用例5：大数
        System.out.println("测试用例5: " + solution.getSum(1000, 2000)); // 3000

        // 测试用例6：一个为0
        System.out.println("测试用例6: " + solution.getSum(5, 0));      // 5
    }

    public int getSum(int a, int b) {
        return add(a, b);
    }

    private int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int xor = a ^ b;
        int carry = a & b;
        return add(xor, carry << 1);
    }
}