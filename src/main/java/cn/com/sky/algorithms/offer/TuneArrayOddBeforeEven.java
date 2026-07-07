package cn.com.sky.algorithms.offer;

import java.util.Arrays;

/**
 * <pre>
 * 剑指Offer 21. 调整数组顺序使奇数位于偶数前面【Easy】
 *
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 算法原理（双指针法）：
 * 1. 使用两个指针，left从左往右找偶数，right从右往左找奇数
 * 2. 当left指向偶数且right指向奇数时，交换两个元素
 * 3. 直到left >= right为止
 *
 * 时间复杂度：O(n)，每个元素最多被访问一次
 * 空间复杂度：O(1)，原地交换
 *
 * 扩展：如果需要保证奇数和奇数之间、偶数和偶数之间的相对位置不变，
 * 则需要使用类似插入排序的稳定方法，时间复杂度O(n^2)
 * </pre>
 */
public class TuneArrayOddBeforeEven {

    public static void main(String[] args) {
        TuneArrayOddBeforeEven solution = new TuneArrayOddBeforeEven();

        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("调整前: " + Arrays.toString(arr1));
        solution.tune(arr1);
        System.out.println("调整后: " + Arrays.toString(arr1));

        // 测试用例2：全是奇数
        System.out.println("\n=== 测试用例2：全是奇数 ===");
        int[] arr2 = {1, 3, 5, 7};
        System.out.println("调整前: " + Arrays.toString(arr2));
        solution.tune(arr2);
        System.out.println("调整后: " + Arrays.toString(arr2));

        // 测试用例3：全是偶数
        System.out.println("\n=== 测试用例3：全是偶数 ===");
        int[] arr3 = {2, 4, 6, 8};
        System.out.println("调整前: " + Arrays.toString(arr3));
        solution.tune(arr3);
        System.out.println("调整后: " + Arrays.toString(arr3));

        // 测试用例4：空数组
        System.out.println("\n=== 测试用例4：空数组 ===");
        int[] arr4 = {};
        solution.tune(arr4);
        System.out.println("空数组调整完成");

        // 测试用例5：单元素
        System.out.println("\n=== 测试用例5：单元素 ===");
        int[] arr5 = {3};
        System.out.println("调整前: " + Arrays.toString(arr5));
        solution.tune(arr5);
        System.out.println("调整后: " + Arrays.toString(arr5));

        // 测试用例6：已经满足条件
        System.out.println("\n=== 测试用例6：已经满足条件 ===");
        int[] arr6 = {1, 3, 5, 2, 4, 6};
        System.out.println("调整前: " + Arrays.toString(arr6));
        solution.tune(arr6);
        System.out.println("调整后: " + Arrays.toString(arr6));

        // 测试用例7：包含负数
        System.out.println("\n=== 测试用例7：包含负数 ===");
        int[] arr7 = {-1, -2, -3, -4, 5};
        System.out.println("调整前: " + Arrays.toString(arr7));
        solution.tune(arr7);
        System.out.println("调整后: " + Arrays.toString(arr7));
    }

    /**
     * 双指针法调整数组，使奇数在前偶数在后
     *
     * @param arr 待调整的数组
     */
    public void tune(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // 从左往右找偶数
            while (left < right && (arr[left] % 2 != 0)) {
                left++;
            }
            // 从右往左找奇数
            while (left < right && (arr[right] % 2 == 0)) {
                right--;
            }
            // 交换偶数和奇数
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
    }
}