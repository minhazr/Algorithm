package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class Eular {

	public boolean hasEularCircuit(Graph graph) {

		if (graph.isDirected()) {
			return hasEularCircuitDAG(graph);
		} else {
			return hasEularCircuitUndirected(graph);
		}

	}
	public boolean hasEularPath(Graph graph) {

		if (graph.isDirected()) {
			return hasEularPathDAG(graph);
		} else {
			return hasEularPathUndirected(graph);
		}

	}

	private boolean hasEularCircuitDAG(Graph graph) {
		StronglyConnected stronglyConnected = new StronglyConnected();
		if (!stronglyConnected.isStronglyConnected(graph)) {
			return false;
		}
		int[] in = graph.countIndgree();
		int vertices = graph.countVertices();
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (graph.getAdjacentVertices(vertex).size() != in[vertex]) {
				return false;
			}
		}
		return true;
	}
	private boolean hasEularCircuitUndirected(Graph graph) {
		if (!hasEularPathUndirected(graph)) {
			return false;
		}
		int vertices = graph.countVertices();

		int odd = 0;
		for (int i = 0; i < vertices; i++) {
			if ((graph.getNeighbours(i).length & 1) == 1) {
				odd++;
			}
		}

		if (odd > 2) {
			return false;
		}
		return true;
	}
	private boolean hasEularPathDAG(Graph graph) {
		return false;
	}
	private boolean hasEularPathUndirected(Graph graph) {
		int i = 0;
		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		// Find a vertex with non-zero degree
		for (i = 0; i < vertices; i++) {
			if (graph.getNeighbours(i).length != 0) {
				break;
			}
		}

		// If there are no edges in the graph, return true, coz non zero edge
		// already considered eular
		if (i == vertices) {
			return true;
		}

		// Start DFS traversal from a vertex with more then zero edge
		DFS.doDfsR(graph, i, visited);
		// dfsUtil(i);

		for (i = 0; i < vertices; i++) {
			if (!visited[i] && (graph.getNeighbours(i).length > 0)) {
				return false;
			}
		}
		return true;
	}

	// public void dfsUtil(int vetex) {
	// visited[vetex] = true;
	// for (int i : graph.getNeighbours(vetex)) {
	// dfsUtil(i);
	// }
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new AdjacentMatrix(5, true);
		graph.addPath(1, 0, 1);
		graph.addPath(0, 2, 1);
		graph.addPath(2, 1, 1);
		graph.addPath(0, 3, 1);
		graph.addPath(3, 4, 1);
		graph.addPath(4, 0, 1);
		Eular eular = new Eular();
		System.out.println(eular.hasEularCircuitDAG(graph));

	}

}
