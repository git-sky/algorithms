package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 198. 打家劫舍【Medium】（京东高频）
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 计算你在不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
 * 
 * 算法原理（动态规划）：
 * 状态定义：dp[i] = 前i间房屋能偷窃的最大金额
 * 状态转移：
 *   dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *   解释：第i间房屋偷或不偷
 *     - 不偷：dp[i] = dp[i-1]
 *     - 偷：dp[i] = dp[i-2] + nums[i]
 * 
 * 优化空间：只需要保存前两个状态
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class HouseRobber198 {

    public static void main(String[] args) {
        HouseRobber198 solution = new HouseRobber198();
        
        // 测试用例1：正常情况
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("测试用例1: " + solution.rob(nums1)); // 4
        
        // 测试用例2：相邻房屋金额高
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("测试用例2: " + solution.rob(nums2)); // 12
        
        // 测试用例3：空数组
        int[] nums3 = {};
        System.out.println("测试用例3: " + solution.rob(nums3)); // 0
        
        // 测试用例4：单元素
        int[] nums4 = {5};
        System.out.println("测试用例4: " + solution.rob(nums4)); // 5
        
        // 测试用例5：两个元素
        int[] nums5 = {2, 1};
        System.out.println("测试用例5: " + solution.rob(nums5)); // 2
        
        // 测试用例6：三个元素
        int[] nums6 = {3, 2, 7, 10};
        System.out.println("测试用例6: " + solution.rob(nums6)); // 13
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        // 空间优化版本：只保存前两个状态
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}