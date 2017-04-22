package cn.com.sky.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * <pre>
 * 
 * 104. Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * </pre>
 */
public class MaximumDepthofBinaryTree104 {

	@Test
	public void solution() {

		TreeNode root = new TreeNode(1);

		int depth = maxDepth(root);
		System.out.println(depth);
	}

	/**
	 * Depth-first-search
	 */
	// public int maxDepth(TreeNode root) {
	// if (root == null) {
	// return 0;
	// }
	// return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	// }

	
	/**
	 * BFS
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
	}
}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
