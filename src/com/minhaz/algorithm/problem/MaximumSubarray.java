package com.minhaz.algorithm.problem;

/**
 * 
 * Problem Statement
 * 
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum. For example, given the array
 * [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest
 * sum = 6.
 * 
 */
public class MaximumSubarray {

	public int maxSubArray(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int currentSum = A[0];
		int totalSum = A[0];
		for (int i = 1; i < A.length; i++) {
			currentSum = Math.max(A[i], currentSum + A[i]);
			totalSum = Math.max(totalSum, currentSum);
		}
		return totalSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5,
				4}));

	}
}
