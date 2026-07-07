package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 65. 不用加减乘除做加法【Medium】
 *
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 算法原理（位运算模拟加法）：
 * 1. 异或运算（^）：模拟不考虑进位的加法
 *    例如：5 ^ 3 = 101 ^ 011 = 110 = 6（不进位的加法结果）
 *
 * 2. 与运算（&）后左移一位：模拟进位
 *    例如：5 & 3 = 101 & 011 = 001，左移一位 = 010 = 2（进位）
 *
 * 3. 将不进位结果和进位相加，重复上述过程直到没有进位
 *    例如：6 + 2 = 8（最终结果）
 *
 * 核心思想：
 *   a + b = (a ^ b) + ((a & b) << 1)
 *   当进位为0时，异或的结果就是最终答案
 *
 * 时间复杂度：O(1)，最多循环32次（int的位数）
 * 空间复杂度：O(1)
 * </pre>
 */
public class ImplementPlus {

    public static void main(String[] args) {
        ImplementPlus solution = new ImplementPlus();

        // 测试用例1：正常加法
        System.out.println("=== 测试用例1：正常加法 ===");
        System.out.println("5 + 3 = " + solution.add(5, 3));     // 8
        System.out.println("10 + 20 = " + solution.add(10, 20)); // 30

        // 测试用例2：含0
        System.out.println("\n=== 测试用例2：含0 ===");
        System.out.println("0 + 5 = " + solution.add(0, 5));     // 5
        System.out.println("7 + 0 = " + solution.add(7, 0));     // 7
        System.out.println("0 + 0 = " + solution.add(0, 0));     // 0

        // 测试用例3：负数
        System.out.println("\n=== 测试用例3：负数 ===");
        System.out.println("-5 + 3 = " + solution.add(-5, 3));   // -2
        System.out.println("5 + (-3) = " + solution.add(5, -3)); // 2
        System.out.println("-5 + -3 = " + solution.add(-5, -3)); // -8

        // 测试用例4：大数
        System.out.println("\n=== 测试用例4：大数 ===");
        System.out.println("1000000 + 2000000 = " + solution.add(1000000, 2000000)); // 3000000

        // 测试用例5：递归法
        System.out.println("\n=== 测试用例5：递归法 ===");
        System.out.println("5 + 3 = " + solution.plusRecursive(5, 3)); // 8
        System.out.println("-5 + 3 = " + solution.plusRecursive(-5, 3)); // -2
    }

    /**
     * 循环实现：位运算加法
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return a + b
     */
    public int add(int a, int b) {
        while (b != 0) {
            // 不进位的加法
            int sum = a ^ b;
            // 进位
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    /**
     * 递归实现：位运算加法
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return a + b
     */
    public int plusRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return plusRecursive(a ^ b, (a & b) << 1);
    }
}