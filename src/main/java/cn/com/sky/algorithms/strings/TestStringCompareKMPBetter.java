package cn.com.sky.algorithms.strings;

import org.junit.Test;

/**
 * <pre>
 * KMP算法改进版（KMP with nextval）【Medium】
 *
 * 题目：优化KMP算法的next数组，减少不必要的比较
 *
 * 改进原理：
 * 1. 原KMP中，当P[j] == P[next[j]]时，用next[j]回溯后必然再次失配
 * 2. nextval数组：如果P[j] == P[next[j]]，则nextval[j] = nextval[next[j]]
 * 3. 否则nextval[j] = next[j]
 *
 * 示例：模式串 "ababaaaba"
 * - next:    [0, 1, 1, 2, 3, 4, 2, 2, 3]
 * - nextval: [0, 1, 0, 1, 0, 4, 2, 1, 0]
 *
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(n)
 * </pre>
 */
public class TestStringCompareKMPBetter {

	@Test
	public void compare() {
	}

}