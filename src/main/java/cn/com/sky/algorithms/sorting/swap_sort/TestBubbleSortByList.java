package cn.com.sky.algorithms.sorting.swap_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
