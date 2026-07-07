package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;

/**
 * 滑动窗口最大值【Hard】
 * 
 * 给定一个数组 arr 和窗口大小 w，返回每个窗口的最大值。
 * 
 * 算法原理（单调队列）：
 * 使用双端队列维护窗口内的最大值索引，保持队列中的索引对应的元素单调递减：
 * 1. 遍历数组，对于每个元素：
 *    - 从队列尾部移除所有小于等于当前元素的索引
 *    - 将当前索引加入队列尾部
 *    - 如果队列头部索引已经不在窗口内，移除它
 *    - 当遍历到窗口大小后，队列头部就是当前窗口的最大值
 * 
 * 时间复杂度：O(n)，每个元素最多入队和出队一次
 * 空间复杂度：O(w)，队列最多存储窗口大小的元素
 */
public class WinMaxArray {

    public static void main(String[] args) {
        WinMaxArray solution = new WinMaxArray();
        
        // 测试用例1：正常情况
        int[] arr1 = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] result1 = solution.getMaxArray(arr1, 3);
        printArray(result1); // [5,5,5,4,6,7]
        
        // 测试用例2：窗口大小为1
        int[] arr2 = {1, 2, 3, 4};
        int[] result2 = solution.getMaxArray(arr2, 1);
        printArray(result2); // [1,2,3,4]
        
        // 测试用例3：窗口大小等于数组长度
        int[] arr3 = {5, 3, 1, 2, 4};
        int[] result3 = solution.getMaxArray(arr3, 5);
        printArray(result3); // [5]
        
        // 测试用例4：空数组
        int[] result4 = solution.getMaxArray(null, 3);
        printArray(result4); // null
        
        // 测试用例5：窗口大于数组长度
        int[] arr5 = {1, 2};
        int[] result5 = solution.getMaxArray(arr5, 3);
        printArray(result5); // null
        
        // 测试用例6：递减数组
        int[] arr6 = {6, 5, 4, 3, 2, 1};
        int[] result6 = solution.getMaxArray(arr6, 3);
        printArray(result6); // [6,5,4,3]
        
        // 测试用例7：递增数组
        int[] arr7 = {1, 2, 3, 4, 5, 6};
        int[] result7 = solution.getMaxArray(arr7, 3);
        printArray(result7); // [3,4,5,6]
    }

    /**
     * 打印数组
     */
    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public int[] getMaxArray(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        int[] result = new int[arr.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // 从尾部移除所有小于等于当前元素的索引
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            
            // 将当前索引加入队列
            qmax.addLast(i);

            // 如果队列头部索引已经不在窗口内，移除它
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }

            // 当遍历到窗口大小后，记录最大值
            if (i >= w - 1) {
                result[index++] = arr[qmax.peekFirst()];
            }
        }

        return result;
    }
}