package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.DisjointSet;
import com.minhaz.algorithm.ds.Edge;
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
		// converting to Integer object has nothing to do with original algo.
		// this is just to match with my implementation of Disjoint set
		for (int value : graph.getVertices()) {
			newArray[i++] = Integer.valueOf(value);

		}
		List<Edge> output = new ArrayList<Edge>();
		DisjointSet<Integer> djset = new DisjointSet<Integer>(newArray);
		i = 0;
		for (Edge edge : edges) {
			// Edge edge = edges.get(i);
			int source = djset.find(edge.src);
			int destination = djset.find(edge.dest);
			// if not creating cycle
			if (source != destination) {
				output.add(edge);
				djset.union(source, destination);
			}
			i++;
		}

		return output;
	}
	/**
	 * Return vertex with minimum weight value from mst set
	 * 
	 * @param weight
	 * @param mst
	 * @return
	 */
	private int getMinimum(int[] weight, boolean[] mst) {
		int min = Integer.MAX_VALUE;
		int vertex = 0;
		for (int i = 1; i < weight.length; i++) {
			if ((weight[i] < min) && !mst[i]) {
				min = weight[i];
				vertex = i;
			}
		}

		return vertex;

	}

	public List<Edge> doPrims(Graph graph) {
		int vertices = graph.countVertices();

		int[] parent = new int[vertices];
		int[] weights = new int[vertices];
		boolean[] mst = new boolean[vertices];

		Arrays.fill(weights, Integer.MAX_VALUE);
		Arrays.fill(mst, false);

		weights[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < (vertices - 1); count++) {
			int u = getMinimum(weights, mst);
			mst[u] = true;
			for (int vertex = 0; vertex < vertices; vertex++) {
				int currentweight = graph.getWeight(u, vertex);
				// if there is a path from current minimum to v && current
				// vertex is not already added && this path weight is lower then
				// existing
				if (graph.hasPath(u, vertex) && !mst[vertex]
						&& (currentweight < weights[vertex])) {
					weights[vertex] = currentweight;
					parent[vertex] = u;
				}
			}
		}

		List<Edge> result = new ArrayList<Edge>();
		for (int i = 1; i < parent.length; i++) {
			result.add(new Edge(parent[i], i, graph.getWeight(parent[i], i)));
		}

		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new AdjacentMatrix(4, true);
		graph.addPath(0, 1, 10);
		graph.addPath(0, 2, 6);

		graph.addPath(0, 3, 5);
		graph.addPath(1, 3, 15);
		graph.addPath(2, 3, 4);

		// System.out.println("vertecis ............"
		// + graph.getSortedEdges().size());
		// for (Edge edge : graph.getSortedEdges()) {
		// System.out.println("Source= " + edge.src + " Destination= "
		// + edge.dest + " Weight= " + edge.weight);
		// }

		System.out.println();

		MinimumST mst = new MinimumST();
		List<Edge> edges = mst.doKruskal(graph);
		for (Edge edge : edges) {
			System.out.println("Source= " + edge.src + " Destination= "
					+ edge.dest + " Weight= " + edge.weight);
		}

		// System.out.println("Running prims............");
		//
		// edges = mst.doPrims(graph);
		// for (Edge edge : edges) {
		// System.out.println("Source= " + edge.src + " Destination= "
		// + edge.dest + " Weight= " + edge.weight);
		// }

	}

}
