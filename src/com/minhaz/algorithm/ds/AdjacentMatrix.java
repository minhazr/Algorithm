package com.minhaz.algorithm.ds;

import java.util.ArrayList;
import java.util.List;

public class AdjacentMatrix implements Graph {

	private final int[][] matrix;

	public AdjacentMatrix(int vertices) {
		matrix = new int[vertices][vertices];
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
		matrix[destination][source] = weight;
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

}