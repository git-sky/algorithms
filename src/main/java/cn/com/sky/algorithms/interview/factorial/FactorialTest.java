package cn.com.sky.algorithms.interview.factorial;

/**
 * <pre>
 * 阶乘算法【Easy】
 *
 * 题目：求N的阶乘，即n! = 1×2×3×...×n
 *
 * 算法原理：
 * 方法1（迭代法，最优）：从1乘到n
 *   - 时间复杂度O(n)，空间复杂度O(1)
 *
 * 方法2（递归法）：n! = n × (n-1)!
 *   - 时间复杂度O(n)，空间复杂度O(n)（递归栈）
 *   - 缺点：n较大时可能栈溢出
 *
 * 时间复杂度：迭代法O(n)，递归法O(n)
 * 空间复杂度：迭代法O(1)，递归法O(n)
 * </pre>
 */
public class FactorialTest {

    public static void main(String[] args) {
        // 测试用例1：n=5，5! = 120
        System.out.println("=== 测试用例1：n=5 ===");
        System.out.println("迭代法: " + factorial(5));
        System.out.println("递归法: " + factorialRecursive(5));

        // 测试用例2：n=1
        System.out.println("\n=== 测试用例2：n=1 ===");
        System.out.println("迭代法: " + factorial(1));

        // 测试用例3：n=0（无效输入）
        System.out.println("\n=== 测试用例3：n=0 ===");
        System.out.println("迭代法: " + factorial(0));

        // 测试用例4：n=10
        System.out.println("\n=== 测试用例4：n=10 ===");
        System.out.println("迭代法: " + factorial(10));

        // 测试用例5：n=12（接近int上限）
        System.out.println("\n=== 测试用例5：n=12 ===");
        System.out.println("迭代法: " + factorial(12));
    }

    /**
     * 迭代法（最优）
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    private static int factorial(int n) {
        if (n <= 0) return -1;

        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }

    /**
     * 递归法
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    private static int factorialRecursive(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }
}