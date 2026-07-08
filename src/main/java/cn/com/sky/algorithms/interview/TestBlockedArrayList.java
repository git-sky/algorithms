package cn.com.sky.algorithms.interview;

import java.util.Random;

/**
 * <pre>
 * 阻塞队列测试类【Medium】
 *
 * 测试BlockedArrayList的多线程生产者-消费者模式
 * 使用5个生产者线程和5个消费者线程并发操作阻塞队列
 *
 * 算法原理：
 * 生产者-消费者模式：
 * 1. 生产者向队列中put元素，队列满时阻塞
 * 2. 消费者从队列中take元素，队列空时阻塞
 * 3. 通过ReentrantLock + Condition实现线程安全
 * </pre>
 */
public class TestBlockedArrayList {

    public static void main(String[] args) {
        Queue q = new Queue();

        // 测试用例1：5个生产者 + 5个消费者并发
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(q)).start();
            new Thread(new Consumer(q)).start();
        }
    }
}

class Producer implements Runnable {
    Queue list;

    public Producer(Queue list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.produce();
    }
}

class Consumer implements Runnable {
    Queue list;

    public Consumer(Queue list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.consume();
    }
}

class Queue {
    BlockedArrayList<String> list = new BlockedArrayList<>(10);

    void produce() {
        Random r = new Random();
        while (true) {
            try {
                String str = String.valueOf(r.nextInt());
                list.put(str);
                System.out.println(Thread.currentThread() + ",produce:" + str);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    void consume() {
        while (true) {
            try {
                String str = list.take();
                System.out.println(Thread.currentThread() + ",consume:" + str);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}