package com.minhaz.algorithm.problem;

import java.util.Arrays;

public class Permutation {

	public void permute(char[] input, int i) {
		if (i == input.length) {
			System.out.println(input);

		} else {
			for (int j = i; j < input.length; j++) {
				swap(input, i, j);
				permute(input, i + 1);
				swap(input, i, j);
			}
		}

	}
	public void swap(char[] input, int i, int j) {
		char ch = input[j];
		input[j] = input[i];
		input[i] = ch;

	}

	public void lexiographic(char[] input, char[] buffer, int index) {
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			buffer[index] = input[i];
			if (index == (input.length - 1)) {
				System.out.println(new String(buffer));
			} else {
				lexiographic(input, buffer, index + 1);
			}
		}

	}
	public void sortedPermutation(char[] input) {
		// Get size of string
		int size = input.length;

		// Sort the string in increasing order
		Arrays.sort(input);

		// Print permutations one by one
		boolean isFinished = false;
		while (!isFinished) {
			// print this permutation
			System.out.println(new String(input));

			// Find the rightmost character which is smaller than its next
			// character. Let us call it 'first char'
			int i = 0;
			for (i = size - 2; i >= 0; --i) {
				if (input[i] < input[i + 1]) {
					break;
				}
			}

			// If there is no such chracter, all are sorted in decreasing order,
			// means we just printed the last permutation and we are done.
			if (i == -1) {
				isFinished = true;
			} else {
				// Find the ceil of 'first char' in right of first character.
				// Ceil of a character is the smallest character greater than it
				int ceilIndex = findCeil(input, input[i], i + 1, size - 1);

				// Swap first and second characters
				swap(input, i, ceilIndex);

				// Sort the string on right of 'first char'
				Arrays.sort(input, i + 1, size);
			}
		}

	}

	private int findCeil(char[] str, char first, int l, int h) {
		int index = l;

		// Now iterate through rest of the elements and find
		// the smallest character greater than 'first'
		for (int i = l + 1; i <= h; i++) {
			if ((str[i] > first) && (str[i] < str[index])) {
				index = i;
			}
		}

		return index;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation permute = new Permutation();
		permute.permute("ABC ".toCharArray(), 0);
		// permute.sortedPermutation("ABC".toCharArray());
		// permute.permute("ABC".toCharArray(), 0);
		// permute.lexiographic("ABC".toCharArray(), new char["ABC".length()],
		// 0);
		// String s = "STRING";
		// char[] ch = s.toCharArray();
		// Arrays.sort(ch);
		// System.out.println(new String(ch));

	}

}
