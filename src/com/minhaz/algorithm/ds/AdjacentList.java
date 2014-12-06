package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacentList implements Graph {
	private HashMap<Integer, List<Node>> graph;
	private final boolean directed;
	private int totalVertex = 0;

	public AdjacentList(int vertices, boolean directed) {
		graph = new HashMap<Integer, List<Node>>(vertices);
		this.directed = directed;

	}

	@Override
	public void addPath(int source, int destination, int weight) {
		if (graph.containsKey(source)) {
			graph.get(source).add(new Node(destination, weight));
			totalVertex++;
		} else {
			List<Node> list = new ArrayList<Node>();
			list.add(new Node(destination, weight));
			graph.put(source, list);
			totalVertex++;
		}
		if (!directed) {
			if (graph.containsKey(destination)) {
				graph.get(source).add(new Node(source, weight));
			} else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(source, weight));
				graph.put(destination, list);
			}
		}
	}

	@Override
	public int[] getNeighbours(int vertics) {
		if (vertics < 0) {
			return new int[0];
		}
		int[] result;
		if (graph.containsKey(vertics)) {
			List<Node> list = graph.get(vertics);
			result = new int[list.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = list.get(i).getVertex();

			}
			return result;
		}

		return new int[0];

	}

	@Override
	public void addPath(int source, int destination) {
		addPath(source, destination, -1);

	}

	@Override
	public int countVertices() {
		// TODO Auto-generated method stub
		return totalVertex;
	}

}
