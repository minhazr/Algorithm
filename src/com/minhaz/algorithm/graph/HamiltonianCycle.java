package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

/**
 *
 * uses backtracking algorithm
 *
 */
public class HamiltonianCycle {

	public boolean isHamiltonianCycle(Graph graph) {
		int vertices = graph.countVertices();
		int[] paths = new int[vertices];
		Arrays.fill(paths, -1);
		paths[0] = 0;
		if (!hamCycleUtil(graph, paths, 1)) {
			return false;
		}
		return true;

	}

	private boolean hamCycleUtil(Graph graph, int[] paths, int position) {
		int vertices = graph.countVertices();
		// if done visiting all vertices and there is path from first to last.
		if (position == vertices) {
			if (graph.hasPath(paths[position - 1], paths[0])) {
				return true;
			}
			return false;
		}

		int[] neighbours=graph.getNeighbours(paths[position-1]);
		for (int neightbor:neighbours){
			if (notIncludedInPath(neightbor, paths, position)){
				paths[position] = neightbor;
				if (hamCycleUtil(graph, paths, position + 1)) {
					return true;
				}
				paths[position] = -1;
			}
		}

//		for (int vertex = 1; vertex < vertices; vertex++) {
//			if (graph.hasPath(paths[position-1], vertex) && notincludedInCycle(vertex, paths, position)) {
//				paths[position] = vertex;
//				if (hamCycleUtil(graph, paths, position + 1)) {
//					return true;
//				}
//				paths[position] = -1;
//			}
//		}

		return false;
	}

	private boolean notIncludedInPath(int vertex, int[] path, int position) {

		for (int i = 0; i < position; i++) {
			// if already included return false
			if (path[i] == vertex) {
				return false;
			}
		}

		return true;
	}

	// public boolean isHamiltonianCycle(Graph graph, boolean recusive) {
	// int vertices = graph.countVertices();
	// boolean[] visited = new boolean[vertices];
	// for (int vertex = 0; vertex <= vertices; vertex++) {
	// int[] neighbours = graph.getNeighbours(vertex);
	//
	// }
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph1 = new AdjacentMatrix(5, false);

		graph1.addPath(0, 1, 1);
		graph1.addPath(0, 3, 1);

		// graph1.addPath(1, 0, 1);
		graph1.addPath(1, 2, 1);
		graph1.addPath(1, 3, 1);
		graph1.addPath(1, 4, 1);

		graph1.addPath(2, 4, 1);
		graph1.addPath(3, 4, 1);
		graph1.printGraph();

		HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();

		System.out.println(hamiltonianCycle.isHamiltonianCycle(graph1));

		Graph graph2 = new AdjacentMatrix(5, false);

		graph2.addPath(0, 1, 1);
		graph2.addPath(0, 3, 1);

		// graph1.addPath(1, 0, 1);
		graph2.addPath(1, 2, 1);
		graph2.addPath(1, 3, 1);
		graph2.addPath(1, 4, 1);

		graph2.addPath(2, 4, 1);

		// graph2.printGraph();

		System.out.println(hamiltonianCycle.isHamiltonianCycle(graph2));

	}

}
