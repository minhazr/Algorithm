package com.minhaz.algorithm.ds.tree;

import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static java.lang.Math.pow;

import java.util.Arrays;

public class SegmentTree {

	private int[] treeItems;
	private int[] inputItems;
	int itemCount;

	public void construct(int[] inputs) {
		int height = (int) (ceil(log(inputs.length) / log(2)));
		int size = (2 * (int) pow(2, height)) - 1;
		this.treeItems = new int[size];
		itemCount = inputs.length;
		inputItems = inputs;

		constructUtil(inputs, 0, inputs.length - 1, treeItems, 0);
		// return this.items;
		
		printArray();

	}
	private void printArray(){
		System.out.println(Arrays.toString(treeItems));
	}
	/**
	 * 
	 * @param inputs
	 * @param ss
	 *            Segment Start
	 * @param se
	 *            Segment end
	 * @param treeItems
	 *            output Tree items
	 * @param si
	 *            Segment index
	 */
	private int constructUtil(int[] inputs, int ss, int se, int[] treeItems,
			int si) {
		if (ss == se) {
			treeItems[si] = inputs[ss];
			return inputs[ss];
		}

		int mid = getMid(ss, se);
		treeItems[si] = constructUtil(inputs, ss, mid, treeItems, (si * 2) + 1)
				+ constructUtil(inputs, mid + 1, se, treeItems, (si * 2) + 2);
		return treeItems[si];

	}
	private int getMid(int s, int e) {
		return s + ((e - s) / 2);
	}

	public int getSum(int qs, int qe) {
		// Check for erroneous input values
		int size = getTotalItem() - 1;
		if ((qs < 0) || (qe > size) || (qs > qe)) {
			return -1;
		}

		return getSumUtil(this.treeItems, 0, size, qs, qe, 0);
	}

	private int getSumUtil(int[] tree, int ss, int se, int qs, int qe, int si) {
		// If segment of this node is a part of given range, then return the
		// sum of the segment
		if ((qs <= ss) && (qe >= se)) {
			return tree[si];
		}

		// If segment of this node is outside the given range
		if ((se < qs) || (ss > qe)) {
			return 0;
		}

		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return getSumUtil(tree, ss, mid, qs, qe, (2 * si) + 1)
				+ getSumUtil(tree, mid + 1, se, qs, qe, (2 * si) + 2);
	}
	public int getTotalItem() {
		return itemCount;
	}
	private int[] getInputItems() {
		return inputItems;
	}
	public void updateValue(int i, int new_val) {
		// Check for erroneous input index
		int size = getTotalItem();
		int[] arr = getInputItems();
		if ((i < 0) || (i > (size - 1))) {
			return;
		}

		// Get the difference between new value and old value
		int diff = new_val - arr[i];

		// Update the value in array
		arr[i] = new_val;

		// Update the values of nodes in segment tree
		updateValueUtil(this.treeItems, 0, size - 1, i, diff, 0);
	}
	private void updateValueUtil(int[] tree, int ss, int se, int i, int diff,
			int index) {
		// Base Case: If the input index lies outside the range of this segment
		if ((i < ss) || (i > se)) {
			return;
		}

		// If the input index is in range of this node, then update the value
		// of the node and its children
		tree[index] = tree[index] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(tree, ss, mid, i, diff, (2 * index) + 1);
			updateValueUtil(tree, mid + 1, se, i, diff, (2 * index) + 2);
		}
	}

	public int getRangeMinimum(int qs, int qe) {
		int size = getTotalItem();
		if ((qs < 0) || (qe > (size - 1)) || (qs > qe)) {
			return -1;
		}

		return rmqUtil(this.treeItems, 0, size - 1, qs, qe, 0);
	}
	private int rmqUtil(int[] tree, int ss, int se, int qs, int qe, int root) {

		if ((qs <= ss) && (qe >= se)) {
			return tree[root];
		}

		// If segment of this node is outside the given range
		if ((se < qs) || (ss > qe)) {
			return Integer.MAX_VALUE;
		}

		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return Math.min(rmqUtil(tree, ss, mid, qs, qe, (2 * root) + 1),
				rmqUtil(tree, mid + 1, se, qs, qe, (2 * root) + 2));

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		SegmentTree tree = new SegmentTree();
		tree.construct(arr);
		
		


//		System.out.println(tree.getSum(1, 3));
//
//		tree.updateValue(1, 10);
//
//		System.out.println(tree.getSum(1, 3));
//
//		int[] input = {1, 3, 2, 7, 9, 11};
//		SegmentTree rmqTree = new SegmentTree();
//		rmqTree.construct(input);
//
//		System.out.println(rmqTree.getRangeMinimum(1, 5));

	}

}
