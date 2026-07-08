package cn.com.sky.algorithms.searching.dynamics.bst;

/**
 * <pre>
 * 二叉排序树/二叉搜索树（BST - Binary Search Tree）【Easy】
 *
 * 题目：实现二叉排序树的插入、查找和遍历
 *
 * 算法原理：
 * 1. 左子树所有节点值 < 根节点值
 * 2. 右子树所有节点值 > 根节点值
 * 3. 左右子树也分别是二叉排序树
 *
 * 插入：从根节点开始比较，小于走左子树，大于走右子树，直到空位插入
 * 查找：同插入路径，O(log n)平均，O(n)最坏（退化为链表）
 * 遍历：中序遍历得到有序序列
 *
 * 时间复杂度：
 * - 查找/插入：平均O(log n)，最坏O(n)
 * 空间复杂度：O(n)
 *
 * 缺点：极端情况下退化为链表，查找效率降为O(n)
 * 解决：使用AVL树或红黑树保持平衡
 * </pre>
 */
public class TestBinarySortTree {

	public int value;
	public TestBinarySortTree left;
	public TestBinarySortTree right;

	public void store(int value) {
		if (value < this.value) {
			if (this.left == null) {
				this.left = new TestBinarySortTree();
				this.left.value = value;
			} else {
				this.left.store(value);
			}
		} else if (value > this.value) {
			if (this.right == null) {
				this.right = new TestBinarySortTree();
				this.right.value = value;
			} else {
				this.right.store(value);
			}
		}
	}

	public boolean find(int value) {
		System.out.println("happen" + this.value);
		if (value == this.value) {
			return true;
		} else if (value < this.value) {
			return this.left.find(value);
		} else {
			return this.right.find(value);
		}
	}

	public void preList() {
		System.out.println(this.value + ",");
		if (left != null) {
			this.left.preList();
		}
		if (this.right != null) {
			this.right.preList();
		}
	}

	public void middleList() {
		if (this.left != null) {
			left.middleList();
		}
		System.out.println(this.value + ",");
		if (this.right != null) {
			right.middleList();
		}
	}

	public void afterList() {
		if (this.left != null) {
			this.left.afterList();
		}
		if (this.right != null) {
			right.afterList();
		}
		System.out.println(value + ",");
	}

	public static void main(String[] args) {
		int[] data = new int[20];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 100) + 1;
			System.out.println(data[i] + ",");
		}

		System.out.println();

		TestBinarySortTree root = new TestBinarySortTree();
		root.value = data[0];
		for (int i = 1; i < data.length; i++) {
			root.store(data[i]);
		}

		root.find(data[19]);

		root.preList();
		System.out.println();
		root.middleList();
		System.out.println();
		root.afterList();
	}
}