package cn.com.sky.algorithms.interview.stack_queue;

import java.util.Random;

/**
 * <pre>
 * 用两个栈实现队列【Easy】
 * 
 * 问题：使用两个栈实现一个队列，支持队列的基本操作（add，poll，peek）。
 * 
 * 算法原理：
 * 1. 使用两个栈：stackPush（入队栈）和 stackPop（出队栈）
 * 2. add操作：直接push到stackPush
 * 3. poll/peek操作：如果stackPop为空，将stackPush中所有元素转移到stackPop，然后操作
 * 
 * 关键规则：
 * 1. 必须一次性把stackPush中的数据全部转移到stackPop
 * 2. 如果stackPop不为空，stackPush不能向stackPop中压入数据
 * 
 * 时间复杂度（摊还分析）：
 * - add: O(1)
 * - poll: 均摊O(1)，每个元素最多入栈和出栈两次
 * - peek: 均摊O(1)
 * 空间复杂度：O(n)
 * </pre>
 */
public class TwoStackQueue {

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        // 测试用例1：正常操作
        System.out.println("=== 测试用例1：正常操作 ===");
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
            System.out.println("add: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("peek: " + queue.peek());
            System.out.println("poll: " + queue.poll());
        }

        // 测试用例2：空队列poll
        System.out.println("\n=== 测试用例2：空队列poll ===");
        try {
            queue.poll();
        } catch (RuntimeException e) {
            System.out.println("异常: " + e.getMessage());
        }

        // 测试用例3：交替add和poll
        System.out.println("\n=== 测试用例3：交替操作 ===");
        queue.add(1);
        queue.add(2);
        System.out.println("poll: " + queue.poll());
        queue.add(3);
        System.out.println("poll: " + queue.poll());
        System.out.println("poll: " + queue.poll());
    }

    Stack stackPush = new Stack(10);
    Stack stackPop = new Stack(10);
    int length = 10;

    public TwoStackQueue() {
        stackPush = new Stack(length);
        stackPop = new Stack(length);
    }

    public TwoStackQueue(int size) {
        stackPush = new Stack(size);
        stackPop = new Stack(size);
        length = size;
    }

    /**
     * 入队操作
     */
    public void add(int e) {
        if (stackPush.size() < length) {
            stackPush.push(e);
        } else {
            throw new RuntimeException("the queue is full...");
        }
    }

    /**
     * 出队操作
     */
    public int poll() {
        // 如果stackPop为空，将stackPush的所有元素转移到stackPop
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                int e = stackPush.pop();
                stackPop.push(e);
            }
        }
        
        if (stackPop.isEmpty()) {
            throw new RuntimeException("the queue is empty...");
        }
        
        return stackPop.pop();
    }

    /**
     * 查看队首元素
     */
    public int peek() {
        // 如果stackPop为空，将stackPush的所有元素转移到stackPop
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                int e = stackPush.pop();
                stackPop.push(e);
            }
        }
        
        if (stackPop.isEmpty()) {
            throw new RuntimeException("the queue is empty...");
        }
        
        return stackPop.peek();
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

}