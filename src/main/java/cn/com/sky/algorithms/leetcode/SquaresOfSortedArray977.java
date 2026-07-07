package cn.com.sky.algorithms.leetcode;


import java.util.Arrays;

/**
 * LeetCode 977. 有序数组的平方
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class SquaresOfSortedArray977 {

    /**
     * 双指针法 - 最优解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1; // 从结果数组末尾开始填充

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }

    /**
     * 暴力解法 - 先平方再排序
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1) 或 O(n)（取决于排序算法）
     */
    public int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray977 solution = new SquaresOfSortedArray977();

        // 测试用例1
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println("输入: " + Arrays.toString(nums1));
        System.out.println("输出: " + Arrays.toString(solution.sortedSquares(nums1)));

        // 测试用例2
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println("\n输入: " + Arrays.toString(nums2));
        System.out.println("输出: " + Arrays.toString(solution.sortedSquares(nums2)));

        // 测试用例3：全负数
        int[] nums3 = {-5, -4, -3, -2, -1};
        System.out.println("\n输入: " + Arrays.toString(nums3));
        System.out.println("输出: " + Arrays.toString(solution.sortedSquares(nums3)));

        // 测试用例4：全正数
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("\n输入: " + Arrays.toString(nums4));
        System.out.println("输出: " + Arrays.toString(solution.sortedSquares(nums4)));
    }
}