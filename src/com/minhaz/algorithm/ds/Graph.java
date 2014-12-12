package com.minhaz.algorithm.ds;

import java.util.List;

public interface Graph {
	final int UNASSIGNED = Integer.MAX_VALUE;
	public void addPath(int source, int destination, int weight);
	public void addPath(int source, int destination);

	public int countVertices();
	public int[] getNeighbours(int vertics);
	public int[] getVertices();
	public List<Node> getAdjacentVertices(int vertics);

	public List<Edge> getSortedEdges();

	public Graph getTranspose();
	public boolean hasPath(int source, int destination);

	public int getWeight(int source, int destination);
	public boolean isDirected();

}
