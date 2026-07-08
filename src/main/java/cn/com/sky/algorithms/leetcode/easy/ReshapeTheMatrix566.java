package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 566. 重塑矩阵【Easy】
 * 
 * 题目描述：将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 如果重塑操作不可能，则返回原始矩阵。
 * 
 * 示例1：
 * 输入：nums = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 
 * 示例2：
 * 输入：nums = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]（元素数量不匹配，返回原矩阵）
 * 
 * 算法原理（一维索引映射）：
 * 1. 首先检查元素数量是否匹配：rows * cols == r * c
 * 2. 使用一维索引遍历原始矩阵
 * 3. 通过 index / c 和 index % c 映射到新矩阵的行列
 * 
 * 关键：将二维坐标转化为一维索引，再映射到新的二维坐标
 * - 原矩阵 (i, j) → 一维索引 i * cols + j
 * - 一维索引 index → 新矩阵 (index / c, index % c)
 * 
 * 时间复杂度：O(m * n)，m、n 为原矩阵的行列数
 * 空间复杂度：O(m * n)，存储结果矩阵
 * </pre>
 */
public class ReshapeTheMatrix566 {

    public static void main(String[] args) {
        ReshapeTheMatrix566 solution = new ReshapeTheMatrix566();

        // 测试用例1：2x2 → 1x4
        int[][] nums1 = {{1, 2}, {3, 4}};
        System.out.println("测试用例1: ");
        printMatrix(solution.matrixReshape(nums1, 1, 4));

        // 测试用例2：2x2 → 2x4（不可能）
        int[][] nums2 = {{1, 2}, {3, 4}};
        System.out.println("\n测试用例2: ");
        printMatrix(solution.matrixReshape(nums2, 2, 4));

        // 测试用例3：2x3 → 3x2
        int[][] nums3 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("\n测试用例3: ");
        printMatrix(solution.matrixReshape(nums3, 3, 2));

        // 测试用例4：1x1 → 1x1
        int[][] nums4 = {{1}};
        System.out.println("\n测试用例4: ");
        printMatrix(solution.matrixReshape(nums4, 1, 1));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;

        if (rows * cols != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index / c][index % c] = nums[i][j];
                index++;
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}