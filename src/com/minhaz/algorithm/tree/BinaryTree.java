package com.minhaz.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	/**
	 * Preorder traversal using stack
	 * 
	 * @param root
	 *            of the tree
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if ((node.left != null) && (node.right != null)) {
				stack.add(node.right);
				stack.add(node.left);
			} else if ((node.left != null) && (node.right == null)) {
				stack.add(node.left);
			} else if ((node.left == null) && (node.right != null)) {
				TreeNode rnode = node.right;
				stack.add(rnode);
			}
		}
		return list;

	}
	/**
	 * Binary Tree inorder taversal using stack.
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if ((temp.left == null) && (temp.right == null)) {
				list.add(temp.val);
				// stack.pop();
			} else if ((temp.left != null) && (temp.right != null)) {
				TreeNode temp1 = temp.left;
				temp.left = null;
				stack.push(temp);
				stack.push(temp1);

			} else if ((temp.left != null) && (temp.right == null)) {
				TreeNode temp1 = temp.left;
				temp.left = null;
				stack.push(temp);
				stack.push(temp1);
			} else if ((temp.left == null) && (temp.right != null)) {
				list.add(temp.val);
				TreeNode temp1 = temp.right;
				stack.push(temp1);
				// root=root.left;
			}
		}
		return list;

	}

	private List<Integer> list;
	/**
	 * level order traversal of binary tree
	 * 
	 * @param root
	 *            Root of the tree
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> listlist = new ArrayList<List<Integer>>();
		if (root == null) {
			return listlist;
		}

		int height = height(root);
		for (int i = 1; i <= height; i++) {
			list = new ArrayList<Integer>();
			listlist.add(levelOrder(root, i));
		}
		return listlist;
	}

	private List<Integer> levelOrder(TreeNode root, int level) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		if ((root != null) && (level == 1)) {
			list.add(root.val);
		} else if ((root != null) && (level > 1)) {
			levelOrder(root.left, level - 1);
			levelOrder(root.right, level - 1);
		}
		return list;
	}
	/**
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}, 
	 * 	3 
	 * / \ 
	 * 9 20 
	 * 	 / \ 
	 * 	15  7
	 * return its bottom-up level order traversal as: 
	 * [ [15,7], 
	 * [9,20], 
	 * [3] ]
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> reverseLevelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int treeHeight = height(root);
		if (treeHeight == 0) {
			return lists;
		}
		for (int i = treeHeight; i > 0; i--) {
			List<Integer> list = new ArrayList<Integer>();
			getLevel(root, i, list);
			lists.add(list);
		}
		return lists;

	}
	private void getLevel(TreeNode root, int n, List list) {
		// if (root==null) return null;
		if (n == 1) {
			list.add(root.val);
		}
		if (root.left != null) {
			getLevel(root.left, n - 1, list);
		}
		if (root.right != null) {
			getLevel(root.right, n - 1, list);
		}
	}
	/**
	 * Return max depth of binary tree
	 * @param root Root of the tree
	 * @return
	 */
	public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        
    }
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

}
