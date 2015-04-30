package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.EdgeList;
import com.minhaz.algorithm.ds.Graph;

/**
 * This is Eular for undirected graph
 *
 */
public class EularUGraph {

	public boolean hasEular(Graph graph) {
		// (1) If there are no edges in the graph, return true, coz non zero
		// edge already considered eular
		int vertices = graph.countVertices();
		int i = 0;
		int[] x = new int[]{1, 5};
		for (i = 0; i < vertices; i++) {
			if (graph.getNeighbours(i).length != 0) {
				break;
			}
		}
		if (i == vertices) {
			return true;
		}
		// (2) All vertices with non-zero degree are connected.
		if (!isNonZeroDegreeVerticesConnected(graph)) {
			return false;
		}

		// (3) All vertices have even degree.
		// int vertices = graph.countVertices();
		int odd = 0;
		for (i = 0; i < vertices; i++) {
			if ((graph.getNeighbours(i).length & 1) == 1) {
				odd++;
			}
		}

		if (odd > 0) {
			return false;
		}
		return true;
	}
	
	
	public boolean hasPath(Graph graph) {
		// (1) all vertices with non zero degree need to be connected
		if (!isNonZeroDegreeVerticesConnected(graph)) {
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

		// (1) all vertices with non zero degree need to be visited/connected
		for (i = 0; i < vertices; i++) {
			if ((!visited[i]) && (graph.getNeighbours(i).length > 0)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new EdgeList();
		graph.addPath(1, 0, 1);
		graph.addPath(1, 2, 1);
		graph.addPath(1, 4, 1);
		graph.addPath(1, 3, 1);
		graph.addPath(2, 4, 1);
		graph.addPath(3, 4, 1);
		EularUGraph eular = new EularUGraph();
		System.out.println(eular.hasPath(graph));

	}

}
