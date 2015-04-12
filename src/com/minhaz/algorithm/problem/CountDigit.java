package com.minhaz.algorithm.problem;

public class CountDigit {
	// int count = 0;
	int CountDigita(char[] digits, int n) {
		// base cases
		if ((n == 0) || (n == 1)) {
			return 1;
		}

		int count = 0; // Initialize count

		// If the last digit is not 0, then last digit must add to
		// the number of words
		if (digits[n - 1] > '0') {
			count = CountDigita(digits, n - 1);
		}

		// If the last two digits form a number smaller than or equal to 26,
		// then consider last two digits and recur
		if ((digits[n - 2] < '2')
				|| ((digits[n - 2] == '2') && (digits[n - 1] < '7'))) {
			count += CountDigita(digits, n - 2);
		}

		return count;
	}
	int countDecodingDP(char[] digits, int n) {
		int[] count = new int[n + 1]; // A table to store results of subproblems
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if (digits[i - 1] > '0') {
				count[i] = count[i - 1];
			}

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			if ((digits[i - 2] < '2')
					|| ((digits[i - 2] == '2') && (digits[i - 1] < '7'))) {
				count[i] += count[i - 2];
			}
		}
		return count[n];
	}
	String s1 = "";
	int count = 0;
	int maxDecode(String prefix, String s) {
		// TODO Auto-generated method stub

		if (s.length() <= 0) {
			System.out.println(prefix);
			count++;
			return count;
		}

		for (int i = 1; i <= s.length(); i++) {
			String p = s.substring(0, i);
			String cur = "";
			int b = 1;
			if (i < s.length()) {
				cur = s.substring(i, i + 1);
				b = (Integer.parseInt(cur));
			}
			int a = (Integer.parseInt(p));

			if ((a > 0) && (a <= 26) && ((b > 0) && (b <= 26))) {
				p = "" + (char) (a + 64);
				maxDecode(prefix + p, s.substring(i));
			}

		}
		return count;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountDigit digit = new CountDigit();
		char[] digits = {'1', '2', '3'};
		System.out.println(digit.CountDigita(digits, 3));

	}

}
