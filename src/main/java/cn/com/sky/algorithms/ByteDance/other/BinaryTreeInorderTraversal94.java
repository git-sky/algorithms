package cn.com.sky.algorithms.ByteDance.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 94. 二叉树的中序遍历【Medium】（字节跳动高频）
 * 
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 * 
 * 算法原理：
 * 中序遍历顺序：左子树 -> 根节点 -> 右子树
 * 
 * 递归法：直接递归遍历
 * 迭代法：使用栈模拟递归过程
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class BinaryTreeInorderTraversal94 {

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
        BinaryTreeInorderTraversal94 solution = new BinaryTreeInorderTraversal94();
        
        // 构建测试树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        // 测试递归法
        System.out.println("递归法: " + solution.inorderTraversalRecursive(root)); // [1,3,2]
        
        // 测试迭代法
        System.out.println("迭代法: " + solution.inorderTraversalIterative(root)); // [1,3,2]
        
        // 测试空树
        System.out.println("空树: " + solution.inorderTraversalRecursive(null)); // []
        
        // 测试单节点
        TreeNode single = new TreeNode(1);
        System.out.println("单节点: " + solution.inorderTraversalRecursive(single)); // [1]
    }

    /**
     * 递归法中序遍历
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    /**
     * 迭代法中序遍历
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // 遍历到最左子节点
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // 弹出节点，访问
            curr = stack.pop();
            result.add(curr.val);
            
            // 转向右子树
            curr = curr.right;
        }
        
        return result;
    }
}