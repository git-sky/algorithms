package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 88. 合并两个有序数组【Easy】
 * 
 * 题目描述：给你两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，
 * 使 nums1 成为一个有序数组。nums1 的空间大小等于 m + n。
 * 
 * 示例：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 
 * 算法原理（从后向前双指针）：
 * 1. 使用三个指针：i 指向 nums1 有效部分末尾，j 指向 nums2 末尾，k 指向合并后末尾
 * 2. 从后向前比较，将较大的元素放到 nums1 的末尾
 * 3. 这样可以避免从前向后合并时覆盖 nums1 中未处理的元素
 * 4. 如果 nums2 还有剩余元素，直接复制到 nums1 前面
 * 
 * 关键：从后向前遍历是本题的核心技巧，避免了额外空间的使用
 * 
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)，原地修改
 * </pre>
 */
public class MergeSortedArray88 {

    public static void main(String[] args) {
        MergeSortedArray88 solution = new MergeSortedArray88();

        // 测试用例1：正常合并
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println("测试用例1: " + Arrays.toString(nums1)); // [1,2,2,3,5,6]

        // 测试用例2：nums2全小于nums1
        int[] nums2 = {4, 5, 6, 0, 0, 0};
        solution.merge(nums2, 3, new int[]{1, 2, 3}, 3);
        System.out.println("测试用例2: " + Arrays.toString(nums2)); // [1,2,3,4,5,6]

        // 测试用例3：nums2为空
        int[] nums3 = {1};
        solution.merge(nums3, 1, new int[]{}, 0);
        System.out.println("测试用例3: " + Arrays.toString(nums3)); // [1]

        // 测试用例4：nums1为空
        int[] nums4 = {0};
        solution.merge(nums4, 0, new int[]{1}, 1);
        System.out.println("测试用例4: " + Arrays.toString(nums4)); // [1]

        // 测试用例5：nums2全大于nums1
        int[] nums5 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums5, 3, new int[]{4, 5, 6}, 3);
        System.out.println("测试用例5: " + Arrays.toString(nums5)); // [1,2,3,4,5,6]
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}