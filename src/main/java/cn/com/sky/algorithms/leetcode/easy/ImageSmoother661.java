package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 *
 * 661. Image Smoother【Easy】
 *
 * 给定一个二维整数矩阵M表示图像的灰度，你需要设计一个平滑器，
 * 使每个单元格的灰度变为所有8个相邻单元格和自身的平均灰度（向下取整）。
 * 如果一个单元格的相邻单元格不足8个，则使用尽可能多的相邻单元格。
 *
 * 示例:
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点(0,0), (0,2), (2,0), (2,2): floor(3/4) = 0
 * 对于点(0,1), (1,0), (1,2), (2,1): floor(5/6) = 0
 * 对于点(1,1): floor(8/9) = 0
 *
 * 算法原理（直接模拟）：
 * 对每个单元格，遍历其周围3x3区域（包括自身），统计有效单元格的数量和灰度总和，
 * 然后计算平均值（向下取整）。
 *
 * 关键点：
 * - 需要使用新数组存储结果，避免覆盖原数组影响后续计算
 * - 边界单元格的相邻单元格可能不足8个，需要判断越界
 *
 * 时间复杂度：O(m * n)，每个单元格最多检查9个邻居
 * 空间复杂度：O(m * n)，用于存储结果
 *
 * </pre>
 */
public class ImageSmoother661 {

    @Test
    public void solution() {
        int[][] test1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result1 = imageSmoother(test1);
        System.out.println("测试用例1:");
        printMatrix(result1);

        int[][] test2 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}};
        int[][] result2 = imageSmoother(test2);
        System.out.println("测试用例2:");
        printMatrix(result2);

        int[][] test3 = {{1}};
        int[][] result3 = imageSmoother(test3);
        System.out.println("测试用例3(单像素):");
        printMatrix(result3);

        int[][] test4 = {{1, 2, 3}};
        int[][] result4 = imageSmoother(test4);
        System.out.println("测试用例4(单行):");
        printMatrix(result4);
    }

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return M;
        }

        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int ni = i + di;
                        int nj = j + dj;
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            sum += M[ni][nj];
                            count++;
                        }
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}