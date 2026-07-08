package cn.com.sky.algorithms.graphs.traverse;

import java.util.*;

/**
 * <pre>
 * 图的遍历算法 - DFS和BFS（邻接表/对象实现）【Medium】
 *
 * 题目：使用邻接表（对象引用）存储图，实现深度优先遍历和广度优先遍历
 *
 * 算法原理：
 *
 * 邻接表存储：
 * - 每个节点维护一个出边列表outgoing
 * - ArcT表示一条边，包含起点start和终点end
 * - 适合稀疏图，空间O(V + E)
 *
 * DFS（深度优先搜索）：
 * 1. 访问当前节点，加入已访问列表
 * 2. 递归访问所有出边的终点
 * 3. 使用List记录已访问节点防止重复和死循环
 *
 * BFS（广度优先搜索）：
 * 1. 起点入队
 * 2. 出队并访问当前节点
 * 3. 将所有未访问的邻居节点入队
 * 4. 使用Set记录已访问节点
 *
 * 时间复杂度：O(V + E)
 * 空间复杂度：O(V + E)（邻接表存储）
 * </pre>
 */
public class TestGraphTraverse3 {

	public static void main(String args[]) {
		// 测试用例1：标准有向图
		System.out.println("=== 测试用例1：标准有向图 ===");
		NodeT a = new NodeT("a");
		NodeT b = new NodeT("b");
		NodeT c = new NodeT("c");
		NodeT d = new NodeT("d");
		NodeT e = new NodeT("e");
		NodeT f = new NodeT("f");
		NodeT g = new NodeT("g");
		NodeT h = new NodeT("h");

		ArcT ab = new ArcT(a, b);
		ArcT ac = new ArcT(a, c);
		ArcT ad = new ArcT(a, d);
		ArcT ah = new ArcT(a, h);
		ArcT bc = new ArcT(b, c);
		ArcT de = new ArcT(d, e);
		ArcT ef = new ArcT(e, f);
		ArcT eg = new ArcT(e, g);
		ArcT hg = new ArcT(h, g);

		a.outgoing.add(ab);
		a.outgoing.add(ac);
		a.outgoing.add(ad);
		a.outgoing.add(ah);
		b.outgoing.add(bc);
		d.outgoing.add(de);
		e.outgoing.add(ef);
		e.outgoing.add(eg);
		h.outgoing.add(hg);

		TestGraphTraverse3 search = new TestGraphTraverse3();

		System.out.println("广度优先遍历：");
		search.widthSearch(a);

		System.out.println("\n深度优先遍历：");
		List<NodeT> visited = new ArrayList<NodeT>();
		search.deptFisrtSearch(a, visited);

		// 测试用例2：链式结构
		System.out.println("\n\n=== 测试用例2：链式结构 ===");
		NodeT n1 = new NodeT("1");
		NodeT n2 = new NodeT("2");
		NodeT n3 = new NodeT("3");
		n1.outgoing.add(new ArcT(n1, n2));
		n2.outgoing.add(new ArcT(n2, n3));

		TestGraphTraverse3 search2 = new TestGraphTraverse3();
		System.out.println("BFS: ");
		search2.widthSearch(n1);
		System.out.println("\nDFS: ");
		List<NodeT> visited2 = new ArrayList<>();
		search2.deptFisrtSearch(n1, visited2);

		// 测试用例3：单节点
		System.out.println("\n\n=== 测试用例3：单节点 ===");
		NodeT single = new NodeT("single");
		TestGraphTraverse3 search3 = new TestGraphTraverse3();
		System.out.println("BFS: ");
		search3.widthSearch(single);
		System.out.println("\nDFS: ");
		List<NodeT> visited3 = new ArrayList<>();
		search3.deptFisrtSearch(single, visited3);
	}

	/**
	 * 深度优先遍历（递归）
	 * 从当前节点出发，一直深入访问，直到无法继续为止
	 *
	 * @param cur     当前节点
	 * @param visited 已访问节点列表
	 */
	void deptFisrtSearch(NodeT cur, List<NodeT> visited) {
		if (visited.contains(cur)) return;
		visited.add(cur);
		System.out.println("访问节点：" + cur.word);
		for (int i = 0; i < cur.outgoing.size(); i++) {
			deptFisrtSearch(cur.outgoing.get(i).end, visited);
		}
	}

	/**
	 * 广度优先遍历
	 * 按层次对图进行访问，先第一层，再第二层，依次类推
	 *
	 * @param start 起始节点
	 */
	void widthSearch(NodeT start) {
		Set<NodeT> visited = new HashSet<NodeT>();
		Queue<NodeT> q = new LinkedList<NodeT>();
		q.offer(start);

		while (!q.isEmpty()) {
			NodeT cur = q.poll();
			if (!visited.contains(cur)) {
				visited.add(cur);
				System.out.println("访问节点：" + cur.word);
				for (int i = 0; i < cur.outgoing.size(); i++) {
					q.offer(cur.outgoing.get(i).end);
				}
			}
		}
	}
}

/**
 * 图的顶点类
 */
class NodeT {
	List<ArcT> outgoing;
	String word;

	public NodeT(String word) {
		this.word = word;
		outgoing = new ArrayList<ArcT>();
	}
}

/**
 * 图的边类（有向边）
 */
class ArcT {
	NodeT start, end;

	public ArcT(NodeT start, NodeT end) {
		this.start = start;
		this.end = end;
	}
}