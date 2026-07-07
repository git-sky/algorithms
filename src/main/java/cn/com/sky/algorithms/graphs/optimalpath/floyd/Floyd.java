package cn.com.sky.algorithms.graphs.optimalpath.floyd;

/**
 * <pre>
 * Floyd-Warshall算法 - 多源最短路径【Medium】
 * 
 * 算法原理：
 * 1. 初始化距离矩阵为邻接矩阵
 * 2. 对于每个中间节点k，尝试经过k来优化i到j的路径
 * 3. 如果 dist[i][k] + dist[k][j] < dist[i][j]，则更新
 * 4. 三重循环：k -> i -> j
 * 
 * 特点：
 * - 可以处理负权边（但不能处理负权环）
 * - 一次性计算所有顶点对之间的最短路径
 * 
 * 时间复杂度：O(V^3)
 * 空间复杂度：O(V^2)
 * </pre>
 */
public class Floyd {

	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// 测试用例1：标准图
		int[][] graph1 = {
			{0, 5, INF, 10},
			{INF, 0, 3, INF},
			{INF, INF, 0, 1},
			{INF, INF, INF, 0}
		};
		System.out.println("=== 测试用例1：标准图 ===");
		floydWarshall(graph1);

		// 测试用例2：含负权边（无负权环）
		int[][] graph2 = {
			{0, 5, INF, 10},
			{INF, 0, -2, INF},
			{INF, INF, 0, 1},
			{INF, INF, INF, 0}
		};
		System.out.println("\n=== 测试用例2：含负权边 ===");
		floydWarshall(graph2);

		// 测试用例3：单节点
		int[][] graph3 = {{0}};
		System.out.println("\n=== 测试用例3：单节点 ===");
		floydWarshall(graph3);

		// 测试用例4：链式图
		int[][] graph4 = {
			{0, 1, INF, INF},
			{INF, 0, 2, INF},
			{INF, INF, 0, 3},
			{INF, INF, INF, 0}
		};
		System.out.println("\n=== 测试用例4：链式图 ===");
		floydWarshall(graph4);
	}

	/**
	 * Floyd-Warshall算法实现
	 * 
	 * @param graph 邻接矩阵
	 */
	public static void floydWarshall(int[][] graph) {
		int V = graph.length;
		if (V == 0) {
			System.out.println("图为空");
			return;
		}

		// 距离矩阵
		int[][] dist = new int[V][V];

		// 初始化距离矩阵
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		// Floyd-Warshall核心算法
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					// 防止溢出
					if (dist[i][k] != INF && dist[k][j] != INF) {
						if (dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
		}

		printSolution(dist, V);
	}

	/**
	 * 打印所有顶点对的最短路径
	 */
	private static void printSolution(int[][] dist, int V) {
		System.out.println("所有顶点对的最短路径：");
		System.out.print("  ");
		for (int i = 0; i < V; i++) {
			System.out.print((char) ('A' + i) + " ");
		}
		System.out.println();

		for (int i = 0; i < V; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.printf("%-3d ", dist[i][j]);
				}
			}
			System.out.println();
		}
	}
}