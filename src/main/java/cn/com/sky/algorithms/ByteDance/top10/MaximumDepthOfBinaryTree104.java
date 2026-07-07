package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * 104. Maximum Depth of Binary Tree
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree104 {

    @Test
    public void test() {
        // 测试用例1：正常二叉树
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例1(正常树): " + maxDepth(root1));      // 3
        System.out.println("测试用例1(BFS): " + maxDepthBFS(root1));      // 3

        // 测试用例2：空树
        System.out.println("测试用例2(空树): " + maxDepth(null));        // 0

        // 测试用例3：单节点
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试用例3(单节点): " + maxDepth(root3));     // 1

        // 测试用例4：左斜树
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        System.out.println("测试用例4(左斜树): " + maxDepth(root4));     // 3
    }

    /**
     * 方法一：DFS 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，h 为树的高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 方法二：BFS 层序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    /**
     * 二叉树节点定义
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}