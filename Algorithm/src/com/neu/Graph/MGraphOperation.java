package com.neu.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MGraphOperation {
	
	private MGraph g;
	
	public MGraphOperation() {
		// TODO Auto-generated constructor stub
		g = null;
	}
	
	/**
	 * create a graph by matrix
	 */
	@SuppressWarnings("resource")
	public void createMGraph(){
		Scanner cin = new Scanner(System.in);
		System.out.println("输入顶点数和边数：");
		int n = cin.nextInt();
		int e = cin.nextInt();
		if (n < 0) throw new RuntimeException("Number of vertices must be nonnegative");
		if (e < 0) throw new RuntimeException("Number of edges must be nonnegative");
		
		this.g = new MGraph(n,e);
		
		// create vertex info
		System.out.println("输入顶点信息：");
		for(int i = 0; i < n ; i++){
			Vertex v = new Vertex();
			v.setData(cin.nextInt());
			g.vex[i] = v;
		}
		
		// create edge info 
		System.out.println("输入有向边(vi,vj)上的顶点序号和权值：");
		for(int i = 0; i < e; i++){
			String[] value = cin.next().split(",");
			if (value.length < 3) throw new RuntimeException("input value must has three numbers");
			int vi = Integer.parseInt(value[0]);
			int vj = Integer.parseInt(value[1]);
			int weight = Integer.parseInt(value[2]);
			g.edges[vi][vj] = weight;
		}
	}
	
	/**
	 * create a matrix graph by auto
	 */
	public void createMGraphAuto(){
		
		int n = 13;
		int e = 15;
		
//		int[] vexinfo = {0,1,2,3};
//		String[] edgesinfo ={
//				"0,1,1",
//				"0,3,4",
//				"1,3,2",
//				"1,2,9",
//				"2,0,3",
//				"2,1,5",
//				"2,3,8",
//				"3,2,6"};
		
		int[] vexinfo = {0,1,2,3,4,5,6,7,8,9,10,11,12};
		String[] edgesinfo = {
				"0,1,1",
				"0,6,1",
				"0,5,1",
				"2,0,1",
				"2,3,1",
				"3,5,1",
				"5,4,1",
				"6,4,1",
				"6,9,1",
				"7,6,1",
				"8,7,1",
				"9,10,1",
				"9,11,1",
				"9,12,1",
				"11,12,1"};
		
		this.g = new MGraph(n,e);
		
		// create vertex info
		for(int i = 0; i < n ; i++){
			Vertex v = new Vertex();
			v.setData(vexinfo[i]);
			g.vex[i] = v;
		}
		
		// create edge info and indegrees
		int[] indegrees = new int[n];
		for(int i = 0; i < e; i++){
			String[] value = edgesinfo[i].split(",");
			int vi = Integer.parseInt(value[0]);
			int vj = Integer.parseInt(value[1]);
			int weight = Integer.parseInt(value[2]);
			indegrees[vj]++; // count indegree
			g.edges[vi][vj] = weight;
		}
		
		g.indegrees = indegrees;
	}
	
	/**
	 * print a graph
	 */
	public void printGraph(){
		if(g == null) throw new RuntimeException("create a graph first");
		if(g != null){
			int i,j;
			for (i = 0; i < g.getN(); i++){
				for (j = 0; j < g.getN(); j++){
					System.out.print(g.edges[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}
	
	/**
	 * topolopic for a graph
	 * @return toposort
	 */
	public int[] topologic(){
		int[] toposort = new int[g.getN()];
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] indegrees = g.indegrees;
		int[][] edges = g.edges;
	
		for(int i = 0; i < indegrees.length; i++){
			if(indegrees[i] == 0){
				queue.offer(i);
			}
		}
		int cur; // current node's indegree is 0
		int j = 0;
		while(!queue.isEmpty()){
			cur = queue.poll();
			toposort[j++] = cur;
			for(int i =0; i < g.getN(); i++){
				if(edges[cur][i] != 0){
					indegrees[i]--;
					if(indegrees[i] == 0){
						queue.offer(i);
					}
				}
			}
			
		}
		return toposort;
	}
	
	public static void main(String[] args) {
		MGraphOperation mgo = new MGraphOperation();
//		mgo.createMGraph();
//		System.out.println("打印图：");
//		mgo.printGraph();
		
		/*****************Test 1********************/
		mgo.createMGraphAuto();
		System.out.println("打印图：");
		mgo.printGraph();
		int[] indegree = mgo.g.indegrees;
		for(int i=0; i < indegree.length; i++){
			System.out.print(indegree[i] + " ");
		}
		System.out.println("");
		
		/*****************Test 2********************/
		System.out.println("拓扑排序：");
		int[] toposort = mgo.topologic();
		for(int i = 0; i < toposort.length; i++){
			System.out.print(toposort[i] + " ");
		}
		System.out.println("");
	}
}
