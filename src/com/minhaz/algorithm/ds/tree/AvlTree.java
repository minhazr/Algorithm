package com.minhaz.algorithm.ds.tree;

public class AvlTree {
	private AVLTreeNode root = null;

	public int getHeight() {
		return height(root);
	}
	private int height(AVLTreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return tree.height;
	}

	private AVLTreeNode leftRotate(AVLTreeNode tree) {
		AVLTreeNode right = tree.right;
		AVLTreeNode childLeft = right.left;
		tree.right = childLeft;
		right.left = tree;

		int leftHeight = tree.left == null ? 0 : tree.left.height;
		int rightHeight = tree.right == null ? 0 : tree.right.height;
		tree.height = (Math.max(leftHeight, rightHeight) + 1);

		int leftChildHeight = right.left == null ? 0 : right.left.height;
		int rightChildHeight = right.right == null ? 0 : right.right.height;
		right.height = (Math.max(leftChildHeight, rightChildHeight) + 1);

		return right;
	}

	private AVLTreeNode rightRotate(AVLTreeNode tree) {
		AVLTreeNode leftChild = tree.left;
		AVLTreeNode leftChildRight = leftChild.right;
		tree.left = leftChildRight;
		leftChild.right = tree;

		int leftHeight = tree.left == null ? 0 : tree.left.height;
		int rightHeight = tree.right == null ? 0 : tree.right.height;

		tree.height = (Math.max(leftHeight, rightHeight) + 1);

		int leftChildHeight = leftChild.left == null
				? 0
				: leftChild.left.height;
		int rightChildHeight = leftChild.right == null
				? 0
				: leftChild.right.height;
		leftChild.height = (Math.max(leftChildHeight, rightChildHeight) + 1);

		return leftChild;
	}

	public void inorder() {
		printInorder(root);
	}
	public void printInorder(AVLTreeNode tree) {
		if (tree != null) {
			printInorder(tree.left);
			System.out.print("{ value=" + tree.value + " Height=" + tree.height
					+ "} ");
			printInorder(tree.right);
		}

	}

	public void insert(int item) {
		root = insert(root, item);
	}
	private AVLTreeNode insert(AVLTreeNode tree, int value) {
		// tree is null
		if (tree == null) {
			tree = new AVLTreeNode(value);

			tree.height = 1;
			return tree;
		}
		// perform standard BST operation
		if (tree.value < value) {
			tree.right = insert(tree.right, value);
		} else if (tree.value > value) {
			tree.left = insert(tree.left, value);
		}
		// update height
		int leftHeight = tree.left == null ? 0 : tree.left.height;
		int rightHeight = tree.right == null ? 0 : tree.right.height;
		tree.height = (Math.max(leftHeight, rightHeight) + 1);

		int balance = leftHeight - rightHeight;

		if (balance > 1) {
			// left left case
			if (value < tree.left.value) {
				return rightRotate(tree);
			}
			// left right case
			if (value > tree.left.value) {
				tree.left = (leftRotate(tree.left));
				rightRotate(tree);
			}
		}
		if (balance < -1) {
			// right right case
			if (value > tree.right.value) {
				return leftRotate(tree);
			}
			// right left case
			if (value < tree.right.value) {
				tree.left = rightRotate(tree.left);
				leftRotate(tree);
			}

		}
		return tree;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvlTree avl = new AvlTree();
		TreeNode root = null;
		avl.insert(20);
		avl.insert(15);
		avl.insert(10);
		avl.insert(5);
		avl.insert(1);
		avl.inorder();

	}

	class AVLTreeNode {
		AVLTreeNode left;
		AVLTreeNode right;
		int height;
		int value;

		AVLTreeNode(int item) {
			this.value = item;
		}

	}

}
