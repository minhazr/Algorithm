package com.minhaz.algorithm.graph;

import java.util.Arrays;
import java.util.Stack;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

/**
 * 
 * Problem Statement
 * 
 * A directed graph is strongly connected if there is a path between all pairs
 * of vertices.
 * 
 */
public class StronglyConnected {

	public boolean isStronglyConnected(Graph graph) {
		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);

		int vertex = 0;
		// find first non zero degree vertex
		for (vertex = 0; vertex < vertices; vertex++) {
			if (graph.getAdjacentVertices(vertex).size() > 0) {
				break;
			}
		}
		DFS.doDfsR(graph, vertex, visited);
		// if any non zero degree vertices is not travarsed return false
		for (int u = 0; u < vertices; u++) {
			if ((graph.getAdjacentVertices(u).size() > 0) && !visited[vertex]) {
				return false;
			}
		}

		Graph transpose = graph.getTranspose();

		Arrays.fill(visited, false);
		DFS.doDfsR(transpose, vertex, visited);

		for (vertex = 0; vertex < vertices; vertex++) {
			if ((transpose.getAdjacentVertices(vertex).size() > 0)
					&& !visited[vertex]) {
				return false;
			}
		}

		return true;
	}

	public void getStronglyConnectedComponents(Graph graph) {
		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<Integer>();
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!visited[vertex]) {
				DFS.getDfsRevereseOrder(graph, vertex, visited, stack);
			}
		}
		Graph transpose = graph.getTranspose();
		Arrays.fill(visited, false);

		Stack<Integer> result = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (!visited[vertex]) {
				DFS.getDfsOrder(transpose, vertex, visited, result);
			}
			printSort(result);
			result.clear();
		}

	}
	public void printSort(Stack<Integer> stack) {
		if (stack.size() <= 0) {
			return;
		}
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println("");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new AdjacentMatrix(5, true);
		graph.addPath(1, 0, 1);
		graph.addPath(0, 2, 1);
		graph.addPath(2, 1, 1);
		graph.addPath(0, 3, 1);
		graph.addPath(3, 4, 1);
		StronglyConnected stronglyConnected = new StronglyConnected();
		stronglyConnected.getStronglyConnectedComponents(graph);

		System.out.println(stronglyConnected.isStronglyConnected(graph));
		graph.addPath(4, 0, 1);
		System.out.println(stronglyConnected.isStronglyConnected(graph));

	}

}
