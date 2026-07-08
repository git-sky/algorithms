package cn.com.sky.algorithms.trees.trees;

import org.junit.Test;

/**
 * <pre>
 * 树的三种存储结构【Easy】
 *
 * 题目：实现树的双亲表示法、孩子表示法、孩子兄弟表示法
 *
 * 1. 双亲表示法（Parent Representation）
 *    - 每个节点记录其父节点的位置
 *    - 优点：找父节点方便，O(1)
 *    - 缺点：找孩子需要遍历，O(n)
 *
 * 2. 孩子表示法（Child Representation）
 *    - 每个节点记录其所有孩子节点
 *    - 优点：找孩子方便
 *    - 缺点：找父节点需要遍历
 *
 * 3. 孩子兄弟表示法（Child-Sibling / First-Child Next-Sibling）
 *    - 也叫二叉树表示法、左孩子右兄弟表示法
 *    - firstChild指向第一个孩子，nextSibling指向下一个兄弟
 *    - 可将任意树转换为二叉树处理
 *    - 优点：统一用二叉树操作树
 * </pre>
 */
public class Tree {

	@Test
	public void treeParents() {// 双亲表示法

	}

	@Test
	public void treeSons() {// 孩子表示法

	}

	@Test
	public void treeSonsSiblings() {// 孩子兄弟表示法

	}

}