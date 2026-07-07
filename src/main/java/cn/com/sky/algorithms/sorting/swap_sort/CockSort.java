package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.Arrays;

/**
 * <pre>
 * 鸡尾酒排序（Cocktail Sort）【Easy】
 * 
 * 算法原理：
 * 1. 冒泡排序的改进版
 * 2. 从左到右冒泡一次，然后从右到左冒泡一次
 * 3. 重复直到没有交换发生
 * 
 * 适用场景：
 * - 大部分元素已经有序的情况
 * - 小范围的逆序元素
 * 
 * 时间复杂度：
 * - 最坏：O(n^2)
 * - 最好：O(n)（已排序）
 * 空间复杂度：O(1)
 * 
 * 稳定性：稳定
 * </pre>
 */
public class CockSort {

    public static void main(String[] args) {
        // 测试用例1：基本情况
        System.out.println("=== 测试用例1：基本情况 ===");
        int[] arr1 = {6, 2, 4, 1, 5, 9};
        System.out.println("排序前: " + Arrays.toString(arr1));
        cocktailSort(arr1);
        System.out.println("排序后: " + Arrays.toString(arr1));

        // 测试用例2：已排序数组
        System.out.println("\n=== 测试用例2：已排序数组 ===");
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("排序前: " + Arrays.toString(arr2));
        cocktailSort(arr2);
        System.out.println("排序后: " + Arrays.toString(arr2));

        // 测试用例3：逆序数组
        System.out.println("\n=== 测试用例3：逆序数组 ===");
        int[] arr3 = {6, 5, 4, 3, 2, 1};
        System.out.println("排序前: " + Arrays.toString(arr3));
        cocktailSort(arr3);
        System.out.println("排序后: " + Arrays.toString(arr3));

        // 测试用例4：含重复元素
        System.out.println("\n=== 测试用例4：含重复元素 ===");
        int[] arr4 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("排序前: " + Arrays.toString(arr4));
        cocktailSort(arr4);
        System.out.println("排序后: " + Arrays.toString(arr4));

        // 测试用例5：单元素
        System.out.println("\n=== 测试用例5：单元素 ===");
        int[] arr5 = {42};
        System.out.println("排序前: " + Arrays.toString(arr5));
        cocktailSort(arr5);
        System.out.println("排序后: " + Arrays.toString(arr5));
    }

    /**
     * 鸡尾酒排序实现
     * 
     * @param arr 待排序数组
     */
    public static void cocktailSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int left = 0;
        int right = arr.length - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // 从左到右冒泡
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            right--;

            if (!swapped) {
                break;
            }

            swapped = false;

            // 从右到左冒泡
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            left++;
        }
    }

    /**
     * 交换数组中两个元素
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}