package com.minhaz.algorithm.problem.graph;

/**
 * 
 * Shortest path from source to destination when left, right, top and bottom
 * moves are possible.
 * 
 */
public class ShortestPath {

	int[][] board = new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 0},};
	// destination point
	int destx = 4, desty = 4;

	public int sohrtestPath(int row, int col) {
		if ((row < 0) || (col < 0) || (row >= board.length)
				|| (col >= board[0].length)) {
			return 500;
		} else if (board[row][col] == 1) {
			return 500;
		} else if ((row == destx) && (col == desty)) {
			return 0;
		} else {
			board[row][col] = 1;
			return 1 + Math.min(
					Math.min(sohrtestPath(row - 1, col),
							sohrtestPath(row + 1, col)),
					Math.min(sohrtestPath(row, col - 1),
							sohrtestPath(row, col + 1)));
		}

	}
	public static void main(String[] args) throws java.lang.Exception {
		// start point
		int startx = 0;
		int starty = 0;
		ShortestPath ideone = new ShortestPath();
		System.out.println(ideone.sohrtestPath(startx, starty));
	}

}
