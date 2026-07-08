package cn.com.sky.algorithms.graphs.traverse;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <pre>
 * 图的遍历算法 - DFS和BFS（邻接矩阵+ArrayList实现）【Medium】
 *
 * 题目：使用邻接矩阵存储图，实现深度优先遍历和广度优先遍历
 *
 * 算法原理：
 *
 * 邻接矩阵存储：
 * - 使用二维数组edges[i][j]存储边信息
 * - edges[i][j] > 0 表示顶点i和顶点j之间有边
 * - 适合稠密图，空间O(V^2)
 *
 * DFS（深度优先搜索）：
 * 1. 访问当前节点，标记为已访问
 * 2. 递归访问所有未访问的邻接节点
 * 3. 对于非连通图，需要遍历所有未访问节点
 *
 * BFS（广度优先搜索）：
 * 1. 访问起始节点并入队
 * 2. 循环出队，访问其所有未访问的邻接节点并入队
 * 3. 直到队列为空
 *
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V^2)（邻接矩阵存储）
 * </pre>
 */
public class TestGraphTraverse2 {

	private ArrayList<Object> vertexList;
	private int[][] edges;
	private int numOfEdges;

	public TestGraphTraverse2(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<Object>(n);
		numOfEdges = 0;
	}

	public int getNumOfVertex() {
		return vertexList.size();
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public Object getValueByIndex(int i) {
		return vertexList.get(i);
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	public void insertVertex(Object vertex) {
		vertexList.add(vertexList.size(), vertex);
	}

	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		numOfEdges++;
	}

	public void deleteEdge(int v1, int v2) {
		edges[v1][v2] = 0;
		numOfEdges--;
	}

	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	/**
	 * 深度优先遍历（递归）
	 */
	private void depthFirstSearch(boolean[] isVisited, int i) {
		System.out.print(getValueByIndex(i) + "  ");
		isVisited[i] = true;

		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				depthFirstSearch(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	/**
	 * 深度优先遍历（对外接口）
	 * 对于非连通图，需要遍历所有未访问节点
	 */
	public void depthFirstSearch() {
		boolean[] isVisited = new boolean[getNumOfVertex()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				depthFirstSearch(isVisited, i);
			}
		}
	}

	/**
	 * 广度优先遍历
	 */
	private void broadFirstSearch(boolean[] isVisited, int i) {
		int u, w;
		LinkedList<Integer> queue = new LinkedList<Integer>();

		System.out.print(getValueByIndex(i) + "  ");
		isVisited[i] = true;
		queue.addLast(i);

		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "  ");
					isVisited[w] = true;
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);
			}
		}
	}

	/**
	 * 广度优先遍历（对外接口）
	 */
	public void broadFirstSearch() {
		boolean[] isVisited = new boolean[getNumOfVertex()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			isVisited[i] = false;
		}
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				broadFirstSearch(isVisited, i);
			}
		}
	}

	public static void main(String args[]) {
		// 测试用例1：8个节点的图
		System.out.println("=== 测试用例1：8节点图 ===");
		int n = 8;
		String labels[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

		TestGraphTraverse2 graph = new TestGraphTraverse2(n);

		for (String label : labels) {
			graph.insertVertex(label);
		}
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);
		graph.insertEdge(1, 0, 1);
		graph.insertEdge(2, 0, 1);
		graph.insertEdge(3, 1, 1);
		graph.insertEdge(4, 1, 1);
		graph.insertEdge(7, 3, 1);
		graph.insertEdge(7, 4, 1);
		graph.insertEdge(4, 2, 1);
		graph.insertEdge(5, 2, 1);
		graph.insertEdge(6, 5, 1);

		System.out.println("深度优先搜索序列为：");
		graph.depthFirstSearch();
		System.out.println();
		System.out.println("广度优先搜索序列为：");
		graph.broadFirstSearch();

		// 测试用例2：3个节点的三角形图
		System.out.println("\n\n=== 测试用例2：三角形图 ===");
		TestGraphTraverse2 graph2 = new TestGraphTraverse2(3);
		graph2.insertVertex("A");
		graph2.insertVertex("B");
		graph2.insertVertex("C");
		graph2.insertEdge(0, 1, 1);
		graph2.insertEdge(1, 0, 1);
		graph2.insertEdge(1, 2, 1);
		graph2.insertEdge(2, 1, 1);
		graph2.insertEdge(0, 2, 1);
		graph2.insertEdge(2, 0, 1);
		System.out.println("DFS: ");
		graph2.depthFirstSearch();
		System.out.println();
		System.out.println("BFS: ");
		graph2.broadFirstSearch();
	}
}