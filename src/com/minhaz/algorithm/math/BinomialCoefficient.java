package com.minhaz.algorithm.math;

public class BinomialCoefficient {

	public int binomialCoefficientR(int n, int k) {
		// Base Cases
		if ((k == 0) || (k == n)) {
			return 1;
		}

		// Recur
		return binomialCoefficientR(n - 1, k - 1)
				+ binomialCoefficientR(n - 1, k);
	}

	public int binomialCoefficientC(int n, int k) {
		int res = 1;

		// Since C(n, k) = C(n, n-k)
		if (k > (n - k)) {
			k = n - k;
		}

		// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
