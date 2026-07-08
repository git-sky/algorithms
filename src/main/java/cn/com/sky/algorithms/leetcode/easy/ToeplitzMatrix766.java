package cn.com.sky.algorithms.leetcode.easy;

/**
 * <pre>
 * LeetCode 766. 托普利茨矩阵【Easy】
 * 
 * 题目描述：如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是托普利茨矩阵。
 * 
 * 示例1：
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 1234
 * 5123
 * 9512
 * 每条对角线上元素都相同
 * 
 * 示例2：
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 
 * 算法原理（逐元素检查）：
 * 1. 对于每个元素 matrix[r][c]，检查它是否等于左上角元素 matrix[r-1][c-1]
 * 2. 只需检查 r > 0 且 c > 0 的元素（第一行和第一列没有左上角）
 * 3. 如果发现任何不等的元素，返回 false
 * 
 * 原理：托普利茨矩阵的定义等价于每个元素等于其左上角元素
 * 
 * 时间复杂度：O(M * N)
 * 空间复杂度：O(1)
 * </pre>
 */
public class ToeplitzMatrix766 {

    public static void main(String[] args) {
        ToeplitzMatrix766 solution = new ToeplitzMatrix766();

        // 测试用例1：托普利茨矩阵
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println("测试用例1: " + solution.isToeplitzMatrix(matrix1)); // true

        // 测试用例2：非托普利茨矩阵
        int[][] matrix2 = {{1, 2}, {2, 2}};
        System.out.println("测试用例2: " + solution.isToeplitzMatrix(matrix2)); // false

        // 测试用例3：单元素
        int[][] matrix3 = {{1}};
        System.out.println("测试用例3: " + solution.isToeplitzMatrix(matrix3)); // true

        // 测试用例4：单行
        int[][] matrix4 = {{1, 2, 3}};
        System.out.println("测试用例4: " + solution.isToeplitzMatrix(matrix4)); // true

        // 测试用例5：单列
        int[][] matrix5 = {{1}, {2}, {3}};
        System.out.println("测试用例5: " + solution.isToeplitzMatrix(matrix5)); // true

        // 测试用例6：2x2 托普利茨
        int[][] matrix6 = {{1, 2}, {3, 1}};
        System.out.println("测试用例6: " + solution.isToeplitzMatrix(matrix6)); // true
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}