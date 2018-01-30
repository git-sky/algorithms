package cn.com.sky.algorithms.interview.factorial;

import org.junit.Test;

/**
 * 阶乘算法
 * <p>
 * 求N的阶乘相加。
 * 即求：1!+2!+3!+...+n!
 */
public class FactorialAddTest {

    @Test
    public void solution() {

        int n = 5;

        System.out.println(factorial(n));
        System.out.println(factorialRecursive(n));
    }

    /**
     * 循环实现
     * <p>
     * 求N的阶乘相加
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    private int factorial(int n) {

        if (n <= 0) return -1;

        int total = 0;
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
//            System.out.println(temp);
            total += temp;
        }
        return total;
    }

    /**
     * 递归实现
     * <p>
     * 求N的阶乘相加
     * 时间复杂度O(N^2)
     * 空间复杂度O(N)???
     */
    private int factorialRecursive(int n) {

        if (n <= 0) return -1;

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += recursive(i);
            System.out.println(total);
        }
        return total;
    }

    private int recursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n * recursive(n - 1);
    }


}
