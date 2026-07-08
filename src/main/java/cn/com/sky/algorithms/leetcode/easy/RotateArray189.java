package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 189. 轮转数组【Easy】
 * 
 * 题目描述：给定一个数组，将数组中的元素向右轮转 k 个位置。
 * 
 * 示例：
 * 输入：[1,2,3,4,5,6,7], k = 3
 * 输出：[5,6,7,1,2,3,4]
 * 
 * 算法原理（三次反转法）：
 * 1. 首先对 k 取模：k %= nums.length，避免不必要的轮转
 * 2. 反转整个数组：[1,2,3,4,5,6,7] → [7,6,5,4,3,2,1]
 * 3. 反转前 k 个元素：[7,6,5,4,3,2,1] → [5,6,7,4,3,2,1]
 * 4. 反转后 n-k 个元素：[5,6,7,4,3,2,1] → [5,6,7,1,2,3,4]
 * 
 * 原理：轮转 k 位 = 将后 k 个元素移到前面
 * - 反转整个数组后，后 k 个元素变到了前面，但顺序反了
 * - 再分别反转前后两部分，恢复正确顺序
 * 
 * 时间复杂度：O(n)，每个元素被反转3次
 * 空间复杂度：O(1)，原地修改
 * </pre>
 */
public class RotateArray189 {

    public static void main(String[] args) {
        RotateArray189 solution = new RotateArray189();

        // 测试用例1：正常轮转
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 3);
        System.out.println("测试用例1: " + Arrays.toString(nums1)); // [5,6,7,1,2,3,4]

        // 测试用例2：k大于数组长度
        int[] nums2 = {1, 2, 3};
        solution.rotate(nums2, 4);
        System.out.println("测试用例2: " + Arrays.toString(nums2)); // [3,1,2]

        // 测试用例3：k等于0
        int[] nums3 = {1, 2, 3};
        solution.rotate(nums3, 0);
        System.out.println("测试用例3: " + Arrays.toString(nums3)); // [1,2,3]

        // 测试用例4：k等于数组长度
        int[] nums4 = {1, 2, 3};
        solution.rotate(nums4, 3);
        System.out.println("测试用例4: " + Arrays.toString(nums4)); // [1,2,3]

        // 测试用例5：单元素
        int[] nums5 = {1};
        solution.rotate(nums5, 1);
        System.out.println("测试用例5: " + Arrays.toString(nums5)); // [1]

        // 测试用例6：负数
        int[] nums6 = {-1, -100, 3, 99};
        solution.rotate(nums6, 2);
        System.out.println("测试用例6: " + Arrays.toString(nums6)); // [3,99,-1,-100]
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}