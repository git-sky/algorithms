package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 
 * 760. Find Anagram Mappings
 * 
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * 
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the i th element in A appears in B at index j.
 * 
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * 
 * For example, given
 * 
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 * 
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 * 
 * </pre>
 */
public class FindAnagramMappings760 {

	@Test
	public void solution() {
		int[] A = { 12, 28, 46, 32, 50 };
		int[] B = { 50, 12, 32, 46, 28 };

		int[] c = anagramMappings(A, B);
		System.out.println(Arrays.toString(c));
	}

	/**
	 * 使用HashMap查找元素，时间复杂度是O(1)。
	 * 
	 * 该实现方式：时间复杂度O(n)，空间复杂度O(n)。
	 * 
	 */
	public int[] anagramMappings(int[] A, int[] B) {
		Map<Integer, Integer> D = new HashMap();
		for (int i = 0; i < B.length; ++i) {
			D.put(B[i], i);
		}

		int[] ans = new int[A.length];
		int t = 0;
		for (int x : A)
			ans[t++] = D.get(x);
		return ans;
	}

}
