package com.minhaz.algorithm.problem;

import java.util.Arrays;

public class SmallestWindowSubstring {

	public String getSmallestWindowSubstring(String pattern, String input) {

		int max_length = Integer.MAX_VALUE;
		int[] table = new int[256];
		Arrays.fill(table, 0);
		int patternLength = pattern.length();
		for (int i = 0; i < patternLength; i++) {
			table[pattern.charAt(i)]++;
		}
		int length = input.length();
		int startIndex = 0;
		int endIndex = 0;

		for (int j = 0; j < length;) {
			int start = -1, end = -1;
			int currentLength = 0;
			int[] temp = Arrays.copyOf(table, table.length);
			for (int i = j; i < length; i++) {
				if (temp[input.charAt(i)] > 0) {
					currentLength++;
					temp[input.charAt(i)]--;
					if (start == -1) {
						start = i;
					}
					if (currentLength == patternLength) {
						end = i;
						if ((end - start) < max_length) {
							max_length = end - start;
							startIndex = start;
							endIndex = end;

						}
						j = j + start;
						break;
					}

				}
			}

		}

		return new String(input.substring(startIndex, endIndex));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SmallestWindowSubstring sws = new SmallestWindowSubstring();
		System.out.println(sws.getSmallestWindowSubstring("tist",
				"this is a test string"));

	}

}
