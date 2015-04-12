package com.minhaz.algorithm.ds;

public class StandardTrie implements Trie {
	private final int NOT_FOUND = -1;

	@Override
	public void create(TrieNode trie, char[] chars, int index) {
		TrieNode temp = trie;
		for (int i = 0; i < chars.length; i++) {

			if (temp.childrens[chars[i] - 'a'] == null) {
				temp.childrens[chars[i] - 'a'] = new TrieNode(chars[i], index);

			}
			temp = temp.childrens[chars[i] - 'a'];

		}
	}

	@Override
	public int serch(TrieNode trie, char[] pattern) {
		// TODO Auto-generated method stub
		if (trie == null) {
			return NOT_FOUND;
		}

		for (int i = 0; i < pattern.length; i++) {
			if (trie != null) {
				if (i == (pattern.length - 1)) {
					TrieNode tmp = trie.childrens[pattern[i] - 'a'];
					if (tmp != null) {
						return tmp.startPoint;
					}
				} else {
					trie = trie.childrens[pattern[i] - 'a'];
				}
			}
		}

		return NOT_FOUND;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = {"box", "rock", "bull", "bat"};
		Trie trie = new StandardTrie();
		TrieNode node = new TrieNode();
		for (int i = 0; i < input.length; i++) {
			trie.create(node, input[i].toCharArray(), i);
		}
		System.out.println(trie.serch(node, "bat".toCharArray()));

	}
}
