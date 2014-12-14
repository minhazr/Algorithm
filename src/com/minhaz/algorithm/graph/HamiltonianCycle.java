package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class HamiltonianCycle {

	public boolean isHamiltonianCycle(Graph graph) {
		int vertices = graph.countVertices();
		int[] path = new int[vertices];
		Arrays.fill(path, -1);
		path[0] = 0;
		if (!hamCycleUtil(graph, path, 1)) {
			return false;
		}
		return true;

	}

	private boolean hamCycleUtil(Graph graph, int[] path, int position) {
		int vertices = graph.countVertices();
		if (position == vertices) {
			if (graph.hasPath(path[position - 1], path[0])) {
				return true;
			}
			return false;
		}

		for (int vertex = 1; vertex < graph.countVertices(); vertex++) {
			if (isSafe(vertex, graph, path, position)) {
				path[position] = vertex;
				if (hamCycleUtil(graph, path, position + 1)) {
					return true;
				}
				path[position] = -1;
			}
		}

		return false;
	}

	private boolean isSafe(int vertex, Graph graph, int[] path, int position) {
		if (!graph.hasPath(path[position - 1], vertex)) {
			return false;
		}
		for (int i = 0; i < position; i++) {
			if (path[i] == vertex) {
				return false;
			}
		}

		return true;
	}

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
