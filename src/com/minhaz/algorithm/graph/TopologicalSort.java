package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.minhaz.algorithm.ds.AdjacentList;
import com.minhaz.algorithm.ds.Graph;

/**
 * Topological sort, is the path in graph where parent node accessed before
 * child node http://en.wikipedia.org/wiki/Topological_sorting
 * 
 */
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
		int graphSize = graph.countVertices();
		for (int i = 0; i < graphSize; i++) {
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
			if (!visited[neighbour]) {
				sortUtil(neighbour);
			}
		}
		stack.add(vertex);

	}
	public void printSort(List<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
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

		TopologicalSort tSort = new TopologicalSort(graph);
		List<Integer> list = tSort.sort();
		tSort.printSort(list);

	}
}
