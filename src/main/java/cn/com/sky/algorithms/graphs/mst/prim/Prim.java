package cn.com.sky.algorithms.graphs.mst.prim;

import java.util.Arrays;

/**
 * <pre>
 * Prim算法 - 最小生成树【Medium】
 * 
 * 算法原理：
 * 1. 从任意顶点开始，将其加入最小生成树
 * 2. 找到连接已选顶点和未选顶点的最小权边
 * 3. 将该边和对应的顶点加入最小生成树
 * 4. 重复步骤2-3，直到所有顶点都被加入
 * 
 * 时间复杂度：O(V^2)（邻接矩阵实现）
 *            O(E log V)（优先队列优化）
 * 空间复杂度：O(V)
 * 
 * Prim vs Kruskal：
 * - Prim适合稠密图（边数多）
 * - Kruskal适合稀疏图（边数少）
 * </pre>
 */
public class Prim {

	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// 测试用例1：标准图
		int[][] graph1 = {
			{0, 2, INF, 6, INF},
			{2, 0, 3, 8, 5},
			{INF, 3, 0, INF, 7},
			{6, 8, INF, 0, 9},
			{INF, 5, 7, 9, 0}
		};
		System.out.println("=== 测试用例1：标准图 ===");
		primMST(graph1, 0);

		// 测试用例2：链式图
		int[][] graph2 = {
			{0, 1, INF, INF},
			{1, 0, 2, INF},
			{INF, 2, 0, 3},
			{INF, INF, 3, 0}
		};
		System.out.println("\n=== 测试用例2：链式图 ===");
		primMST(graph2, 0);

		// 测试用例3：三角形图
		int[][] graph3 = {
			{0, 1, 2},
			{1, 0, 3},
			{2, 3, 0}
		};
		System.out.println("\n=== 测试用例3：三角形图 ===");
		primMST(graph3, 0);

		// 测试用例4：单节点
		int[][] graph4 = {{0}};
		System.out.println("\n=== 测试用例4：单节点 ===");
		primMST(graph4, 0);
	}

	/**
	 * Prim算法实现
	 * 
	 * @param graph 邻接矩阵
	 * @param start 起始顶点
	 */
	public static void primMST(int[][] graph, int start) {
		int V = graph.length;
		if (V == 0) {
			System.out.println("图为空");
			return;
		}

		// 保存最小生成树
		int[] parent = new int[V];
		// 用于选择最小权边
		int[] key = new int[V];
		// 表示顶点是否已加入MST
		boolean[] mstSet = new boolean[V];

		// 初始化key数组为无穷大
		Arrays.fill(key, INF);
		// 起始顶点的key设为0
		key[start] = 0;
		// 起始顶点没有父节点
		parent[start] = -1;

		for (int count = 0; count < V - 1; count++) {
			// 找到key值最小且未加入MST的顶点
			int u = minKey(key, mstSet, V);
			mstSet[u] = true;

			// 更新相邻顶点的key值
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		printMST(parent, graph, V);
	}

	/**
	 * 找到key值最小的未加入MST的顶点
	 */
	private static int minKey(int[] key, boolean[] mstSet, int V) {
		int min = INF, minIndex = -1;

		for (int v = 0; v < V; v++) {
			if (!mstSet[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	/**
	 * 打印最小生成树
	 */
	private static void printMST(int[] parent, int[][] graph, int V) {
		System.out.println("边\t权值");
		int totalWeight = 0;
		for (int i = 1; i < V; i++) {
			System.out.println((char) ('A' + parent[i]) + " - " + (char) ('A' + i) + "\t" + graph[i][parent[i]]);
			totalWeight += graph[i][parent[i]];
		}
		System.out.println("最小生成树总权值: " + totalWeight);
	}
}