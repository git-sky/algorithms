package cn.com.sky.algorithms.ByteDance.other;

import java.util.*;

/**
 * LeetCode 15. 三数之和【Medium】（阿里巴巴高频）
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c 使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 
 * 算法原理：
 * 1. 先对数组排序，便于去重和双指针操作
 * 2. 固定第一个数，用双指针在剩余部分找两数之和为 -nums[i]
 * 3. 注意去重：跳过重复的第一个数和重复的左右指针
 * 
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)（不计结果存储）
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        ThreeSum15 solution = new ThreeSum15();
        
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("输入: " + Arrays.toString(nums1));
        System.out.println("输出: " + solution.threeSum(nums1));
    }
}