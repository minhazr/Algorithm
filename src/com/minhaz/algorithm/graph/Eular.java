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
		// 1) All vertices with nonzero degree belong to a single strongly
		// connected component.
		StronglyConnected stronglyConnected = new StronglyConnected();
		if (!stronglyConnected.isStronglyConnected(graph)) {
			return false;
		}
		// 2) In degree and out degree of every vertex is same.
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
		// (1) All vertices with non-zero degree are connected.
		if (!isNonZeroDegreeVerticesConnected(graph)) {
			return false;
		}

		// (2) All vertices have even degree.
		int vertices = graph.countVertices();
		int odd = 0;
		for (int i = 0; i < vertices; i++) {
			if ((graph.getNeighbours(i).length & 1) == 1) {
				odd++;
			}
		}

		if (odd > 0) {
			return false;
		}
		return true;
	}
	private boolean hasEularPathDAG(Graph graph) {
		return false;
	}
	private boolean hasEularPathUndirected(Graph graph) {
		// (1) all vertices with non zero degree need to be connected
		if (isNonZeroDegreeVerticesConnected(graph)) {
			return false;
		}

		// (2) number of odd vertices has to be between zero to two
		int vertices = graph.countVertices();
		int odd = 0;
		for (int i = 0; i < vertices; i++) {
			// counting number of odd vertices
			if (((graph.getNeighbours(i).length & 1) == 1)) {
				odd++;
			}
		}

		if (odd <= 2) {
			return true;
		}
		return false;
	}
	private boolean isNonZeroDegreeVerticesConnected(Graph graph) {
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

		// (1) all vertices with non zero degree need to be connected
		for (i = 0; i < vertices; i++) {
			if ((visited[i] == false) && (graph.getNeighbours(i).length > 0)) {
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
		Graph graph = new AdjacentMatrix(5, false);
		graph.addPath(1, 0, 1);
		graph.addPath(1, 2, 1);
		graph.addPath(1, 4, 1);
		graph.addPath(1, 3, 1);
		graph.addPath(2, 4, 1);
		graph.addPath(3, 4, 1);
		Eular eular = new Eular();
		System.out.println(eular.hasEularPathUndirected(graph));

	}

}
