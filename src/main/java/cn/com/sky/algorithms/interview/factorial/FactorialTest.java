package cn.com.sky.algorithms.interview.factorial;

import org.junit.Test;

/**
 * 阶乘算法
 * <p>
 * 求N的阶乘
 * <p>
 * 即n!=1×2×3×...×n。
 */
public class FactorialTest {

    @Test
    public void solution() {

        int n = 5;

        System.out.println(factorial(n));
        System.out.println(factorialRecursive(n));
    }

    /**
     * 循环实现
     * <p>
     * 求N的阶乘
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    private int factorial(int n) {

        if (n <= 0) return -1;

        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }

    /**
     * 递归实现
     * <p>
     * 求N的阶乘
     * 时间复杂度O(N)
     * 空间复杂度O(N)???
     */
    private int factorialRecursive(int n) {
        if (n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }


}
