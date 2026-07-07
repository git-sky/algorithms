package cn.com.sky.algorithms.ByteDance.other;

/**
 * LeetCode 236. 二叉树的最近公共祖先【Medium】（字节跳动高频）
 * 
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 算法原理（递归）：
 * 1. 如果当前节点为空或等于p或q，返回当前节点
 * 2. 递归查找左子树和右子树
 * 3. 如果左右子树都找到，说明当前节点是最近公共祖先
 * 4. 如果只有左子树找到，返回左子树结果
 * 5. 如果只有右子树找到，返回右子树结果
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（递归栈）
 */
public class LowestCommonAncestor236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 构建测试树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        LowestCommonAncestor236 solution = new LowestCommonAncestor236();
        
        // 测试用例1：p=5, q=1
        TreeNode p1 = root.left;
        TreeNode q1 = root.right;
        TreeNode result1 = solution.lowestCommonAncestor(root, p1, q1);
        System.out.println("测试用例1(LCA(5,1)): " + result1.val); // 3
        
        // 测试用例2：p=5, q=4
        TreeNode p2 = root.left;
        TreeNode q2 = root.left.right.right;
        TreeNode result2 = solution.lowestCommonAncestor(root, p2, q2);
        System.out.println("测试用例2(LCA(5,4)): " + result2.val); // 5
        
        // 测试用例3：p=6, q=7
        TreeNode p3 = root.left.left;
        TreeNode q3 = root.left.right.left;
        TreeNode result3 = solution.lowestCommonAncestor(root, p3, q3);
        System.out.println("测试用例3(LCA(6,7)): " + result3.val); // 5
        
        // 测试用例4：p=3, q=5
        TreeNode p4 = root;
        TreeNode q4 = root.left;
        TreeNode result4 = solution.lowestCommonAncestor(root, p4, q4);
        System.out.println("测试用例4(LCA(3,5)): " + result4.val); // 3
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // 递归查找左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归查找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 如果左右都找到，当前节点是LCA
        if (left != null && right != null) {
            return root;
        }
        
        // 返回非空的结果
        return left != null ? left : right;
    }
}