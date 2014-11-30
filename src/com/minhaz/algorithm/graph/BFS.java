package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Breadth first search of a graph
 * 
 * It uses a matrix representation of graph. 0 value will assume no path, for
 * negative weight change it to something else.
 */

public class BFS {

	private final int[][] graph;
	private boolean[] visited;

	private Queue<Integer> queue = new LinkedList<Integer>();

	BFS(int[][] graph) {
		this.graph = graph;
		visited = new boolean[graph.length];
	}

	public List<Integer> getUnvisitedChildNodes(int source) {
		// creating list as i do not know how node will be there
		List<Integer> list = new ArrayList<Integer>();
		for (int v = 0; v < graph.length; v++) { // if not visited and there is
													// path in graph
			if (!isVisited(v) && (graph[source][v] > 0)) {
				list.add(v);
			}
		}
		return list;
	}

	public void setVisited(int vertices, boolean flag) {
		visited[vertices] = flag;
	}
	public boolean isVisited(int vertices) {
		return visited[vertices];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
