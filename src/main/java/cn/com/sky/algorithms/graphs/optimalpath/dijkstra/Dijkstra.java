package cn.com.sky.algorithms.graphs.optimalpath.dijkstra;

import java.util.Arrays;

/**
 * <pre>
 * Dijkstra算法 - 单源最短路径【Medium】
 * 
 * 算法原理：
 * 1. 初始化距离数组，起点距离为0，其他为无穷大
 * 2. 维护一个已访问集合
 * 3. 每次从未访问顶点中选择距离最小的顶点
 * 4. 更新该顶点所有邻居的距离
 * 5. 重复直到所有顶点都被访问
 * 
 * 注意：Dijkstra算法不能处理负权边
 * 
 * 时间复杂度：O(V^2)（邻接矩阵）
 *            O(E log V)（优先队列优化）
 * 空间复杂度：O(V)
 * </pre>
 */
public class Dijkstra {

	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// 测试用例1：标准图
		int[][] graph1 = {
			{0, 4, INF, INF, INF, INF, INF, 8, INF},
			{4, 0, 8, INF, INF, INF, INF, 11, INF},
			{INF, 8, 0, 7, INF, 4, INF, INF, 2},
			{INF, INF, 7, 0, 9, 14, INF, INF, INF},
			{INF, INF, INF, 9, 0, 10, INF, INF, INF},
			{INF, INF, 4, 14, 10, 0, 2, INF, INF},
			{INF, INF, INF, INF, INF, 2, 0, 1, 6},
			{8, 11, INF, INF, INF, INF, 1, 0, 7},
			{INF, INF, 2, INF, INF, INF, 6, 7, 0}
		};
		System.out.println("=== 测试用例1：标准图（从A出发）===");
		dijkstra(graph1, 0);

		// 测试用例2：链式图
		int[][] graph2 = {
			{0, 1, INF, INF},
			{INF, 0, 2, INF},
			{INF, INF, 0, 3},
			{INF, INF, INF, 0}
		};
		System.out.println("\n=== 测试用例2：链式图（从A出发）===");
		dijkstra(graph2, 0);

		// 测试用例3：有环图
		int[][] graph3 = {
			{0, 1, 4},
			{INF, 0, 2},
			{INF, INF, 0}
		};
		System.out.println("\n=== 测试用例3：有环图（从A出发）===");
		dijkstra(graph3, 0);

		// 测试用例4：单节点
		int[][] graph4 = {{0}};
		System.out.println("\n=== 测试用例4：单节点 ===");
		dijkstra(graph4, 0);
	}

	/**
	 * Dijkstra算法实现
	 * 
	 * @param graph 邻接矩阵
	 * @param src   源顶点
	 */
	public static void dijkstra(int[][] graph, int src) {
		int V = graph.length;
		if (V == 0) {
			System.out.println("图为空");
			return;
		}

		// 保存从src到各顶点的最短距离
		int[] dist = new int[V];
		// 标记顶点是否已处理
		boolean[] visited = new boolean[V];

		// 初始化
		Arrays.fill(dist, INF);
		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			// 找到未处理顶点中距离最小的
			int u = minDistance(dist, visited, V);
			visited[u] = true;

			// 更新所有邻居的距离
			for (int v = 0; v < V; v++) {
				if (!visited[v] && graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}

		printSolution(dist, src, V);
	}

	/**
	 * 找到距离最小的未访问顶点
	 */
	private static int minDistance(int[] dist, boolean[] visited, int V) {
		int min = INF, minIndex = -1;

		for (int v = 0; v < V; v++) {
			if (!visited[v] && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	/**
	 * 打印最短路径结果
	 */
	private static void printSolution(int[] dist, int src, int V) {
		System.out.println("顶点\t距离(" + (char) ('A' + src) + ")");
		for (int i = 0; i < V; i++) {
			System.out.println((char) ('A' + i) + "\t" + (dist[i] == INF ? "INF" : dist[i]));
		}
	}
}