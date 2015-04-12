package com.minhaz.algorithm.ds;

public class TrieNode {
	private static final int ALPHABET_SIZE = 26;
	public int startPoint;
	private char item;
	public TrieNode[] childrens = new TrieNode[ALPHABET_SIZE];
	public TrieNode() {
		// Arrays.fill(childrens, null);
		// childrens = new TrieNode[ALPHABET_SIZE];
		super();

	}
	public TrieNode(char key, int startIndex) {

		childrens[key - 'a'] = new TrieNode();
		this.startPoint = startIndex;
		// this.value = value;
	}

}
