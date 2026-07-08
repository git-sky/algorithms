package cn.com.sky.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 加权轮询调度算法（Weighted Round-Robin）【Medium】（Nginx/LVS负载均衡核心算法）
 *
 * 题目：实现加权轮询调度算法，按照服务器权重比例分配请求
 *
 * 算法原理：
 * 1. 每台服务器有一个权重值，权重越大被选中的概率越高
 * 2. 使用比较因子cw从最大权重开始，以最大公约数为步长递减
 * 3. 每轮遍历所有服务器，选择权重>=cw的服务器
 * 4. 当cw减到0时，重置为最大权重，开始新一轮
 *
 * 举例：服务器权重为{5, 1, 3}，gcd=1，max=5
 * - cw=5: 选服务器0（权重5>=5）
 * - cw=4: 无服务器权重>=4（跳过）
 * - cw=3: 选服务器0（5>=3）和服务器2（3>=3）
 * - cw=2: 选服务器0（5>=2）和服务器2（3>=2）
 * - cw=1: 选服务器0（5>=1）、服务器1（1>=1）和服务器2（3>=1）
 * 总计：服务器0被选5次，服务器1被选1次，服务器2被选3次，符合权重比
 *
 * 轮询策略 vs IP哈希策略：
 * - 轮询：适用性强，均匀分配，但不支持会话保持
 * - IP哈希：支持会话保持，但可能导致负载不均衡
 *
 * 时间复杂度：O(n) 每次选择
 * 空间复杂度：O(n)
 * </pre>
 */
public class RoundRobinWeightTest {

	public static int[] server = new int[10];
	public static int cw = 0;
	public static int number = -1;
	public static int max;
	public static int gcd;

	static {
		init();
		max = getMaxWeight(server);
		gcd = gcd(server);
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
	 * 求最大公约数（辗转相减法）
	 * 从最小权重开始递减，找到第一个能整除所有元素的数
	 *
	 * 优化方向：可使用欧几里得算法（辗转相除法）优化为O(n*log(min))
	 */
	public static int gcd(int[] ary) {
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
		return min;
	}

	/**
	 * 求最大权重值
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
	 * 获取下一个请求应分配的服务器序号
	 * 核心逻辑：
	 * 1. number循环递增遍历所有服务器
	 * 2. 每完成一轮遍历，cw减去gcd
	 * 3. 当cw<=0时，重置为最大权重
	 * 4. 选择权重>=cw的服务器
	 */
	public static Integer next() {
		while (true) {
			number = (number + 1) % server.length;
			if (number == 0) {
				cw = cw - gcd;
				if (cw <= 0) {
					cw = max;
					if (cw == 0) return null;
				}
			}
			if (server[number] >= cw) return number;
		}
	}

	public static void main(String[] args) {
		// 测试用例1：100次请求的分配结果
		System.out.println("=== 测试用例1：100次请求分配 ===");
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
			pool.shutdown();
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			System.out.println("\nall thread complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 测试用例2：验证权重比例
		System.out.println("\n=== 测试用例2：验证权重比例 ===");
		int[] counts = new int[server.length];
		for (int i = 0; i < 1000; i++) {
			int s = next();
			counts[s]++;
		}
		for (int i = 0; i < server.length; i++) {
			System.out.println("服务器" + i + "(权重=" + server[i] + "): 被选中" + counts[i] + "次");
		}
	}
}