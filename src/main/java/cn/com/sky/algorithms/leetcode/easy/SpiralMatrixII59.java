package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * <pre>
 * LeetCode 59. 螺旋矩阵 II【Medium】
 * 
 * 题目描述：给定一个正整数 n，生成一个包含 1 到 n^2 所有元素的螺旋矩阵。
 * 
 * 示例（n = 3）：
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * 算法原理（按层模拟）：
 * 1. 使用四个边界变量：top, bottom, left, right
 * 2. 按顺时针方向逐层填充：
 *    - 从左到右填充上边界
 *    - 从上到下填充右边界
 *    - 从右到左填充下边界（需检查 top <= bottom）
 *    - 从下到上填充左边界（需检查 left <= right）
 * 3. 每填充完一条边，收缩对应的边界
 * 4. 重复直到所有数字填完
 * 
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)，存储结果矩阵
 * </pre>
 */
public class SpiralMatrixII59 {

    public static void main(String[] args) {
        SpiralMatrixII59 solution = new SpiralMatrixII59();

        // 测试用例1：3x3
        System.out.println("测试用例1 (n=3):");
        printMatrix(solution.generateMatrix(3));

        // 测试用例2：4x4
        System.out.println("\n测试用例2 (n=4):");
        printMatrix(solution.generateMatrix(4));

        // 测试用例3：1x1
        System.out.println("\n测试用例3 (n=1):");
        printMatrix(solution.generateMatrix(1));

        // 测试用例4：0x0
        System.out.println("\n测试用例4 (n=0):");
        printMatrix(solution.generateMatrix(0));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n == 0) {
            return matrix;
        }

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}