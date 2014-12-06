package com.minhaz.algorithm.ds;

public interface Graph {
	public void addPath(int source, int destination, int weight);
	public void addPath(int source, int destination);

	public int countVertices();
	public int[] getNeighbours(int vertics);

}
