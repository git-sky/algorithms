package cn.com.sky.algorithms.interview.stack_queue;

/**
 * <pre>
 * 栈的简单实现【Easy】
 *
 * 算法原理（数组实现）：
 * 1. 使用固定大小数组存储元素
 * 2. size记录当前栈中元素个数，同时指向下一个入栈位置
 * 3. push时将元素放入items[size]，然后size++
 * 4. pop时size--，返回items[size]
 * 5. peek返回items[size-1]（不弹出）
 *
 * 时间复杂度：push O(1)，pop O(1)，peek O(1)
 * 空间复杂度：O(capacity)
 * </pre>
 */
public class Stack {

    private int[] items;
    private int size = 0;

    public Stack() {
        items = new int[10];
    }

    public Stack(int n) {
        items = new int[n];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 入栈操作
     */
    public void push(int e) {
        if (size < items.length) {
            items[size++] = e;
        } else {
            throw new RuntimeException("the stack is full...");
        }
    }

    /**
     * 出栈操作
     */
    public int pop() {
        if (size > 0) {
            return items[--size];
        } else {
            throw new RuntimeException("the stack is empty...");
        }
    }

    /**
     * 查看栈顶元素（不弹出）
     */
    public int peek() {
        if (size > 0) {
            return items[size - 1];
        } else {
            throw new RuntimeException("the stack is empty...");
        }
    }
}