package cn.com.sky.algorithms.offer;

/**
 * <pre>
 * 剑指Offer 27. 二叉树的镜像【Easy】
 *
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 算法原理（递归交换）：
 * 1. 交换根节点的左右子树
 * 2. 递归地对左子树求镜像
 * 3. 递归地对右子树求镜像
 *
 * 镜像定义：将二叉树左右翻转，即每个节点的左右子树互换
 *
 * 时间复杂度：O(n)，需要遍历所有节点
 * 空间复杂度：O(h)，h为树的高度（递归栈深度）
 * </pre>
 */
public class CopyBinaryTree {

    public static void main(String[] args) {
        CopyBinaryTree solution = new CopyBinaryTree();

        // 测试用例1：正常二叉树
        System.out.println("=== 测试用例1：正常二叉树 ===");
        BinaryNode root1 = solution.buildTree();
        System.out.println("镜像前（前序遍历）:");
        solution.preorderPrint(root1);
        root1 = solution.mirror(root1);
        System.out.println("\n镜像后（前序遍历）:");
        solution.preorderPrint(root1);

        // 测试用例2：空树
        System.out.println("\n\n=== 测试用例2：空树 ===");
        BinaryNode root2 = solution.mirror(null);
        System.out.println("空树镜像: " + root2);

        // 测试用例3：单节点
        System.out.println("\n=== 测试用例3：单节点 ===");
        BinaryNode root3 = new BinaryNode(1, null, null);
        root3 = solution.mirror(root3);
        System.out.println("单节点镜像: " + root3.data);

        // 测试用例4：只有左子树
        System.out.println("\n=== 测试用例4：只有左子树 ===");
        BinaryNode root4 = new BinaryNode(1,
            new BinaryNode(2,
                new BinaryNode(3, null, null), null), null);
        System.out.println("镜像前（前序遍历）:");
        solution.preorderPrint(root4);
        root4 = solution.mirror(root4);
        System.out.println("\n镜像后（前序遍历）:");
        solution.preorderPrint(root4);

        // 测试用例5：完全二叉树
        System.out.println("\n\n=== 测试用例5：完全二叉树 ===");
        BinaryNode root5 = new BinaryNode(8,
            new BinaryNode(6,
                new BinaryNode(5, null, null),
                new BinaryNode(7, null, null)),
            new BinaryNode(10,
                new BinaryNode(9, null, null),
                new BinaryNode(11, null, null)));
        System.out.println("镜像前（前序遍历）:");
        solution.preorderPrint(root5);
        root5 = solution.mirror(root5);
        System.out.println("\n镜像后（前序遍历）:");
        solution.preorderPrint(root5);
    }

    /**
     * 求二叉树的镜像（递归法）
     *
     * @param root 根节点
     * @return 镜像后的根节点
     */
    public BinaryNode mirror(BinaryNode root) {
        if (root == null) {
            return null;
        }

        // 交换左右子树
        BinaryNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归处理左右子树
        mirror(root.left);
        mirror(root.right);

        return root;
    }

    /**
     * 构建测试用的二叉树
     *       1
     *      / \
     *     2   3
     *    /     \
     *   4       5
     */
    private BinaryNode buildTree() {
        BinaryNode node4 = new BinaryNode(4, null, null);
        BinaryNode node5 = new BinaryNode(5, null, null);
        BinaryNode node2 = new BinaryNode(2, node4, null);
        BinaryNode node3 = new BinaryNode(3, null, node5);
        return new BinaryNode(1, node2, node3);
    }

    /**
     * 前序遍历打印
     */
    private void preorderPrint(BinaryNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    /**
     * 二叉树节点
     */
    static class BinaryNode {
        int data;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int data, BinaryNode left, BinaryNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}