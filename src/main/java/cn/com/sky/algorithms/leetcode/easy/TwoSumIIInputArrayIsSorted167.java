package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 167. 两数之和 II - 输入有序数组【Easy】
 * 
 * 题目描述：给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * 返回这两个数的下标（从1开始），且较小下标在前。
 * 
 * 示例：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 
 * 算法原理（双指针）：
 * 1. 左指针指向数组开头，右指针指向数组末尾
 * 2. 计算两指针指向元素之和
 * 3. 如果和等于目标，返回下标
 * 4. 如果和大于目标，右指针左移（减小和）
 * 5. 如果和小于目标，左指针右移（增大和）
 * 
 * 为什么双指针有效：
 * - 数组有序，每次移动指针都能确定排除一部分不可能的解
 * - 不会遗漏解，因为对于每个左指针，右指针只会向左移动
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class TwoSumIIInputArrayIsSorted167 {

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted167 solution = new TwoSumIIInputArrayIsSorted167();

        // 测试用例1：正常情况
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("测试用例1: " + Arrays.toString(solution.twoSum(nums1, 9))); // [1,2]

        // 测试用例2：目标在中间
        int[] nums2 = {2, 3, 4};
        System.out.println("测试用例2: " + Arrays.toString(solution.twoSum(nums2, 6))); // [1,3]

        // 测试用例3：负数
        int[] nums3 = {-1, 0};
        System.out.println("测试用例3: " + Arrays.toString(solution.twoSum(nums3, -1))); // [1,2]

        // 测试用例4：首尾
        int[] nums4 = {1, 2, 3, 4, 4};
        System.out.println("测试用例4: " + Arrays.toString(solution.twoSum(nums4, 8))); // [4,5]

        // 测试用例5：两元素
        int[] nums5 = {5, 25};
        System.out.println("测试用例5: " + Arrays.toString(solution.twoSum(nums5, 30))); // [1,2]
    }

    public int[] twoSum(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) {
            return indice;
        }

        int left = 0, right = num.length - 1;

        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }

        return indice;
    }
}