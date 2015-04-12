package com.minhaz.algorithm.ds.tree;

public class BTree {
	private final int DEGREE;
	private BTreeNode root;
	public BTree(int degree) {
		this.DEGREE = degree;
	}

	public void insert(int item) {
		root = insert(root, item);
	}

	private BTreeNode insert(BTreeNode node, int item) {
		if (node == null) {
			node = new BTreeNode(DEGREE, false);
			node.keys[0] = item;
			node.n = 1;
		} else {

			if (node.n == ((2 * DEGREE) - 1)) {
				BTreeNode newRoot = new BTreeNode(DEGREE, false);
				newRoot.nodes[0] = root;
			}

		}
		return node;
	}
	private BTreeNode splitChild(int i, BTreeNode node){
		
		BTreeNode child=new BTreeNode(DEGREE, node.leaf);
		child.n=DEGREE-1;
		
		 // Copy the last (t-1) keys of y to z
	    for (int j = 0; j < (DEGREE-1); j++) {
			child.keys[j] = node.keys[j+DEGREE];
		}
	    
	    if (!node.leaf)
	    {
	        for (int j = 0; j < DEGREE; j++) {
				child.nodes[j] = node.nodes[j+DEGREE];
			}
	    }
	 // Reduce the number of keys in y
	    node.n = DEGREE - 1;
	 
	    // Since this node is going to have a new child,
	    // create space of new child
	    for (int j = n; j >= (i+1); j--) {
			C[j+1] = C[j];
		}
	 
	    // Link the new child to this node
	    C[i+1] = z;
	 
	    // A key of y will move to this node. Find location of
	    // new key and move all greater keys one space ahead
	    for (int j = n-1; j >= i; j--) {
			keys[j+1] = keys[j];
		}
	 
	    // Copy the middle key of y to this node
	    keys[i] = y->keys[t-1];
	 
	    // Increment count of keys in this node
	    n = n + 1;
		
		return null;
	}
	class BTreeNode {
		int[] keys; // An array of keys
		// Minimum degree (defines the range for number of keys)
		BTreeNode[] nodes;
		// An array of child pointers
		int n; // Current number of keys
		boolean leaf; // Is true when node is leaf. Otherwise false

		BTreeNode(int degree, boolean leaf) {
			keys = new int[degree];
			nodes = new BTreeNode[degree];
			this.leaf = leaf;
		}
	}

}
