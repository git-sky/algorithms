package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 10-II. 青蛙跳台阶问题【Easy】
 *
 * 问题1：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 等价问题：用2*1的小矩形覆盖2*n的大矩形，总共有多少种方法？
 * 解答：f(n) = f(n-1) + f(n-2)，即斐波那契数列
 *
 * 问题2：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解答：f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0) = 2 * f(n-1) = 2^(n-1)
 *
 * 算法原理：
 * 问题1推导：
 *   跳到第n级台阶，最后一步只有两种可能：
 *   - 从第n-1级跳1级上来，有f(n-1)种
 *   - 从第n-2级跳2级上来，有f(n-2)种
 *   所以 f(n) = f(n-1) + f(n-2)
 *
 * 问题2推导：
 *   跳到第n级台阶，最后一步可以从第0级到第n-1级任意一级跳上来
 *   f(n) = f(n-1) + f(n-2) + ... + f(1) + f(0)
 *   又 f(n-1) = f(n-2) + ... + f(1) + f(0)
 *   所以 f(n) = 2 * f(n-1)，即 f(n) = 2^(n-1)
 *
 * 时间复杂度：问题1 O(n)，问题2 O(1)
 * 空间复杂度：O(1)
 * </pre>
 */
public class Fibonacci2 {

    public static void main(String[] args) {
        Fibonacci2 solution = new Fibonacci2();

        // 测试用例1：问题1 - 青蛙跳台阶
        System.out.println("=== 问题1：青蛙跳1级或2级台阶 ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("跳" + i + "级台阶: " + solution.jumpFloor(i) + "种跳法");
        }

        // 测试用例2：问题2 - 青蛙跳n级台阶
        System.out.println("\n=== 问题2：青蛙跳1到n级台阶 ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("跳" + i + "级台阶: " + solution.jumpFloorII(i) + "种跳法");
        }

        // 测试用例3：边界值
        System.out.println("\n=== 测试用例3：边界值 ===");
        System.out.println("jumpFloor(1) = " + solution.jumpFloor(1)); // 1
        System.out.println("jumpFloor(2) = " + solution.jumpFloor(2)); // 2
        System.out.println("jumpFloorII(1) = " + solution.jumpFloorII(1)); // 1
        System.out.println("jumpFloorII(2) = " + solution.jumpFloorII(2)); // 2

        // 测试用例4：验证问题2的公式 2^(n-1)
        System.out.println("\n=== 测试用例4：验证问题2公式 ===");
        for (int i = 1; i <= 10; i++) {
            int expected = (int) Math.pow(2, i - 1);
            int actual = solution.jumpFloorII(i);
            System.out.println("n=" + i + ", 2^(n-1)=" + expected + ", jumpFloorII=" + actual
                + ", 匹配=" + (expected == actual));
        }
    }

    /**
     * 问题1：青蛙跳1级或2级台阶，迭代法
     * f(n) = f(n-1) + f(n-2)
     *
     * @param n 台阶数
     * @return 跳法数
     */
    public int jumpFloor(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    /**
     * 问题2：青蛙跳1到n级台阶，数学公式法
     * f(n) = 2^(n-1)
     *
     * @param n 台阶数
     * @return 跳法数
     */
    public int jumpFloorII(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        // f(n) = 2^(n-1)，使用位运算加速
        return 1 << (n - 1);
    }
}