package com.minhaz.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

/**
 * 
 * Bipartite Graph
 * 
 * A Bipartite Graph is a graph whose vertices can be divided into two
 * independent sets
 * 
 */
public class Bipartite {
	private static final int BLUE = 1;
	private static final int RED = 2;
	private static final int NO_COLOR = -1;

	public boolean isBipartite(Graph graph, int src) {
		int vertices = graph.countVertices();
		int[] color = new int[vertices];
		Arrays.fill(color, NO_COLOR);

		color[src] = BLUE;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);

		while (!queue.isEmpty()) {
			int u = queue.remove();
			int[] neighbours = graph.getNeighbours(u);
			for (int neighbour : neighbours) {
				if (color[neighbour] == NO_COLOR) {
					// subtracting by 3 is just to make sure we have alternate
					// color. i got 3 as i initialized color value 1 and 2
					color[neighbour] = 3 - color[u];
					queue.add(neighbour);
				} else if (color[u] == color[neighbour]) {
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
