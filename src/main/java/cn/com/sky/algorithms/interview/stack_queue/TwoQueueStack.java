package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 用两个队列实现栈【Easy】
 * 
 * 问题：使用两个队列实现一个栈，支持栈的基本操作（push，pop，isEmpty）。
 * 
 * 算法原理：
 * 1. 使用两个队列 q1 和 q2
 * 2. push操作：将元素加入非空队列（如果都为空则加入q1）
 * 3. pop操作：将非空队列中的 n-1 个元素转移到另一个队列，然后弹出最后一个元素
 * 
 * 时间复杂度：
 * - push: O(1)
 * - pop: O(n)，需要转移n-1个元素
 * 空间复杂度：O(n)
 * </pre>
 */
public class TwoQueueStack {

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();

        // 测试用例1：正常push和pop
        System.out.println("=== 测试用例1：正常操作 ===");
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println("push: " + i);
        }
        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }

        // 测试用例2：空栈pop
        System.out.println("\n=== 测试用例2：空栈pop ===");
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("异常: " + e.getMessage());
        }

        // 测试用例3：单元素
        System.out.println("\n=== 测试用例3：单元素 ===");
        stack.push(10);
        System.out.println("pop: " + stack.pop());
    }

    int length = 10;
    int count = 0;
    Queue qleft = new Queue(10);
    Queue qright = new Queue(10);

    public TwoQueueStack() {
        qleft = new Queue(length);
        qright = new Queue(length);
    }

    public TwoQueueStack(int size) {
        qleft = new Queue(size);
        qright = new Queue(size);
        length = size;
    }

    /**
     * 入栈操作
     */
    public void push(int e) {
        if (count < length) {
            count++;
            // 将元素加入非空队列
            if (!qleft.isEmpty()) {
                qleft.enqueue(e);
            } else {
                qright.enqueue(e);
            }
        } else {
            throw new RuntimeException("the stack is full...");
        }
    }

    /**
     * 出栈操作
     */
    public int pop() {
        if (count > 0) {
            count--;
            // 将非空队列的n-1个元素转移到另一个队列
            if (!qleft.isEmpty()) {
                while (qleft.size() > 1) {
                    qright.enqueue(qleft.dequeue());
                }
                return qleft.dequeue();
            } else {
                while (qright.size() > 1) {
                    qleft.enqueue(qright.dequeue());
                }
                return qright.dequeue();
            }
        } else {
            throw new RuntimeException("the stack is empty...");
        }
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }

}