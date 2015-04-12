package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;
/**
 * 
 * Standard dijkstra shortest path algorithim.
 * 
 * This is same as prims MST except the relaxation part.
 */
public class Dijkstra {

	public void getShortestPath(Graph graph, int source) {
		int vertices = graph.countVertices();
		int[] dist = new int[vertices];
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;

		for (int vertex = 0; vertex < (vertices - 1); vertex++) {
			int minimum_vertex = minDistance(dist, visited);
			visited[minimum_vertex] = true;

			int[] neighbours = graph.getNeighbours(minimum_vertex);
			for (int neighbour : neighbours) {
				int neighbour_distance = graph.getWeight(minimum_vertex,
						neighbour);
				if (!visited[neighbour]
						&& (dist[minimum_vertex] != Integer.MAX_VALUE)
						&& ((dist[minimum_vertex] + neighbour_distance) < dist[neighbour])) {

					dist[neighbour] = dist[minimum_vertex] + neighbour_distance;

				}

			}
		}
		printPath(dist);

	}

	public void printPath(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println("vertex= " + i + " distance from source ="
					+ result[i]);
		}
	}
	/**
	 * Return minimum vertex from already added set which is not visited
	 * 
	 * @param result
	 * @param visited
	 * @return
	 */

	private int minDistance(int[] result, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		for (int i = 0; i < result.length; i++) {
			if (!visited[i] && (result[i] < min)) {
				min = result[i];
				min_index = i;

			}
		}
		return min_index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Graph graph1 = new AdjacentMatrix(9, true);
		graph1.addPath(0, 1, 4);
		graph1.addPath(0, 7, 8);

		graph1.addPath(1, 0, 4);
		graph1.addPath(1, 2, 8);
		graph1.addPath(1, 7, 11);

		graph1.addPath(2, 1, 8);
		graph1.addPath(2, 3, 7);
		graph1.addPath(2, 5, 4);
		graph1.addPath(2, 8, 2);

		graph1.addPath(3, 2, 7);
		graph1.addPath(3, 4, 9);
		graph1.addPath(3, 5, 14);

		graph1.addPath(4, 3, 9);
		graph1.addPath(4, 5, 10);

		graph1.addPath(5, 2, 4);
		graph1.addPath(5, 4, 10);
		graph1.addPath(5, 6, 2);

		graph1.addPath(6, 3, 14);
		graph1.addPath(6, 5, 2);
		graph1.addPath(6, 7, 1);
		graph1.addPath(6, 8, 6);

		graph1.addPath(7, 0, 8);
		graph1.addPath(7, 1, 11);
		graph1.addPath(7, 6, 1);
		graph1.addPath(7, 8, 7);

		graph1.addPath(8, 2, 2);
		graph1.addPath(8, 6, 6);
		graph1.addPath(8, 7, 7);

		// graph1.printGraph();

		Dijkstra dijkstra = new Dijkstra();
		dijkstra.getShortestPath(graph1, 0);

	}
}
