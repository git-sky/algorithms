package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * 求1+2+3+...+n的和【Easy】
 *
 * 题目：计算1到n的累加和
 *
 * 算法原理：
 * 1. 公式法（最优）：sum = n*(n+1)/2，高斯求和公式，O(1)
 * 2. 迭代法：从1加到n，O(n)
 * 3. 递归法：f(n) = n + f(n-1)，O(n)，空间O(n)
 *
 * 时间复杂度：公式法O(1)，迭代法O(n)，递归法O(n)
 * 空间复杂度：公式法O(1)，迭代法O(1)，递归法O(n)
 * </pre>
 */
public class PrintSum {

    public static void main(String[] args) {
        // 测试用例1：n=100
        System.out.println("=== 测试用例1：n=100 ===");
        System.out.println("递归法: " + calcRecursive(100));
        System.out.println("迭代法: " + calcLoop(100));
        System.out.println("公式法: " + calcFormula(100));

        // 测试用例2：n=1
        System.out.println("\n=== 测试用例2：n=1 ===");
        System.out.println("公式法: " + calcFormula(1));

        // 测试用例3：n=0
        System.out.println("\n=== 测试用例3：n=0 ===");
        System.out.println("公式法: " + calcFormula(0));

        // 测试用例4：大数n=10000
        System.out.println("\n=== 测试用例4：n=10000 ===");
        System.out.println("公式法: " + calcFormula(10000));
    }

    /**
     * 递归实现
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    private static int calcRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n + calcRecursive(n - 1);
    }

    /**
     * 循环实现
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    private static int calcLoop(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    /**
     * 公式法（最优）
     * 高斯求和公式：1+2+...+n = n*(n+1)/2
     * 时间复杂度O(1)，空间复杂度O(1)
     */
    private static int calcFormula(int n) {
        if (n <= 0) {
            return 0;
        }
        return n * (n + 1) / 2;
    }
}