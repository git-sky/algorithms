package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 5.重建二叉树
 * 
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建出如下图所示的二叉树并输出它的头结点。　
 * 
 *          1
 *      2       3
 *    4       5   6
 *      7       8
 * 
 * 算法原理：
 * 1. 前序遍历的第一个元素是根节点
 * 2. 在中序遍历中找到根节点，左边是左子树，右边是右子树
 * 3. 递归重建左子树和右子树
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（存储哈希表和递归栈）
 * </pre>
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        // 测试用例1：正常情况
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        
        RebuildBinaryTree solution = new RebuildBinaryTree();
        Node root = solution.reConstructBinaryTree(preorder, inorder);
        
        System.out.println("前序遍历验证:");
        preorderPrint(root);  // 应输出: 1 2 4 7 3 5 6 8
        System.out.println();
        
        System.out.println("中序遍历验证:");
        inorderPrint(root);   // 应输出: 4 7 2 1 5 3 8 6
        System.out.println();
        
        // 测试用例2：单节点
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        Node root2 = solution.reConstructBinaryTree(preorder2, inorder2);
        System.out.println("单节点测试:");
        preorderPrint(root2);  // 应输出: 1
        System.out.println();
        
        // 测试用例3：只有左子树
        int[] preorder3 = {1, 2, 3};
        int[] inorder3 = {3, 2, 1};
        Node root3 = solution.reConstructBinaryTree(preorder3, inorder3);
        System.out.println("只有左子树测试:");
        preorderPrint(root3);  // 应输出: 1 2 3
        System.out.println();
        
        // 测试用例4：只有右子树
        int[] preorder4 = {1, 2, 3};
        int[] inorder4 = {1, 2, 3};
        Node root4 = solution.reConstructBinaryTree(preorder4, inorder4);
        System.out.println("只有右子树测试:");
        preorderPrint(root4);  // 应输出: 1 2 3
    }

    /**
     * 前序遍历打印
     */
    public static void preorderPrint(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    /**
     * 中序遍历打印
     */
    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    /**
     * 二叉树节点定义
     */
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 根据前序和中序遍历重建二叉树
     */
    public Node reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        
        return buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 递归构建二叉树
     * 
     * @param pre      前序遍历数组
     * @param preStart 前序遍历起始索引
     * @param preEnd   前序遍历结束索引
     * @param in       中序遍历数组
     * @param inStart  中序遍历起始索引
     * @param inEnd    中序遍历结束索引
     * @return 构建的子树根节点
     */
    private Node buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的第一个元素是根节点
        int rootVal = pre[preStart];
        Node root = new Node(rootVal);

        // 在中序遍历中找到根节点的位置
        int rootIndex = inStart;
        while (rootIndex <= inEnd && in[rootIndex] != rootVal) {
            rootIndex++;
        }

        // 计算左子树的节点数量
        int leftSize = rootIndex - inStart;

        // 递归构建左子树
        root.left = buildTree(pre, preStart + 1, preStart + leftSize, in, inStart, rootIndex - 1);
        
        // 递归构建右子树
        root.right = buildTree(pre, preStart + leftSize + 1, preEnd, in, rootIndex + 1, inEnd);

        return root;
    }
}