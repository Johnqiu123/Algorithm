package com.neu.Tree;

/**
 *  The <tt>TreeNode</tt> Java  provides a  tree node
 *  <p>
 *  
 *  @author Johnqiu
 */
public class TreeNode {
	
		private int data;
		TreeNode left;
		TreeNode right;
		
		 public TreeNode(int data) {
			// construtor
			 this.data = data;
			 this.left = null;
			 this.right = null;
		}
		
		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}
		 
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		         return this.data + "";
		}			 
}
