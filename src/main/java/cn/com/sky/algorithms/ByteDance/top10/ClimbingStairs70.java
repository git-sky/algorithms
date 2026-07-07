package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * LeetCode 70. 爬楼梯【Easy】
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 算法原理（动态规划）：
 * 1. 状态定义：dp[i] = 爬到第i阶的方法数
 * 2. 状态转移：dp[i] = dp[i-1] + dp[i-2]
 *    - 最后一步爬1阶：方法数为 dp[i-1]
 *    - 最后一步爬2阶：方法数为 dp[i-2]
 * 3. 初始条件：dp[1] = 1, dp[2] = 2
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)（优化后）
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