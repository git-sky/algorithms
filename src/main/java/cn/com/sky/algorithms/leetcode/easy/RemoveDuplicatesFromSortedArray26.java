package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 26. 删除有序数组中的重复项【Easy】
 * 
 * 题目描述：给你一个升序排列的数组 nums ，请你原地删除重复出现的元素，
 * 使每个元素只出现一次，返回删除后数组的新长度。
 * 
 * 示例：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 
 * 算法原理（双指针 / 快慢指针）：
 * 1. 慢指针 i 指向当前无重复部分的末尾
 * 2. 快指针 j 遍历数组
 * 3. 当 nums[j] != nums[i] 时，说明发现新元素
 * 4. 将 i 前进一位，将 nums[j] 复制到 nums[i]
 * 5. 最终 i+1 即为不重复元素的个数
 * 
 * 时间复杂度：O(n)，每个元素最多被访问一次
 * 空间复杂度：O(1)，原地修改
 * </pre>
 */
public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 solution = new RemoveDuplicatesFromSortedArray26();

        // 测试用例1：有重复
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.println("测试用例1: len=" + len1 + ", " + Arrays.toString(Arrays.copyOf(nums1, len1))); // 2, [1,2]

        // 测试用例2：多个重复
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.println("测试用例2: len=" + len2 + ", " + Arrays.toString(Arrays.copyOf(nums2, len2))); // 5, [0,1,2,3,4]

        // 测试用例3：无重复
        int[] nums3 = {1, 2, 3};
        int len3 = solution.removeDuplicates(nums3);
        System.out.println("测试用例3: len=" + len3 + ", " + Arrays.toString(Arrays.copyOf(nums3, len3))); // 3, [1,2,3]

        // 测试用例4：单元素
        int[] nums4 = {1};
        int len4 = solution.removeDuplicates(nums4);
        System.out.println("测试用例4: len=" + len4 + ", " + Arrays.toString(Arrays.copyOf(nums4, len4))); // 1, [1]

        // 测试用例5：空数组
        int[] nums5 = {};
        int len5 = solution.removeDuplicates(nums5);
        System.out.println("测试用例5: len=" + len5); // 0
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}