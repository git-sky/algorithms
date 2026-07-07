package cn.com.sky.algorithms.ByteDance.top10;

/**
 * LeetCode 53. 最大子数组和【Medium】（字节跳动高频）
 * 
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 算法原理（Kadane算法）：
 * 1. 遍历数组，维护当前子数组的和 currentSum
 * 2. 如果 currentSum < 0，重置为当前元素（因为负数会拖累后续和）
 * 3. 否则，currentSum += 当前元素
 * 4. 每次更新最大和 maxSum
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {
        MaximumSubarray53 solution = new MaximumSubarray53();
        
        // 测试用例1：正常情况
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("测试用例1: " + solution.maxSubArray(nums1)); // 6
        
        // 测试用例2：全负数
        int[] nums2 = {-3, -2, -1};
        System.out.println("测试用例2: " + solution.maxSubArray(nums2)); // -1
        
        // 测试用例3：单元素
        int[] nums3 = {5};
        System.out.println("测试用例3: " + solution.maxSubArray(nums3)); // 5
        
        // 测试用例4：全正数
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("测试用例4: " + solution.maxSubArray(nums4)); // 15
        
        // 测试用例5：空数组
        int[] nums5 = {};
        System.out.println("测试用例5: " + solution.maxSubArray(nums5)); // 0
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // 如果当前和为负，重置为当前元素
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}