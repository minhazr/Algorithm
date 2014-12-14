package com.minhaz.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class FordFulkerson {

	/**
	 * This works by doing BFS on graph.
	 * 
	 * @param rGraph
	 * @param s
	 * @param t
	 * @param parent
	 * @return
	 */
	private boolean hasAugmentedPath(int rGraph[][], int s, int t, int parent[]) {
		// Create a visited array and mark all vertices as not visited
		boolean[] visited = new boolean[rGraph.length];

		// Create a queue, enqueue source vertex and mark source vertex
		// as visited
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop
		while (!q.isEmpty()) {
			int u = q.peek();
			q.poll();

			for (int v = 0; v < rGraph.length; v++) {
				if ((visited[v] == false) && (rGraph[u][v] > 0)) {
					q.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		return visited[t];
	}
	public int fordFulkerson(int[][] graph, int s, int t) {
		int u, v;

		// Create a residual graph and fill the residual graph with
		// given capacities in the original graph as residual capacities
		// in residual graph
		int[][] rGraph = new int[graph.length][graph.length]; // Residual graph
																// where
																// rGraph[i][j]
		// indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is not)
		for (u = 0; u < graph.length; u++) {
			for (v = 0; v < graph.length; v++) {
				rGraph[u][v] = graph[u][v];
			}
		}

		int[] parent = new int[graph.length]; // This array is filled by BFS and
												// to store
		// path

		int max_flow = 0; // There is no flow initially

		// we are using weighted graph. And we start with some value.
		// everytime we used a path its get subtracted.
		// it means as long as we can do BFS from srouce to
		// destination we do have a path.
		while (hasAugmentedPath(rGraph, s, t, parent)) {
			// Find minimum for this source to destination
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}

			// update residual capacities of the edges and reverse edges
			// along the path
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}

		// Return the overall flow
		return max_flow;
	}

	public int fordFulkerson(Graph graph, int s, int t) {
		int vertices = graph.countVertices();
		int source, destination;

		Graph residualGraph = new AdjacentMatrix(vertices, true);
		// indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is not)
		for (source = 0; source < vertices; source++) {
			for (destination = 0; destination < vertices; destination++) {
				residualGraph.addPath(source, destination,
						graph.getWeight(source, destination));
			}
		}

		int[] parent = new int[vertices]; // This array is filled by BFS and
											// to store
		// path

		int max_flow = 0; // There is no flow initially

		// we are using weighted graph. And we start with some value.
		// everytime we used a path its get subtracted.
		// it means as long as we can do BFS from srouce to
		// destination we do have a path.
		while (hasAugmentedPath(residualGraph, s, t, parent)) {
			// Find minimum for this source to destination
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
		// residualGraph.printGraph();

		// Return the overall flow
		return max_flow;
	}

	private boolean hasAugmentedPath(Graph graph, int source, int sink,
			int[] parent) {
		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);

		// Create a queue, enqueue source vertex and mark source vertex
		// as visited
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		parent[source] = -1;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int vertex = 0; vertex < vertices; vertex++) {
				if (!visited[vertex] && (graph.getWeight(u, vertex) > 0)) {
					queue.add(vertex);
					parent[vertex] = u;
					visited[vertex] = true;
				}
			}
		}

		return visited[sink];
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
