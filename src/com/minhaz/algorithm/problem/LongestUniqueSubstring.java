package com.minhaz.algorithm.problem;

import java.util.Arrays;

public class LongestUniqueSubstring {

	public int getLongestUniqueSubstring(String s) {
		int length = s.length();
		int[] visited = new int[length];
		Arrays.fill(visited, -1);
		visited[s.charAt(0) - 'A'] = 0;

		int prev_index;
		int cur_len = 1;
		int max_len = 1;

		for (int i = 1; i < length; i++) {
			prev_index = visited[s.charAt(i) - 'A'];
			if ((prev_index == -1) || ((i - cur_len) > prev_index)) {
				cur_len++;
			} else {
				/*
				 * Also, when we are changing the NRCS, we should also check
				 * whether length of the previous NRCS was greater than max_len
				 * or not.
				 */
				if (cur_len > max_len) {
					max_len = cur_len;
				}

				cur_len = i - prev_index;
			}

			visited[s.charAt(i) - 'A'] = i;

		}
		if (cur_len > max_len) {
			max_len = cur_len;
		}
		return max_len;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
		System.out.println(longestUniqueSubstring
				.getLongestUniqueSubstring("ABDEFGABEF"));

	}

}
