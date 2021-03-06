package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeList implements Graph {
	private List<Edge> edges;
	public boolean directed;

	public EdgeList(Graph graph) {
		edges = new ArrayList<Edge>();
		int vertices = graph.countVertices();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				addPath(i, j, graph.getWeight(i, j));
			}
		}
		directed=graph.isDirected();
	}
	public EdgeList() {
		edges = new ArrayList<Edge>();
	}


	@Override
	public void addPath(int source, int destination, int weight) {
		// TODO Auto-generated method stub
		edges.add(new Edge(source, destination, weight));
		if(!isDirected()){
			edges.add(new Edge(destination, source, weight));
		}


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

	@Override
	public int countEdges() {
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

	@Override
	public List<Edge> getSortedEdges() {
		Collections.sort(edges);

		return edges;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public int[] getVertices() {
		Set<Integer> set = new HashSet<Integer>();
		for (Edge edge : edges) {
			set.add(edge.src);
			set.add(edge.dest);
		}
		int[] result = new int[set.size()];
		int i = 0;
		for (int item : set) {
			result[i] = item;
			i++;
		}
		return result;
	}
	@Override
	public Graph getTranspose() {
		Graph graph = new EdgeList();
		for (Edge edge : edges) {
			graph.addPath(edge.dest, edge.src, edge.weight);
		}

		return graph;
	}
	@Override
	public boolean hasPath(int source, int destination) {
		// TODO Auto-generated method stub
		for (Edge edge : edges) {
			if ((edge.src == source) && (edge.dest == destination)) {
				return true;
			}
			if ((edge.dest == source) && (edge.src == destination)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int getWeight(int source, int destination) {
		for (Edge edge : edges) {
			if ((edge.src == source) && (edge.dest == destination)) {
				return edge.weight;
			}
			if ((edge.dest == source) && (edge.src == destination)) {
				return edge.weight;
			}
		}
		return UNASSIGNED;
	}
	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return directed;
	}
	@Override
	public void printGraph() {
		for (Edge edge : edges) {
			System.out.println("Source= " + edge.src + " Destination= "
					+ edge.dest + " Weight= " + edge.weight);
		}

	}
	@Override
	public void updateWeight(int source, int destination, int weight) {
		for (Edge edge : edges) {
			if ((edge.src == source) && (edge.dest == destination)) {
				edges.remove(edge);
				edges.add(new Edge(source, destination, weight));
			}

		}

	}
	@Override
	public int[] getNeighbours(int vertex, int weight) {
		List<Node> nodes = getAdjacentVertices(vertex, weight);
		int[] result = new int[nodes.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = nodes.get(i).getVertex();
		}
		return result;
	}
	@Override
	public List<Node> getAdjacentVertices(int vertex, int weight) {
		List<Node> nodes = new ArrayList<Node>();
		for (Edge edge : edges) {
			if (edge.weight > weight) {
				if (edge.src == vertex) {
					nodes.add(new Node(edge.dest, edge.weight));
				} else if (edge.dest == vertex) {
					nodes.add(new Node(edge.src, edge.weight));
				}
			}

		}
		return nodes;
	}
	@Override
	public int[] countIndgree() {
		int vertices = countVertices();
		int[] in = new int[vertices];
		for (Edge edge : edges) {
			in[edge.dest]++;
		}
		return in;
	}
	@Override
	public List<Edge> getAdjacentEdges(int vertex) {
		List<Edge> edges = new ArrayList<Edge>();
		for (Edge edge : this.edges) {
			if (edge.src == vertex) {
				edges.add(edge);
			}
			else if (!isDirected()&& (edge.dest==vertex)){
				edges.add(edge);
			}
		}
		return edges;
	}

	@Override
	public List<Edge> getAdjacentEdges(Edge edge) {
		List<Edge> edges = new ArrayList<Edge>();
		for (Edge current_edge : this.edges) {

			if (edge.dest == current_edge.src) {
				edges.add(current_edge);
			}
			if (isDirected()) {
				continue;
			}
			if (edge.src==current_edge.src){
				edges.add(edge);
			}else if (edge.dest==current_edge.dest){
				edges.add(edge);
			}else if (edge.dest==current_edge.src){
				edges.add(edge);
			}
		}
		return edges;
	}

}
