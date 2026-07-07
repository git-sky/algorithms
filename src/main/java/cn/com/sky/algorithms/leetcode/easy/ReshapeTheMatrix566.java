package cn.com.sky.algorithms.leetcode.easy;

import java.util.Arrays;

import org.junit.Test;

/**
 * <pre>
 *
 * 566. Reshape the Matrix
 *
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 *
 *
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 *
 * </pre>
 */
public class ReshapeTheMatrix566 {

	@Test
	public void solution() {
		int[][] nums1 = { { 1, 2 }, { 3, 4 } };
		int r1 = 1, c1 = 4;
		System.out.println("测试用例1: ");
		printMatrix(matrixReshape(nums1, r1, c1));
		
		int[][] nums2 = { { 1, 2 }, { 3, 4 } };
		int r2 = 2, c2 = 4;
		System.out.println("\n测试用例2: ");
		printMatrix(matrixReshape(nums2, r2, c2));
		
		int[][] nums3 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int r3 = 3, c3 = 2;
		System.out.println("\n测试用例3: ");
		printMatrix(matrixReshape(nums3, r3, c3));
	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int rows = nums.length;
		int cols = nums[0].length;
		
		// 如果元素数量不匹配，返回原矩阵
		if (rows * cols != r * c) {
			return nums;
		}
		
		int[][] result = new int[r][c];
		int index = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[index / c][index % c] = nums[i][j];
				index++;
			}
		}
		
		return result;
	}
	
	private void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}