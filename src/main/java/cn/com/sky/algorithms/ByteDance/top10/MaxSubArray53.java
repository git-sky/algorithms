package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * 53. Maximum Subarray
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