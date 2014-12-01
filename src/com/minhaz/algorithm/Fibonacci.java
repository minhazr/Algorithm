package com.minhaz.algorithm;

public class Fibonacci {

	public int rcursive(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		} else {
			return rcursive(n - 1) + rcursive(n - 2);
		}
	}

	public int dp(int n) {
		int[] output = new int[n];
		output[0] = 1;
		output[1] = 1;
		for (int i = 0; i < n; i++) {
			output[i] = output[i - 1] + output[i - 2];
		}
		return output[n - 1];
	}

	public int constant(int n) {
		int first = 1;
		int seccond = 1;
		int count = 2;
		int result = 0;
		int temp;
		if ((n == 1) || (n == 2)) {
			return 1;
		}
		while (count < n) {
			result = first + seccond;
			temp = seccond;
			seccond = result;
			first = temp;
			count++;
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.constant(5));

	}

}
