package cn.com.sky.algorithms.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public interface Sortable {

	@Before
	public void setUp();

	@After
	public void tearDown();

	@Test
	public void sort();
}