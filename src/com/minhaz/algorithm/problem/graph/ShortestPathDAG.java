package com.minhaz.algorithm.problem.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.minhaz.algorithm.ds.AdjacentList;
import com.minhaz.algorithm.ds.Graph;
import com.minhaz.algorithm.ds.Node;
import com.minhaz.algorithm.graph.TopologicalSort;

public class ShortestPathDAG {
	private Graph graph;

	public ShortestPathDAG(Graph graph) {
		this.graph = graph;
	}

	private int[] getShortestPath(int source) {
		// TODO Auto-generated method stub
		TopologicalSort sort = new TopologicalSort();
		Stack<Integer> stack = sort.sort(graph);
		// sort.printSort(stack);
		System.out.println("Size of Stack" + stack.size());
		int[] dis = new int[graph.countVertices()];

		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[source] = 0;
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (dis[vertex] != Integer.MAX_VALUE) {
				List<Node> neighbours = graph.getAdjacentVertices(vertex);
				for (Node neighbour : neighbours) {
					if (dis[neighbour.getVertex()] > (dis[vertex] + neighbour
							.getWeight())) {
						dis[neighbour.getVertex()] = dis[vertex]
								+ neighbour.getWeight();
					}
				}
			}

		}
		return dis;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new AdjacentList(6, true);
		graph.addPath(0, 1, 5);
		graph.addPath(0, 2, 3);
		graph.addPath(1, 3, 6);
		graph.addPath(1, 2, 2);
		graph.addPath(2, 4, 4);
		graph.addPath(2, 5, 2);
		graph.addPath(2, 3, 7);
		graph.addPath(3, 4, -1);
		graph.addPath(4, 5, -2);

		ShortestPathDAG path = new ShortestPathDAG(graph);
		int[] output = path.getShortestPath(1);
		System.out.println(Arrays.toString(output));

	}

}
