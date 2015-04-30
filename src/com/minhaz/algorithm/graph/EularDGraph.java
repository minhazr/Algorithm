package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.minhaz.algorithm.ds.Edge;
import com.minhaz.algorithm.ds.EdgeList;
import com.minhaz.algorithm.ds.Graph;
import com.minhaz.algorithm.ds.Node;

/**
 * This is Eular for directed graph
 *
 */
public class EularDGraph {
	/*
	 * 1) All vertices with nonzero degree belong to a single strongly connected component.
	 *  2) In degree and out degree of every vertex is same.
	 */
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public boolean hasCircuit(Graph graph) {
		// 1) All vertices with nonzero degree belong to a single strongly
		// connected component.
		StronglyConnected stronglyConnected = new StronglyConnected();
		if (!stronglyConnected.isStronglyConnected(graph)) {
			return false;
		}
		// 2) In degree and out degree of every vertex is same.
		int[] in = graph.countIndgree();
		int vertices = graph.countVertices();
		for (int vertex = 0; vertex < vertices; vertex++) {
			if (graph.getAdjacentVertices(vertex).size() != in[vertex]) {
				return false;
			}
		}
		return true;
	}
	public boolean hasPath(Graph graph) {
		//http://stones333.blogspot.com/2013/11/find-eulerian-path-in-directed-graph.html
		return false;
	}
	public List<Edge> getUnvisitedEdges(Graph graph, int vertex){
		List<Edge> edges = graph.getAdjacentEdges(vertex);
		for (Edge edge:edges){
			if (edge.visited){
				edges.remove(edge);
			}
		}
		
		return edges;
	}
	private List<Edge> getHierholzerPath(Graph graph, int start_vertex){
		Stack<Edge> forward =new Stack<Edge>();
		 Stack<Edge> backtrack =new Stack<Edge>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new EdgeList();
		graph.addPath(1, 0, 1);
		graph.addPath(1, 2, 1);
		graph.addPath(1, 4, 1);
		graph.addPath(1, 3, 1);
		graph.addPath(2, 4, 1);
		graph.addPath(3, 4, 1);
		EularDGraph eular = new EularDGraph();
		System.out.println(eular.hasPath(graph));

	}

}
