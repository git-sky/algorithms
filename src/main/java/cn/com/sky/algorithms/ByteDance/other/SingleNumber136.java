package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 136. 只出现一次的数字【Easy】（字节跳动高频）
 * 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
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
 */
public class SingleNumber136 {

    public static void main(String[] args) {
        SingleNumber136 solution = new SingleNumber136();
        
        // 测试用例1：正常情况
        int[] nums1 = {2, 2, 1};
        System.out.println("测试用例1: " + solution.singleNumber(nums1)); // 1
        
        // 测试用例2：多个重复元素
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("测试用例2: " + solution.singleNumber(nums2)); // 4
        
        // 测试用例3：单元素
        int[] nums3 = {1};
        System.out.println("测试用例3: " + solution.singleNumber(nums3)); // 1
        
        // 测试用例4：负数
        int[] nums4 = {-1, -1, -2};
        System.out.println("测试用例4: " + solution.singleNumber(nums4)); // -2
        
        // 测试用例5：空数组（按题意不会出现）
        int[] nums5 = {};
        System.out.println("测试用例5: " + solution.singleNumber(nums5)); // 0
    }

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