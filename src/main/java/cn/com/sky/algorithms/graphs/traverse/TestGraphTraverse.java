package cn.com.sky.algorithms.graphs.traverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <pre>
 * 图的遍历算法 - DFS和BFS（邻接矩阵实现）【Medium】
 *
 * 题目：实现图的深度优先遍历(DFS)和广度优先遍历(BFS)
 *
 * 算法原理：
 *
 * DFS（深度优先搜索）：
 * 1. 从起点出发，尽可能深地探索路径
 * 2. 当无法继续时，回溯到上一个节点
 * 3. 重复直到所有节点都被访问
 * 4. 递归实现：自然利用函数调用栈
 * 5. 非递归实现：使用显式栈模拟递归过程
 *
 * BFS（广度优先搜索）：
 * 1. 从起点出发，先访问所有相邻节点
 * 2. 然后依次处理每个相邻节点的邻居
 * 3. 按层遍历，使用队列实现
 *
 * DFS vs BFS：
 * - DFS使用栈（递归或显式栈），适合找路径、拓扑排序
 * - BFS使用队列，适合找最短路径、层序遍历
 *
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V)
 * </pre>
 */
public class TestGraphTraverse {

	private Object[] vertices;
	private int[][] arcs;
	private int vexnum;
	private boolean[] visited;

	public static void main(String[] args) {
		// 测试用例1：标准二叉树形图
		System.out.println("=== 测试用例1：标准图 ===");
		TestGraphTraverse g = new TestGraphTraverse(8);
		Character[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		g.addVertex(vertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 7);
		g.addEdge(2, 5);
		g.addEdge(2, 6);

		System.out.println("深度优先遍历（递归）：");
		g.depthTraverse();
		System.out.println();

		System.out.println("广度优先遍历：");
		g.broadTraverse();
		System.out.println();

		System.out.println("深度优先遍历（非递归）：");
		g.depth();
		System.out.println();

		// 测试用例2：三角形图
		System.out.println("\n=== 测试用例2：三角形图 ===");
		TestGraphTraverse g2 = new TestGraphTraverse(3);
		Character[] v2 = {'A', 'B', 'C'};
		g2.addVertex(v2);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(0, 2);
		System.out.println("DFS: ");
		g2.depthTraverse();
		System.out.println();
		System.out.println("BFS: ");
		g2.broadTraverse();
		System.out.println();

		// 测试用例3：单节点
		System.out.println("\n=== 测试用例3：单节点 ===");
		TestGraphTraverse g3 = new TestGraphTraverse(1);
		g3.addVertex(new Character[]{'A'});
		System.out.println("DFS: ");
		g3.depthTraverse();
		System.out.println();
	}

	public TestGraphTraverse(int n) {
		vexnum = n;
		vertices = new Object[n];
		arcs = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < vexnum; i++) {
			for (int j = 0; j < vexnum; j++) {
				arcs[i][j] = 0;
			}
		}
	}

	public void addVertex(Object[] obj) {
		this.vertices = obj;
	}

	public void addEdge(int i, int j) {
		if (i == j) return;
		arcs[i][j] = 1;
		arcs[j][i] = 1;
	}

	public int firstAdjVex(int i) {
		for (int j = 0; j < vexnum; j++) {
			if (arcs[i][j] > 0) return j;
		}
		return -1;
	}

	public int nextAdjVex(int i, int k) {
		for (int j = k + 1; j < vexnum; j++) {
			if (arcs[i][j] > 0) return j;
		}
		return -1;
	}

	/**
	 * 深度优先遍历（递归）
	 */
	public void depthTraverse() {
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) traverse(i);
		}
	}

	private void traverse(int i) {
		visited[i] = true;
		visit(i);
		for (int j = this.firstAdjVex(i); j >= 0; j = this.nextAdjVex(i, j)) {
			if (!visited[j]) this.traverse(j);
		}
	}

	/**
	 * 广度优先遍历
	 */
	public void broadTraverse() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				q.add(i);
				visited[i] = true;
				visit(i);
				while (!q.isEmpty()) {
					int j = q.remove();
					for (int k = this.firstAdjVex(j); k >= 0; k = this.nextAdjVex(j, k)) {
						if (!visited[k]) {
							q.add(k);
							visited[k] = true;
							visit(k);
						}
					}
				}
			}
		}
	}

	private void visit(int i) {
		System.out.print(vertices[i] + " ");
	}

	/**
	 * 深度优先遍历（非递归，使用栈）
	 */
	public void depth() {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				s.add(i);
				visited[i] = true;
				while (!s.isEmpty()) {
					int j = s.pop();
					visit(j);
					for (int k = this.lastAdjVex(j); k >= 0; k = this.lastAdjVex(j, k)) {
						if (!visited[k]) {
							s.add(k);
							visited[k] = true;
						}
					}
				}
			}
		}
	}

	public int lastAdjVex(int i) {
		for (int j = vexnum - 1; j >= 0; j--) {
			if (arcs[i][j] > 0) return j;
		}
		return -1;
	}

	public int lastAdjVex(int i, int k) {
		for (int j = k - 1; j >= 0; j--) {
			if (arcs[i][j] > 0) return j;
		}
		return -1;
	}
}