package cn.com.sky.algorithms.ByteDance.other;

import java.util.Arrays;

/**
 * LeetCode 300. 最长递增子序列【Medium】（阿里/字节高频）
 * 
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 
 * 算法原理（动态规划+二分优化）：
 * 1. 维护一个tails数组，tails[i]表示长度为i+1的递增子序列的最小末尾元素
 * 2. 遍历每个数，用二分查找找到它在tails中的位置
 * 3. 如果它大于tails所有元素，追加到末尾；否则替换掉第一个大于等于它的元素
 * 
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(n)
 */
public class LongestIncreasingSubsequence300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] tails = new int[nums.length];
        int length = 0;
        
        for (int num : nums) {
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            tails[left] = num;
            if (left == length) {
                length++;
            }
        }
        
        return length;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence300 solution = new LongestIncreasingSubsequence300();
        
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("输入: " + Arrays.toString(nums));
        System.out.println("最长递增子序列长度: " + solution.lengthOfLIS(nums));
    }
}