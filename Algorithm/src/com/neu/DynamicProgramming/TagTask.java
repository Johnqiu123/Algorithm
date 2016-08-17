package com.neu.DynamicProgramming;

/**
 *  The <tt>TagTask</tt> Java  provides a class for tag task 
 *  <p>
 *  
 *  @author Johnqiu
 */
public class TagTask {
	
	private int id;  // task id
	private int RO;  // R[id] - O[id]
	
	public TagTask() {
		// TODO Auto-generated constructor stub
		id = 0;
		RO = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRO() {
		return RO;
	}

	public void setRO(int rO) {
		RO = rO;
	}
	
	

}
