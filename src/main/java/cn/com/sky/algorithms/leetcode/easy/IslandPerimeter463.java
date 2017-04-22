package cn.com.sky.algorithms.leetcode.easy;

import org.junit.Test;

/**
 * <pre>
 * 
 * 
 * You are given a map in form of a two-dimensional(二维的) integer grid where 1 represents land and 0 represents water. 
 * Grid cells are connected horizontally/vertically (not diagonally(对角)). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter(周长) of the island.
 * 
 * 
 * Example:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Answer: 16
 * 
 * </pre>
 */
public class IslandPerimeter463 {

	@Test
	public void solution() {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		// 16;

		int n = islandPerimeter(grid);
		System.out.println(n);
	}

	public int islandPerimeter(int[][] grid) {

		int allOne = 0;
		int brige = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					allOne++;
					brige += countBrige(grid, i, j);
				}
			}
		}
		return allOne * 4 - brige;
	}

	private int countBrige(int[][] grid, int i, int j) {
		int brige = 0;
		if (grid[i][j] == 1) {
			if (i > 0 && grid[i - 1][j] == 1) {
				brige++;
			}
			if (i + 1 < grid.length && grid[i + 1][j] == 1) {
				brige++;
			}
			if (j > 0 && grid[i][j - 1] == 1) {
				brige++;
			}
			if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
				brige++;
			}
		}

		return brige;
	}
}
