package com.minhaz.algorithm.ds.tree;

public interface Tree {
	public int height();
	public TreeNode leftRotate(TreeNode tree);
	public TreeNode rightRotate(TreeNode tree);
	public void printInorder(TreeNode tree);
	public TreeNode insert(TreeNode tree, int key);
	/**
	 * Interval tree insert operation.
	 * 
	 * @param tree
	 *            Root node of the tree
	 * @param interval
	 *            Interval to be inserted
	 * @return newly inserted node
	 */
	public TreeNode insert(TreeNode tree, Interval interval);
	/**
	 * Interval Tree operation to check if given Interval overlapped with
	 * available Interval in Tree
	 * 
	 * @param tree
	 *            Root of the tree
	 * @param interval
	 *            Interval to check
	 * @return True if interval overlapped; False if interval doesn't overlapped
	 */
	public boolean isOverLap(TreeNode tree, Interval interval);
	public boolean isAvailable(TreeNode root, int key);
	public TreeNode find(TreeNode root, int key);

}
