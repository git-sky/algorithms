package cn.com.sky.algorithms.ByteDance.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 226. 翻转二叉树【Easy】（腾讯高频）
 * 
 * 翻转一棵二叉树。
 * 
 * 算法原理：
 * 递归法：交换左右子树，然后递归翻转左右子树
 * 迭代法：使用队列进行层序遍历，交换每个节点的左右子树
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（递归栈或队列）
 */
public class InvertBinaryTree226 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree226 solution = new InvertBinaryTree226();
        
        // 构建测试树
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        
        System.out.println("原树前序遍历:");
        printPreorder(root);
        System.out.println();
        
        TreeNode inverted = solution.invertTreeRecursive(root);
        System.out.println("翻转后前序遍历:");
        printPreorder(inverted);
        System.out.println();
        
        // 测试空树
        System.out.println("空树测试: " + (solution.invertTreeRecursive(null) == null));
        
        // 测试单节点
        TreeNode single = new TreeNode(1);
        TreeNode invertedSingle = solution.invertTreeRecursive(single);
        System.out.println("单节点测试: " + (invertedSingle != null && invertedSingle.val == 1));
    }

    /**
     * 前序遍历打印
     */
    private static void printPreorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    /**
     * 递归法翻转二叉树
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转左右子树
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    /**
     * 迭代法翻转二叉树（BFS）
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 交换左右子树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}