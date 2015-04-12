package com.minhaz.algorithm.ds.tree;

public class StringTransformation {

	public void cycleLeader(char[] str, int shift, int len) {
		int j;
		int item;

		for (int i = 1; i < len; i *= 3) {
			j = i;

			item = j + shift;
			do {
				// odd index
				if ((j & 1) != 1) {
					j /= 2;

					// even index
				} else {
					j = (len / 2) + (j / 2);
				}

				// keep the back-up of element at new position
				System.out.println("i:" + i + " j:" + j + " :"
						+ new String(str));
				swap(str, j + shift, item);

			} while (j != i);
		}
	}

	public void swap(char[] input, int i, int j) {
		char ch = input[j];
		input[j] = input[i];
		input[i] = ch;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "a1b2c3d4e5f6g7h8i9";
		StringTransformation transformation = new StringTransformation();
		transformation.cycleLeader(str.toCharArray(), 0, 9);
		int i = 1 / 2;
		System.out.println(i);

	}

}
