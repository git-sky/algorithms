package cn.com.sky.algorithms.trees.binarytrees.threaded_binary_tree;

/**
 * <pre>
 * 线索二叉树（Threaded Binary Tree）【Medium】
 *
 * 题目：实现线索二叉树
 *
 * 算法原理：
 * 1. 利用二叉树中n+1个空指针（n个节点的二叉树有2n个指针，只用了n-1个）
 * 2. 左空指针指向前驱节点（前驱线索）
 * 3. 右空指针指向后继节点（后继线索）
 * 4. 增加ltag/rtag标志位区分是孩子指针还是线索
 *
 * 优点：
 * - 中序遍历不需要递归和栈
 * - 快速查找前驱和后继节点
 *
 * 时间复杂度：遍历O(n)，查找前驱/后继O(1)（平均）
 * 空间复杂度：O(n)
 *
 * TODO: 待实现
 * </pre>
 */
public class asdfadf {

}