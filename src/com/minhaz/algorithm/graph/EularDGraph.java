package com.minhaz.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.minhaz.algorithm.ds.Edge;
import com.minhaz.algorithm.ds.EdgeList;
import com.minhaz.algorithm.ds.Graph;

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
	public boolean hasPath(Graph graph, int soruce, int dest) {
		//http://stones333.blogspot.com/2013/11/find-eulerian-path-in-directed-graph.html
		List<Edge> path = getHierholzerPath(graph, soruce);
		   if ((path==null) || (path.size()==0)) {
		    return false;
		   } else if ( path.get(path.size()-1).dest == dest ) {
		     System.out.println ("\nEulerian path found:");
		     printPath(path);
		     return true;
		   }

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
	public void printPath(List<Edge> path) {
		   for (int i=0; i<path.size(); i++) {
		    System.out.print(path.get(i).src + "->" + path.get(i).dest + " ");
		   }
		  }
	private List<Edge> getHierholzerPath(Graph graph, int start_vertex){
		Stack<Edge> forward =new Stack<Edge>();
		 Stack<Edge> backtrack =new Stack<Edge>();
		 List<Edge> edges=graph.getAdjacentEdges(start_vertex);
		 while (!edges.isEmpty()){
			 edges.get(0).visited=true;
			 forward.push(edges.get(0));
			 edges=graph.getAdjacentEdges(edges.get(0).dest);
		 }
		 Edge e;
		 while (!forward.empty()){
			 e=forward.pop();
			 backtrack.push(e);
			 edges=graph.getAdjacentEdges(e.src);
			 while (!edges.isEmpty()){
				 edges.get(0).visited=true;
				 forward.push(edges.get(0));
				 edges=graph.getAdjacentEdges(edges.get(0).dest);
			 }
		 }
		 List<Edge> path = new ArrayList<Edge>();
		   while(!backtrack.isEmpty()) {
		    Edge edge = backtrack.pop();
		    path.add(edge);
		   }

		   return path;
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
