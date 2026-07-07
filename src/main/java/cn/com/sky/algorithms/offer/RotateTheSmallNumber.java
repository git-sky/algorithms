package cn.com.sky.algorithms.offer;

import java.util.Arrays;

/**
 * <pre>
 * 剑指Offer 11. 旋转数组的最小数字【Easy】
 *
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 算法原理（二分查找）：
 * 1. 旋转数组由两个递增子数组组成，前面子数组的元素都大于等于后面子数组的元素
 * 2. 最小元素刚好是两个子数组的分界线
 * 3. 使用二分查找：
 *    - 如果中间元素 >= 左指针元素，最小值在右半部分
 *    - 如果中间元素 <= 右指针元素，最小值在左半部分
 * 4. 当左右指针相邻时，右指针指向的就是最小值
 * 5. 特殊情况：当三个指针指向的值相等时，无法判断，需要顺序查找
 *
 * 时间复杂度：O(log n)，最坏O(n)（当元素大量重复时）
 * 空间复杂度：O(1)
 * </pre>
 */
public class RotateTheSmallNumber {

    public static void main(String[] args) {
        RotateTheSmallNumber solution = new RotateTheSmallNumber();

        // 测试用例1：正常旋转
        System.out.println("=== 测试用例1：正常旋转 ===");
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println("数组: " + Arrays.toString(arr1));
        System.out.println("最小值: " + solution.getMin(arr1)); // 1

        // 测试用例2：未旋转（递增数组）
        System.out.println("\n=== 测试用例2：未旋转 ===");
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("数组: " + Arrays.toString(arr2));
        System.out.println("最小值: " + solution.getMin(arr2)); // 1

        // 测试用例3：旋转1个元素
        System.out.println("\n=== 测试用例3：旋转1个元素 ===");
        int[] arr3 = {5, 1, 2, 3, 4};
        System.out.println("数组: " + Arrays.toString(arr3));
        System.out.println("最小值: " + solution.getMin(arr3)); // 1

        // 测试用例4：两个元素
        System.out.println("\n=== 测试用例4：两个元素 ===");
        int[] arr4 = {2, 1};
        System.out.println("数组: " + Arrays.toString(arr4));
        System.out.println("最小值: " + solution.getMin(arr4)); // 1

        // 测试用例5：单元素
        System.out.println("\n=== 测试用例5：单元素 ===");
        int[] arr5 = {1};
        System.out.println("数组: " + Arrays.toString(arr5));
        System.out.println("最小值: " + solution.getMin(arr5)); // 1

        // 测试用例6：含重复元素
        System.out.println("\n=== 测试用例6：含重复元素 ===");
        int[] arr6 = {1, 0, 1, 1, 1};
        System.out.println("数组: " + Arrays.toString(arr6));
        System.out.println("最小值: " + solution.getMin(arr6)); // 0

        // 测试用例7：空数组
        System.out.println("\n=== 测试用例7：空数组 ===");
        int[] arr7 = {};
        System.out.println("最小值: " + solution.getMin(arr7)); // Integer.MIN_VALUE
    }

    /**
     * 二分查找旋转数组的最小值
     *
     * @param numbers 旋转数组
     * @return 最小值
     */
    public int getMin(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0;
        int right = numbers.length - 1;
        int mid = left;

        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;

            // 特殊情况：三个指针指向的值相等，无法判断，顺序查找
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                return getMinInOrder(numbers, left, right);
            }

            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }

        return numbers[mid];
    }

    /**
     * 顺序查找最小值
     */
    private int getMinInOrder(int[] numbers, int left, int right) {
        int result = numbers[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}