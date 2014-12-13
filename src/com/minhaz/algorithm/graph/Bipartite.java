package com.minhaz.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class Bipartite {
	private static final int BLUE = 1;
	private static final int RED = 2;
	private static final int NO_COLOR = -1;

	public boolean isBipartite(Graph graph, int src) {
		int vertices = graph.countVertices();
		int[] color = new int[vertices];
		for (int i = 0; i < vertices; ++i) {
			color[i] = NO_COLOR;
		}

		color[src] = BLUE;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);

		while (!queue.isEmpty()) {
			int u = queue.remove();
			int[] neiggbours = graph.getNeighbours(u);
			for (int i : neiggbours) {
				if (graph.hasPath(u, i) && (color[i] == NO_COLOR)) {
					color[i] = 3 - color[u];
					queue.add(i);
				} else if (graph.hasPath(u, i) && (color[u] == color[i])) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new AdjacentMatrix(4, false);
		graph.addPath(0, 1, 1);
		graph.addPath(0, 3, 1);

		// graph.addPath(1, 0, 1);
		graph.addPath(1, 2, 1);

		// graph.addPath(2, 1, 1);
		graph.addPath(2, 3, 1);

		// graph.addPath(3, 0, 1);
		// graph.addPath(3, 2, 1);

		graph.printGraph();
		Bipartite bipartite = new Bipartite();
		System.out.println(bipartite.isBipartite(graph, 0));

	}

}
