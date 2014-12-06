package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacentList {
	private HashMap<Integer, List<Node>> graph;
	private final boolean directed;

	AdjacentList(int vertices, boolean directed) {
		graph = new HashMap<Integer, List<Node>>(vertices);
		this.directed = directed;

	}

	public void addPath(int source, int destination, int weight) {
		if (graph.containsKey(source)) {
			graph.get(source).add(new Node(destination, weight));
		} else {
			List<Node> list = new ArrayList<Node>();
			list.add(new Node(destination, weight));
			graph.put(source, list);
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

	public List<Node> getNeighbours(int vertics) {
		if (vertics < 0) {
			return new ArrayList<Node>();
		}
		if (graph.containsKey(vertics)) {
			return graph.get(vertics);
		}

		return new ArrayList<Node>();

	}

}
