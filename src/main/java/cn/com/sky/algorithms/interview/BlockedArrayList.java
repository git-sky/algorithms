package cn.com.sky.algorithms.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己实现阻塞队列
 */
public class BlockedArrayList<E> {

	private Object[] items;
	private int takeIndex = 0;// 获取元素的索引
	private int putIndex = 0;// 存放元素的索引
	private int count = 0; // 队列里的元素个数

	public BlockedArrayList(int capacity) {
		items = new Object[capacity];
	}

	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();

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

	private void insert(E e) {
		items[putIndex] = e;
		putIndex = inc(putIndex);
		count++;
		notEmpty.signal();
	}

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

	@SuppressWarnings("unchecked")
	private E extract() {
		E e = (E) items[takeIndex];
		items[takeIndex] = null;
		takeIndex = inc(takeIndex);
		count--;
		notFull.signal();
		return e;
	}

	private int inc(int i) {
		return (++i == items.length) ? 0 : i;
	}
}
