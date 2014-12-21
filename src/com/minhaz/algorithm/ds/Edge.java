package com.minhaz.algorithm.ds;

public class Edge implements Comparable<Edge> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + dest;
		result = (prime * result) + src;
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
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge other = (Edge) obj;
		if (dest != other.dest) {
			return false;
		}
		if (src != other.src) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		return true;
	}

	public int src;
	public int dest;
	public int weight;

	public Edge(int source, int destination, int weight) {
		this.src = source;
		this.dest = destination;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		if (weight < e.weight) {
			return -1;
		} else if (weight > e.weight) {
			return 1;
		} else {
			return 0;
		}
	}

}
