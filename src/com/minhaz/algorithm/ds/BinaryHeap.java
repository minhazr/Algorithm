package com.minhaz.algorithm.ds;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeap {

	int data;
	BinaryHeap left;
	BinaryHeap right;

	BinaryHeap(int value) {
		this.data = value;
	}

	public BinaryHeap add(BinaryHeap root, int value) {
		if (root == null) {
			return new BinaryHeap(value);
		}
		Queue<BinaryHeap> queue = new LinkedList<BinaryHeap>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryHeap node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
			} else {
				node.left = new BinaryHeap(value);
				return root;
			}
			if (node.right != null) {
				queue.add(node.left);
				return root;
			} else {
				node.right = new BinaryHeap(value);
			}
		}
		return null;

	}
	public void heapify(BinaryHeap root) {
		if (root == null) {
			return;
		}
		heapify(root.left);
		if (root.left != null) {
			if (root.left.data < root.data) {

			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
