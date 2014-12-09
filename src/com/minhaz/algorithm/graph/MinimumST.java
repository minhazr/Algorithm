package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

import com.minhaz.algorithm.ds.DisjointSet;
import com.minhaz.algorithm.ds.Edge;
import com.minhaz.algorithm.ds.EdgeList;
import com.minhaz.algorithm.ds.Graph;

public class MinimumST {

	/**
	 * Implementation of Kruskal Minimam spanning tree algorithm.
	 * 
	 * @param graph
	 * @return
	 */
	public List<Edge> doKruskal(Graph graph) {
		int vertices = graph.countVertices();
		List<Edge> edges = graph.getSortedEdges();
		Integer[] newArray = new Integer[vertices];
		int i = 0;
		for (int value : graph.getVertices()) {
			newArray[i++] = Integer.valueOf(value);

		}
		List<Edge> output = new ArrayList<Edge>();
		DisjointSet<Integer> djset = new DisjointSet<Integer>(newArray);
		i = 0;
		while (i < vertices) {
			Edge edge = edges.get(i);
			int source = djset.find(edge.src);
			int destination = djset.find(edge.dest);
			if (source != destination) {
				output.add(edge);
				djset.union(source, destination);
			}
			i++;
		}

		return output;
	}

	public List<Edge> doPrims(Graph graph) {
		int vertices = graph.countVertices();
		List<Edge> edges = graph.getSortedEdges();
		Integer[] newArray = new Integer[vertices];
		int i = 0;
		for (int value : graph.getVertices()) {
			newArray[i++] = Integer.valueOf(value);

		}
		List<Edge> output = new ArrayList<Edge>();

		return output;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new EdgeList();
		graph.addPath(0, 1, 10);
		graph.addPath(0, 2, 6);

		graph.addPath(0, 3, 5);
		graph.addPath(1, 3, 15);
		graph.addPath(2, 3, 4);

		MinimumST mst = new MinimumST();
		List<Edge> edges = mst.doKruskal(graph);
		for (Edge edge : edges) {
			System.out.println("Source= " + edge.src + " Destination= "
					+ edge.dest + " Weight= " + edge.weight);
		}

	}

}
