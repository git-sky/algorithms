package cn.com.sky.algorithms.graphs.dag.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * 有向无环图(DAG)的拓扑排序 - Kahn算法【Medium】
 * 
 * 算法原理：
 * 1. 构建邻接表表示图结构
 * 2. 计算每个顶点的入度
 * 3. 将所有入度为0的顶点加入队列
 * 4. 依次出队，减少其邻居节点的入度
 * 5. 若邻居节点入度变为0，加入队列
 * 6. 重复直到队列为空
 * 7. 如果结果包含所有顶点，说明无环；否则存在环
 * 
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V)
 * </pre>
 */
public class ListDG {

	private class ENode {
		int ivex;        // 该边所指向的顶点的位置
		ENode nextEdge;  // 指向下一条弧的指针
	}

	private class VNode {
		char data;       // 顶点信息
		ENode firstEdge; // 指向第一条依附该顶点的弧
	}

	private List<VNode> mVexs; // 顶点数组

	public ListDG(char[] vexs, char[][] edges) {
		int vlen = vexs.length;
		int elen = edges.length;

		mVexs = new ArrayList<>();
		for (int i = 0; i < vlen; i++) {
			VNode vnode = new VNode();
			vnode.data = vexs[i];
			vnode.firstEdge = null;
			mVexs.add(vnode);
		}

		for (int i = 0; i < elen; i++) {
			char c1 = edges[i][0];
			char c2 = edges[i][1];
			int p1 = getPosition(c1);
			int p2 = getPosition(c2);

			ENode node1 = new ENode();
			node1.ivex = p2;
			if (mVexs.get(p1).firstEdge == null)
				mVexs.get(p1).firstEdge = node1;
			else
				linkLast(mVexs.get(p1).firstEdge, node1);
		}
	}

	private void linkLast(ENode list, ENode node) {
		ENode p = list;
		while (p.nextEdge != null)
			p = p.nextEdge;
		p.nextEdge = node;
	}

	private int getPosition(char ch) {
		for (int i = 0; i < mVexs.size(); i++)
			if (mVexs.get(i).data == ch)
				return i;
		return -1;
	}

	public void DFS() {
		boolean[] visited = new boolean[mVexs.size()];
		for (int i = 0; i < mVexs.size(); i++)
			visited[i] = false;

		System.out.print("DFS: ");
		for (int i = 0; i < mVexs.size(); i++) {
			if (!visited[i])
				dfs(i, visited);
		}
		System.out.println();
	}

	private void dfs(int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(mVexs.get(i).data + " ");
		ENode node = mVexs.get(i).firstEdge;
		while (node != null) {
			if (!visited[node.ivex])
				dfs(node.ivex, visited);
			node = node.nextEdge;
		}
	}

	public void BFS() {
		int head = 0, rear = 0;
		int[] queue = new int[mVexs.size()];
		boolean[] visited = new boolean[mVexs.size()];

		for (int i = 0; i < mVexs.size(); i++)
			visited[i] = false;

		System.out.print("BFS: ");
		for (int i = 0; i < mVexs.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				System.out.print(mVexs.get(i).data + " ");
				queue[rear++] = i;
			}

			while (head != rear) {
				int j = queue[head++];
				ENode node = mVexs.get(j).firstEdge;
				while (node != null) {
					int k = node.ivex;
					if (!visited[k]) {
						visited[k] = true;
						System.out.print(mVexs.get(k).data + " ");
						queue[rear++] = k;
					}
					node = node.nextEdge;
				}
			}
		}
		System.out.println();
	}

	/**
	 * 拓扑排序（Kahn算法）
	 * 
	 * @return 排序后的顶点数组，若存在环返回null
	 */
	public Character[] topologicalSort() {
		int num = mVexs.size();
		int[] ins = new int[num];
		Character[] tops = new Character[num];
		Queue<Integer> queue = new LinkedList<>();

		// 统计每个顶点的入度数
		for (int i = 0; i < num; i++) {
			ENode node = mVexs.get(i).firstEdge;
			while (node != null) {
				ins[node.ivex]++;
				node = node.nextEdge;
			}
		}

		// 将所有入度为0的顶点入队列
		for (int i = 0; i < num; i++)
			if (ins[i] == 0)
				queue.offer(i);

		int index = 0;
		while (!queue.isEmpty()) {
			int j = queue.poll();
			tops[index++] = mVexs.get(j).data;
			ENode node = mVexs.get(j).firstEdge;

			while (node != null) {
				ins[node.ivex]--;
				if (ins[node.ivex] == 0)
					queue.offer(node.ivex);
				node = node.nextEdge;
			}
		}

		// 如果结果不包含所有顶点，说明存在环
		if (index != num) {
			System.out.println("图中存在环，无法进行拓扑排序");
			return null;
		}

		return tops;
	}

	public static void main(String[] args) {
		ListDG pG;
		
		// 测试用例1：正常DAG图
		char[] vexs1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		char[][] edges1 = {{'A', 'G'}, {'B', 'A'}, {'B', 'D'}, {'C', 'F'}, {'C', 'G'}, {'D', 'E'}, {'D', 'F'}};
		pG = new ListDG(vexs1, edges1);
		System.out.println("=== 测试用例1：正常DAG图 ===");
		Character[] result1 = pG.topologicalSort();
		if (result1 != null) {
			System.out.print("拓扑排序结果: ");
			for (char c : result1) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

		// 测试用例2：存在环的图
		char[] vexs2 = {'A', 'B', 'C'};
		char[][] edges2 = {{'A', 'B'}, {'B', 'C'}, {'C', 'A'}};
		pG = new ListDG(vexs2, edges2);
		System.out.println("\n=== 测试用例2：存在环的图 ===");
		Character[] result2 = pG.topologicalSort();

		// 测试用例3：单节点
		char[] vexs3 = {'A'};
		char[][] edges3 = {};
		pG = new ListDG(vexs3, edges3);
		System.out.println("\n=== 测试用例3：单节点 ===");
		Character[] result3 = pG.topologicalSort();
		if (result3 != null) {
			System.out.print("拓扑排序结果: ");
			for (char c : result3) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

		// 测试用例4：空图
		char[] vexs4 = {};
		char[][] edges4 = {};
		pG = new ListDG(vexs4, edges4);
		System.out.println("\n=== 测试用例4：空图 ===");
		Character[] result4 = pG.topologicalSort();
		if (result4 != null) {
			System.out.println("拓扑排序结果为空");
		}

		// 测试用例5：链式结构
		char[] vexs5 = {'A', 'B', 'C', 'D'};
		char[][] edges5 = {{'A', 'B'}, {'B', 'C'}, {'C', 'D'}};
		pG = new ListDG(vexs5, edges5);
		System.out.println("\n=== 测试用例5：链式结构 ===");
		Character[] result5 = pG.topologicalSort();
		if (result5 != null) {
			System.out.print("拓扑排序结果: ");
			for (char c : result5) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}