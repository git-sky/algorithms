package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 409. Longest Palindrome   最长回文（指顺读和倒读都一样的词语）
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * </pre>
 */
public class LongestPalindrome409 {

	@Test
	public void solution() {
		String s = "abccccdd";
		int n = longestPalindrome(s);
		System.out.println(n);
	}

	/**
	 * <pre>
	 * 
	 *  十进制       字符串
	 *          
	 *  48	    0
	 *  49	    1
	 *  50	    2
	 *  51	    3
	 *  52	    4
	 *  53	    5
	 *  54	    6
	 *  55	    7
	 *  56	    8
	 *  57	    9
	 *          
	 *  65      A
	 *  \       \
	 *  90	    Z
	 *          
	 *  97	    a
	 *  \       \
	 *  122	    z
	 * 
	 * </pre>
	 * 
	 * 
	 */
	public int longestPalindrome(String s) {

		int[] charStatArray = new int[52];
		int oneTimeOddCount = 0;
		int evenCount = 0;

		// keep the times of appearance of each character in the array
		for (char ch : s.toCharArray()) {
			if (ch >= 97) {
				charStatArray[26 + ch - 'a']++;
			} else {
				charStatArray[ch - 'A']++;
			}
		}

		/**
		 * the answer is the count of characters that has even number of appereances. for characters
		 * that has odd number of appereances, their appereances minus 1 will make their apperances
		 * even. And finally we can put an unused character in the middle of the palindrome (if
		 * there is any).
		 */
		for (int cnt : charStatArray) {
			if (cnt != 0) {
				if (cnt % 2 == 0) {
					evenCount += cnt;
				} else {
					if (cnt == 1) {
						oneTimeOddCount++;
					} else {
						evenCount += cnt - 1;
						oneTimeOddCount++;
					}
				}
			}
		}

		return oneTimeOddCount > 0 ? 1 + evenCount : evenCount;

	}
}
