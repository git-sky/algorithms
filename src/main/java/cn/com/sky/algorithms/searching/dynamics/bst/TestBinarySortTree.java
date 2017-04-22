package cn.com.sky.algorithms.searching.dynamics.bst;

/**
 * 二叉排序树
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
