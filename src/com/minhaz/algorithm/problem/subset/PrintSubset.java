package com.minhaz.algorithm.problem.subset;

import java.util.Arrays;

public class PrintSubset {

	/**
	 * Print all possible subset from given set
	 * 
	 * @param set
	 */
	public void printAllSubSet(int[] set) {
		int totalSubset = (int) (Math.pow(2, set.length) - 1);
		int temp;
		while (totalSubset > 0) {
			temp = totalSubset;
			for (int i = 0; i < set.length; i++) {
				if ((temp & 1) != 0) {
					System.out.print(set[i] + " ");

				}
				temp >>= 1;

			}
			System.out.println();
			totalSubset--;
		}

	}
	public void printKSubSet(int[] set, int k) {
		// BinomialCoefficient coefficient
		int[] subset = new int[k];
		processSubsets(set, subset, 0, 0);

	}

	private void processSubsets(int[] set, int[] subset, int subsetSize,
			int nextIndex) {
		if (subsetSize == subset.length) {
			System.out.println(Arrays.toString(subset));
		} else {
			for (int j = nextIndex; j < set.length; j++) {
				subset[subsetSize] = set[j];
				processSubsets(set, subset, subsetSize + 1, j + 1);
			}
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 5};
		PrintSubset allSubset = new PrintSubset();
		allSubset.printKSubSet(input, 3);

	}

}
