package com.minhaz.algorithm.problem;

/**
 * 
 * 
 * Problem Statement
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
		if ((s1.length() + s2.length()) != s3.length()) {
			return false;
		}
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				matrix[i][j] = false;
			}
		}
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {

				if ((i == 0) && (j == 0)) {
					matrix[i][j] = true;
				} else if ((i == 0) && (j > 0)
						&& (s2.charAt(j - 1) == s3.charAt(j - 1))) {
					matrix[i][j] = matrix[i][j - 1];
				} else if ((i > 0) && (j == 0)
						&& (s1.charAt(i - 1) == s3.charAt(i - 1))) {
					matrix[i][j] = matrix[i - 1][j];
				} else if ((i > 0) && (j > 0)) {
					if ((s1.charAt(i - 1) == s3.charAt((i + j) - 1))
							&& (s2.charAt(j - 1) != s3.charAt((i + j) - 1))) {
						matrix[i][j] = matrix[i - 1][j];
					} else if ((s1.charAt(i - 1) != s3.charAt((i + j) - 1))
							&& (s2.charAt(j - 1) == s3.charAt((i + j) - 1))) {
						matrix[i][j] = matrix[i][j - 1];
					} else if ((s1.charAt(i - 1) == s3.charAt((i + j) - 1))
							&& (s2.charAt(j - 1) == s3.charAt((i + j) - 1))) {
						matrix[i][j] = matrix[i][j - 1] || matrix[i - 1][j];
					}
				}

			}
		}
		return matrix[s1.length()][s2.length()];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterleavingString interleav = new InterleavingString();
		System.out.println(interleav.isInterleave("a", "b", "a"));

	}

}
