package com.minhaz.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem Statement
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * First Variation: can jump Determine if you are able to reach the last index.
 * 
 * Second Variation: find minimum Jump Find the minimum jump if such jump is
 * possible
 * 
 */
public class JumpGame {
	/**
	 * WORK IN PROGRESS
	 * 
	 * @param arr
	 * @param l
	 * @param h
	 * @return
	 */
	public int minJumps(int arr[], int l, int h) {
		// Base case: when source and destination are same
		if (h == l) {
			return 0;
		}

		// When nothing is reachable from the given source
		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}

		// Traverse through all the points reachable from arr[l]. Recursively
		// get the minimum number of jumps needed to reach arr[h] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; (i <= h) && (i <= (l + arr[l])); i++) {
			int jumps = minJumps(arr, i, h);
			if ((jumps != Integer.MAX_VALUE) && ((jumps + 1) < min)) {
				min = jumps + 1;
			}
		}

		return min;
	}
	/**
	 * 
	 * This is graph base solution of First Variation
	 * 
	 * @param A
	 * @return
	 */
	public boolean canJump(int[] A) {
		int length = A.length;
		if (length == 0) {
			return false;
		}
		if (A[0] == 0) {
			return false;
		}
		// System.out.println("Return before void");

		int[][] matrix = createMatrix(A);
		boolean[] visited = new boolean[matrix.length];

		dfsUtil(matrix, 0, visited);

		return visited[length - 1];

	}
	/**
	 * Array base solution of First Variation
	 * 
	 * @param A
	 *            input array
	 * @param flag
	 *            this parameter never used. Just making it overloaded, as i
	 *            have another method of same name.
	 * @return
	 */
	public boolean canJump(int[] A, boolean flag) {
		int maxInd = 0;
		for (int i = 0; i < A.length; i++) {
			if (maxInd < (A[i] + i)) {
				maxInd = A[i] + i;
			}
			if (maxInd >= (A.length - 1)) {
				return true;
			}
			if (maxInd <= i) {
				return false;
			}
		}
		return false;

	}

	/**
	 * 
	 * Work with graph base solution
	 */
	private void dfsUtil(int[][] matrix, int vertics, boolean[] visited) {

		visited[vertics] = true;
		for (int i = 0; i < matrix.length; i++) {
			int[] neighbours = getNeighbours(matrix, i);
			for (int j : neighbours) {
				if (!visited[j]) {
					dfsUtil(matrix, j, visited);
				}
			}
		}
	}
	/**
	 * Graph base solution
	 * 
	 * @param matrix
	 * @param vertics
	 * @return
	 */
	private int[] getNeighbours(int[][] matrix, int vertics) {
		if (vertics < 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertics][i] == 1) {
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;

	}

	private int[][] createMatrix(int[] A) {
		int length = A.length;
		int[][] matrix = new int[length][length];
		for (int i = 0; i < length; i++) {

			for (int j = i + 1, k = 0; (k < A[i]) && (j < length); j++, k++) {
				matrix[i][j] = 1;
			}
		}
		return matrix;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0, 4, 0, 0, 0, 1};
		int[] input2 = {0};
		int[] input3 = {3, 2, 1, 0, 4};
		int[] input4 = {1, 3, 6, 1, 0, 9};

		JumpGame jm = new JumpGame();
		int[][] matrix = jm.createMatrix(input1);

		// for (int i = 0; i < matrix.length; i++) {
		// for (int j = 0; j < matrix.length; j++) {
		// System.out.print(matrix[i][j] + " ");
		// }
		// System.out.println(" ");
		// }
		// jm.canJump(input4);
		System.out.println(jm.canJump(input3));

	}

}
