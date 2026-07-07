package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 70. 爬楼梯【Easy】（字节跳动高频）
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 算法原理（动态规划）：
 * 状态定义：dp[i] = 爬到第 i 阶的方法数
 * 状态转移：
 *   dp[i] = dp[i-1] + dp[i-2]
 *   解释：到达第i阶有两种方式
 *     - 从第i-1阶爬1步
 *     - 从第i-2阶爬2步
 * 
 * 初始条件：
 *   dp[0] = 1（地面到第0阶有一种方法：不爬）
 *   dp[1] = 1（爬1步）
 * 
 * 优化空间：只保存前两个状态
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ClimbingStairs70 {

    public static void main(String[] args) {
        ClimbingStairs70 solution = new ClimbingStairs70();
        
        // 测试用例1：n=1
        System.out.println("测试用例1(n=1): " + solution.climbStairs(1)); // 1
        
        // 测试用例2：n=2
        System.out.println("测试用例2(n=2): " + solution.climbStairs(2)); // 2
        
        // 测试用例3：n=3
        System.out.println("测试用例3(n=3): " + solution.climbStairs(3)); // 3
        
        // 测试用例4：n=4
        System.out.println("测试用例4(n=4): " + solution.climbStairs(4)); // 5
        
        // 测试用例5：n=5
        System.out.println("测试用例5(n=5): " + solution.climbStairs(5)); // 8
        
        // 测试用例6：n=0（边界情况）
        System.out.println("测试用例6(n=0): " + solution.climbStairs(0)); // 1
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        // 空间优化版本：只保存前两个状态
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}