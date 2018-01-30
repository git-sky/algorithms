package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 567. Permutation in String
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * 
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * </pre>
 * 
 */
public class PermutationInString {

	@Test
	public void solution() {

		String s1 = "ab";
		String s2 = "eidbaooo";

		boolean f = checkInclusion(s1, s2);
		System.out.println(f);
	}

//	public boolean checkInclusion(String s1, String s2) {
//
//	}

}
