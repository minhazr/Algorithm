package com.minhaz.algorithm.graph;

import java.util.Arrays;
import java.util.Stack;

import com.minhaz.algorithm.ds.AdjacentList;
import com.minhaz.algorithm.ds.Graph;

/**
 * Topological sort, is the path in graph where parent node accessed before
 * child node http://en.wikipedia.org/wiki/Topological_sorting
 * 
 */
public class TopologicalSort {

	public Stack<Integer> sort(Graph graph) {
		int vertices = graph.countVertices();

		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<Integer>();
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!visited[vertex]) {
				sortUtil(graph, vertex, visited, stack);
			}
		}
		return stack;
	}
	private void sortUtil(Graph graph, int vertex, boolean[] visited,
			Stack<Integer> stack) {
		visited[vertex] = true;
		int[] neighbours = graph.getNeighbours(vertex);
		for (int neighbour : neighbours) {
			if (!visited[neighbour]) {
				sortUtil(graph, neighbour, visited, stack);
			}
		}
		stack.push(vertex);

	}
	public void printSort(Stack<Integer> stack) {
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.indexOf(i) + " ");
		}
		System.out.println("");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new AdjacentList(6, true);
		graph.addPath(5, 2);
		graph.addPath(5, 0);
		graph.addPath(4, 0);
		graph.addPath(4, 1);
		graph.addPath(2, 3);
		graph.addPath(3, 1);
		System.out.println(Arrays.toString(graph.getNeighbours(2)));

		TopologicalSort tSort = new TopologicalSort();

		tSort.printSort(tSort.sort(graph));

	}
}
