package com.neu.LinearList;

/**
 *  The <tt>ListNode</tt> Java  provides a node of linear list
 *  <p>
 *  @author Johnqiu
 */
public class ListNode {

	private int data;
	ListNode next;
	
	public ListNode(int value) {
		// initiate a node
		this.data = value;
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data + "";
	}
}
