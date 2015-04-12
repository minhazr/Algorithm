package com.minhaz.algorithm.string;

/**
 * 
 * This is famous Knuth Moris Pratt algorithim.
 * 
 * 
 * I used followings sources to understand the algorithm.
 * 
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/ 
 * https://www.youtube.com/watch?v=iZ93Unvxwtw (Lecture from Princeton University) 
 * https://www.youtube.com/watch?v=1k2KDhcO_uo (How to generate KMP table.)
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * 
 * 
 * Problem Statement
 * 
 * txt[] = "THIS IS A TEST TEXT" 
 * pat[] = "TEST" Output: Pattern found at index 10
 * 
 * 
 */

public class KMP {

	public void KMPAlgorithim(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		int j = 0; // index for pat[]

		int[] lps = generateKMPTable(pat);

		int i = 0; // index for txt[]
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}

			if (j == M) {
				System.out.println("Pattern found in " + (i - j));
				j = lps[j - 1];
			}

			// mismatch after j matches
			else if ((i < N) && (pat.charAt(j) != txt.charAt(i))) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	private int[] generateKMPTable(String pat) {
		int len = 0;
		int i = 1;
		int length = pat.length();
		int[] output = new int[length];
		output[0] = 0;

		while (i < length) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				output[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = output[len - 1];
				} else {
					output[i] = 0;
					i++;
				}
			}
		}
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
