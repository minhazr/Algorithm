package com.minhaz.algorithm.sort;

public class CountingSort {

	public static int[] sort(int[] input) {

		// 1. find the maximum value
		int max = Integer.MIN_VALUE;
		for (int i : input) {
			if (i > max) {
				max = i;
			}
			if (i < 0) {
				return new int[0];
			}
		}
		// 2 count the number of items
		int[] countArr = new int[max + 1];
		for (int i : input) {
			countArr[i]++;
		}
		// 3 Add each item
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] = countArr[i] + countArr[i - 1];
		}

		// set back in result
		int[] result = new int[input.length];
		for (int i = 0; i < result.length; i++) {
			result[countArr[input[i]] - 1] = input[i];
			countArr[input[i]]--;
		}
		return result;

	}
	public static char[] sort(char[] input) {

		// 1. find the maximum value
		int max = Integer.MIN_VALUE;
		for (int i : input) {
			if (i > max) {
				max = i;
			}
			if (i < 0) {
				return new char[0];
			}
		}
		// 2 count the number of items
		int[] countArr = new int[max + 1];
		for (int i : input) {
			countArr[i]++;
		}
		// 3 Add each item
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] = countArr[i] + countArr[i - 1];
		}

		// set back in result
		char[] result = new char[input.length];
		for (int i = 0; i < result.length; i++) {
			result[countArr[input[i]] - 1] = input[i];
			countArr[input[i]]--;
		}
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] output = CountingSort.sort(new int[]{7, 5, 2, 2});
		// for (int i : output) {
		// System.out.print(i + " ");
		// }
		char[] output = CountingSort.sort("geeks".toCharArray());
		for (char i : output) {
			System.out.print(i + " ");
		}

	}
}
