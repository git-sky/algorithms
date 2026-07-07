package cn.com.sky.algorithms.ByteDance.other;

import java.util.Arrays;

/**
 * LeetCode 62. 不同路径【Medium】（京东高频）
 * 
 * 一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角。问总共有多少条不同的路径？
 * 
 * 算法原理（动态规划）：
 * 状态定义：dp[i][j] = 到达(i,j)的路径数
 * 状态转移：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 优化空间：只用一维数组
 * 
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(n)
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths62 solution = new UniquePaths62();
        
        System.out.println("m=3, n=7");
        System.out.println("路径数: " + solution.uniquePaths(3, 7));
    }
}