package cn.com.sky.algorithms.offer;

import java.util.Arrays;

/**
 * <pre>
 * 剑指Offer 56-I. 数组中只出现一次的两个数字【Medium】
 *
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度O(1)。
 *
 * 算法原理（异或分组法）：
 * 1. 将所有元素异或，结果为两个只出现一次的数字的异或值（因为其他数字异或后为0）
 * 2. 找到异或结果中为1的某一位（说明这两个数字在该位上不同）
 * 3. 根据该位将数组分成两组，每组恰好包含一个只出现一次的数字
 * 4. 分别对两组进行异或，即可得到两个只出现一次的数字
 *
 * 核心思想：
 *   异或性质：a ^ a = 0, a ^ 0 = a
 *   通过某一位的不同将两个目标数字分到不同的组
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * </pre>
 */
public class ArrayOnlyOnce {

    public static void main(String[] args) {
        ArrayOnlyOnce solution = new ArrayOnlyOnce();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        int[] arr1 = {2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println("数组: " + Arrays.toString(arr1));
        solution.findNumsAppearOnce(arr1); // 4, 6

        // 测试用例2：两个数在数组两端
        System.out.println("\n=== 测试用例2：两个数在数组两端 ===");
        int[] arr2 = {1, 1, 2, 2, 3, 4};
        System.out.println("数组: " + Arrays.toString(arr2));
        solution.findNumsAppearOnce(arr2); // 3, 4

        // 测试用例3：含负数
        System.out.println("\n=== 测试用例3：含负数 ===");
        int[] arr3 = {-1, -1, -2, 3};
        System.out.println("数组: " + Arrays.toString(arr3));
        solution.findNumsAppearOnce(arr3); // -2, 3

        // 测试用例4：最小数组
        System.out.println("\n=== 测试用例4：最小数组 ===");
        int[] arr4 = {1, 2};
        System.out.println("数组: " + Arrays.toString(arr4));
        solution.findNumsAppearOnce(arr4); // 1, 2

        // 测试用例5：含0
        System.out.println("\n=== 测试用例5：含0 ===");
        int[] arr5 = {0, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("数组: " + Arrays.toString(arr5));
        solution.findNumsAppearOnce(arr5); // 0, 4
    }

    /**
     * 找出数组中只出现一次的两个数字
     *
     * @param array 输入数组
     */
    public void findNumsAppearOnce(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        // 第一步：所有元素异或，结果为两个只出现一次数字的异或值
        int xorResult = 0;
        for (int num : array) {
            xorResult ^= num;
        }

        // 第二步：找到异或结果中最低位为1的位置
        int mask = xorResult & (-xorResult);

        // 第三步：根据该位将数组分成两组，分别异或
        int num1 = 0;
        int num2 = 0;
        for (int num : array) {
            if ((num & mask) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        System.out.println("只出现一次的数字: " + num1 + ", " + num2);
    }
}