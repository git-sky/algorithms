package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * <pre>
 * 栈的排序【Medium】
 *
 * 题目：将一个栈中的元素排序（从顶到底递减），只能使用一个辅助栈，
 * 不能使用其他数据结构，且不能使用数组等额外存储。
 *
 * 算法原理（辅助栈 + 插入排序思想）：
 * 1. 使用辅助栈help存储已排序的元素（从顶到底递增）
 * 2. 从原栈stack中依次弹出元素cur
 * 3. 如果cur > help的栈顶，将help中比cur小的元素依次弹回stack，再将cur压入help
 * 4. 如果cur <= help的栈顶，直接压入help
 * 5. 最终help中的元素从顶到底递增，再依次弹回stack即为从顶到底递减
 *
 * 类似于插入排序，每次将新元素插入到辅助栈的正确位置
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 * </pre>
 */
public class StackSort {

    public static void main(String[] args) {
        // 测试用例1：正常情况
        System.out.println("=== 测试用例1：正常情况 ===");
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(1);
        stack1.push(3);
        stack1.push(2);
        stack1.push(4);
        System.out.println("排序前: " + stack1);
        sort(stack1);
        System.out.println("排序后: " + stack1);

        // 测试用例2：已排序
        System.out.println("\n=== 测试用例2：已排序 ===");
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println("排序前: " + stack2);
        sort(stack2);
        System.out.println("排序后: " + stack2);

        // 测试用例3：逆序
        System.out.println("\n=== 测试用例3：逆序 ===");
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(3);
        stack3.push(2);
        stack3.push(1);
        System.out.println("排序前: " + stack3);
        sort(stack3);
        System.out.println("排序后: " + stack3);

        // 测试用例4：单元素
        System.out.println("\n=== 测试用例4：单元素 ===");
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(1);
        sort(stack4);
        System.out.println("排序后: " + stack4);

        // 测试用例5：有重复元素
        System.out.println("\n=== 测试用例5：有重复元素 ===");
        Stack<Integer> stack5 = new Stack<>();
        stack5.push(3);
        stack5.push(1);
        stack5.push(2);
        stack5.push(1);
        System.out.println("排序前: " + stack5);
        sort(stack5);
        System.out.println("排序后: " + stack5);
    }

    /**
     * 栈排序（从顶到底递减）
     * 使用辅助栈实现插入排序
     */
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            // 将help中比cur小的元素弹回stack
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        // 将help中的元素弹回stack（此时stack从顶到底递减）
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}