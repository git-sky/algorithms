package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs70 {

    @Test
    public void test() {
        System.out.println(climbStairs(2));   // 2
        System.out.println(climbStairs(3));   // 3
        System.out.println(climbStairs(5));   // 8
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public int climbStairsOptimized(int n) {
        if (n <= 2) return n;
        int prev1 = 1, prev2 = 2, current = 0;
        for (int i = 3; i <= n; i++) { current = prev1 + prev2; prev1 = prev2; prev2 = current; }
        return current;
    }
}