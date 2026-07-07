package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 136. 只出现一次的数字【Easy】（字节跳动高频）
 * 
 * 题目描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 
 * 算法原理（位运算-异或）：
 * 异或运算特性：
 *   1. a ^ a = 0（任何数和自己异或为0）
 *   2. a ^ 0 = a（任何数和0异或为自己）
 *   3. 异或运算满足交换律和结合律
 * 
 * 遍历数组，将所有元素异或，最终结果就是只出现一次的元素。
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class SingleNumber136 {

    public static void main(String[] args) {
        SingleNumber136 solution = new SingleNumber136();
        
        // 测试用例1：正常情况
        int[] nums1 = {1, 3, 1, 2, 3, 5, 2};
        System.out.println("测试用例1: " + Arrays.toString(nums1));
        System.out.println("结果: " + solution.singleNumber(nums1)); // 5
        
        // 测试用例2：单元素
        int[] nums2 = {5};
        System.out.println("\n测试用例2: " + Arrays.toString(nums2));
        System.out.println("结果: " + solution.singleNumber(nums2)); // 5
        
        // 测试用例3：负数
        int[] nums3 = {-1, -1, -2};
        System.out.println("\n测试用例3: " + Arrays.toString(nums3));
        System.out.println("结果: " + solution.singleNumber(nums3)); // -2
        
        // 测试用例4：空数组（按题意不会出现）
        int[] nums4 = {};
        System.out.println("\n测试用例4: " + Arrays.toString(nums4));
        System.out.println("结果: " + solution.singleNumber(nums4)); // 0
    }

    /**
     * 查找只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}