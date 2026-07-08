package cn.com.sky.algorithms.interview.factorial;

/**
 * <pre>
 * 阶乘求和【Easy】
 *
 * 题目：求1!+2!+3!+...+n!
 *
 * 算法原理：
 * 方法1（迭代法，最优）：利用前一个阶乘值递推，temp *= i，total += temp
 *   - 避免重复计算，每次只需在前一个阶乘基础上乘以i
 *   - 时间复杂度O(n)，空间复杂度O(1)
 *
 * 方法2（递归法）：对每个i单独计算阶乘再累加
 *   - 存在大量重复计算，例如5!需要计算4!*5，而4!之前已经算过
 *   - 时间复杂度O(n^2)，空间复杂度O(n)
 *
 * 时间复杂度：迭代法O(n)，递归法O(n^2)
 * 空间复杂度：迭代法O(1)，递归法O(n)
 * </pre>
 */
public class FactorialAddTest {

    public static void main(String[] args) {
        // 测试用例1：n=5，1!+2!+3!+4!+5! = 1+2+6+24+120 = 153
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
    }

    /**
     * 迭代法（最优）
     * 利用前一个阶乘值递推：temp保存i!，total累加
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    private static int factorial(int n) {
        if (n <= 0) return -1;

        int total = 0;
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            total += temp;
        }
        return total;
    }

    /**
     * 递归法（非最优，存在重复计算）
     * 对每个i单独递归计算阶乘再累加
     * 时间复杂度O(n^2)，空间复杂度O(n)
     */
    private static int factorialRecursive(int n) {
        if (n <= 0) return -1;

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += recursive(i);
        }
        return total;
    }

    /**
     * 递归计算n的阶乘
     */
    private static int recursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n * recursive(n - 1);
    }
}