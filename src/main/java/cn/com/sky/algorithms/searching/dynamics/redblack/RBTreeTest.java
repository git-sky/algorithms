package cn.com.sky.algorithms.searching.dynamics.redblack;

/**
 * <pre>
 * 红黑树测试用例【Hard】
 *
 * 测试内容：
 * 1. 插入操作：插入10个节点，验证红黑性质
 * 2. 遍历操作：先序、中序、后序遍历
 * 3. 查找最值：最小值、最大值
 * 4. 删除操作：删除所有节点（可选开启调试模式）
 *
 * 调试开关：
 * - mDebugInsert：打印每次插入后的树结构
 * - mDebugDelete：打印每次删除后的树结构
 * </pre>
 */
public class RBTreeTest {

	private static final int a[] = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
	private static final boolean mDebugInsert = false; // "插入"动作的检测开关(false，关闭；true，打开)
	private static final boolean mDebugDelete = false; // "删除"动作的检测开关(false，关闭；true，打开)

	public static void main(String[] args) {
		int i, ilen = a.length;
		RBTree<Integer> tree = new RBTree<Integer>();

		System.out.printf("== 原始数据: ");
		for (i = 0; i < ilen; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		for (i = 0; i < ilen; i++) {
			tree.insert(a[i]);
			// 设置mDebugInsert=true,测试"添加函数"
			if (mDebugInsert) {
				System.out.printf("== 添加节点: %d\n", a[i]);
				System.out.printf("== 树的详细信息: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

		System.out.printf("== 前序遍历: ");
		tree.preOrder();

		System.out.printf("\n== 中序遍历: ");
		tree.inOrder();

		System.out.printf("\n== 后序遍历: ");
		tree.postOrder();
		System.out.printf("\n");

		System.out.printf("== 最小值: %s\n", tree.minimum());
		System.out.printf("== 最大值: %s\n", tree.maximum());
		System.out.printf("== 树的详细信息: \n");
		tree.print();
		System.out.printf("\n");

		// 设置mDebugDelete=true,测试"删除函数"
		if (mDebugDelete) {
			for (i = 0; i < ilen; i++) {
				tree.remove(a[i]);

				System.out.printf("== 删除节点: %d\n", a[i]);
				System.out.printf("== 树的详细信息: \n");
				tree.print();
				System.out.printf("\n");
			}
		}

		// 销毁二叉树
		tree.clear();
	}
}