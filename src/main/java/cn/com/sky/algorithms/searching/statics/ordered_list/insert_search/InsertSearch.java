package cn.com.sky.algorithms.searching.statics.ordered_list.insert_search;

/**
 * <pre>
 * 插值查找（Interpolation Search）【Medium】
 *
 * 题目：实现插值查找算法
 *
 * 算法原理：
 * 1. 二分查找的改进版，根据目标值在区间中的大致位置来计算mid
 * 2. mid = low + (high - low) * (key - a[low]) / (a[high] - a[low])
 * 3. 当数据分布均匀时，插值查找比二分查找更快
 * 4. 当数据分布不均匀时，性能可能退化为O(n)
 *
 * 类比：查字典时，查"apple"会翻前面，查"zoo"会翻后面
 *       而不是每次都翻到中间
 *
 * 时间复杂度：
 * - 平均：O(log log n)（数据均匀分布时）
 * - 最坏：O(n)（数据分布极度不均匀时）
 * 空间复杂度：O(1)
 *
 * 适用场景：数据量大且分布均匀的有序表
 * </pre>
 */
public class InsertSearch {

	public int insertSearch(int[] a, int key) {
		int low, high, mid;
		low = 0;
		high = a.length - 1;
		while (low <= high) {
			mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
			if (key < a[mid])
				high = mid - 1;
			else if (key > a[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int key = 3;

		InsertSearch search = new InsertSearch();
		int pos = search.insertSearch(a, key);
		System.out.println(pos);

	}
}