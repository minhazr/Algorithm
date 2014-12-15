package com.minhaz.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class FordFulkerson {

	public int fordFulkerson(Graph graph, int source, int destination) {
		int vertices = graph.countVertices();
		int u, v;

		// copy of original graph
		Graph residualGraph = new AdjacentMatrix(graph);

		int[] parents = new int[vertices]; // This array is filled by BFS and
											// to store
		// path

		int max_flow = 0; // There is no flow initially

		// we are using weighted graph. And we start with some value.
		// Every time we use a weight its get subtracted.
		// it means as long as we can do BFS from source to
		// destination we do have a path.
		while (hasAugmentedPath(residualGraph, source, destination, parents)) {
			// Find minimum for this source to destination
			int current_flow = Integer.MAX_VALUE;
			// starting loop from back
			for (v = destination; v != source; v = parents[v]) {
				u = parents[v];
				current_flow = Math.min(current_flow,
						residualGraph.getWeight(u, v));
			}

			// update residual capacities of the edges and reverse edges
			// along the path
			for (v = destination; v != source; v = parents[v]) {
				u = parents[v];

				residualGraph.updateWeight(u, v, residualGraph.getWeight(u, v)
						- current_flow);

				// if we have reverse edge just want to make sure we ignore it.
				residualGraph.updateWeight(v, u, residualGraph.getWeight(v, u)
						+ current_flow);
			}

			// Add path flow to overall flow
			max_flow += current_flow;
		}
		return max_flow;
	}

	public boolean hasAugmentedPath(Graph graph, int source, int destination,
			int[] parents) {
		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);

		// Create a queue, enqueue source vertex and mark source vertex
		// as visited
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		parents[source] = -1;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int vertex = 0; vertex < vertices; vertex++) {
				if (!visited[vertex] && (graph.getWeight(u, vertex) > 0)) {
					queue.add(vertex);
					parents[vertex] = u;
					visited[vertex] = true;
				}
			}
		}

		return visited[destination];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] graph = {{0, 16, 13, 0, 0, 0}, {0, 0, 10, 12, 0, 0},
				{0, 4, 0, 0, 14, 0}, {0, 0, 9, 0, 0, 20}, {0, 0, 0, 7, 0, 4},
				{0, 0, 0, 0, 0, 0}};
		Graph graph1 = new AdjacentMatrix(graph);
		// graph1.printGraph();
		FordFulkerson id = new FordFulkerson();
		System.out.println(id.fordFulkerson(graph1, 0, 5));

	}

}
