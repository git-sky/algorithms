package cn.com.sky.algorithms.interview.stack_queue;

/**
 * <pre>
 * 循环队列的简单实现【Easy】
 *
 * 算法原理（循环数组）：
 * 1. 使用固定大小数组存储元素
 * 2. putIndex指向下一个入队位置，takeIndex指向下一个出队位置
 * 3. count记录当前元素数量
 * 4. 入队时putIndex循环递增，出队时takeIndex循环递增
 * 5. 当count==数组长度时队列满，count==0时队列空
 *
 * 时间复杂度：enqueue O(1)，dequeue O(1)
 * 空间复杂度：O(capacity)
 * </pre>
 */
public class Queue {

    private int[] items;
    private int count = 0;
    private int putIndex = 0;
    private int takeIndex = 0;

    public Queue() {
        items = new int[10];
    }

    public Queue(int n) {
        items = new int[n];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    /**
     * 入队操作
     */
    public void enqueue(int e) {
        if (count < items.length) {
            items[putIndex] = e;
            count++;
            putIndex = incr(putIndex);
        } else {
            throw new RuntimeException("the queue is full...");
        }
    }

    /**
     * 出队操作
     */
    public int dequeue() {
        if (count > 0) {
            int e = items[takeIndex];
            count--;
            takeIndex = incr(takeIndex);
            return e;
        } else {
            throw new RuntimeException("the queue is empty...");
        }
    }

    /**
     * 循环递增索引
     */
    private int incr(int i) {
        return (++i == items.length) ? 0 : i;
    }
}