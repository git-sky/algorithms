package cn.com.sky.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * <pre>
 * LeetCode 155. 最小栈【Easy】（字节跳动高频）
 * 
 * 题目描述：设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 算法原理（双栈法）：
 * 1. 使用一个主栈存储所有元素
 * 2. 使用一个辅助栈（最小栈）存储当前最小值
 * 3. 每次 push 时，若新元素小于等于最小栈顶，则同时压入最小栈
 * 4. 每次 pop 时，若弹出的是最小值，则同时弹出最小栈顶
 * 
 * 时间复杂度：O(1)（所有操作）
 * 空间复杂度：O(n)
 * </pre>
 */
public class MinStack155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin()); // --> 返回 -3.
        minStack.pop();
        System.out.println("top: " + minStack.top());      // --> 返回 0.
        System.out.println("getMin: " + minStack.getMin()); // --> 返回 -2.
        
        // 额外测试用例
        minStack.push(-5);
        System.out.println("getMin after push -5: " + minStack.getMin()); // --> 返回 -5
        minStack.pop();
        System.out.println("getMin after pop -5: " + minStack.getMin()); // --> 返回 -2
    }
}

class MinStack {
    Stack<Integer> stack;   // 主栈：存储所有元素
    Stack<Integer> minStack; // 辅助栈：存储当前最小值

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 若最小栈为空或新元素小于等于当前最小值，则压入最小栈
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 若弹出的是当前最小值，则同时弹出最小栈顶
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}