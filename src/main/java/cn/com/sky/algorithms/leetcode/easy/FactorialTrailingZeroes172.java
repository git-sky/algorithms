package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 172. Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity(对数时间复杂度).
 *
 * </pre>
 */
public class FactorialTrailingZeroes172 {

    @Test
    public void solution() {
        int n = trailingZeroes(38);
        System.out.println(n);
    }

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
