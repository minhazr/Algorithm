package com.minhaz.algorithm.problem;
/**
 * 
 * Problem Statement
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * 
 */
public class SingleNumber {

	public int singleNumber(int[] A) {
		int value = 0;
		for (int i = 0; i < A.length; i++) {
			value = value ^ A[i];
		}
		return value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber number = new SingleNumber();
		System.out.println(number.singleNumber(new int[]{2, 2, 7, 7, 8}));

	}

}
