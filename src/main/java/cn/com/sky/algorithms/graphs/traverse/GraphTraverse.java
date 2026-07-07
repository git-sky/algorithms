package cn.com.sky.algorithms.graphs.traverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <pre>
 * 图的遍历算法 - DFS和BFS【Easy】
 * 
 * DFS（深度优先搜索）原理：
 * 1. 从起点出发，尽可能深地探索路径
 * 2. 当无法继续时，回溯到上一个节点
 * 3. 重复直到所有节点都被访问
 * 
 * BFS（广度优先搜索）原理：
 * 1. 从起点出发，先访问所有相邻节点
 * 2. 然后依次处理每个相邻节点的邻居
 * 3. 按层遍历，使用队列实现
 * 
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V)
 * </pre>
 */
public class GraphTraverse {

	private Object[] vertices;
	private int[][] adjMatrix;
	private int vertexCount;
	private boolean[] visited;

	public GraphTraverse(int n) {
		vertexCount = n;
		vertices = new Object[n];
		adjMatrix = new int[n][n];
		visited = new boolean[n];
	}

	public void addVertex(Object[] vs) {
		this.vertices = vs;
	}

	public void addEdge(int i, int j) {
		if (i == j) return;
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}

	/**
	 * 深度优先遍历（递归）
	 */
	public void dfsRecursive() {
		resetVisited();
		System.out.print("DFS(递归): ");
		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				dfsHelper(i);
			}
		}
		System.out.println();
	}

	private void dfsHelper(int v) {
		visited[v] = true;
		System.out.print(vertices[v] + " ");
		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[v][i] == 1 && !visited[i]) {
				dfsHelper(i);
			}
		}
	}

	/**
	 * 深度优先遍历（非递归）
	 */
	public void dfsIterative() {
		resetVisited();
		System.out.print("DFS(非递归): ");
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				stack.push(i);
				visited[i] = true;

				while (!stack.isEmpty()) {
					int v = stack.pop();
					System.out.print(vertices[v] + " ");

					// 逆序入栈，保证顺序正确
					for (int j = vertexCount - 1; j >= 0; j--) {
						if (adjMatrix[v][j] == 1 && !visited[j]) {
							stack.push(j);
							visited[j] = true;
						}
					}
				}
			}
		}
		System.out.println();
	}

	/**
	 * 广度优先遍历
	 */
	public void bfs() {
		resetVisited();
		System.out.print("BFS: ");
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				queue.offer(i);
				visited[i] = true;

				while (!queue.isEmpty()) {
					int v = queue.poll();
					System.out.print(vertices[v] + " ");

					for (int j = 0; j < vertexCount; j++) {
						if (adjMatrix[v][j] == 1 && !visited[j]) {
							queue.offer(j);
							visited[j] = true;
						}
					}
				}
			}
		}
		System.out.println();
	}

	private void resetVisited() {
		for (int i = 0; i < vertexCount; i++) {
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		// 测试用例1：标准图
		System.out.println("=== 测试用例1：标准图 ===");
		GraphTraverse g1 = new GraphTraverse(8);
		Character[] v1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		g1.addVertex(v1);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(3, 7);
		g1.addEdge(4, 7);
		g1.addEdge(2, 5);
		g1.addEdge(2, 6);
		g1.dfsRecursive();
		g1.dfsIterative();
		g1.bfs();

		// 测试用例2：链式图
		System.out.println("\n=== 测试用例2：链式图 ===");
		GraphTraverse g2 = new GraphTraverse(4);
		Character[] v2 = {'A', 'B', 'C', 'D'};
		g2.addVertex(v2);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.dfsRecursive();
		g2.dfsIterative();
		g2.bfs();

		// 测试用例3：孤立节点
		System.out.println("\n=== 测试用例3：含孤立节点 ===");
		GraphTraverse g3 = new GraphTraverse(5);
		Character[] v3 = {'A', 'B', 'C', 'D', 'E'};
		g3.addVertex(v3);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		// D和E是孤立节点
		g3.dfsRecursive();
		g3.dfsIterative();
		g3.bfs();

		// 测试用例4：单节点
		System.out.println("\n=== 测试用例4：单节点 ===");
		GraphTraverse g4 = new GraphTraverse(1);
		Character[] v4 = {'A'};
		g4.addVertex(v4);
		g4.dfsRecursive();
		g4.dfsIterative();
		g4.bfs();
	}
}