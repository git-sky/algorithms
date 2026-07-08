package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Stack;

/**
 * <pre>
 * 两个栈实现队列【Easy】
 *
 * 题目：用两个栈实现一个队列，支持push、pop、peek操作。
 *
 * 算法原理（双栈法）：
 * 1. stackPush负责入队，stackPop负责出队
 * 2. push时：直接压入stackPush
 * 3. pop/peek时：如果stackPop为空，将stackPush中所有元素倒入stackPop
 *    然后从stackPop弹出/查看栈顶
 *
 * 关键约束（必须遵守，否则会出错）：
 * 1. 只有stackPop为空时，才能将stackPush的元素倒入stackPop
 * 2. 倒入时必须一次性将stackPush中所有元素全部倒入
 *
 * 原理：栈是后进先出，两次后进先出就变成了先进先出
 * 例如：push 1,2,3 → stackPush: [1,2,3]
 * 倒入stackPop → stackPop: [3,2,1]
 * pop → 1（先进先出）
 *
 * 时间复杂度：push O(1)，pop均摊O(1)
 * 空间复杂度：O(n)
 * </pre>
 */
public class TwoStackQueue {

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        // 测试用例1：正常操作
        System.out.println("=== 测试用例1：正常操作 ===");
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("peek: " + queue.peek()); // 1
        System.out.println("poll: " + queue.poll()); // 1
        System.out.println("poll: " + queue.poll()); // 2
        queue.push(4);
        System.out.println("poll: " + queue.poll()); // 3
        System.out.println("poll: " + queue.poll()); // 4

        // 测试用例2：单元素
        System.out.println("\n=== 测试用例2：单元素 ===");
        TwoStackQueue queue2 = new TwoStackQueue();
        queue2.push(10);
        System.out.println("poll: " + queue2.poll()); // 10

        // 测试用例3：交替push和poll
        System.out.println("\n=== 测试用例3：交替push和poll ===");
        TwoStackQueue queue3 = new TwoStackQueue();
        queue3.push(1);
        System.out.println("poll: " + queue3.poll()); // 1
        queue3.push(2);
        queue3.push(3);
        System.out.println("poll: " + queue3.poll()); // 2
        System.out.println("poll: " + queue3.poll()); // 3
    }

    Stack<Integer> stackPush = new Stack<>();
    Stack<Integer> stackPop = new Stack<>();

    /**
     * 入队操作：直接压入stackPush
     */
    public void push(int e) {
        stackPush.push(e);
    }

    /**
     * 出队操作：从stackPop弹出
     * 如果stackPop为空，先将stackPush的元素全部倒入
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty...");
        }

        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    /**
     * 查看队头元素
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty...");
        }

        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}