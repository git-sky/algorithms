package cn.com.sky.algorithms.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 剑指Offer 29. 顺时针打印矩阵【Easy】
 *
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如：如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * 算法原理（边界收缩法）：
 * 1. 设定上、下、左、右四个边界
 * 2. 按顺时针方向依次遍历：从左到右 → 从上到下 → 从右到左 → 从下到上
 * 3. 每完成一个方向的遍历，收缩对应的边界
 * 4. 当边界交叉时停止
 *
 * 关键点：每次遍历前需要判断边界是否仍然有效，避免重复打印
 *
 * 时间复杂度：O(m * n)，每个元素被访问一次
 * 空间复杂度：O(1)，不算结果数组
 * </pre>
 */
public class Print {

    public static void main(String[] args) {
        Print solution = new Print();

        // 测试用例1：4x4矩阵
        System.out.println("=== 测试用例1：4x4矩阵 ===");
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix1));

        // 测试用例2：3x3矩阵
        System.out.println("\n=== 测试用例2：3x3矩阵 ===");
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix2));

        // 测试用例3：3x4矩阵
        System.out.println("\n=== 测试用例3：3x4矩阵 ===");
        int[][] matrix3 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix3));

        // 测试用例4：1x1矩阵
        System.out.println("\n=== 测试用例4：1x1矩阵 ===");
        int[][] matrix4 = {{1}};
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix4));

        // 测试用例5：单行矩阵
        System.out.println("\n=== 测试用例5：单行矩阵 ===");
        int[][] matrix5 = {{1, 2, 3, 4}};
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix5));

        // 测试用例6：单列矩阵
        System.out.println("\n=== 测试用例6：单列矩阵 ===");
        int[][] matrix6 = {{1}, {2}, {3}, {4}};
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix6));

        // 测试用例7：2x2矩阵
        System.out.println("\n=== 测试用例7：2x2矩阵 ===");
        int[][] matrix7 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix7));

        // 测试用例8：空矩阵
        System.out.println("\n=== 测试用例8：空矩阵 ===");
        int[][] matrix8 = {};
        System.out.println("顺时针打印: " + solution.spiralOrder(matrix8));
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix 输入矩阵
     * @return 顺时针遍历的结果列表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 从左到右遍历上边界
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 从上到下遍历右边界
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 从右到左遍历下边界（需要判断是否还有行）
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 从下到上遍历左边界（需要判断是否还有列）
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}