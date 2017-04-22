package cn.com.sky.algorithms.searching.statics.ordered_list.binary_search;

/**
 * 
 * <pre>
 * 
 * 二分查找又称折半查找，它是一种效率较高的查找方法。 　　
 * 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
 * 
 * </pre>
 * 
 */
public class TestBinarySearch2 {
	public static void main(String[] args) {
		int[] src = new int[] { 1, 3, 5, 7, 8, 9 };
		System.out.println(binarySearch(src, 3));
		System.out.println(binarySearch(src, 8));
		System.out.println(binarySearch(src, 5, 1, src.length - 2));
	}

	/**
	 * 二分查找算法(循环)
	 */
	public static int binarySearch(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找特定整数在整型数组中的位置(递归)
	 *
	 */
	public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

}