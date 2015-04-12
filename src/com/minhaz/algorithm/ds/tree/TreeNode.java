package com.minhaz.algorithm.ds.tree;

public class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private int height;
	private int value;

	// Required for B Tree
	private int[] keys;
	private TreeNode[] childrens;
	private boolean leaf;
	private int totalKeys;

	// required for Interval tree
	private Interval interval;
	private int max;

	public TreeNode() {
		super();
	}
	public TreeNode(Interval interval) {
		super();
		this.interval = interval;
	}
	public TreeNode(int bTreeSize) {
		keys = new int[(2 * bTreeSize) - 1];
		childrens = new TreeNode[(2 * bTreeSize) - 1];
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
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the keys
	 */
	public int[] getKeys() {
		return keys;
	}
	/**
	 * @param keys
	 *            the keys to set
	 */
	public void setKeys(int[] keys) {
		this.keys = keys;
	}
	/**
	 * @return the childrens
	 */
	public TreeNode[] getChildrens() {
		return childrens;
	}
	/**
	 * @param childrens
	 *            the childrens to set
	 */
	public void setChildrens(TreeNode[] childrens) {
		this.childrens = childrens;
	}
	public void addChildrens(TreeNode children) {
		int i;
		for (i = 0; i < childrens.length; i++) {
			if (childrens[i] == null) {
				break;
			}
		}
		childrens[i] = children;
	}
	/**
	 * @return the leaf
	 */
	public boolean isLeaf() {
		return leaf;
	}
	/**
	 * @param leaf
	 *            the leaf to set
	 */
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	/**
	 * @return the totalKeys
	 */
	public int getTotalKeys() {
		return totalKeys;
	}
	/**
	 * @param totalKeys
	 *            the totalKeys to set
	 */
	public void setTotalKeys(int totalKeys) {
		this.totalKeys = totalKeys;
	}
	public void incrementTotalKeys() {
		this.totalKeys++;
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

}
