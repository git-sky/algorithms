package cn.com.sky.algorithms.searching.statics.ordered_list.insert_search;

/**
 * 插值查找
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