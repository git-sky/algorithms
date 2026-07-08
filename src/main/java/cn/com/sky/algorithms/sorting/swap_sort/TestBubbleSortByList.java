package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * 冒泡排序 - 基于List的实现【Easy】
 *
 * 题目：使用ArrayList实现冒泡排序
 *
 * 算法原理：
 * 1. 相邻元素两两比较，如果逆序则交换
 * 2. 每趟排序将最大元素"冒泡"到末尾
 * 3. 重复n-1趟
 *
 * 注意：List的get/set操作效率低于数组直接访问
 * 实际应用中，对List排序建议使用Collections.sort()
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * </pre>
 */
public class TestBubbleSortByList {

	List<Integer> list = new ArrayList<Integer>();

	@Before
	public void setUp() {
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(Arrays.asList(list));
	}

	@After
	public void tearDown() {
		System.out.println(Arrays.asList(list));
	}

	@Test
	public void sort() {
		int len = list.size();
		for (int i = 1; i < len; i++) {
			for (int j = len - 2; j >= i - 1; j--) {
				if (list.get(j) > list.get(j + 1)) {
					int tmp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, tmp);
				}
			}
		}
	}

}