package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 27. 移除元素【Easy】
 * 
 * 题目描述：给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。
 * 
 * 示例：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2,_,_]
 * 
 * 算法原理（双指针）：
 * 1. 慢指针 i 指向当前有效部分的末尾
 * 2. 快指针 j 遍历数组
 * 3. 当 nums[j] != val 时，将 nums[j] 复制到 nums[i]，i 前进
 * 4. 最终 i 即为不等于 val 的元素个数
 * 
 * 优化：当删除元素很少时，可以用交换代替复制，减少赋值次数
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)，原地修改
 * </pre>
 */
public class RemoveElement27 {

    public static void main(String[] args) {
        RemoveElement27 solution = new RemoveElement27();

        // 测试用例1：正常情况
        int[] nums1 = {3, 2, 2, 3};
        int len1 = solution.removeElement(nums1, 3);
        System.out.println("测试用例1: len=" + len1 + ", " + Arrays.toString(Arrays.copyOf(nums1, len1))); // 2, [2,2]

        // 测试用例2：全部需要删除
        int[] nums2 = {1, 1, 1};
        int len2 = solution.removeElement(nums2, 1);
        System.out.println("测试用例2: len=" + len2); // 0

        // 测试用例3：无需删除
        int[] nums3 = {1, 2, 3};
        int len3 = solution.removeElement(nums3, 4);
        System.out.println("测试用例3: len=" + len3 + ", " + Arrays.toString(Arrays.copyOf(nums3, len3))); // 3, [1,2,3]

        // 测试用例4：空数组
        int[] nums4 = {};
        int len4 = solution.removeElement(nums4, 1);
        System.out.println("测试用例4: len=" + len4); // 0

        // 测试用例5：单元素匹配
        int[] nums5 = {2};
        int len5 = solution.removeElement(nums5, 2);
        System.out.println("测试用例5: len=" + len5); // 0
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}