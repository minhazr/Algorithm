package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Edge;
import com.minhaz.algorithm.ds.Graph;

/**
 * 
 * Uses ford fulkerson algorithim.
 * 
 */

public class StCut {

	public List<Edge> minimumCut(Graph graph, int s, int t) {
		int vertices = graph.countVertices();
		Graph residualGraph = new AdjacentMatrix(graph);
		int[] parent = new int[vertices];
		FordFulkerson fordFulkerson = new FordFulkerson();
		int max_flow = 0;
		int source, destination;

		while (fordFulkerson.hasAugmentedPath(residualGraph, s, t, parent)) {
			int path_flow = Integer.MAX_VALUE;
			for (destination = t; destination != s; destination = parent[destination]) {
				source = parent[destination];
				path_flow = Math.min(path_flow,
						residualGraph.getWeight(source, destination));
			}

			// update residual capacities of the edges and reverse edges
			// along the path
			for (destination = t; destination != s; destination = parent[destination]) {
				source = parent[destination];

				residualGraph.updateWeight(source, destination,
						residualGraph.getWeight(source, destination)
								- path_flow);
				residualGraph.updateWeight(destination, source,
						residualGraph.getWeight(destination, source)
								+ path_flow);
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		DFS.doDfsS(residualGraph, s, visited);
		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				// has a path from visited to non visited
				if (visited[i] && !visited[j] && (graph.getWeight(i, j) > 0)) {
					edges.add(new Edge(i, j, graph.getWeight(i, j)));
				}
			}
		}
		return edges;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = new int[][]{{0, 16, 13, 0, 0, 0},
				{0, 0, 10, 12, 0, 0}, {0, 4, 0, 0, 14, 0}, {0, 0, 9, 0, 0, 20},
				{0, 0, 0, 7, 0, 4}, {0, 0, 0, 0, 0, 0}};
		Graph graph = new AdjacentMatrix(matrix);
		StCut cut = new StCut();
		List<Edge> edges = cut.minimumCut(graph, 0, matrix.length - 1);
		for (Edge edge : edges) {
			System.out.println("Source= " + edge.src + " destination= "
					+ edge.dest);
		}

	}

}
