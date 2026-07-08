package cn.com.sky.algorithms.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * 阻塞队列实现【Medium】
 *
 * 题目：自己实现一个线程安全的阻塞队列，支持多线程下的生产者-消费者模式。
 *
 * 算法原理（ReentrantLock + Condition）：
 * 1. 使用ReentrantLock替代synchronized，支持更灵活的锁控制
 * 2. 使用两个Condition（notFull和notEmpty）实现精确唤醒：
 *    - notFull：队列未满条件，生产者在队列满时等待
 *    - notEmpty：队列非空条件，消费者在队列空时等待
 * 3. 使用循环数组实现队列，putIndex和takeIndex循环递增
 * 4. 生产者put时：队列满则等待notFull，插入后signalNotEmpty唤醒消费者
 * 5. 消费者take时：队列空则等待notEmpty，取出后signalNotFull唤醒生产者
 *
 * 为什么用while而不是if判断条件？
 * - 防止虚假唤醒（spurious wakeup）
 * - 多个生产者/消费者被唤醒时，条件可能已被其他线程改变
 *
 * 与synchronized+wait/notify的区别：
 * - Condition可以创建多个等待条件，实现精确唤醒
 * - wait/notify只能有一个等待队列，notifyAll会唤醒所有线程
 *
 * 时间复杂度：O(1)（put和take）
 * 空间复杂度：O(capacity)
 * </pre>
 */
public class BlockedArrayList<E> {

    private Object[] items;
    private int takeIndex = 0;
    private int putIndex = 0;
    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockedArrayList(int capacity) {
        items = new Object[capacity];
    }

    /**
     * 生产者：向队列中添加元素
     * 如果队列已满，阻塞等待直到有空间
     */
    public void put(E e) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            insert(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 插入元素并唤醒消费者
     */
    private void insert(E e) {
        items[putIndex] = e;
        putIndex = inc(putIndex);
        count++;
        notEmpty.signal();
    }

    /**
     * 消费者：从队列中取出元素
     * 如果队列为空，阻塞等待直到有元素
     */
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return extract();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 取出元素并唤醒生产者
     */
    @SuppressWarnings("unchecked")
    private E extract() {
        E e = (E) items[takeIndex];
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        count--;
        notFull.signal();
        return e;
    }

    /**
     * 循环递增索引，到达数组末尾后回到0
     */
    private int inc(int i) {
        return (++i == items.length) ? 0 : i;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        BlockedArrayList<String> queue = new BlockedArrayList<>(5);

        // 测试用例1：单生产者单消费者
        System.out.println("=== 测试用例1：单生产者单消费者 ===");
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put("item" + i);
                    System.out.println("生产: item" + i + ", 队列大小: " + queue.size());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(50);
                    String item = queue.take();
                    System.out.println("消费: " + item + ", 队列大小: " + queue.size());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer").start();

        // 测试用例2：空队列take会阻塞
        System.out.println("\n=== 测试用例2：空队列take阻塞 ===");
        BlockedArrayList<Integer> queue2 = new BlockedArrayList<>(3);
        System.out.println("队列是否为空: " + queue2.isEmpty());

        // 测试用例3：满队列put会阻塞
        System.out.println("\n=== 测试用例3：容量验证 ===");
        BlockedArrayList<Integer> queue3 = new BlockedArrayList<>(3);
        try {
            queue3.put(1);
            queue3.put(2);
            queue3.put(3);
            System.out.println("队列大小: " + queue3.size()); // 3
            System.out.println("取出: " + queue3.take()); // 1
            System.out.println("取出: " + queue3.take()); // 2
            System.out.println("取出: " + queue3.take()); // 3
            System.out.println("队列是否为空: " + queue3.isEmpty()); // true
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}