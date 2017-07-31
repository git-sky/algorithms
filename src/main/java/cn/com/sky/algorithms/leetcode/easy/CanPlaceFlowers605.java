package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 605. Can Place Flowers
 * 
 * Suppose you have a long flowerbed(花圃) in which some of the plots(把…分成小块) are planted and some are not. 
 * However, flowers cannot be planted in adjacent(相邻) plots - they would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating(违反) the no-adjacent-flowers rule.
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * 
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * 
 * </pre>
 */
public class CanPlaceFlowers605 {

	@Test
	public void solution() {
		int[] flowerbed = {1,0,0,0,1};
		int n = 2;

		boolean b = canPlaceFlowers(flowerbed, n);
		System.out.println(b);
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int i = 0, count = 0;
		while (i < flowerbed.length) {
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			i++;
		}
		return count >= n;
	}
}
