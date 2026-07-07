package cn.com.sky.algorithms.offer;

import java.util.Arrays;

/**
 * <pre>
 * 剑指Offer 4. 二维数组中的查找【Medium】
 *
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 算法原理（从右上角/左下角开始搜索）：
 * 1. 从右上角开始比较：
 *    - 如果当前元素等于目标值，找到
 *    - 如果当前元素大于目标值，剔除当前列（列指针左移）
 *    - 如果当前元素小于目标值，剔除当前行（行指针下移）
 * 2. 每次比较都可以剔除一行或一列，逐步缩小搜索范围
 *
 * 为什么从右上角开始？
 * - 右上角的元素是所在行的最大值、所在列的最小值
 * - 大于目标值时，可以确定该列不可能有目标值（该列下方更大）
 * - 小于目标值时，可以确定该行不可能有目标值（该行左侧更小）
 *
 * 时间复杂度：O(m + n)，最多移动m+n次
 * 空间复杂度：O(1)
 * </pre>
 */
public class TwoArraySearch {

    public static void main(String[] args) {
        TwoArraySearch solution = new TwoArraySearch();

        // 测试用例1：目标值存在
        System.out.println("=== 测试用例1：目标值存在 ===");
        int[][] array1 = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };
        printMatrix(array1);
        System.out.println("查找7: " + solution.search(array1, 7)); // true
        System.out.println("查找1: " + solution.search(array1, 1)); // true
        System.out.println("查找15: " + solution.search(array1, 15)); // true

        // 测试用例2：目标值不存在
        System.out.println("\n=== 测试用例2：目标值不存在 ===");
        System.out.println("查找0: " + solution.search(array1, 0)); // false
        System.out.println("查找16: " + solution.search(array1, 16)); // false
        System.out.println("查找5: " + solution.search(array1, 5)); // false

        // 测试用例3：单行数组
        System.out.println("\n=== 测试用例3：单行数组 ===");
        int[][] array2 = {{1, 3, 5, 7}};
        System.out.println("查找5: " + solution.search(array2, 5)); // true
        System.out.println("查找4: " + solution.search(array2, 4)); // false

        // 测试用例4：单列数组
        System.out.println("\n=== 测试用例4：单列数组 ===");
        int[][] array3 = {{1}, {3}, {5}, {7}};
        System.out.println("查找5: " + solution.search(array3, 5)); // true
        System.out.println("查找4: " + solution.search(array3, 4)); // false

        // 测试用例5：1x1数组
        System.out.println("\n=== 测试用例5：1x1数组 ===");
        int[][] array4 = {{5}};
        System.out.println("查找5: " + solution.search(array4, 5)); // true
        System.out.println("查找3: " + solution.search(array4, 3)); // false

        // 测试用例6：空数组
        System.out.println("\n=== 测试用例6：空数组 ===");
        int[][] array5 = {};
        System.out.println("查找1: " + solution.search(array5, 1)); // false
    }

    /**
     * 从右上角开始搜索
     *
     * @param array 二维数组，每行从左到右递增，每列从上到下递增
     * @param k     目标值
     * @return 是否存在
     */
    public boolean search(int[][] array, int k) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;

        while (row <= array.length - 1 && col >= 0) {
            int current = array[row][col];
            if (current == k) {
                return true;
            } else if (current > k) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    private static void printMatrix(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}