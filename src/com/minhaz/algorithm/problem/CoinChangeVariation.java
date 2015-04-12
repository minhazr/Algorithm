package com.minhaz.algorithm.problem;

import java.util.Arrays;

public class CoinChangeVariation {

	public int knapsackProblem(int W, int[] wt, int[] val) {
		int[][] k = new int[wt.length + 1][W + 1];

		for (int i = 0; i <= k.length; i++) {
			for (int w = 0; w <= W; w++) {
				if ((i == 0) || (w == 0)) {
					k[i][w] = 0;
				} else if (wt[i - 1] >= w) {
					k[i][w] = Math.max(val[i - 1] + k[i - 1][w - wt[i - 1]],
							k[i - 1][w]);
				} else {
					k[i][w] = k[i - 1][w];
				}
			}
		}
		return k[wt.length][W];

	}
	// public int coinChange(int[] s, int total){
	// int[][] k = new int[s.length][total];
	// }
	public boolean isPossible(int[] containers, int container, int target,
			int index, int capacity) {
		// base case
		if (containers[container] == target) {
			System.out.println("-----------------------------");
			return true;
		}
		if ((index < 0) || (index >= containers.length)) {
			return false;
		}

		// try move item
		int[] temp = Arrays.copyOf(containers, containers.length);
		int source = index - 1;
		int destination = index;
		int available = capacity - temp[destination];
		// source has more item then destination can handle
		if (temp[source] > available) {
			temp[source] = temp[source] - available;
			temp[destination] = temp[destination] + available;
		} else {
			// taking everything from source which will make source empty
			temp[destination] = temp[destination] + temp[source];
			temp[source] = 0;
		}

		int[] temp2 = Arrays.copyOf(containers, containers.length);
		source = index;
		destination = index - 1;
		available = capacity - temp2[destination];
		// source has more item then destination can handle
		if (temp2[source] > available) {
			temp2[source] = temp2[source] - available;
			temp2[destination] = temp2[destination] + available;
		} else {
			// taking everything from source which will make source empty
			temp2[destination] = temp2[destination] + temp2[source];
			temp2[source] = 0;
		}

		// recur by just keep the first item as it is
		return isPossible(containers, container, target, index + 1, capacity)
				|| isPossible(temp2, container, target, index + 1, capacity)
				|| isPossible(temp, container, target, index + 1, capacity);

	}
	private void moveItems(int[] containers, int source, int destination,
			int capacity) {
		if ((source < containers.length) || (destination < containers.length)) {
			return;
		}
		if (containers[destination] == capacity) {
			return;
		}

		int available = capacity - containers[destination];
		// source has more item then destination can handle
		if (containers[source] >= available) {
			containers[source] = containers[source] - available;
			containers[destination] = capacity;
		} else {
			// taking everything from source which will make source empty
			containers[destination] = containers[destination]
					+ containers[source];
			containers[source] = 0;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChangeVariation variation = new CoinChangeVariation();
		int[] input = new int[]{5, 7, 2, 3, 8};
		System.out.println(variation.isPossible(input, 2, 8, 1, 10));

	}

}
