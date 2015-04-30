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

	public AdjacentList(Graph graph) {
		this.graph = new HashMap<Integer, List<Node>>();
		this.directed = graph.isDirected();
		this.set = new HashSet<Integer>();
		int vertices = graph.countVertices();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				addPath(i, j, graph.getWeight(i, j));
			}
		}

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

	@Override
	public List<Edge> getSortedEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getVertices() {
		int[] result = new int[countVertices()];

		int i = 0;
		for (int item : set) {
			result[i] = item;
			i++;
		}
		return result;
	}

	@Override
	public Graph getTranspose() {
		Graph tGraph = new AdjacentList(countVertices(), directed);
		for (int source : graph.keySet()) {
			List<Node> nodes = getAdjacentVertices(source);
			for (Node node : nodes) {
				tGraph.addPath(node.getVertex(), source, node.getWeight());
			}

		}
		return tGraph;
	}

	@Override
	public boolean hasPath(int source, int destination) {
		int[] neighbours = getNeighbours(source);
		for (int i : neighbours) {
			if (i == destination) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getWeight(int source, int destination) {
		List<Node> nodes = getAdjacentVertices(source);
		for (Node node : nodes) {
			if (node.getVertex() == destination) {
				return node.getWeight();
			}
		}
		return UNASSIGNED;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return this.directed;
	}

	@Override
	public void printGraph() {
		// TODO Auto-generated method stub
		for (int i : graph.keySet()) {
			List<Node> nodes = getAdjacentVertices(i);
			for (Node node : nodes) {
				System.out.print(node.getVertex() + " ");
			}
			System.out.println(" ");
		}

	}

	@Override
	public void updateWeight(int source, int destination, int weight) {
		List<Node> nodes = getAdjacentVertices(source);
		for (Node node : nodes) {
			if (node.getVertex() == destination) {
				nodes.remove(node);
				nodes.add(new Node(destination, weight));
				graph.put(source, nodes);
			}
		}

	}

	@Override
	public int[] getNeighbours(int vertics, int weight) {
		if (vertics < 0) {
			return new int[0];
		}
		int[] result;
		if (graph.containsKey(vertics)) {
			List<Node> list = graph.get(vertics);
			List<Node> temp = new ArrayList<Node>();
			for (Node node : list) {
				if (node.getWeight() > weight) {
					temp.add(node);
				}
			}
			result = new int[temp.size()];
			for (int i = 0; i < result.length; i++) {
				result[i] = temp.get(i).getVertex();

			}
			return result;
		}

		return new int[0];
	}

	@Override
	public List<Node> getAdjacentVertices(int vertex, int weight) {
		if (vertex < 0) {
			return new ArrayList<Node>();
		}
		if (graph.containsKey(vertex)) {
			List<Node> result = new ArrayList<Node>();
			List<Node> nodes = graph.get(vertex);
			for (Node node : nodes) {
				if (node.getWeight() > weight) {
					result.add(node);
				}
			}
			return result;

		}

		return new ArrayList<Node>();
	}

	@Override
	public int[] countIndgree() {
		int vertices = countVertices();
		int[] in = new int[vertices];
		for (int i : graph.keySet()) {
			List<Node> nodes = graph.get(i);
			for (Node node : nodes) {
				in[node.getVertex()]++;
			}
		}
		return in;
	}

	@Override
	public List<Edge> getAdjacentEdges(int vertex) {
		List<Edge> edges = new ArrayList<Edge>();
		List<Node> nodes=graph.get(vertex);
		for (int neighbour:neighbours){
			edges.add(new Edge(vertex, neighbour, weight));
		}
		return null;
	}

	@Override
	public List<Edge> getAdjacentEdges(Edge edge) {
		// TODO Auto-generated method stub
		return null;
	}

}
