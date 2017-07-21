package cn.com.sky.algorithms.offer;

import java.util.Random;

import org.junit.Test;

/**
 * 题目： 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class CopyBinaryTree {

	@Test
	public void solution() {

		Random r = new Random();
		int count = r.nextInt(10);

		BinaryNode head = init(count);

	}

	// TODO 生产二叉树
	public BinaryNode init(int count) {

		BinaryNode node = new BinaryNode(1, null, null);

		return null;

	}

	public void get(BinaryNode data, BinaryNode left, BinaryNode right) {

	}

	static class BinaryNode {
		int data;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode(int data, BinaryNode left, BinaryNode right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

}
