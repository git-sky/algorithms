package cn.com.sky.algorithms.ByteDance.top10;

import org.junit.Test;

/**
 * LeetCode 104. Maximum Depth of Binary Tree【Easy】
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree104 {

    /**
     * 方法一：DFS 递归）-深度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(h)，h 为树的高度
     * <p>
     * 核心思想：树的高度 = max(左子树高度, 右子树高度) + 1
     * 这是一个非常经典的递归问题，核心逻辑就是一句话：当前节点的深度 = 左右子树深度的较大值 + 1
     * <p>
     * 一句话记忆法
     * "空节点为0，左右取大再加1"
     */
    public int maxDepth(TreeNode root) {
        // ① 终止条件：空节点的深度为 0
        if (root == null) {
            return 0;
        }

        // ② 递归计算左子树的深度
        int leftDepth = maxDepth(root.left);

        // ③ 递归计算右子树的深度
        int rightDepth = maxDepth(root.right);

        // ④ 当前节点的深度 = 较大子树深度 + 1（+1表示当前节点本身）
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 方法二：BFS 层序遍历 -广度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * <p>
     * 核心思想：逐层遍历，每遍历完一层，深度+1
     * BFS（广度优先搜索）用队列实现，按层从左到右遍历。每处理完一整层，深度就增加1。
     */
    public int maxDepthBFS(TreeNode root) {
        // ① 空树深度为0
        if (root == null) {
            return 0;
        }

        // ② 用队列存储待遍历的节点，先把根节点入队
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;

        // ③ 逐层处理：队列不为空说明还有节点没遍历完
        while (!queue.isEmpty()) {

            // ④ 获取当前层的节点数（这一步很关键！）
            int levelSize = queue.size();
            // ⑤ 开始处理新的一层，深度+1
            depth++;

            // ⑥ 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // 出队一个节点

                // ⑦ 把下一层的节点入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // ⑧ 当前层处理完毕，回到 while 判断下一层是否还有节点
        }

        // ⑨ 所有层处理完毕，返回最终深度
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
}