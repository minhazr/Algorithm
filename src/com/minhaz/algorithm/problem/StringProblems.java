package com.minhaz.algorithm.problem;

import java.util.HashMap;

public class StringProblems {

	public String removeAdjacenDuplicates(char[] str, int index, int pointer) {
		if (str.length == 0) {
			return new String(str);
		}
		if (index == (str.length - 1)) {
			return new String(str, 0, pointer + 1);
		}

		if ((index > 0) && (str[index] == str[index - 1])) {
			pointer--;
			index++;
			str[pointer] = str[index];

		}
		if ((pointer > 0) && (str[pointer] == str[pointer - 1])) {
			pointer--;
			index++;
			str[pointer] = str[index];

		}
		str[pointer] = str[index];
		return removeAdjacenDuplicates(str, index + 1, pointer + 1);

	}

	public void stringFilter(char[] str) {
		int prev = 0;
		for (int i = 0; i < str.length; i++) {
			if ((prev > 0) && (str[i] == 'c') && (str[prev - 1] == 'a')) {
				prev = prev - 1;
			} else if (str[i] != 'b') {
				str[prev++] = str[i];
			}
		}
		str[prev] = '\0';
	}
	public void allPhoneDigitWords(int[] numbers) {
		HashMap<Integer, String> table = new HashMap<Integer, String>();
		table.put(0, "");
		table.put(1, "");
		table.put(2, "ABC");
		table.put(3, "DEF");
		table.put(4, "GHI");
		table.put(5, "JKL");
		table.put(6, "MNO");
		table.put(7, "PQRS");
		table.put(8, "TUV");
		table.put(9, "WXYZ");
		char[] output = new char[numbers.length + 1];
		allPhoneDigitWordsUtil(table, numbers, 0, output);

	}

	private void allPhoneDigitWordsUtil(HashMap<Integer, String> table,
			int[] numbers, int index, char[] result) {
		// if (index >= result.length) {
		// return;
		// }
		if (index >= numbers.length) {
			System.out.println(new String(result));
			return;
		} else {
			int number = numbers[index];
			// System.out.println(number + "--" + index);
			char[] chars = table.get(number).toCharArray();
			// System.out.println("chars " + new String(chars));
			for (char ch : chars) {
				result[index] = ch;
				allPhoneDigitWordsUtil(table, numbers, index + 1, result);
			}
		}

	}
	public boolean isPalindrom(String str, int i, int j) {
		if (i == j) {
			return true;
		}
		if ((str.charAt(i) < 'A') || (str.charAt(i) > 'Z')) {
			return isPalindrom(str, ++i, j);
		}
		if ((str.charAt(j) < 'A') || (str.charAt(j) > 'Z')) {
			return isPalindrom(str, i, --j);
		} else {
			return (str.charAt(i) == str.charAt(j))
					&& isPalindrom(str, ++i, --j);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringProblems problems = new StringProblems();
		// System.out.println(problems.removeAdjacenDuplicates(
		// "acaaabbbacdddd".toCharArray(), 0, 0));
		problems.allPhoneDigitWords(new int[]{2, 3});

	}

}
