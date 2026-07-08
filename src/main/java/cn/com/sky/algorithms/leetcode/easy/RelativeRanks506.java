package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 506. 相对名次【Easy】
 * 
 * 题目描述：给定 N 名运动员的成绩，找到他们的相对名次和前三名。
 * 前三名分别获得 "Gold Medal"、"Silver Medal" 和 "Bronze Medal"。
 * 
 * 示例：
 * 输入：[5, 4, 3, 2, 1]
 * 输出：["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 
 * 算法原理（排序 + 哈希映射）：
 * 1. 将成绩和原始索引一起排序（降序）
 * 2. 排序后的位置即为名次
 * 3. 前三名特殊处理，其余直接用数字字符串
 * 
 * 时间复杂度：O(n log n)，排序的时间
 * 空间复杂度：O(n)，存储排序副本和结果
 * </pre>
 */
public class RelativeRanks506 {

    public static void main(String[] args) {
        RelativeRanks506 solution = new RelativeRanks506();

        // 测试用例1：正常情况
        int[] nums1 = {5, 4, 3, 2, 1};
        System.out.println("测试用例1: " + Arrays.toString(solution.findRelativeRanks(nums1)));

        // 测试用例2：乱序
        int[] nums2 = {10, 3, 8, 9, 4};
        System.out.println("测试用例2: " + Arrays.toString(solution.findRelativeRanks(nums2)));

        // 测试用例3：单元素
        int[] nums3 = {5};
        System.out.println("测试用例3: " + Arrays.toString(solution.findRelativeRanks(nums3)));

        // 测试用例4：两个元素
        int[] nums4 = {5, 4};
        System.out.println("测试用例4: " + Arrays.toString(solution.findRelativeRanks(nums4)));

        // 测试用例5：三个元素
        int[] nums5 = {10, 20, 30};
        System.out.println("测试用例5: " + Arrays.toString(solution.findRelativeRanks(nums5)));
    }

    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[][] indexed = new int[n][2];

        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }

        Arrays.sort(indexed, (a, b) -> b[0] - a[0]);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = indexed[i][1];
            if (i == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (i == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (i == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}