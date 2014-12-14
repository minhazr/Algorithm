package com.minhaz.algorithm.graph;

import java.util.Stack;

import com.minhaz.algorithm.ds.Graph;

public class DFS {

	public static void doDfsR(Graph graph, int source, boolean[] visited) {
		visited[source] = true;
		int[] neighbours = graph.getNeighbours(source);
		for (int neighbour : neighbours) {
			doDfsR(graph, neighbour, visited);
		}

	}
	public static void doDfsS(Graph graph, int source, boolean[] visited) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(source);
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (visited[vertex]) {
				continue;
			}
			visited[vertex] = true;
			int[] neighbours = graph.getNeighbours(vertex);
			for (int neighbour : neighbours) {
				stack.push(neighbour);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
