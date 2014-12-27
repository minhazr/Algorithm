package com.minhaz.algorithm.ds;

import java.util.Arrays;

/**
 * 
 * 
 * http://algs4.cs.princeton.edu/63suffix/SuffixArray.java.html
 * https://www.youtube.com/watch?v=WfTcW4Pu_tc
 */
public class SuffixArray {

	private Suffix[] suffixs;

	public SuffixArray(String input) {
		int length = input.length();
		suffixs = new Suffix[length];
		for (int i = 0; i < length; i++) {
			suffixs[i] = new Suffix(input.substring(i), i);
		}

	}

	public void sort() {
		Arrays.sort(suffixs);
	}

	public int lcp(String input1, String input2) {
		int minlength = Math.min(input1.length(), input2.length());
		for (int i = 0; i < minlength; i++) {
			if (input1.charAt(i) != input2.charAt(i)) {
				return i;
			}
		}
		return minlength;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(+1);

	}

	private static class Suffix implements Comparable<Suffix> {
		private String text;
		private int index;

		Suffix(String input, int index) {
			this.text = input;
			this.index = index;
		}

		@Override
		public int compareTo(Suffix o) {
			for (int i = 0; i < Math.max(text.length(), o.text.length()); i++) {
				if (this.text.charAt(i) > o.text.charAt(i)) {
					return 1;
				}
				if (this.text.charAt(i) < o.text.charAt(i)) {
					return -1;
				}
			}
			return 0;
		}

	}

}
