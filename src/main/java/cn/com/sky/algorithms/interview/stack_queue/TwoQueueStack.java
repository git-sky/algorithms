package cn.com.sky.algorithms.interview.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 两个队列实现栈【Easy】
 *
 * 题目：用两个队列实现一个栈，支持push、pop、peek操作。
 *
 * 算法原理：
 * 方法1（push时倒换，最优）：
 * - push时：将元素加入空队列，再将另一个队列的所有元素依次加入
 * - pop时：直接从非空队列头部取出
 * - 原理：每次push都保证新元素在队列头部，实现后进先出
 * - push O(n)，pop O(1)
 *
 * 方法2（pop时倒换）：
 * - push时：直接加入非空队列
 * - pop时：将非空队列的前n-1个元素移到另一个队列，取出最后一个元素
 * - push O(1)，pop O(n)
 *
 * 本实现采用方法2（pop时倒换），更直观
 *
 * 时间复杂度：push O(1)，pop O(n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class TwoQueueStack {

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();

        // 测试用例1：正常操作
        System.out.println("=== 测试用例1：正常操作 ===");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: " + stack.peek()); // 3
        System.out.println("pop: " + stack.pop()); // 3
        System.out.println("pop: " + stack.pop()); // 2
        stack.push(4);
        System.out.println("pop: " + stack.pop()); // 4
        System.out.println("pop: " + stack.pop()); // 1

        // 测试用例2：单元素
        System.out.println("\n=== 测试用例2：单元素 ===");
        TwoQueueStack stack2 = new TwoQueueStack();
        stack2.push(10);
        System.out.println("pop: " + stack2.pop()); // 10

        // 测试用例3：交替push和pop
        System.out.println("\n=== 测试用例3：交替push和pop ===");
        TwoQueueStack stack3 = new TwoQueueStack();
        stack3.push(1);
        System.out.println("pop: " + stack3.pop()); // 1
        stack3.push(2);
        stack3.push(3);
        System.out.println("pop: " + stack3.pop()); // 3
        System.out.println("pop: " + stack3.pop()); // 2
    }

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 入栈操作：直接加入非空队列
     */
    public void push(int e) {
        if (queue1.isEmpty()) {
            queue2.add(e);
        } else {
            queue1.add(e);
        }
    }

    /**
     * 出栈操作：将非空队列的前n-1个元素移到另一个队列，取出最后一个
     */
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("stack is empty...");
        }

        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /**
     * 查看栈顶元素
     */
    public int peek() {
        int val = pop();
        push(val);
        return val;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}