package com.minhaz.algorithm.problem;

/**
 * 
 * Problem Statement
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties: Integers in each row are sorted
 * from left to right. The first integer of each row is greater than the last
 * integer of the previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * Given target = 3, return true.
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 1) {
			for (int column = 0; column < matrix[0].length; column++) {
				if (matrix[0][column] == target) {
					return true;
				}
			}
		} else if (matrix.length > 1) {
			for (int row = 0; row < matrix.length; row++) {
				if (target <= matrix[row][matrix[row].length - 1]) {
					for (int column = 0; column < matrix[row].length; column++) {
						if (matrix[row][column] == target) {
							return true;
						}
					}
				}

			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20},
				{23, 30, 34, 50}};
		SearchMatrix sMatrix = new SearchMatrix();
		System.out.println(sMatrix.searchMatrix(matrix, 3));

	}

}
