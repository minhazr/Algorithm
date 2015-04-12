package com.minhaz.algorithm.ds.tree;

import java.util.ArrayList;

public class BinaryHeap {

	private ArrayList<Integer> items; // pointer to array of elements in heap
	private int capacity; // maximum possible size of min heap
	private int heapSize; // Current number of elements in min heap
	private boolean minHeap;

	BinaryHeap(boolean min) {
		this.minHeap = min;
		items = new ArrayList<Integer>();
	}

	private void swap(int i, int j, ArrayList<Integer> arr) {
		int t = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, t);
	}
	public void insert(int k) {
		if (minHeap) {
			insertMinHeap(k);
		} else {
			insertMaxHeap(k);
		}
	}
	private void insertMinHeap(int k) {
		if (items == null) {
			return;
		}
		items.add(k);
		int i = items.size() - 1;
		while ((i != 0) && (items.get(getParent(i)) > items.get(i))) {
			swap(i, getParent(i), items);
			i = getParent(i);
		}
	}
	private void insertMaxHeap(int k) {
		if (items == null) {
			return;
		}
		items.add(k);
		int i = items.size() - 1;
		while ((i != 0) && (items.get(getParent(i)) < items.get(i))) {
			swap(i, getParent(i), items);
			i = getParent(i);
		}
	}
	public int getParent(int i, ArrayList<Integer> items) {
		int index = getParent(i);
		if ((items != null) && (index >= 0) && (items.size() >= index)) {
			return items.get(index);
		}
		return -1;
	}
	private int getParent(int i) {

		return (i - 1) / 2;
	}

	// to get index of left child of node at index i
	public int getLeft(int i, ArrayList<Integer> items) {
		int index = getLeft(i);
		if ((items != null) && (index >= 0) && (items.size() >= index)) {
			return items.get(index);
		}
		return -1;
	}
	private int getLeft(int i) {
		return (2 * i) + 1;

	}

	// to get index of right child of node at index i
	public int getRight(int i, ArrayList<Integer> items) {
		int index = getRight(i);
		if ((items != null) && (index >= 0) && (items.size() >= index)) {
			return items.get(index);
		}
		return -1;
	}
	private int getRight(int i) {
		return (2 * i) + 2;
	}
	private void heapify(int i, ArrayList<Integer> items) {
		if (items == null) {
			return;
		}
		if (minHeap) {
			minHeapify(i, items);
		} else {
			maxHeapify(i, items);
		}

	}
	private void minHeapify(int i, ArrayList<Integer> items) {
		if (items == null) {
			return;
		}
		int l = getLeft(i);
		int r = getRight(i);

		int size = items.size();
		int smallest = i;
		if ((l < size) && (items.get(l) < items.get(i))) {
			smallest = l;
		}
		if ((r < size) && (items.get(r) < items.get(smallest))) {
			smallest = r;
		}
		if (smallest != i) {
			swap(i, smallest, items);
			minHeapify(smallest, items);
		}
	}
	private void maxHeapify(int i, ArrayList<Integer> items) {
		if (items == null) {
			return;
		}
		int l = getLeft(i);
		int r = getRight(i);

		int size = items.size();
		int largest = i;
		if ((l < size) && (items.get(l) > items.get(i))) {
			largest = l;
		}
		if ((r < size) && (items.get(r) > items.get(largest))) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest, items);
			maxHeapify(largest, items);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
