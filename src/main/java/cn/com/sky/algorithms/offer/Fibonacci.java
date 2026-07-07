package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 10-I. 斐波那契数列【Easy】
 *
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 * 斐波那契数列定义：f(0)=0, f(1)=1, f(n)=f(n-1)+f(n-2)
 *
 * 例如：0 1 1 2 3 5 8 13 21 34 55 89
 *
 * 相同问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * （跳n级台阶 = 从n-1级跳1级 + 从n-2级跳2级 = f(n-1) + f(n-2)）
 *
 * 算法原理：
 * 方法1（递归法）：
 *   直接按定义递归，但有大量重复计算
 *   时间复杂度：O(2^n)，空间复杂度：O(n)
 *
 * 方法2（迭代法）【最优】：
 *   只需保存前两个值，逐步向后计算
 *   时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 方法3（矩阵快速幂）：
 *   利用矩阵乘法的性质，可将时间优化到O(log n)
 *   [[f(n+1), f(n)], [f(n), f(n-1)]] = [[1,1],[1,0]]^n
 * </pre>
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        // 测试用例1：前15项
        System.out.println("=== 测试用例1：前15项 ===");
        for (int i = 0; i < 15; i++) {
            System.out.println("f(" + i + ") = " + solution.fibIterative(i));
        }

        // 测试用例2：边界值
        System.out.println("\n=== 测试用例2：边界值 ===");
        System.out.println("f(0) = " + solution.fibIterative(0)); // 0
        System.out.println("f(1) = " + solution.fibIterative(1)); // 1
        System.out.println("f(2) = " + solution.fibIterative(2)); // 1

        // 测试用例3：较大值
        System.out.println("\n=== 测试用例3：较大值 ===");
        System.out.println("f(10) = " + solution.fibIterative(10)); // 55
        System.out.println("f(20) = " + solution.fibIterative(20)); // 6765
        System.out.println("f(30) = " + solution.fibIterative(30)); // 832040

        // 测试用例4：对比递归和迭代
        System.out.println("\n=== 测试用例4：对比递归和迭代 ===");
        for (int i = 0; i < 10; i++) {
            System.out.println("f(" + i + "): 递归=" + solution.fibRecursive(i)
                + ", 迭代=" + solution.fibIterative(i));
        }
    }

    /**
     * 迭代法求斐波那契数列第n项【推荐】
     *
     * @param n 第n项
     * @return f(n)
     */
    public int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    /**
     * 递归法求斐波那契数列第n项
     * 注意：效率极低，存在大量重复计算
     *
     * @param n 第n项
     * @return f(n)
     */
    public int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}