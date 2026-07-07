package cn.com.sky.algorithms.ByteDance.top10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15. 三数之和【Medium】（字节跳动高频）
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 
 * 算法原理（双指针）：
 * 1. 排序数组，便于去重和双指针操作
 * 2. 遍历数组，固定第一个数 nums[i]
 * 3. 使用双指针 left=i+1, right=n-1
 * 4. 根据 sum = nums[i] + nums[left] + nums[right] 的值移动指针：
 *    - sum = 0：记录结果，同时移动两个指针并去重
 *    - sum < 0：左指针右移
 *    - sum > 0：右指针左移
 * 
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)（不考虑结果存储）
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 solution = new ThreeSum15();
        
        // 测试用例1：正常情况
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("测试用例1: " + solution.threeSum(nums1)); // [[-1,-1,2],[-1,0,1]]
        
        // 测试用例2：空数组
        int[] nums2 = {};
        System.out.println("测试用例2: " + solution.threeSum(nums2)); // []
        
        // 测试用例3：元素不足3个
        int[] nums3 = {0};
        System.out.println("测试用例3: " + solution.threeSum(nums3)); // []
        
        // 测试用例4：全零
        int[] nums4 = {0, 0, 0, 0};
        System.out.println("测试用例4: " + solution.threeSum(nums4)); // [[0,0,0]]
        
        // 测试用例5：正数数组
        int[] nums5 = {1, 2, 3};
        System.out.println("测试用例5: " + solution.threeSum(nums5)); // []
        
        // 测试用例6：负数数组
        int[] nums6 = {-3, -2, -1};
        System.out.println("测试用例6: " + solution.threeSum(nums6)); // []
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // 排序数组
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重：跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 去重：跳过重复的左指针元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重：跳过重复的右指针元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}