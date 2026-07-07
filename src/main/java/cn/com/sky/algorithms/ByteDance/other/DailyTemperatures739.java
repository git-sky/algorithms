package cn.com.sky.algorithms.ByteDance.other;

import java.util.Stack;

/**
 * LeetCode 739. 每日温度【Medium】（字节跳动高频）
 * 
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 
 * 算法原理（单调栈）：
 * 1. 使用单调栈存储温度索引，保持栈内索引对应的温度单调递减
 * 2. 遍历数组：
 *    - 如果当前温度大于栈顶温度，说明找到了下一个更高温度
 *    - 计算天数差，更新结果数组
 *    - 弹出栈顶，继续比较
 *    - 将当前索引压入栈
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class DailyTemperatures739 {

    public static void main(String[] args) {
        DailyTemperatures739 solution = new DailyTemperatures739();
        
        // 测试用例1：正常情况
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        printArray(result1); // [1,1,4,2,1,1,0,0]
        
        // 测试用例2：递减序列
        int[] temperatures2 = {30, 20, 10};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        printArray(result2); // [0,0,0]
        
        // 测试用例3：递增序列
        int[] temperatures3 = {10, 20, 30, 40, 50};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        printArray(result3); // [1,1,1,1,0]
        
        // 测试用例4：单元素
        int[] temperatures4 = {50};
        int[] result4 = solution.dailyTemperatures(temperatures4);
        printArray(result4); // [0]
        
        // 测试用例5：重复温度
        int[] temperatures5 = {55, 55, 55, 55};
        int[] result5 = solution.dailyTemperatures(temperatures5);
        printArray(result5); // [0,0,0,0]
    }

    /**
     * 打印数组
     */
    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
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

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 当前温度大于栈顶温度，找到了下一个更高温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        
        return result;
    }
}