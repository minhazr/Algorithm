package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeList implements Graph {
	private List<Edge> edges = new ArrayList<Edge>();

	@Override
	public void addPath(int source, int destination, int weight) {
		// TODO Auto-generated method stub

		edges.add(new Edge(source, destination, weight));

	}
	@Override
	public void addPath(int source, int destination) {
		addPath(source, destination, UNASSIGNED);

	}

	@Override
	public int countVertices() {
		Set<Integer> set = new HashSet<Integer>();
		for (Edge edge : edges) {
			set.add(edge.src);
			set.add(edge.dest);
		}
		return set.size();
	}

	public int countEdge() {
		return edges.size();
	}

	@Override
	public int[] getNeighbours(int vertex) {
		List<Node> nodes = getAdjacentVertices(vertex);
		int[] result = new int[nodes.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = nodes.get(i).getVertex();
		}
		return result;
	}

	@Override
	public List<Node> getAdjacentVertices(int vertex) {
		// TODO Auto-generated method stub
		List<Node> nodes = new ArrayList<Node>();
		for (Edge edge : edges) {
			if (edge.src == vertex) {
				nodes.add(new Node(edge.dest, edge.weight));
			} else if (edge.dest == vertex) {
				nodes.add(new Node(edge.src, edge.weight));
			}
		}
		return nodes;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
