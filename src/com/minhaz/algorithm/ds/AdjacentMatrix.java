package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacentMatrix implements Graph {

	private final int[][] matrix;
	private boolean directed;

	public AdjacentMatrix(int[][] graph, boolean directed) {
		this.matrix = graph;
		this.directed = false;

	}
	public AdjacentMatrix(int[][] graph) {
		this.matrix = graph;
		this.directed = false;

	}
	public AdjacentMatrix(Graph graph) {
		int vertices = graph.countVertices();
		matrix = new int[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				matrix[i][j] = graph.getWeight(i, j);
			}
		}

	}
	public AdjacentMatrix(int row, int column, boolean directed) {
		this.matrix = new int[row][column];
		this.directed = directed;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = UNASSIGNED;
			}
		}

	}

	public AdjacentMatrix(int vertices, boolean directed) {
		matrix = new int[vertices][vertices];
		this.directed = directed;
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				matrix[i][j] = UNASSIGNED;
			}
		}
	}

	@Override
	public void addPath(int source, int destination, int weight) {
		if (!isValidVertices(source, destination)) {
			return;
		}
		matrix[source][destination] = weight;
		if (!directed) {
			matrix[destination][source] = weight;
		}
	}

	@Override
	public int[] getNeighbours(int vertics) {
		if (vertics < 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertics][i] != UNASSIGNED) {
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;

	}
	/**
	 * Return neigbours with weight greater then given weight
	 *
	 * @param vertics
	 * @param weight
	 * @return
	 */
	@Override
	public int[] getNeighbours(int vertics, int weight) {
		if (vertics < 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertics][i] > weight) {
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;

	}
	private boolean isValidVertices(int source, int destination) {
		if ((source < 0) || (source >= matrix.length)) {
			return false;
		}
		if ((destination < 0) || (destination >= matrix.length)) {
			return false;
		}
		return true;
	}
	public boolean isPathExist(int source, int destination) {
		if (!isValidVertices(source, destination)) {
			return false;
		}
		if (matrix[source][destination] != UNASSIGNED) {
			return true;
		}

		return false;
	}

	@Override
	public void addPath(int source, int destination) {
		addPath(source, destination, -1);

	}

	@Override
	public List<Node> getAdjacentVertices(int vertics) {
		if (vertics < 0) {
			return new ArrayList<Node>();
		}
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertics][i] != UNASSIGNED) {
				Node node = new Node(i, matrix[vertics][i]);
				list.add(node);
			}
		}

		return list;

	}

	@Override
	public int countVertices() {
		// TODO Auto-generated method stub
		return matrix.length;
	}

	@Override
	public List<Edge> getSortedEdges() {
		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != UNASSIGNED) {
					edges.add(new Edge(i, j, matrix[i][j]));
				}
			}
		}
		Collections.sort(edges);
		return edges;
	}

	@Override
	public int countEdges() {
		int edge=0;
		for (int[] element : matrix) {
			for (int j = 0; j < matrix.length; j++) {
				if (element[j] != UNASSIGNED) {
					edge++;
				}
			}
		}
		return edge;
	}

	@Override
	public int[] getVertices() {
		// TODO Auto-generated method stub
		int[] result = new int[countVertices()];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}

	@Override
	public Graph getTranspose() {
		int[][] tGraph = new int[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != UNASSIGNED) {
					tGraph[j][i] = matrix[i][j];
				} else {
					tGraph[j][i] = UNASSIGNED;
				}
			}
		}
		return new AdjacentMatrix(tGraph, this.directed);
	}

	@Override
	public boolean hasPath(int source, int destination) {
		if (directed && (matrix[source][destination] != UNASSIGNED)) {
			return true;
		}
		if (!directed && (matrix[source][destination] != UNASSIGNED)) {
			return true;
		}
		return false;
	}

	@Override
	public int getWeight(int source, int destination) {
		// TODO Auto-generated method stub
		return matrix[source][destination];
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return directed;
	}

	@Override
	public void printGraph() {
		for (int[] element : matrix) {
			for (int j = 0; j < matrix.length; j++) {
				if (element[j] == UNASSIGNED) {
					System.out.print(0 + " ");
				} else {
					System.out.print(element[j] + " ");
				}

			}
			System.out.println(" ");
		}

	}
	@Override
	public void updateWeight(int source, int destination, int weight) {
		matrix[source][destination] = weight;

	}
	@Override
	public List<Node> getAdjacentVertices(int vertex, int weight) {
		if (vertex < 0) {
			return new ArrayList<Node>();
		}
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertex][i] > weight) {
				Node node = new Node(i, matrix[vertex][i]);
				list.add(node);
			}
		}

		return list;
	}

	@Override
	public int[] countIndgree() {
		int vertices = countVertices();
		int[] in = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (getWeight(j, i) != UNASSIGNED) {
					in[i]++;
				}
			}
		}
		return in;
	}
	@Override
	public List<Edge> getAdjacentEdges(int vertex) {
		List<Edge> edges = new ArrayList<Edge>();
		int vertices = countVertices();
		for (int i = 0; i < vertices; i++) {
			if (getWeight(vertex, i) != UNASSIGNED) {
				edges.add(new Edge(vertex, i, getWeight(vertex, i)));
			}
		}
		return edges;
	}
	@Override
	public List<Edge> getAdjacentEdges(Edge edge) {
		List<Edge> edges = new ArrayList<Edge>();
		int vertices = countVertices();
		for (int i = 0; i < vertices; i++) {
			if (getWeight(edge.dest, i) != UNASSIGNED) {
				edges.add(new Edge(edge.dest, i, getWeight(edge.dest, i)));
			}
			if (isDirected()) {
				continue;
			}
			if (getWeight(edge.src, i) != UNASSIGNED) {
				edges.add(new Edge(edge.src, i, getWeight(edge.src, i)));
			}
		}

		return edges;
	}

}
