package com.minhaz.algorithm.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

/**
 * 
 * Problem Statement
 * 
 * A vertex in an undirected connected graph is an articulation point (or cut
 * vertex) iff removing it (and edges through it) disconnects the graph.
 * 
 * A vertex is an articulation point is one of following statements are true:
 * 
 * 1) It is the root of tree and it has at least two children.
 * 
 * 2) it is not the root of tree but it has a child v such, none of the 
 * children of v is connected to ancestor of v by a back edge.
 * 
 * 
 */
public class ArticulationPoint {

	public void findArticulationPoint(Graph graph) {

		int vertices = graph.countVertices();
		boolean[] visited = new boolean[vertices];
		Arrays.fill(visited, false);

		int[] discovery = new int[vertices];
		Arrays.fill(discovery, -1);

		int[] low = new int[vertices];
		Arrays.fill(low, -1);

		boolean[] aps = new boolean[vertices];
		Arrays.fill(aps, false);

		int[] parents = new int[vertices];
		Arrays.fill(parents, -1);

		int time = 0;
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (!visited[vertex]) {
				apUtils(graph, vertex, visited, discovery, low, aps, parents,
						time);
			}
		}

		for (int i = 0; i < vertices; i++) {
			if (aps[i]) {
				System.out.println("Index=" + i + " " + aps[i]);
			}
		}

	}
	private void apUtils(Graph graph, int parent, boolean[] visited,
			int[] discovery, int[] low, boolean[] ap, int[] parents, int time) {

		visited[parent] = true;
		low[parent] = time;
		discovery[parent] = time;
		int children = 0;

		int[] childrens = graph.getNeighbours(parent);
		for (int child : childrens) {
			if (!visited[child]) {
				parents[child] = parent;
				// counting number of child for this parent
				children++;
				apUtils(graph, child, visited, discovery, low, ap, parents,
						++time);
				// we need to make sure that parent always has a lower value
				// then its child. reason is to avoid a back path from child to
				// its ancestors.
				low[parent] = Math.min(low[parent], low[child]);

				// (1) parent is root of DFS tree and has two or more children.
				if ((parents[parent] == -1) && (children > 1)) {
					ap[parent] = true;
				}

				// (2) If parent is not root and low value of one of its child
				// is more than discovery value of parent.
				if ((parents[parent] != -1)
						&& (low[child] >= discovery[parent])) {
					ap[parent] = true;
				}
				// this is case where their is a path from child to its parent
				// && parent is already visited.
			} else if (child != parents[parent]) {
				low[parent] = Math.min(low[parent], discovery[child]);

			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph1 = new AdjacentMatrix(7, false);
		graph1.addPath(1, 0, 1);
		graph1.addPath(0, 3, 1);
		graph1.addPath(2, 1, 1);
		graph1.addPath(5, 3, 1);
		graph1.addPath(3, 4, 1);
		graph1.addPath(5, 4, 1);
		graph1.addPath(2, 6, 1);
		graph1.addPath(2, 3, 1);

		ArticulationPoint point = new ArticulationPoint();
		point.findArticulationPoint(graph1);

		Graph graph2 = new AdjacentMatrix(4, false);
		graph2.addPath(0, 1);
		graph2.addPath(1, 2);
		graph2.addPath(2, 3);

		// point.findArticulationPoint(graph2);

		Graph graph3 = new AdjacentMatrix(7, false);
		graph3.addPath(0, 1);
		graph3.addPath(1, 2);
		graph3.addPath(2, 0);
		graph3.addPath(1, 3);
		graph3.addPath(1, 4);
		graph3.addPath(1, 6);
		graph3.addPath(3, 5);
		graph3.addPath(4, 5);

		// point.findArticulationPoint(graph3);

	}

}
