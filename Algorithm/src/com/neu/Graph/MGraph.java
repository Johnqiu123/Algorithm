package com.neu.Graph;

public class MGraph {

	private int n; // the number of vertex
	private int e; // the number of edge
	
	int[][] edges;
	Vertex vex[];
	int[] indegrees; // indegree of each node 
	
	public MGraph(int n, int e) {
		this.n = n;
		this.e  = e;
		edges = new int[n][n];
		vex = new Vertex[n];
		indegrees = new int[n];
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}
	
	
}
