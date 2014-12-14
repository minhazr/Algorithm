package com.minhaz.algorithm.problem.graph;

import java.util.Arrays;

import com.minhaz.algorithm.ds.AdjacentMatrix;
import com.minhaz.algorithm.ds.Graph;

/**
 * 
 * Problem Statement
 * 
 * 
 * There are M job applicants and N jobs. Each applicant has a subset of jobs
 * that he/she is interested in. Each job opening can only accept one applicant
 * and a job applicant can be appointed for only one job. Find an assignment of
 * jobs to applicants in such that as many applicants as possible get jobs.
 * 
 */

public class JobAsigenment {
	private static int applicant = 6;
	private static int job = 6;
	private static final int AVAILABE = -1;
	public int getMaxAssigenment(Graph graph) {
		int vetices = graph.countVertices();
		int[] applicants = new int[job];
		Arrays.fill(applicants, AVAILABE);

		boolean[] assigenments = new boolean[job];
		Arrays.fill(assigenments, false);

		int result = 0;
		for (int applicant = 0; applicant < this.applicant; applicant++) {
			Arrays.fill(assigenments, false);
			if (isAssigenmentPossible(graph, applicant, applicants,
					assigenments)) {
				result++;
			}

		}
		return result;

	}

	private boolean isAssigenmentPossible(Graph graph, int applicant,
			int[] applicants, boolean[] assigenments) {
		for (int job = 0; job < this.job; job++) {
			if (graph.hasPath(applicant, job) && !assigenments[job]) {
				assigenments[job] = true;

				if ((applicants[job] == AVAILABE)
						|| isAssigenmentPossible(graph, applicants[job],
								applicants, assigenments)) {
					applicants[applicant] = job;
					return true;
				}

			}

		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// So we add a source
		// and add edges from source to all applicants. Similarly, add edges
		// from all jobs to sink. The capacity of every edge is marked as 1
		// unit. total number vetex is job+applicant+2 and additional vertices
		// are for sourc and sink

		int applicant = 6;
		int jobs = 6;

		Graph graph = new AdjacentMatrix(applicant, jobs, true);

		graph.addPath(0, 1, 1);
		graph.addPath(0, 2, 1);

		graph.addPath(1, 0, 1);
		graph.addPath(1, 3, 1);

		graph.addPath(2, 2, 1);

		graph.addPath(3, 2, 1);
		graph.addPath(3, 3, 1);

		graph.addPath(5, 5, 1);
		graph.printGraph();

		JobAsigenment asigenment = new JobAsigenment();
		System.out.println(asigenment.getMaxAssigenment(graph));

	}

}
