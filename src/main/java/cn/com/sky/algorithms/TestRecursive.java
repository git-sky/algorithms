package cn.com.sky.algorithms;

import org.junit.Test;

/**
 * <pre>
 * 递归与迭代对比测试【Easy】
 *
 * 算法原理：
 * 1. 普通递归：F(n) = F(n-1) + F(n-2)，存在大量重复计算
 *    - 时间复杂度O(2^n)，空间复杂度O(n)
 *    - 问题：重复计算、栈溢出风险
 *
 * 2. 尾递归：将当前计算结果通过参数传递给下一层
 *    - 时间复杂度O(n)，空间复杂度O(n)（Java不支持尾递归优化）
 *    - 优势：不需要回溯计算，逻辑更清晰
 *
 * 3. 迭代法（最优）：使用变量保存前两个值
 *    - 时间复杂度O(n)，空间复杂度O(1)
 *    - 优势：无栈溢出风险，空间最优
 *
 * 为什么递归效率低？
 * - 每次方法调用需要创建栈帧、保存状态、上下文切换
 * - 递归深度大时可能导致栈溢出(StackOverflowError)
 * - 普通递归存在大量重复计算（如斐波那契）
 *
 * 时间复杂度：迭代法O(n)，尾递归O(n)，普通递归O(2^n)
 * 空间复杂度：迭代法O(1)，尾递归O(n)，普通递归O(n)
 * </pre>
 */
public class TestRecursive {

    @Test
    public void test() {
        // 测试用例1：n=10
        System.out.println("=== 测试用例1：n=10 ===");
        System.out.println("普通递归: " + FibonacciRecursive(10));
        System.out.println("尾递归: " + FibonacciTailRecursive(10, 0, 1));
        System.out.println("迭代法: " + FibonacciLoop(10));

        // 测试用例2：n=0
        System.out.println("\n=== 测试用例2：n=0 ===");
        System.out.println("迭代法: " + FibonacciLoop(0));

        // 测试用例3：n=1
        System.out.println("\n=== 测试用例3：n=1 ===");
        System.out.println("迭代法: " + FibonacciLoop(1));

        // 测试用例4：n=2
        System.out.println("\n=== 测试用例4：n=2 ===");
        System.out.println("迭代法: " + FibonacciLoop(2));

        // 测试用例5：n=20
        System.out.println("\n=== 测试用例5：n=20 ===");
        System.out.println("迭代法: " + FibonacciLoop(20));
    }

    /**
     * 普通递归（非最优，存在大量重复计算）
     * 时间复杂度O(2^n)，空间复杂度O(n)
     */
    int FibonacciRecursive(int n) {
        if (n < 2) return n;
        return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    /**
     * 尾递归
     * 将当前计算结果通过参数传递，不需要回溯
     * 时间复杂度O(n)，空间复杂度O(n)（Java不支持尾递归优化）
     */
    int FibonacciTailRecursive(int n, int ret1, int ret2) {
        if (n == 0) return ret1;
        return FibonacciTailRecursive(n - 1, ret2, ret1 + ret2);
    }

    /**
     * 迭代法（最优）
     * 使用两个变量保存前两个斐波那契数
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public int FibonacciLoop(int n) {
        if (n < 2) return n;

        int a = 0;
        int b = 1;
        int total = a + b;

        int i = 2;
        while (i <= n) {
            i++;
            a = b;
            b = total;
            total = a + b;
        }
        return total;
    }
}