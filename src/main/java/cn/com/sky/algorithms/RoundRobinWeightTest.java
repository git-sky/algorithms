package cn.com.sky.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 
 * 轮询策略和IP哈希策略对比
 * 
 * 
 * 加权轮询策略
 * 优点：适用性更强，不依赖于客户端的任何信息，完全依靠后端服务器的情况来进行选择。能把客户端请求更合理更均匀地分配到各个后端服务器处理。
 * 缺点：同一个客户端的多次请求可能会被分配到不同的后端服务器进行处理，无法满足做会话保持的应用的需求。
 * 
 * IP哈希策略
 * 优点：能较好地把同一个客户端的多次请求分配到同一台服务器处理，避免了加权轮询无法适用会话保持的需求。
 * 缺点：当某个时刻来自某个IP地址的请求特别多，那么将导致某台后端服务器的压力可能非常大，而其他后端服务器却空闲的不均衡情况、
 * 
 * 
 * 权重轮询调度(Weighted Round-Robin))算法（使用最大公约数算法）
 * 
 * </pre>
 * 
 */
public class RoundRobinWeightTest {

	public static int[] server = new int[10];// 机器序号：权重
	public static int cw = 0;
	public static int number = -1;// 当前SERVER的序号,开始是-1
	public static int max;// 最大权重
	public static int gcd;// 最大公约数

	static {
		init();
		max = getMaxWeight(server);// 最大权重
		gcd = gcd(server); // 最大公约数
	}

	public static void init() {
		server[0] = 5;
		server[1] = 15;
		server[2] = 10;
		server[3] = 5;
		server[4] = 25;

		server[5] = 5;
		server[6] = 5;
		server[7] = 10;
		server[8] = 11;
		server[9] = 9;

	}

	/**
	 * 求最大公约数
	 * 
	 * @param array
	 * @return
	 */
	public static int gcd(int[] ary) {

		// min:最小权重
		int min = ary[0];

		for (int i = 0; i < ary.length; i++) {
			if (ary[i] < min) {
				min = ary[i];
			}
		}

		while (min >= 1) {
			boolean isCommon = true;
			for (int i = 0; i < ary.length; i++) {
				if (ary[i] % min != 0) {
					isCommon = false;
					break;
				}
			}
			if (isCommon) {
				break;
			}
			min--;
		}
		// System.out.println("gcd=" + min);
		return min;
	}

	/**
	 * 求最大值，权重
	 * 
	 * @return
	 */

	public static int getMaxWeight(int[] ary) {
		int max = 0;
		for (int i = 0; i < ary.length; i++) {
			if (max < ary[i]) {
				max = ary[i];
			}
		}
		return max;
	}

	/**
	 * 获取请求的SERVER序号
	 * 
	 * @return
	 */
	public static Integer next() {

		while (true) {
			number = (number + 1) % server.length;//number:-1...8
			// System.out.println("number=" + number);
			// System.out.println("cw=" + cw);
			if (number == 0) {
				cw = cw - gcd;// cw比较因子，从最大权重开始，以最大公约数为步长递减
				if (cw <= 0) {//
					cw = max;
					if (cw == 0)
						return null;
				}
			}
			if (server[number] >= cw)
				return number;
		}

	}

	public static void main(String[] args) {
		try {
			ExecutorService pool = Executors.newFixedThreadPool(1);

			for (int i = 0; i < 100; i++) {
				Runnable run = new Runnable() {
					public void run() {
						System.out.print(RoundRobinWeightTest.next() + ",");
					}
				};

				pool.execute(run);
			}
			// 关闭启动线程
			pool.shutdown();
			// 等待子线程结束，再继续执行下面的代码
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			System.out.println("all thread complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*
		 * int req = 99; while (req >= 0) { System.out.print(RoundRobinWeightTest.next() + ",");
		 * req--; }
		 */

	}
}