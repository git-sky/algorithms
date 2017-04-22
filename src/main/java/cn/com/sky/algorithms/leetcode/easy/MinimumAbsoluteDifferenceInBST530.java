package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 530. Minimum Absolute Difference in BST
 * 
 * 
 * Given a binary search tree(二叉查找树) with non-negative values, find the minimum absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * Input:
 * 
 *    1
 *     \
 *      3
 *     /
 *    2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * BST(Binary Search Tree),二叉查找树; 
 *  
 * 性质： 
 * 若结点的左子树不空，则左子树上所有结点的值均小于它的根结点的值; 
 * 若结点的右子树不空，则右子树上所有结点的值均大于它的根结点的值;
 * 该结点的左、右子树也分别为二叉查找树;
 * 
 * </pre>
 */
public class MinimumAbsoluteDifferenceInBST530 {

	@Test
	public void solution() {

		TreeNode root = getTree(0, null, 2236, 1277, 2776, 519);

		int depth = getMinimumDifference(root);
		System.out.println(depth);
	}

	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return min;

		getMinimumDifference(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;

		getMinimumDifference(root.right);

		return min;
	}

	private TreeNode getTree(Integer... integers) {
		TreeNode root = null;
		for (Integer i : integers) {
			if (i == null) {
				continue;
			}
			System.out.println("i:" + i);
			TreeNode node = new TreeNode(i);
			if (root == null) {
				root = node;
			} else {
				addNode(root, node);
			}

		}
		return root;
	}

	private void addNode(TreeNode before, TreeNode node) {
		if (before == null) {
			return;
		}
		if (before.val > node.val) {
			if (before.left != null) {
				addNode(before.left, node);
			} else {
				before.left = node;
			}
		} else {
			if (before.right != null) {
				addNode(before.right, node);
			} else {
				before.right = node;
			}
		}
	}

	// public int getMinimumDifference(TreeNode root) {
	//
	// LinkedList<Integer> list = new LinkedList<>();
	//
	// getMiddleTraversal(list, root);
	//
	// int min = Integer.MAX_VALUE;
	// int before = -1;
	// for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
	//
	// int cur = iterator.next();
	// if (before == -1) {
	// before = cur;
	// continue;
	// }
	//
	// min = Math.min(min, cur - before);
	// before = cur;
	// }
	//
	// return min;
	//
	// }
	//
	// public int getMiddleTraversal(LinkedList<Integer> list, TreeNode root) {
	//
	// if (root == null) {
	// return 0;
	// }
	//
	// getMiddleTraversal(list, root.left);
	// int mid = root.val;
	// list.add(mid);
	// System.out.println("mid:" + mid);
	// return getMiddleTraversal(list, root.right);
	//
	// }

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
