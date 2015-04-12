package com.minhaz.algorithm.problem.graph;

import java.util.ArrayList;
import java.util.List;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

public class PrintSimplePaths {

	public void printsPaths(Graph graph, int source, int destination) {
		// int vertices = graph.countVertices();
		// boolean[] visited = new boolean[vertices];
		List<Integer> list = new ArrayList<Integer>();
		list.add(source);
		simplePaths(graph, list, source, destination);

	}

	private void simplePaths(Graph graph, List<Integer> list, int source,
			int destination) {
		if (source == destination) {
			printStack(list);
		} else {
			int[] neighbours = graph.getNeighbours(source);
			for (int neighbour : neighbours) {
				if (list.contains(neighbour)) {
					continue;
				}
				List<Integer> temp = new ArrayList<Integer>();
				temp.addAll(list);
				temp.add(neighbour);
				simplePaths(graph, temp, neighbour, destination);

			}
		}

	}

	private void printStack(List<Integer> stack) {
		// TODO Auto-generated method stub
		for (Integer i : stack) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintSimplePaths paths = new PrintSimplePaths();
		Graph graph = new AdjacentMatrix(4, false);
		graph.addPath(0, 1);
		graph.addPath(0, 2);
		graph.addPath(0, 3);
		graph.addPath(2, 3);
		graph.addPath(1, 3);
		graph.addPath(2, 1);
		paths.printsPaths(graph, 0, 3);

	}

}
