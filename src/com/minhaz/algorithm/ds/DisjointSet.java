package com.minhaz.algorithm.ds;

import java.util.HashMap;

public class DisjointSet<T> {

	private HashMap<T, T> set = new HashMap<T, T>();
	private HashMap<T, Integer> rank = new HashMap<T, Integer>();

	public T find(T item) {
		if (item == null) {
			return null;
		}
		if (set.containsKey(item)) {
			return set.get(item);
		} else {
			return find(set.get(item));
		}
	}

	public void union(T item1, T item2) {
		if ((item1 == null) || (item2 == null)) {
			return;
		}
		if (!rank.containsKey(item1) || !rank.containsKey(item2)
				|| !set.containsKey(item1) || !set.containsKey(item2)) {
			return;
		}
		int item1Rank = rank.get(item1);
		int item2Rank = rank.get(item2);
		if (item1Rank < item2Rank) {
			set.put(item1, item2);

		} else if (item1Rank > item2Rank) {
			set.put(item2, item1);

		} else {
			item1Rank++;
			rank.put(item1, item1Rank);
			set.put(item1, item2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
