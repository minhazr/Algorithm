package com.minhaz.algorithm.ds.tree;

public class IntervalTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int height(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return Math.max(height(tree.getLeft()), height(tree.getRight())) + 1;
	}

	public void printInorder(TreeNode tree) {
		if (tree == null) {
			return;
		}
		printInorder(tree.getLeft());
		System.out.println("[" + tree.getInterval().getLow() + ", "
				+ tree.getInterval().getHigh() + "]");
		printInorder(tree.getRight());

	}

	public TreeNode insert(TreeNode tree, Interval interval) {
		if (tree == null) {
			tree = new TreeNode(interval);
		}
		int low = tree.getInterval().getLow();
		if (interval.getLow() < low) {
			tree = insert(tree.getLeft(), interval);
		}
		if (interval.getLow() > low) {
			tree = insert(tree.getRight(), interval);
		}
		if (tree.getMax() < interval.getHigh()) {
			tree.setMax(interval.getHigh());
		}
		return tree;
	}

	public boolean isOverLap(TreeNode tree, Interval interval) {
		// when tree is empty, it can't overlapped.
		if (tree == null) {
			return false;
		}
		Interval treeInterval = tree.getInterval();
		if ((treeInterval.getHigh() >= interval.getLow())
				&& (treeInterval.getLow() <= interval.getHigh())) {
			return true;
		}
		if ((tree.getLeft() != null)
				&& (tree.getLeft().getMax() >= interval.getLow())) {
			return isOverLap(tree.getLeft(), treeInterval);
		}
		return isOverLap(tree.getRight(), treeInterval);
	}
	public class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private Interval interval;
		private int max;
		public TreeNode() {
			super();
		}
		public TreeNode(Interval interval) {
			super();
			this.interval = interval;
		}
		/**
		 * @return the left
		 */
		public TreeNode getLeft() {
			return left;
		}
		/**
		 * @param left
		 *            the left to set
		 */
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		/**
		 * @return the right
		 */
		public TreeNode getRight() {
			return right;
		}
		/**
		 * @param right
		 *            the right to set
		 */
		public void setRight(TreeNode right) {
			this.right = right;
		}
		/**
		 * @return the interval
		 */
		public Interval getInterval() {
			return interval;
		}
		/**
		 * @param interval
		 *            the interval to set
		 */
		public void setInterval(Interval interval) {
			this.interval = interval;
		}
		/**
		 * @return the max
		 */
		public int getMax() {
			return max;
		}
		/**
		 * @param max
		 *            the max to set
		 */
		public void setMax(int max) {
			this.max = max;
		}

	}

}
