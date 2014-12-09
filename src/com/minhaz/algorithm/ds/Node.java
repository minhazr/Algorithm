package com.minhaz.algorithm.ds;

public class Node implements Comparable<Node> {

	private int vertex;
	private int weight;

	Node(int vertiex, int weight) {
		this.vertex = vertiex;
		this.weight = weight;
	}

	/**
	 * @return the vertex
	 */
	public int getVertex() {
		return vertex;
	}

	/**
	 * @param vertex
	 *            the vertex to set
	 */
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Node e) {
		if (weight < e.weight) {
			return -1;
		} else if (weight > e.weight) {
			return 1;
		} else {
			return 0;
		}
	}

}
