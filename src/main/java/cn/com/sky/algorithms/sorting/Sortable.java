package cn.com.sky.algorithms.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * 排序算法接口【Reference】
 *
 * 定义排序算法的标准接口：
 * - setUp(): 初始化排序数据
 * - tearDown(): 验证排序结果
 * - sort(): 执行排序算法
 * </pre>
 */
public interface Sortable {

	@Before
	public void setUp();

	@After
	public void tearDown();

	@Test
	public void sort();
}