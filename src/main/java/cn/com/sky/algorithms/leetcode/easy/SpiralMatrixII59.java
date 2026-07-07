package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 *
 * 59. Spiral(螺旋) Matrix(矩阵) II
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * </pre>
 */
public class SpiralMatrixII59 {

	@Test
	public void solution() {
		int n = 3;
		int[][] matrix = generateMatrix(n);
		
		System.out.println("n = " + n);
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("\nn = 4");
		int[][] matrix2 = generateMatrix(4);
		for (int[] row : matrix2) {
			System.out.println(Arrays.toString(row));
		}
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		
		if (n == 0) {
			return matrix;
		}
		
		int top = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int num = 1;
		
		while (num <= n * n) {
			// 从左到右
			for (int i = left; i <= right; i++) {
				matrix[top][i] = num++;
			}
			top++;
			
			// 从上到下
			for (int i = top; i <= bottom; i++) {
				matrix[i][right] = num++;
			}
			right--;
			
			// 从右到左
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					matrix[bottom][i] = num++;
				}
				bottom--;
			}
			
			// 从下到上
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					matrix[i][left] = num++;
				}
				left++;
			}
		}
		
		return matrix;
	}
}