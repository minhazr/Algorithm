package com.minhaz.algorithm.string;

import java.util.HashMap;

public class RollingHash {
	private static final int BASE1 = 256, BASE2 = 512;
	private static final int PRIME1 = 101, PRIME2 = 223;
	public int lcs(String a, String b) {
		if ((a == null) || (b == null)) {
			return 0;
		}
		if ((a.length() == 0) || (b.length() == 0)) {
			return 0;
		}

		int minLength = a.length() > b.length() ? a.length() : b.length();
		int i = minLength / 2;
		while (i < minLength) {

		}

		return -1;
	}

	public HashMap<Long, Long> getRollingHashOfSizeK(String str, int k) {
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		int length = str.length();

		for (int i = 2; i < str.length(); i++) {
			long first = hash(str, i - 2, i, BASE1, PRIME1);
			long seccond = hash(str, i - 2, i, BASE2, PRIME2);
			map.put(first, seccond);
		}

		return map;
	}

	private long hash(String text, int i, int n, int base, int mod) {
		long h = 0;
		for (int j = i; (j <= n) && (j < text.length()); j++) {
			h = ((base * h) + text.charAt(j)) % mod;
		}
		return h;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
