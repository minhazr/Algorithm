package com.minhaz.algorithm.problem.graph;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;
import com.minhaz.algorithm.graph.Eular;

/**
 * 
 * 
 * Problem Statement
 * 
 * Given an array of strings, find if the given strings can be chained to form a
 * circle.
 * 
 * Input: arr[] = {"for", "geek", "rig", "kaf"} Output: Yes,
 * 
 * Input: arr[] = {"aaa", "bbb"}; Output: No
 * 
 */
public class StringChain {

	public boolean canBeChained(String[] input) {
		Graph graph = new AdjacentMatrix(26, true);
		for (String str : input) {
			graph.addPath(str.charAt(0) - 'a',
					str.charAt(str.length() - 1) - 'a', 1);
		}
		Eular eular = new Eular();
		return eular.hasEularCircuit(graph);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1 = {"geek", "king"};
		String[] input2 = {"for", "geek", "rig", "kaf"};
		String[] input3 = {"aab", "bac", "aaa", "cda"};
		String[] input4 = {"aaa", "bbb", "baa", "aab"};
		String[] input5 = {"aaa"};
		String[] input6 = {"aaa", "bbb"};

		StringChain chain = new StringChain();
		System.out.println(chain.canBeChained(input6));

	}

}
