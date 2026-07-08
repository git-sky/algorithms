package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;

/**
 * <pre>
 * 滑动窗口最大值【Hard】
 *
 * 题目：给定一个数组和滑动窗口大小w，求滑动窗口中最大值组成的数组。
 * 例如：数组[4,3,5,4,3,3,6,7]，窗口大小w=3
 * 结果：[5,5,5,4,6,7]
 *
 * 算法原理（单调双端队列法，最优）：
 * 1. 使用双端队列qmax存储数组下标，保持队列中下标对应的值从大到小排列
 * 2. 遍历数组时：
 *    - 如果当前值 >= 队尾下标对应的值，弹出队尾（保持单调递减）
 *    - 将当前下标加入队尾
 *    - 如果队头下标已过期（i - qmax.peekFirst() >= w），弹出队头
 * 3. 当i >= w-1时，队头下标对应的值就是当前窗口的最大值
 *
 * 为什么是最优？
 * - 每个元素最多入队出队各一次，总时间O(n)
 * - 暴力法每个窗口遍历w个元素，总时间O(n*w)
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(w)
 * </pre>
 */
public class WinMaxArray {

    public static void main(String[] args) {
        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        int[] arr1 = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] result1 = getMaxWindow(arr1, 3);
        System.out.print("滑动窗口最大值: ");
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 测试用例2：窗口大小为1
        System.out.println("\n=== 测试用例2：窗口大小为1 ===");
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] result2 = getMaxWindow(arr2, 1);
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 测试用例3：窗口大小等于数组长度
        System.out.println("\n=== 测试用例3：窗口大小等于数组长度 ===");
        int[] arr3 = {1, 3, 2, 5, 4};
        int[] result3 = getMaxWindow(arr3, 5);
        for (int val : result3) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 测试用例4：递减数组
        System.out.println("\n=== 测试用例4：递减数组 ===");
        int[] arr4 = {5, 4, 3, 2, 1};
        int[] result4 = getMaxWindow(arr4, 3);
        for (int val : result4) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 测试用例5：递增数组
        System.out.println("\n=== 测试用例5：递增数组 ===");
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] result5 = getMaxWindow(arr5, 3);
        for (int val : result5) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    /**
     * 求滑动窗口最大值（单调双端队列法，最优）
     *
     * @param arr 数组
     * @param w   窗口大小
     * @return 每个窗口的最大值组成的数组
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // 保持队列单调递减：弹出所有比当前值小的队尾元素
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);

            // 弹出过期的队头元素
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }

            // 当窗口形成后，记录最大值
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }
}