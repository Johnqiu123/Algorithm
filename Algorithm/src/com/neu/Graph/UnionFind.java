package com.neu.Graph;

import java.util.Scanner;

public class UnionFind {

	private int[] id;  // component id
	private int  count; // components' number
	private int[] sz; // the size of component of each root 
	
	public UnionFind(int n) {
		// initialization
		count = n;
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
		
	}
	
	/**
	 * return components' number
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * judge whether p and q are connected
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	/** 
	 * find by weighted quick-union algorithm
	 * @param p
	 * @return
	 */
	public int find(int p){
		while(p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * union by weighted quick-union algorithm
	 * @param p
	 * @param q
	 */
	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		
		// link small tree to big tree
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	
	/**
	 * find by quick-find algorithm
	 * @param p  index
	 * @return
	 */
	public int findbyqf(int p){
		return id[p];
	}
	
	/**
	 * union by quick-find algorithm
	 * @param p
	 * @param q
	 */
	public void unionbyqf(int p, int q){
		// get id
		int pid = findbyqf(p);
		int qid = findbyqf(q);
		
		// p,q in the same component
		if(pid == qid) return;
		
		// p,q not in the same component
		for(int i = 0; i < id.length; i++){
			if(id[i] == pid) id[i] = qid;
		}
		 count--;
	}
	
	/**
	 * find by quick-union algorithm
	 * @param p
	 * @return
	 */
	public int findbyqu(int p){
		while(p != id[p]) p = id[p];
		return p;
	}
	
	/**
	 * union by quick-union algorithm
	 * @param p
	 * @param q
	 */
	public void unionbyqu(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		UnionFind uf = new UnionFind(n);
		while(cin.hasNext()){
			int p = cin.nextInt();
			int q = cin.nextInt();
			if(uf.connected(p, q)){
				continue;
			}
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + "components");
	}
}
