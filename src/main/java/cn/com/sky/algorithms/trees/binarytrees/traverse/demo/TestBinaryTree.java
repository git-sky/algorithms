package cn.com.sky.algorithms.trees.binarytrees.traverse.demo;

/**
 * <pre>
 * 二叉树遍历测试用例【Easy】
 *
 * 测试内容：
 * 1. 先序遍历创建二叉树
 * 2. 先序/中序/后序遍历（递归+非递归）
 * 3. 层序遍历
 *
 * 输入格式（先序创建）：
 * 使用"#"表示空节点，例如：a b # d # # c # #
 *
 * 对应树结构：
 *        a
 *    b       c
 *  #   d   #   #
 *     # #
 * </pre>
 */
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