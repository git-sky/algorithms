package cn.com.sky.algorithms.trees.binarytrees.traverse.demo;

public class TestBinaryTree {

	public static void main(String[] args) {

		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();

		System.out.println("先序遍历创建二叉树");
		binaryTree.buildBinaryTreeByPreOrder();

		// System.out.println("中序遍历创建二叉树");
		// binaryTree.buildBinaryTreeByInOrder();

		// System.out.println("后序遍历创建二叉树");
		// binaryTree.buildBinaryTreeByPostOrder();

		System.out.println();
		System.out.print("先序遍历二叉树-递归:");
		binaryTree.preOrderTraverse();

		System.out.println();
		System.out.print("先序遍历二叉树-非递归:");

		binaryTree.nrPreOrderTraverse();

		System.out.println();
		System.out.print("中序遍历二叉树-递归:");
		binaryTree.inOrderTraverse();

		System.out.println();
		System.out.print("中序遍历二叉树-非递归:");
		binaryTree.nrInOrderTraverse();

		System.out.println();
		System.out.print("后序遍历二叉树-递归:");
		binaryTree.postOrderTraverse();

		System.out.println();
		System.out.print("后序遍历二叉树-非递归:");
		binaryTree.nrPostOrderTraverse();

		System.out.println();
		System.out.print("层序遍历二叉树:");
		binaryTree.levelTraverse();

	}
}