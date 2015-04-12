package com.minhaz.algorithm.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Fibonacci {

	public int rcursive(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		} else {
			return rcursive(n - 1) + rcursive(n - 2);
		}
	}
	int x = 0;
	public int bottomupRcursive(int index, int n, int first, int seccond) {
		int third = first + seccond;
		if (index < n) {
			third = bottomupRcursive(++index, n, seccond, third);
		}
		return third;
	}

	public int dp(int n) {
		int[] output = new int[n + 1];
		output[1] = 1;
		output[2] = 1;
		for (int i = 3; i <= n; i++) {
			output[i] = output[i - 1] + output[i - 2];
		}
		return output[n];
	}
	public int memoized(int n, int[] memo) {
		if (n <= 2) {
			return 1;
		} else if (memo[n] != -1) {
			return memo[n];
		} else {
			memo[n] = memoized(n - 1, memo) + memoized(n - 2, memo);
		}
		return memo[n];
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
		// System.out.println(fib.constant(5));
		// System.out.println(fib.dp(105));

		int n = 5;
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		// fib.memoized(n, memo);
		// fib.printSolution(new int[]{0, 1, 1, 2, 4}, 4);
		System.out.println(fib.findSolution(new int[]{3, 34, 4, 12, 5, 2}, 9));
		// 16));
		// fib.isSubsequenceSum(new int[]{5, 4, 23, 7, 2, 11}, 20);
		// fib.isSubsequenceSum(new int[]{1, 3, 5, 23, 2}, 8);
		// fib.getSolution(new int[]{3, 5, 5, 7}, 10);
		// fib.findSolution(new int[]{1, 2, 1}, 3);

	}
	int printSolution(int p[], int n) {
		int k;
		if (p[n] == 1) {
			k = 1;
		} else {
			k = printSolution(p, p[n] - 1) + 1;
		}
		System.out.println("Line number:" + k + " From word no." + p[n]
				+ " to " + n);
		return k;
	}
	public String reverse(String str) {
		if (str == null) {
			return str;
		}
		if (str.length() == 0) {
			return str;
		} else {
			return reverse(str.substring(1, str.length())) + str.charAt(0);
		}
	}
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		// if (length==1) return 1;
		int[] input = new int[256];
		Set<Character> set = new HashSet<Character>();
		Arrays.fill(input, -1);
		int curLength = 0;
		for (int i = 0; i < length; i++) {
			set.add(s.charAt(i));
		}

		return set.size();
	}

	public void isSubsequenceSum(int[] set, int sum) {
		int currentSum = 0;
		int start = 0;
		for (int i = 0; i < set.length; i++) {
			if (set[i] > sum) {
				start = i;
				start++;
				continue;
			}
			currentSum += set[i];
			while (currentSum > sum) {
				currentSum -= set[start];
				start++;
			}
			if (currentSum == sum) {
				System.out.println("Result found");
				break;
			}
		}
	}
	public boolean findSum(int[] A, int T) {
		int sum = 0;
		int j = 0;
		for (int i = 0; i < A.length; ++i) {
			while ((j < A.length) && (sum < T)) {
				sum += A[j];
				j++;
			}
			if (sum == T) {
				return true;
			}
			sum -= A[i];
		}

		return false;
	}
	public boolean findSolution(int[] scores, int total) {
		int W = total;
		int players = scores.length;

		boolean[][] myArray = new boolean[players + 1][total + 1];

		for (int player = 0; player <= players; player++) {
			myArray[player][0] = true;
		}
		for (int score = 1; score < total; score++) {
			myArray[0][score] = false;
		}
		for (int player = 1; player <= players; player++) {
			for (int score = 1; score <= total; score++) {
				myArray[player][score] = myArray[player - 1][score];
				if (score >= scores[player - 1]) {
					myArray[player][score] = myArray[player - 1][score
							- scores[player - 1]]
							|| myArray[player][score];
				}
			}
		}
		return myArray[players][W];

	}
	public void moveOddEven(int[] input) {
		int even = 0;
		int odd = 0;
		int OddCount = 0;
		for (int i = 0; i < input.length; i++) {
			if ((input[i] & 1) == 1) {
				OddCount++;
			}
		}
		int oddIndex = input.length - 1 - OddCount;
		int carry = input[oddIndex];

		while (even != odd) {
			while ((input[even] % 2) == 0) {
				even++;
			}
			while ((input[odd] & 1) == 1) {
				odd++;
			}
			swap(input, odd, even);
		}
	}
	public void swap(int[] input, int i, int j) {
		int k = input[i];
		input[i] = input[j];
		input[j] = k;
	}

	// public void kPartion(int[] input, int sum, int[] output, int index) {
	// if (isTotal(output, sum)) {
	// return;
	// } else {
	// output[index] = input[index];
	// if (isSafe()) {
	//
	// }
	// }
	// }
	//
	// private boolean isTotal(int[] output, int sum) {
	// int x = 0;
	// for (int i = 0; i < output.length; i++) {
	// x = x + output[i];
	// if (x == sum) {
	// return true;
	// }
	//
	// }
	// return false;
	// }
}
