package cn.com.sky.algorithms.ByteDance.other;

import org.junit.Test;

/**
 * LeetCode 704. 二分查找【Easy】
 * 
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 
 * 算法原理：
 * 1. 初始化左右指针 low=0, high=n-1
 * 2. 循环条件：low <= high
 * 3. 计算中间位置 mid = low + (high - low) / 2（防止溢出）
 * 4. 比较 nums[mid] 与 target：
 *    - 相等：返回 mid
 *    - nums[mid] > target：在左半部分查找，high = mid - 1
 *    - nums[mid] < target：在右半部分查找，low = mid + 1
 * 5. 循环结束未找到，返回 -1
 * 
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class BinarySearch704 {

    @Test
    public void test() {
        BinarySearch704 solution = new BinarySearch704();
        
        // 测试用例1：目标存在
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("测试用例1(目标存在): " + solution.search(nums1, target1)); // 4
        
        // 测试用例2：目标不存在
        int target2 = 2;
        System.out.println("测试用例2(目标不存在): " + solution.search(nums1, target2)); // -1
        
        // 测试用例3：目标在开头
        int target3 = -1;
        System.out.println("测试用例3(目标在开头): " + solution.search(nums1, target3)); // 0
        
        // 测试用例4：目标在结尾
        int target4 = 12;
        System.out.println("测试用例4(目标在结尾): " + solution.search(nums1, target4)); // 5
        
        // 测试用例5：单元素数组
        int[] nums2 = {5};
        System.out.println("测试用例5(单元素找到): " + solution.search(nums2, 5)); // 0
        System.out.println("测试用例5(单元素未找到): " + solution.search(nums2, 3)); // -1
        
        // 测试用例6：空数组
        int[] nums3 = {};
        System.out.println("测试用例6(空数组): " + solution.search(nums3, 0)); // -1
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // 使用 low + (high - low) / 2 防止整数溢出
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}