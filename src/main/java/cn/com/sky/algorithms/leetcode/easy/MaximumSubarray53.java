package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * LeetCode 53. 最大子序和【Easy】（字节跳动、腾讯高频）
 *
 * 题目描述：给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 * 示例：
 * 输入：[-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6（连续子数组 [4,-1,2,1] 的和最大）
 *
 * 算法原理（动态规划 / Kadane算法）：
 *
 * 核心思想：
 * 对于数组中的每个位置i，我们需要做出决策：
 * - 将nums[i]加入之前的连续子数组
 * - 或者从nums[i]开始一个新的子数组
 *
 * 状态定义：
 * dp[i] = 以第i个元素结尾的最大子序和
 *
 * 状态转移方程：
 * dp[i] = max(dp[i-1] + nums[i], nums[i])
 *        = nums[i] + max(dp[i-1], 0)
 *
 * 解释：
 * 如果前一个位置的dp值>0，说明对结果有正向贡献，可以加上
 * 如果前一个位置的dp值≤0，说明对结果没有贡献或负贡献，不如从当前重新开始
 *
 * 最终答案：max(dp[0], dp[1], ..., dp[n-1])
 *
 * 空间优化：
 * 由于dp[i]只依赖dp[i-1]，可以使用一个变量代替整个dp数组
 * 将空间复杂度从O(n)降到O(1)
 *
 * 时间复杂度：O(n)，只需一次遍历
 * 空间复杂度：O(1)，使用常数额外空间
 *
 * 示例演示（[-2,1,-3,4,-1,2,1,-5,4]）：
 * i=0: dp=-2, max=-2
 * i=1: dp=max(-2+1,1)=1, max=1
 * i=2: dp=max(1-3,-3)=-2, max=1
 * i=3: dp=max(-2+4,4)=4, max=4
 * i=4: dp=max(4-1,-1)=3, max=4
 * i=5: dp=max(3+2,2)=5, max=5
 * i=6: dp=max(5+1,1)=6, max=6 ✓
 * i=7: dp=max(6-5,-5)=1, max=6
 * i=8: dp=max(1+4,4)=5, max=6
 * 结果：6
 * </pre>
 */
public class MaximumSubarray53 {

    @Test
    public void solution() {
        MaximumSubarray53 solution = new MaximumSubarray53();

        // 测试用例1：正常情况（LeetCode示例）
        System.out.println("测试用例1: " + solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6

        // 测试用例2：全正数
        System.out.println("测试用例2: " + solution.maxSubArray(new int[]{1, 2, 3, 4}));    // 10

        // 测试用例3：全负数
        System.out.println("测试用例3: " + solution.maxSubArray(new int[]{-1, -2, -3}));   // -1

        // 测试用例4：单元素
        System.out.println("测试用例4: " + solution.maxSubArray(new int[]{5}));            // 5

        // 测试用例5：单元素负数
        System.out.println("测试用例5: " + solution.maxSubArray(new int[]{-5}));           // -5

        // 测试用例6：两个元素
        System.out.println("测试用例6: " + solution.maxSubArray(new int[]{-2, 1}));       // 1

        // 测试用例7：交替正负
        System.out.println("测试用例7: " + solution.maxSubArray(new int[]{1, -1, 1, -1, 1})); // 1

        // 测试用例8：大数
        System.out.println("测试用例8: " + solution.maxSubArray(new int[]{10000}));
    }

    /**
     * Kadane算法 - 最优解法（空间优化版）⭐
     * 使用滚动变量代替DP数组，空间复杂度O(1)
     *
     * @param nums 输入数组
     * @return 最大子序和
     */
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int currentSum = A[0];  // 当前位置的连续子数组和
        int maxSum = A[0];      // 全局最大和

        for (int i = 1; i < A.length; i++) {
            // 状态转移：如果前面的和对当前有正向贡献就加上，否则从当前重新开始
            currentSum = Math.max(A[i], currentSum + A[i]);
            // 更新全局最大值
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * 方法二：标准DP实现（易于理解）
     * 使用dp数组记录每个位置的状态，便于理解但空间效率稍低
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *
     * @param nums 输入数组
     * @return 最大子序和
     */
    public int maxSubArrayDP(int[] A) {
        int n = A.length;
        int[] dp = new int[n];  // dp[i]表示以A[i]结尾的最大子序和
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            // 状态转移方程
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            // 更新全局最大值
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}