package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 292. Nim Game
 * 
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 * 
 * </pre>
 */
public class NimGame292 {

	@Test
	public void solution() {
		int n = 5;
		boolean b = canWinNim(n);
		System.out.println(b);
	}

	/**
	 * 只要保证不是4的倍数，就会有一个最优解。
	 */
	public boolean canWinNim(int n) {

		return (n % 4 != 0);

	}
}
