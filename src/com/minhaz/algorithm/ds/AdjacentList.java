package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacentList implements Graph {
	private HashMap<Integer, List<Node>> graph;
	private final boolean directed;
	private Set<Integer> set;

	public AdjacentList(int vertices, boolean directed) {
		graph = new HashMap<Integer, List<Node>>();
		this.directed = directed;
		set = new HashSet<Integer>();

	}

	@Override
	public void addPath(int source, int destination, int weight) {
		set.add(destination);
		set.add(source);
		if (graph.containsKey(source)) {
			// System.out.print("Adding "+)
			graph.get(source).add(new Node(destination, weight));

		} else {
			List<Node> list = new ArrayList<Node>();
			list.add(new Node(destination, weight));
			graph.put(source, list);
		}
		if (!directed) {
			if (graph.containsKey(destination)) {
				graph.get(source).add(new Node(destination, weight));
			} else {
				List<Node> list = new ArrayList<Node>();
				list.add(new Node(destination, weight));
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
	public List<Node> getAdjacentVertices(int vertics) {
		if (vertics < 0) {
			return new ArrayList<Node>();
		}
		if (graph.containsKey(vertics)) {
			return graph.get(vertics);

		}

		return new ArrayList<Node>();

	}

	@Override
	public void addPath(int source, int destination) {
		addPath(source, destination, UNASSIGNED);

	}

	@Override
	public int countVertices() {
		// TODO Auto-generated method stub
		return set.size();
	}

}
