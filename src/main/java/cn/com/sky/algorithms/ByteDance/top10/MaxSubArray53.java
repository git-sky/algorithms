package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * LeetCode 53. 最大子数组和【Medium】
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 算法原理（Kadane算法）：
 * 1. 维护两个变量：currentSum（当前子数组和）、maxSum（最大子数组和）
 * 2. 遍历数组，对于每个元素：
 *    - currentSum = max(nums[i], currentSum + nums[i])
 *      （如果当前元素本身比加上前面的和更大，就重新开始一个子数组）
 *    - maxSum = max(maxSum, currentSum)
 * 3. 返回 maxSum
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 
 * 分治法思路：
 * 将数组分成左右两部分，最大子数组和可能在：
 * 1. 左半部分
 * 2. 右半部分
 * 3. 跨越中点的子数组
 * 递归求解三者的最大值
 */
public class MaxSubArray53 {

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));  // 6
        System.out.println(maxSubArrayDivideAndConquer(nums));  // 6
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        return Math.max(Math.max(divideAndConquer(nums, left, mid), 
                                 divideAndConquer(nums, mid + 1, right)),
                        crossSum(nums, left, mid, right));
    }

    private int crossSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) leftSum = Math.max(leftSum, sum += nums[i]);
        int rightSum = Integer.MIN_VALUE; sum = 0;
        for (int i = mid + 1; i <= right; i++) rightSum = Math.max(rightSum, sum += nums[i]);
        return leftSum + rightSum;
    }
}