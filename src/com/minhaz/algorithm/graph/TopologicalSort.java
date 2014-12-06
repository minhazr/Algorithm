package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

import com.minhaz.algorithm.ds.AdjacentList;
import com.minhaz.algorithm.ds.Graph;

public class TopologicalSort {

	private boolean[] visited;
	private List<Integer> stack;
	private Graph graph;

	public TopologicalSort(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.countVertices()];
		stack = new ArrayList<Integer>();
		for (int i = 0; i < graph.countVertices(); i++) {
			visited[i] = false;
		}
	}

	public List<Integer> sort() {
		for (int i = 0; i < graph.countVertices(); i++) {
			if (!visited[i]) {
				sortUtil(i);
			}
		}
		return stack;
	}
	private void sortUtil(int vertex) {
		visited[vertex] = true;
		int[] neighbours = graph.getNeighbours(vertex);
		for (int neighbour : neighbours) {
			if (!visited[vertex]) {
				sortUtil(neighbour);
			}

		}
		// System.out.println("Adding in stack " + vertex);
		stack.add(vertex);

	}
	public void printSort(List<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
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

		TopologicalSort tSort = new TopologicalSort(graph);
		List<Integer> list = tSort.sort();
		tSort.printSort(list);

	}
}
