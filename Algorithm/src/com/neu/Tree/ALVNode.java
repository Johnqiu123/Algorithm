package com.neu.Tree;

public class ALVNode {

	private int data;
	private int hgt;  // height
	ALVNode left;
	ALVNode right; 
	
	public ALVNode(int data){
		this.data = data;
		this.hgt = 0;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHgt() {
		return hgt;
	}

	public void setHgt(int hgt) {
		this.hgt = hgt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data + "";
	}
}
