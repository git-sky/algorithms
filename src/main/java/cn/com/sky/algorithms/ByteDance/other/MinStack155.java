package cn.com.sky.algorithms.ByteDance.other;

import java.util.Stack;

/**
 * LeetCode 155. 最小栈【Easy】（腾讯高频）
 * 
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 算法原理：
 * 使用两个栈：
 * 1. stackData：存储所有数据
 * 2. stackMin：存储当前最小值（每次入栈时，如果新元素小于等于当前最小值，也入栈）
 * 
 * 时间复杂度：O(1)（所有操作）
 * 空间复杂度：O(n)
 */
public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        
        // 测试用例1：正常操作
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("当前最小值: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("栈顶元素: " + minStack.top());     // 0
        System.out.println("当前最小值: " + minStack.getMin()); // -2
        
        // 测试用例2：重复最小值
        MinStack155 minStack2 = new MinStack155();
        minStack2.push(2);
        minStack2.push(0);
        minStack2.push(3);
        minStack2.push(0);
        System.out.println("\n测试重复最小值:");
        System.out.println("getMin: " + minStack2.getMin()); // 0
        minStack2.pop();
        System.out.println("pop后getMin: " + minStack2.getMin()); // 0
        minStack2.pop();
        System.out.println("pop后getMin: " + minStack2.getMin()); // 0
        minStack2.pop();
        System.out.println("pop后getMin: " + minStack2.getMin()); // 2
    }

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack155() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        stackData.push(val);
        // 如果stackMin为空或新元素小于等于当前最小值
        if (stackMin.isEmpty() || val <= stackMin.peek()) {
            stackMin.push(val);
        }
    }

    public void pop() {
        int val = stackData.pop();
        // 如果弹出的是最小值，stackMin也弹出
        if (val == stackMin.peek()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}