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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + vertex;
		result = (prime * result) + weight;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		Node other = (Node) obj;
		if (vertex != other.vertex) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		return true;
	}

}
