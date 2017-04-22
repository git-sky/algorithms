package cn.com.sky.algorithms.interview;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBlockedArrayList {

	public static void main(String[] args) {

		ExecutorService s = Executors.newFixedThreadPool(10);
		Queue q = new Queue();
		for (int i = 0; i < 5; i++) {
			// s.submit(new Producer(list));
			// s.submit(new Consumer(list));

			new Thread(new Producer(q)).start();
			new Thread(new Consumer(q)).start();

		}

		s.shutdown();

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
				e.printStackTrace();
			}
		}
	}

	void consume() {
		while (true) {
			try {
				String str = list.take();
				System.out.println(Thread.currentThread() + ",consume:" + str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
