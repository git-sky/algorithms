package cn.com.sky.algorithms.trees.trees.treeparents;

/**
 * <pre>
 * 树节点（双亲表示法）【Easy】
 *
 * 双亲表示法中每个节点存储：
 * - data: 节点数据
 * - parent: 父节点在数组中的索引（根节点为-1）
 *
 * 时间复杂度：
 * - 找父节点：O(1)
 * - 找孩子节点：O(n)
 * </pre>
 */
public class Node<T> {
	private T data;
	private int parent;

	public Node() {
	}

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, int parent) {
		this.data = data;
		this.parent = parent;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getParent() {
		return this.parent;
	}
}