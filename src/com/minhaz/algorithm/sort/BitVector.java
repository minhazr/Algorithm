package com.minhaz.algorithm.sort;

public class BitVector {

	public static int[] sort(int[] input) {

		long bit = 0;
		for (int i : input) {
			bit = bit | (1 << i);
		}
		int[] result = new int[input.length];
		int k = 0;
		for (int i = 0; (i < Long.MAX_VALUE) && (k < input.length); i++) {
			if ((bit & (1 << i)) != 0) {
				result[k++] = i;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] output = BitVector.sort(new int[]{5, 2, 9, 4});
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}

	}

}
