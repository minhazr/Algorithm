package com.minhaz.algorithm.problem;

public class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * Problem description: https://oj.leetcode.com/problems/unique-paths/
	 * 
	 * @param m
	 *            destination row
	 * @param n
	 *            destination col
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		if ((m <= 0) || (n <= 0)) {
			return 0;
		}
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			matrix[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[m - 1][n - 1];
	}

	/**
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid. links https://oj.leetcode.com/problems/unique-paths-ii/
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if ((m <= 0) || (n <= 0)) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 0) {
			matrix[0][0] = 1;
		}
		for (int i = 1; i < obstacleGrid.length; i++) {
			if ((matrix[i - 1][0] == 1) && (obstacleGrid[i][0] == 0)) {
				matrix[i][0] = 1;
			}
		}

		for (int i = 1; i < obstacleGrid[0].length; i++) {
			if ((matrix[0][i - 1] == 1) && (obstacleGrid[0][i] == 0)) {
				matrix[0][i] = 1;
			}
		}

		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					if ((obstacleGrid[i - 1][j] == 0)
							&& (obstacleGrid[i][j - 1] == 0)) {
						matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
					} else if ((obstacleGrid[i - 1][j] == 0)
							&& (obstacleGrid[i][j - 1] != 0)) {
						matrix[i][j] = matrix[i - 1][j];
					} else if ((obstacleGrid[i - 1][j] != 0)
							&& (obstacleGrid[i][j - 1] == 0)) {
						matrix[i][j] = matrix[i][j - 1];
					} else if ((obstacleGrid[i - 1][j] != 0)
							&& (obstacleGrid[i][j - 1] != 0)) {
						matrix[i][j] = 0;
					}

				}
			}
		}
		return matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
