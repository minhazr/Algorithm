package com.minhaz.algorithm.ds.tree;

public class BinarySearchTree {
	private TreeNode root;

	public void insert(int item) {
		root = insert(root, item);

	}

	private TreeNode insert(TreeNode node, int item) {
		if (node == null) {
			node = new TreeNode(item);
		} else {
			if (item > node.data) {
				node.right = insert(node.right, item);
			} else {
				node.left = insert(node.left, item);
			}
		}
		return node;
	}
	public void preorder() {
		preorder(root);
	}
	private void preorder(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		inorder(node.left);
		inorder(node.right);
	}
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		inorder(node.right);
		System.out.print(node.data + " ");
	}

	public void inorder() {
		inorder(root);
	}
	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public void delete(int item) {
		root = delete(root, item);
	}
	private TreeNode delete(TreeNode node, int item) {
		if (node == null) {
			return node;
		}

		if (node.data < item) {
			node.right = delete(node.right, item);
		}
		if (node.data > item) {
			node.left = delete(node.left, item);
		} else {
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}

			TreeNode temp = minValueNode(node.right);
			node.data = temp.data;
			node.right = delete(node.right, temp.data);
		}
		return node;
	}

	public TreeNode minValueNode(TreeNode node) {
		TreeNode current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(15);
		bst.insert(25);
		bst.insert(10);
		bst.insert(22);
		bst.inorder();
		System.out.println();
		bst.preorder();
		System.out.println();
		bst.postOrder();

		bst.delete(20);
		bst.inorder();
	}

	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;
		public TreeNode(int item) {
			this.data = item;
		}
	}

}
