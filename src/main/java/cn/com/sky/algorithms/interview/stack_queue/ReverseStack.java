package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * <pre>
 * 栈的反转【Medium】
 *
 * 题目：将一个栈中的元素反转，只能使用递归操作，不能使用其他数据结构。
 *
 * 算法原理（递归法）：
 * 1. 递归获取栈底元素（getBottom）：弹出栈顶，递归获取栈底，再将栈顶压回
 * 2. 递归反转栈（reverse）：弹出栈顶，递归反转剩余栈，将原栈顶插入到栈底
 * 3. 递归插入到栈底（insertAtBottom）：如果栈空直接压入，否则弹出栈顶，递归插入，再压回栈顶
 *
 * 核心思想：利用递归的函数调用栈作为额外空间
 *
 * 时间复杂度：O(n^2)，每个元素需要O(n)的递归操作
 * 空间复杂度：O(n)，递归栈深度
 * </pre>
 */
public class ReverseStack {

    public static void main(String[] args) {
        // 测试用例1：正常栈
        System.out.println("=== 测试用例1：正常栈 ===");
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println("反转前: " + stack1);
        reverse(stack1);
        System.out.println("反转后: " + stack1);

        // 测试用例2：单元素栈
        System.out.println("\n=== 测试用例2：单元素栈 ===");
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        System.out.println("反转前: " + stack2);
        reverse(stack2);
        System.out.println("反转后: " + stack2);

        // 测试用例3：空栈
        System.out.println("\n=== 测试用例3：空栈 ===");
        Stack<Integer> stack3 = new Stack<>();
        System.out.println("反转前: " + stack3);
        reverse(stack3);
        System.out.println("反转后: " + stack3);

        // 测试用例4：两个元素
        System.out.println("\n=== 测试用例4：两个元素 ===");
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(1);
        stack4.push(2);
        System.out.println("反转前: " + stack4);
        reverse(stack4);
        System.out.println("反转后: " + stack4);
    }

    /**
     * 递归反转栈
     * 原理：弹出栈顶，递归反转剩余栈，将原栈顶插入到栈底
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    /**
     * 将元素插入到栈底
     * 原理：弹出所有栈顶元素，递归到底部后压入，再依次压回
     */
    private static void insertAtBottom(Stack<Integer> stack, int num) {
        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, num);
        stack.push(top);
    }

    /**
     * 获取并移除栈底元素
     * 原理：弹出栈顶，递归获取栈底，再将栈顶压回
     */
    private static int getBottom(Stack<Integer> stack) {
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        int bottom = getBottom(stack);
        stack.push(top);
        return bottom;
    }
}