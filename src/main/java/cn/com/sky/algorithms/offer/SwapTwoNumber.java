package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer - 不使用额外空间交换两个数【Easy】
 *
 * 题目：不使用额外空间，交换两个数的值。
 *
 * 算法原理：
 * 方法1（加减法）：
 *   a = a + b;  // a现在保存了两数之和
 *   b = a - b;  // b = (a+b) - b = 原来的a
 *   a = a - b;  // a = (a+b) - 原来的a = 原来的b
 *   缺点：可能溢出
 *
 * 方法2（异或法）：
 *   a = a ^ b;  // a保存异或结果
 *   b = a ^ b;  // b = (a^b) ^ b = a
 *   a = a ^ b;  // a = (a^b) ^ a = b
 *   优点：不会溢出
 *
 * 异或运算性质：
 *   1. a ^ a = 0（任何数与自身异或为0）
 *   2. a ^ 0 = a（任何数与0异或为自身）
 *   3. 异或满足交换律和结合律
 *
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SwapTwoNumber {

    public static void main(String[] args) {
        // 测试用例1：正常交换
        System.out.println("=== 测试用例1：加减法交换 ===");
        int a1 = 5, b1 = 3;
        System.out.println("交换前: a=" + a1 + ", b=" + b1);
        swapWithPlus(a1, b1);

        // 测试用例2：异或法交换
        System.out.println("\n=== 测试用例2：异或法交换 ===");
        int a2 = 10, b2 = 20;
        System.out.println("交换前: a=" + a2 + ", b=" + b2);
        swapWithXor(a2, b2);

        // 测试用例3：含0
        System.out.println("\n=== 测试用例3：含0 ===");
        int a3 = 0, b3 = 7;
        System.out.println("交换前: a=" + a3 + ", b=" + b3);
        swapWithXor(a3, b3);

        // 测试用例4：负数
        System.out.println("\n=== 测试用例4：负数 ===");
        int a4 = -5, b4 = 8;
        System.out.println("交换前: a=" + a4 + ", b=" + b4);
        swapWithXor(a4, b4);

        // 测试用例5：相同值
        System.out.println("\n=== 测试用例5：相同值 ===");
        int a5 = 6, b5 = 6;
        System.out.println("交换前: a=" + a5 + ", b=" + b5);
        swapWithXor(a5, b5);
    }

    /**
     * 加减法交换
     * 缺点：当a+b超过int范围时会溢出
     */
    public static void swapWithPlus(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("交换后: a=" + a + ", b=" + b);
    }

    /**
     * 异或法交换
     * 优点：不会溢出
     */
    public static void swapWithXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换后: a=" + a + ", b=" + b);
    }
}