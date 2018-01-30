package cn.com.sky.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 
 * 118. Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * 
 * 
 * </pre>
 */
public class PascalsTriangle118 {

	@Test
	public void solution() {
		int numRows = 5;
		generate(numRows);
		System.out.println();
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}
}
