package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 70. 爬楼梯【Easy】（字节跳动、腾讯高频）
 *
 * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶？
 *
 * 示例：
 * 输入：n = 2
 * 输出：2（1步+1步 或 2步）
 *
 * 输入：n = 3
 * 输出：3（1+1+1、1+2、2+1）
 *
 * 算法原理（斐波那契数列）：
 *
 * 数学模型：
 * 设 f(n) 为爬到第n阶的方法数
 * - 要到达第n阶，可以从第n-1阶爬1步上来
 * - 或者从第n-2阶爬2步上来
 * 因此：f(n) = f(n-1) + f(n-2)
 *
 * 这就是斐波那契数列！
 * 初始条件：
 * f(1) = 1 （只有一种方式：爬1步）
 * f(2) = 2 （两种方式：1+1 或 2）
 *
 * 解法对比：
 *
 * 方法一：滚动变量法（最优）⭐
 * - 时间复杂度：O(n)
 * - 空间复杂度：O(1)
 * - 只使用两个变量存储中间结果
 *
 * 方法二：动态规划数组
 * - 时间复杂度：O(n)
 * - 空间复杂度：O(n)
 * - 使用数组存储所有状态，便于理解
 *
 * 方法三：备忘录递归
 * - 时间复杂度：O(n)
 * - 空间复杂度：O(n)
 * - 递归+缓存，避免重复计算
 *
 * 方法四：纯递归（不推荐）
 * - 时间复杂度：O(2^n)，指数级爆炸
 * - 空间复杂度：O(n)，递归栈深度
 * - 存在大量重复计算，会超时
 *
 * 进阶：矩阵快速幂 / 通项公式
 * - 时间复杂度：O(log n)
 * - 可以进一步优化，但代码复杂度高
 *
 * 时间复杂度：O(n)，最优解法
 * 空间复杂度：O(1)，最优解法
 * </pre>
 */
public class ClimbingStairs70 {

    @Test
    public void solution() {
        ClimbingStairs70 solution = new ClimbingStairs70();

        // 测试用例1：基础测试
        System.out.println("测试用例1 (n=2): " + solution.climbStairs(2));   // 2

        // 测试用例2：3阶
        System.out.println("测试用例2 (n=3): " + solution.climbStairs(3));   // 3

        // 测试用例3：1阶
        System.out.println("测试用例3 (n=1): " + solution.climbStairs(1));   // 1

        // 测试用例4：10阶
        System.out.println("测试用例4 (n=10): " + solution.climbStairs(10)); // 89

        // 测试用例5：大数
        System.out.println("测试用例5 (n=45): " + solution.climbStairs(45)); // 1836311903

        // 测试用例6：使用最优解法验证
        System.out.println("测试用例6(最优解法, n=5): " + solution.climbStairsOptimal(5)); // 8
    }

    /**
     * 方法一：动态规划数组版（当前使用的版本）
     * 使用dp数组记录每一步的状态
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param n 楼梯的阶数
     * @return 爬到楼顶的方法数
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // 状态转移方程
        }

        return dp[n];
    }

    /**
     * 方法二：滚动变量法（最优解法）⭐
     * 只使用两个变量存储前两个状态，空间复杂度降为O(1)
     * 时间复杂度 O(n)，空间复杂度 O(1)
     *
     * @param n 楼梯的阶数
     * @return 爬到楼顶的方法数
     */
    public int climbStairsOptimal(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;    // f(n-2)
        int second = 2;   // f(n-1)

        for (int i = 3; i <= n; i++) {
            int third = first + second;  // f(n) = f(n-1) + f(n-2)
            first = second;              // 更新f(n-2)
            second = third;              // 更新f(n-1)
        }

        return second;
    }
}