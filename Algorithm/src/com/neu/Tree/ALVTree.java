package com.neu.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ALVTree {

	private ALVNode root;
	
	public ALVTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	/**
	 * Rotation of left_left
	 * @param node
	 */
	private ALVNode SingRotateLeft(ALVNode node){
		System.out.println("SingRotateLeft");
		ALVNode node2 = node.left; 
		node.left = node2.right;  // set Y to K2 left tree
		node2.right = node;
		node.setHgt(Max(height(node.left),height(node.right))+1);
		node2.setHgt(Max(height(node2.left),node.getHgt())+1);
		return node2;
	}

	/**
	 * Rotation of right_right
	 * @param node
	 */
	private ALVNode SingRotateRight(ALVNode node){
		System.out.println("SingRotateRight");
		ALVNode node2 = node.right; 
		node.right = node2.left;  // set Y to K2 right tree
		node2.left = node;
		node.setHgt(Max(height(node.left),height(node.right))+1);
		node2.setHgt(Max(height(node2.right),node.getHgt())+1);
		return node2;
	}

	/**
	 * Rotation of left_right
	 * @param node
	 */
	private ALVNode DoubleRotateLeft(ALVNode node){
		System.out.println("DoubleRotateLeft");
		node.left = SingRotateRight(node.left);  // transfer to left_left
		node = SingRotateLeft(node);
		return node;
	}

	/**
	 * Rotation of right_left
	 * @param node
	 */
	private ALVNode DoubleRotateRight(ALVNode node){
		System.out.println("DoubleRotateRight");
		node.right = SingRotateLeft(node.right);  // transfer to right_right
		node = SingRotateRight(node);
		return node;
	}
	
	/**
	 *  add a node to Tree
	 * @param node
	 * @param value
	 * @return
	 */
	private ALVNode addNode(ALVNode node, int value){
    	if(node == null){
    		node = new ALVNode(value);
    	}else if(node.getData() > value){
    		node.left = addNode(node.left, value);
    		int diff = height(node.left) - height(node.right);
    		if(diff == 2){
    			if(value < node.left.getData()){
    				node = SingRotateLeft(node);
    			}else{
    				node = DoubleRotateLeft(node);
    			}
    		}
    	}else if(node.getData() < value){
    		node.right = addNode(node.right, value);
    		int diff = height(node.left) - height(node.right);
    		if(diff == -2){
    			if(value > node.right.getData()){
    				node = SingRotateRight(node);
    			}else{
    				node = DoubleRotateRight(node);
    			}
    		}
    	}
    	node.setHgt(Max(height(node.left),height(node.right))+1);
    	return node;  // return new pointer
	}
	
    /**
     * delete a node
     * @param root
     * @param value
     * @return
     * Question!!!
     */
     private boolean deleteNode(ALVNode node, int value){
    	if(node == null){
    		return false;
    	}
    	if(value < node.getData()){
    		deleteNode(node.left, value);
    		if(2==height(node.right)-height(node.left)){
    			if(node.right.left != null && (height(node.right.left)
    					>height(node.right.right))){
    				DoubleRotateRight(node);
    			}else{
    				SingRotateRight(node);
    			}
    		}
    	}else if(value > node.getData()){
    		deleteNode(node.right, value);
    		if(2==height(node.left)-height(node.right)){
    			if(node.left.right != null && (height(node.left.right)
    					> height(node.left.left))){
    				DoubleRotateLeft(node);
    			}else{
    				SingRotateLeft(node);
    			}
    		}
    	}else{
    		if(node.left != null && node.right != null){
    			ALVNode temp = node.right;
    			while(temp.left != null){
    				temp = temp.left;
    			}
    			node.setData(temp.getData());
    			deleteNode(node.right, temp.getData());
    			if(2==height(node.left)- height(node.right)){
    				if(node.left.right != null&&(height(node.left.right))
    						> height(node.left.left)){
    					DoubleRotateLeft(node);
    				}else{
    					SingRotateLeft(node);
    				}
    			}
    		}else{
    			ALVNode temp = node;
    			if(node.left == null){
    				node = node.left;
    			}else if(node.right == null){
    				node = node.left;
    			}
    			temp = null;
    		}
    	}
    	if(node == null){
    		return false;
    	}
    	node.setHgt(Max(height(node.left),height(node.right))+1);
    	return true;
    }
	/**
	 *  Find a node
	 * @param root
	 * @param value
	 * @return
	 */
    private ALVNode findNode(ALVNode root, int value){
    	if(root == null){
    		return null;
    	}
    	ALVNode tempnode = root;
    	while(tempnode != null){
    		if(tempnode.getData() > value){
    			tempnode = tempnode.left;
    		}else if(tempnode.getData() < value){
    			tempnode = tempnode.right;
    		}else{
    			return tempnode;
    		}
    	}
    	return null;
    }
	
	/**
	 * get the height of node
	 * @param node
	 * @return height
	 */
	private int height(ALVNode node){
		if(node != null){
			return node.getHgt();
		}
		return -1;
	}
	
	/**
	 * compare two numbers
	 * @param cmpa,cmpb
	 * @return max
	 */	
	private int Max(int cmpa, int cmpb){
		return cmpa > cmpb? cmpa:cmpb;
	}
	
    /**
     * preorder traversal(recursion)
     * middle --> left --> right
     * @param root
     */
    private void preorder(ALVNode root){
    	if(root != null){
    		System.out.print(root + " ");
    		preorder(root.left);
    		preorder(root.right);
    	}
    }
	
    /**
     * inorder traversal(recursion)
     * left --> middle --> right
     * @param root
     */
    private void inorder(ALVNode root){
    	if(root != null){
    		inorder(root.left);
    		System.out.print(root + " ");
    		inorder(root.right);
    	}
    }
    
    /**
     * postorder traversal(recursion)
     * left --> right --> middle
     * @param root
     */
    private void postorder(ALVNode root){
    	if(root != null){
    		postorder(root.left);
    		postorder(root.right);
    		System.out.print(root+" ");
    	}
    }
    
    /**
     * levelorder traversal(no recursion)
     * level by level
     * @param root
     */
    private void levelorder(ALVNode root){
    	if(root != null){
    		Queue<ALVNode> queue = new LinkedList<ALVNode>();
    		ALVNode node = root;
    		queue.offer(node);
    		while(!queue.isEmpty()){
    			node = queue.poll();
    			System.out.print(node + " ");
    			if(node.left != null){
    				queue.offer(node.left);
    			}
    			if(node.right != null){
    				queue.offer(node.right);
    			}
    		}
    	}
    }
    
    /**
     * print a tree
     * @param root
     */
    private void printTree(ALVNode root){
	   Queue<ALVNode> queue = new LinkedList<ALVNode>();
	   ALVNode ALVNode = root;
	   queue.offer(ALVNode);
	   while(!queue.isEmpty()){
	      ALVNode = (ALVNode) queue.poll();
	      if(ALVNode == null){
    	      System.out.print("null" +"  ");
	      }else{
		      System.out.print(ALVNode.getData()+" ");   		      
		      if(ALVNode.left !=null){
	    	      queue.offer(ALVNode.left);
		      }else{
	    	      queue.offer(null);
		      }
		      if(ALVNode.right != null){
	    	       queue.offer(ALVNode.right);
		      }else{
	    	       queue.offer(null);
		      }
	      }
	   }
    }
	/**
	 * Insert a node to Tree (entrance)
	 * @param value
	 * @return
	 */
	public  ALVNode insert(int value){
		root = addNode(root, value);
		return root;
	}
	
	/**
	 * Delete a node from Tree (entrance)
	 * @param value
	 * @return
	 */
	public  boolean delete(int value){
		boolean flag = deleteNode(root, value);
		return flag;
	}
	
	/**
	 * Find a node(entrance)
	 * @param value
	 * @return
	 */
	public ALVNode find(int value){
		ALVNode node = findNode(root,value);
		return node;
	}
	
	/**
	 * preorder traversal(entrance)
	 */
	public void pre_order(){
		preorder(root);
	}
	
	/**
	 * inorder traversal(entrance)
	 */
	public void in_order(){
		inorder(root);
	}
	
	/**
	 * postorder traversal(entrance)
	 */
	public void post_order(){
		postorder(root);
	}
	
	/**
	 * levelorder traversal(entrance)
	 */
	public void leve_lorder(){
		levelorder(root);
	}
	
	public void print(){
		printTree(root);
	}
	
	public static void main(String[] args) {
		ALVTree alv = new ALVTree();
		int[] a = {6,3,7,1,4,2};
		for(int i=0; i < a.length; i++){
//			System.out.println(a[i]);
			alv.insert(a[i]);
		}
//		alv.print();
		/*****************Test 1********************/
//		alv.pre_order();
//		System.out.println("");
//		alv.in_order();
//		System.out.println("");
//		alv.post_order();	
		/*****************Test 1********************/
		alv.delete(7);
		alv.print();
	}
}
