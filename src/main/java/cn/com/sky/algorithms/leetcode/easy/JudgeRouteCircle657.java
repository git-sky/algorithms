package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 657. Judge Route Circle
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * 
 * Example 1:
 * Input: "UD"
 * Output: true
 * 
 * Example 2:
 * Input: "LL"
 * Output: false
 * 
 * 
 * 
 * 
 * </pre>
 */
public class JudgeRouteCircle657 {

	@Test
	public void solution() {

		String moves = "UD";

		boolean b = judgeCircle(moves);
		System.out.println(b);
	}

	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (char move : moves.toCharArray()) {
			if (move == 'U')
				y--;
			else if (move == 'D')
				y++;
			else if (move == 'L')
				x--;
			else if (move == 'R')
				x++;
		}
		return x == 0 && y == 0;
	}

}
