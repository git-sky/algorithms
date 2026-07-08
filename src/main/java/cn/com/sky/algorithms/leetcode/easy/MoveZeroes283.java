package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 283. 移动零【Easy】
 * 
 * 题目描述：给定一个数组 nums，将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例：
 * 输入：[0,1,0,3,12]
 * 输出：[1,3,12,0,0]
 * 
 * 算法原理（双指针 / 快慢指针）：
 * 1. 慢指针 idx 指向下一个非零元素应该放置的位置
 * 2. 快指针遍历数组，遇到非零元素就放到 idx 位置，idx 前进
 * 3. 遍历结束后，将 idx 之后的所有位置置为 0
 * 
 * 优化：可以使用交换代替复制+置零，减少第二次遍历
 * - 当 nums[i] != 0 时，交换 nums[i] 和 nums[idx]
 * - 这样零元素会被自然地交换到后面
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)，原地操作
 * </pre>
 */
public class MoveZeroes283 {

    public static void main(String[] args) {
        MoveZeroes283 solution = new MoveZeroes283();

        // 测试用例1：正常情况
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println("测试用例1: " + Arrays.toString(nums1)); // [1,3,12,0,0]

        // 测试用例2：无零
        int[] nums2 = {1, 2, 3};
        solution.moveZeroes(nums2);
        System.out.println("测试用例2: " + Arrays.toString(nums2)); // [1,2,3]

        // 测试用例3：全零
        int[] nums3 = {0, 0, 0};
        solution.moveZeroes(nums3);
        System.out.println("测试用例3: " + Arrays.toString(nums3)); // [0,0,0]

        // 测试用例4：单元素0
        int[] nums4 = {0};
        solution.moveZeroes(nums4);
        System.out.println("测试用例4: " + Arrays.toString(nums4)); // [0]

        // 测试用例5：末尾有零
        int[] nums5 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        solution.moveZeroes(nums5);
        System.out.println("测试用例5: " + Arrays.toString(nums5)); // [4,2,4,3,5,1,0,0,0,0]
    }

    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}