package cn.com.sky.algorithms.trees.binarytrees.traverse.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <pre>
 * 
 * 二叉树的相关操作
 *   
 *  二叉树创建：
 *  先序，中序，后序创建
 *  
 *  二叉树遍历(递归和非递归方式)：
 *  先序、 中序、后序遍历
 * 
 * 其中重点的是java在先序创建二叉树和后序非递归遍历的的实现.
 * 
 * 
 *               a
 *       b				c
 *   #      d       #        #
 *       #     #
 * 
 * </pre>
 */
public class BinaryTree<T> {

	private Node<T> root;

	public BinaryTree() {
	}

	public BinaryTree(Node<T> root) {
		this.root = root;
	}

	/**
	 * 先序遍历创建二叉树(a b # d # # c # #)
	 */
	public void buildBinaryTreeByPreOrder() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("e://pre.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		root = createBinaryTreeByPreOrder(root, scanner);
	}

	// 先序遍历创建二叉树
	@SuppressWarnings("unchecked")
	private Node<T> createBinaryTreeByPreOrder(Node<T> node, Scanner scanner) {
		String temp = scanner.next();
		if (temp.trim().equals("#")) {
			return null;
		} else {
			node = new Node<T>((T) temp);
			node.setLeft(createBinaryTreeByPreOrder(node.getLeft(), scanner));
			node.setRight(createBinaryTreeByPreOrder(node.getRight(), scanner));
			return node;
		}
	}

	/**
	 * 中序遍历创建二叉树(# b # d # a # c #)
	 */
	public void buildBinaryTreeByInOrder() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("e://in.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		root = createBinaryTreeByInOrder(root, scanner);
	}

	// 中序遍历创建二叉树
	@SuppressWarnings("unchecked")
	private Node<T> createBinaryTreeByInOrder(Node<T> node, Scanner scanner) {
		String temp = scanner.next();
		if (temp.trim().equals("#")) {
			return null;
		} else {
			node.setLeft(createBinaryTreeByInOrder(node.getLeft(), scanner));
			node = new Node<T>((T) temp);
			node.setRight(createBinaryTreeByInOrder(node.getRight(), scanner));
			return node;
		}
	}

	/**
	 * 后序遍历创建二叉树(# # # d b # # c a)
	 */
	public void buildBinaryTreeByPostOrder() {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("e://post.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		root = createBinaryTreeByPostOrder(root, scanner);
	}

	// 后序遍历创建二叉树
	@SuppressWarnings("unchecked")
	private Node<T> createBinaryTreeByPostOrder(Node<T> node, Scanner scanner) {
		String temp = scanner.next();
		if (temp.trim().equals("#")) {
			return null;
		} else {
			node.setLeft(createBinaryTreeByPostOrder(node.getLeft(), scanner));
			node.setRight(createBinaryTreeByPostOrder(node.getRight(), scanner));
			node = new Node<T>((T) temp);
			return node;
		}
	}

	/**
	 * 先序遍历(递归)
	 */
	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	private void preOrderTraverse(Node<T> node) {
		if (node == null) {
			return;
		}
		visit(node);
		preOrderTraverse(node.getLeft());
		preOrderTraverse(node.getRight());
	}

	/**
	 * 中序遍历(递归)
	 */
	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	private void inOrderTraverse(Node<T> node) {
		if (node == null) {
			return;
		}
		inOrderTraverse(node.getLeft());
		visit(node);
		inOrderTraverse(node.getRight());
	}

	/**
	 * 后序遍历(递归)
	 */
	public void postOrderTraverse() {
		postOrderTraverse(root);
	}

	private void postOrderTraverse(Node<T> node) {
		if (node == null) {
			return;
		}
		postOrderTraverse(node.getLeft());
		postOrderTraverse(node.getRight());
		visit(node);
	}

	/**
	 * 先序遍历(非递归)
	 */
	public void nrPreOrderTraverse() {
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				visit(node);
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			node = node.getRight();
		}
	}

	/**
	 * 中序遍历(非递归)
	 */
	public void nrInOrderTraverse() {

		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			node = stack.pop();
			visit(node);
			node = node.getRight();
		}
	}

	/**
	 * 后序遍历(非递归)
	 */
	public void nrPostOrderTraverse() {

		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> node = root;
		Node<T> preNode = null;// 表示最近一次访问的节点

		while (node != null || !stack.isEmpty()) {

			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}

			node = stack.peek();

			if (node.getRight() == null || node.getRight() == preNode) {
				visit(node);
				node = stack.pop();
				preNode = node;
				node = null;
			} else {
				node = node.getRight();
			}

		}
	}

	/**
	 * 层次遍历(使用队列实现)
	 */
	public void levelTraverse() {
		levelTraverse(root);
	}

	private void levelTraverse(Node<T> node) {
		Queue<Node<T>> queue = new LinkedBlockingQueue<Node<T>>();

		if (node == null) {
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()) {

			Node<T> temp = queue.poll();
			visit(temp);
			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}

			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}

		}
	}

	/**
	 * 访问节点
	 */
	private void visit(Node<T> node) {
		System.out.print(node.getValue());
	}

}

/**
 * 二叉树的节点
 */
class Node<T> {

	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node() {
	}

	public Node(T value) {
		this(value, null, null);
	}

	public Node(T value, Node<T> left, Node<T> right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

}