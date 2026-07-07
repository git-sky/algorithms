package cn.com.sky.algorithms.graphs.mst.kruskal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 * Kruskal算法 - 最小生成树【Medium】
 * 
 * 算法原理：
 * 1. 将所有边按权值从小到大排序
 * 2. 依次选择边，如果这条边不会形成环，则加入最小生成树
 * 3. 使用并查集(Union-Find)检测环
 * 4. 直到选择了V-1条边为止
 * 
 * 时间复杂度：O(E log E)（主要是排序）
 * 空间复杂度：O(E + V)
 * 
 * Prim vs Kruskal：
 * - Prim适合稠密图（边数多）
 * - Kruskal适合稀疏图（边数少）
 * </pre>
 */
public class Kruskal {

	static class Edge {
		int src, dest, weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		// 测试用例1：标准图
		int V1 = 4;
		Edge[] edges1 = {
			new Edge(0, 1, 10),
			new Edge(0, 2, 6),
			new Edge(0, 3, 5),
			new Edge(1, 3, 15),
			new Edge(2, 3, 4)
		};
		System.out.println("=== 测试用例1：标准图 ===");
		kruskalMST(edges1, V1);

		// 测试用例2：链式图
		int V2 = 4;
		Edge[] edges2 = {
			new Edge(0, 1, 1),
			new Edge(1, 2, 2),
			new Edge(2, 3, 3)
		};
		System.out.println("\n=== 测试用例2：链式图 ===");
		kruskalMST(edges2, V2);

		// 测试用例3：三角形图
		int V3 = 3;
		Edge[] edges3 = {
			new Edge(0, 1, 1),
			new Edge(1, 2, 2),
			new Edge(0, 2, 3)
		};
		System.out.println("\n=== 测试用例3：三角形图 ===");
		kruskalMST(edges3, V3);
	}

	/**
	 * Kruskal算法实现
	 */
	public static void kruskalMST(Edge[] edges, int V) {
		int E = edges.length;
		Edge[] result = new Edge[V - 1];
		int resultIndex = 0;

		// 按权值排序边
		Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

		// 并查集
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		int i = 0;
		while (resultIndex < V - 1 && i < E) {
			Edge nextEdge = edges[i++];

			int x = find(parent, nextEdge.src);
			int y = find(parent, nextEdge.dest);

			// 如果不形成环，加入结果
			if (x != y) {
				result[resultIndex++] = nextEdge;
				union(parent, x, y);
			}
		}

		printMST(result, resultIndex);
	}

	/**
	 * 查找根节点（带路径压缩）
	 */
	private static int find(int[] parent, int i) {
		if (parent[i] != i) {
			parent[i] = find(parent, parent[i]);
		}
		return parent[i];
	}

	/**
	 * 合并两个子集
	 */
	private static void union(int[] parent, int x, int y) {
		int xRoot = find(parent, x);
		int yRoot = find(parent, y);
		parent[yRoot] = xRoot;
	}

	/**
	 * 打印最小生成树
	 */
	private static void printMST(Edge[] result, int index) {
		System.out.println("边\t权值");
		int totalWeight = 0;
		for (int i = 0; i < index; i++) {
			System.out.println((char) ('A' + result[i].src) + " - " + (char) ('A' + result[i].dest) + "\t" + result[i].weight);
			totalWeight += result[i].weight;
		}
		System.out.println("最小生成树总权值: " + totalWeight);
	}
}