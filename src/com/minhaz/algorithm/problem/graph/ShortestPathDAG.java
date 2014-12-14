package com.minhaz.algorithm.problem.graph;

import java.util.Arrays;
import java.util.List;

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
		TopologicalSort sort = new TopologicalSort(graph);
		List<Integer> list = sort.sort();
		sort.printSort(list);
		int[] dis = new int[graph.countVertices()];
		for (int i = 0; i < dis.length; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[source] = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			int vertex = list.get(i);
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
