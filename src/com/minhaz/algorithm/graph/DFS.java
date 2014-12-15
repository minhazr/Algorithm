package com.minhaz.algorithm.graph;

import java.util.Stack;

import com.minhaz.algorithm.ds.Graph;

public class DFS {

	public static void doDfsR(Graph graph, int source, boolean[] visited) {
		visited[source] = true;
		int[] neighbours = graph.getNeighbours(source);
		for (int neighbour : neighbours) {
			if (!visited[neighbour]) {
				doDfsR(graph, neighbour, visited);
			}
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
			int[] neighbours = graph.getNeighbours(vertex, 0);
			for (int neighbour : neighbours) {
				stack.push(neighbour);
			}
		}

	}
	/**
	 * Do a standard DFS on given Graph. Returned Stack fill with vertices in
	 * traversing order. For example: if for node u,v and u is traversed before
	 * v u added to stack first.
	 * 
	 * @param graph
	 *            Graph for DFS
	 * @param source
	 *            starting vertices
	 * @param visited
	 *            boolean array to keep track if a node is visited or not
	 * @return vertices in stack
	 */
	public static void getDfsOrder(Graph graph, int source, boolean[] visited,
			Stack<Integer> stack) {

		stack.add(source);
		visited[source] = true;
		int[] neighbours = graph.getNeighbours(source);
		for (int neighbour : neighbours) {
			if (!visited[neighbour]) {
				getDfsOrder(graph, neighbour, visited, stack);
			}
		}

	}

	/**
	 * Do a standard DFS on given Graph. Returned Stack fill with vertices in
	 * reverse order. For example: For node u,v and u is traversed before v, v
	 * added to stack first.
	 * 
	 * @param graph
	 *            Graph for DFS
	 * @param source
	 *            starting vertices
	 * @param visited
	 *            boolean array to keep track if a node is visited or not
	 */
	public static void getDfsRevereseOrder(Graph graph, int source,
			boolean[] visited, Stack<Integer> stack) {

		visited[source] = true;
		int[] neighbours = graph.getNeighbours(source);
		for (int neighbour : neighbours) {
			if (!visited[neighbour]) {
				getDfsRevereseOrder(graph, neighbour, visited, stack);
			}
		}
		stack.add(source);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
