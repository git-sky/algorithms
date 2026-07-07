package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 322. 零钱兑换【Medium】（字节跳动高频）
 * 
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 算法原理（动态规划）：
 * 状态定义：dp[i] = 凑成金额 i 所需的最少硬币数
 * 状态转移：
 *   dp[i] = min(dp[i - coin] + 1) for coin in coins if i >= coin
 * 
 * 初始条件：
 *   dp[0] = 0（凑成0元不需要硬币）
 *   dp[i] = amount + 1（初始化为一个较大值，表示不可达）
 * 
 * 时间复杂度：O(amount * coins.length)
 * 空间复杂度：O(amount)
 */
public class CoinChange322 {

    public static void main(String[] args) {
        CoinChange322 solution = new CoinChange322();
        
        // 测试用例1：正常情况
        int[] coins1 = {1, 2, 5};
        System.out.println("测试用例1: " + solution.coinChange(coins1, 11)); // 3
        
        // 测试用例2：无法凑成
        int[] coins2 = {2};
        System.out.println("测试用例2: " + solution.coinChange(coins2, 3)); // -1
        
        // 测试用例3：金额为0
        System.out.println("测试用例3: " + solution.coinChange(coins1, 0)); // 0
        
        // 测试用例4：单种硬币
        int[] coins4 = {1};
        System.out.println("测试用例4: " + solution.coinChange(coins4, 5)); // 5
        
        // 测试用例5：大额硬币
        int[] coins5 = {1, 3, 4, 5};
        System.out.println("测试用例5: " + solution.coinChange(coins5, 7)); // 2
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        // 初始化，amount + 1 表示不可达
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}